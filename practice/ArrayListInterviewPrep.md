# ArrayList — Interview Prep

Study notes derived from the actual JDK source of `java.util.ArrayList` (JDK 21+, the version
with the `SequencedCollection` methods `getFirst` / `addFirst` / `removeLast`).

Every claim below is traceable to a line in that source — that is the point. Interviewers can
tell the difference between someone who memorised "ArrayList grows by 1.5x" and someone who has
read `grow()`.

## Contents

1. [Tier 1 — Fundamentals](#tier-1--fundamentals)
2. [Tier 2 — The "why" questions](#tier-2--the-why-questions)
3. [Tier 3 — The traps](#tier-3--the-traps)
4. [Comparison table](#comparison-table)
5. [Practice questions](#practice-questions)
6. [One-page cheat sheet](#one-page-cheat-sheet)

---

## Tier 1 — Fundamentals

These should be instant, no thinking.

| Operation | Complexity | Why |
| --- | --- | --- |
| `get` / `set` / `size` / `isEmpty` | O(1) | direct array index |
| `add(E)` | **amortized** O(1) | occasional O(n) copy on grow |
| `add(int, E)` / `remove(int)` | O(n) | `System.arraycopy` shift |
| `remove(Object)` / `contains` / `indexOf` | O(n) | linear scan |
| `addAll(Collection)` | O(m + n) | one grow, one arraycopy |
| `removeIf` / `removeAll` / `retainAll` | O(n) | single compaction pass |
| `sort` | O(n log n) | TimSort, stable |
| `clear` | O(n) | must null every slot for GC |

Core facts:

- **Capacity != size.** `size` is the element count; `elementData.length` is capacity.
- **Capacity never shrinks automatically.** `remove` just nulls a slot. Only `trimToSize()` shrinks.
- Allows `null`, allows duplicates, insertion-ordered, **not** synchronized.
- Implements `RandomAccess` — a marker interface with no methods. `Collections.binarySearch`,
  `shuffle`, `reverse`, and `fill` branch on it to pick index-based vs iterator-based algorithms.
- Max size is bounded by `Integer.MAX_VALUE` (array length is an `int`).

---

## Tier 2 — The "why" questions

### 1. Why are there two empty arrays?

```java
private static final Object[] EMPTY_ELEMENTDATA = {};
private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
```

Identical in content. The JVM distinguishes them by **identity** (`==`), which encodes *how the
list was constructed*:

- `new ArrayList()` -> `DEFAULTCAPACITY_EMPTY_ELEMENTDATA` -> first `add` jumps to capacity **10**.
- `new ArrayList(0)` -> `EMPTY_ELEMENTDATA` -> the caller explicitly asked for 0, so honour it.
  Growth from there is 1 -> 2 -> 3 -> 4 -> 6 -> 9 -> 13 -> 19 ...

That distinction is exactly this branch in `grow`:

```java
if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) { ... }
```

**The real point:** `new ArrayList()` is *lazy*. It allocates **zero** array storage until the
first `add`. Before Java 7 it eagerly allocated `new Object[10]`, which was pure waste for the
millions of never-populated lists in a typical heap. One shared zero-length array costs nothing.

> **Follow-up:** *"Does `ensureCapacity(5)` on a fresh `new ArrayList()` allocate anything?"*
> **No.** The guard `!(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA && minCapacity <= DEFAULT_CAPACITY)`
> skips it, because the list would get capacity 10 on first `add` anyway.

### 2. What is the growth policy, and why 1.5x and not 2x?

```java
ArraysSupport.newLength(oldCapacity,
        minCapacity - oldCapacity,  // minimum growth
        oldCapacity >> 1);          // preferred growth
```

New capacity = `old + max(minGrowth, old / 2)` — so **1.5x**, unless the requested minimum is
larger (a big `addAll` grows straight to what it needs, in one allocation).

Why 1.5x:

- Any factor > 1 gives amortized O(1). The total copying for n appends is a geometric series.
- 1.5x wastes less memory than 2x (avg ~25% slack vs ~50%).
- Allocator-reuse argument: with 1.5x growth, the sum of previously freed blocks eventually
  exceeds the next request, so the allocator can reuse that space; with 2x it never can.
  Worth mentioning as a rationale, not as gospel.
- It is computed as `old + (old >> 1)` — a shift, no division.

**Overflow handling** lives in `ArraysSupport.newLength`. If the preferred length overflows past
`SOFT_MAX_ARRAY_LENGTH` (`Integer.MAX_VALUE - 8`), it falls back to `hugeLength`, which caps at
`Integer.MAX_VALUE` or throws `OutOfMemoryError` if the *minimum* itself overflowed to negative.
Hence the javadoc on `grow`: `@throws OutOfMemoryError if minCapacity is less than zero`.

### 3. Why is `add(E)` split into a private helper?

The source comment is the answer, and quoting it lands well:

```java
/**
 * This helper method split out from add(E) to keep method
 * bytecode size under 35 (the -XX:MaxInlineSize default value),
 * which helps when add(E) is called in a C1-compiled loop.
 */
private void add(E e, Object[] elementData, int s) { ... }
```

`-XX:MaxInlineSize=35` is the bytecode-size limit under which C1 will inline a method that is
**not yet hot**. Keeping `add(E)` tiny lets the JIT inline it into caller loops before it is warm
enough to qualify under `FreqInlineSize` (325). A pure JIT-friendliness refactor — and a strong
signal that you have actually read JDK source rather than a blog post about it.

### 4. `modCount` and fail-fast iteration

`modCount` is inherited from `AbstractList`. It is incremented on every **structural**
modification (add, remove, clear, grow, trim). Each iterator snapshots it into
`expectedModCount` and re-checks on every `next()`.

Say this out loud in an interview: **fail-fast is best-effort, meant for detecting bugs — never
for program logic.** The javadoc states it explicitly. There is no happens-before edge on
`modCount`, so under genuine concurrency it can miss violations entirely.

Quirks worth knowing:

- `set(int, E)` does **not** bump `modCount` — replacing a value is not structural. You may
  `set` freely mid-iteration.
- `sort()` and `replaceAll()` **do** bump it, even though neither changes the size. There is
  literally a `TODO(8203662): remove increment of modCount` in `replaceAll`. Consequence:
  sorting a list invalidates any live iterator.
- `trimToSize()` bumps `modCount` unconditionally, even when it changes nothing.

### 5. Why does `removeIf` use a bitset instead of removing in place?

```java
final long[] deathRow = nBits(end - beg);
deathRow[0] = 1L;   // set bit 0
```

Two reasons, both stated in the source comment:

1. **Correctness under reentrancy** — "Tolerate predicates that reentrantly access the collection
   for read (but writers still get CME)". If the predicate reads the list (e.g.
   `x -> list.indexOf(x) > 3`), a single compacting pass would show it a half-mangled list.
   Mark first, expunge second, and the predicate always sees the original state.
2. **Performance** — one final compaction via `shiftTailOverGap` instead of an O(n) shift per
   removal. `removeIf` is O(n); the naive `for (x : list) if (p(x)) list.remove(x)` is O(n^2)
   *and* throws `ConcurrentModificationException`.

Note the hand-rolled 3-method bitset (`nBits` / `setBit` / `isClear`) under the comment
"A tiny bit set implementation" — `java.util.BitSet` is avoided here for bootstrap-ordering and
allocation reasons.

### 6. Why is `elementData` `transient` with custom `writeObject` / `readObject`?

Default serialization would write the **entire backing array**, including unused capacity slots
(up to ~33% junk `null`s). The custom form writes only `size` elements, and `readObject`
allocates exactly `size` — the same policy `clone()` uses.

Two details that impress:

- `writeObject` writes `size` in the slot where capacity used to live, "for behavioral
  compatibility with clone()" — a legacy stream-format artifact.
- `readObject` calls
  `SharedSecrets.getJavaObjectInputStreamAccess().checkArray(s, Object[].class, size)`
  **before allocating**. That runs the deserialization filter, defending against a hostile stream
  claiming `size = Integer.MAX_VALUE` (a memory-exhaustion DoS). It also rejects `size < 0` with
  `InvalidObjectException`.

### 7. Why the `c.getClass() == ArrayList.class` check in the copy constructor?

```java
Object[] a = c.toArray();
if ((size = a.length) != 0) {
    if (c.getClass() == ArrayList.class) elementData = a;
    else elementData = Arrays.copyOf(a, size, Object[].class);
}
```

**`Collection.toArray()` is not guaranteed to return an actual `Object[]`.**
`Arrays.asList("a", "b").toArray()` returns a `String[]`. If that were stored directly as
`elementData`, a later `list.add(42)` would fail with `ArrayStoreException` — heap pollution
(historically JDK-6260652). So the general path re-copies into a true `Object[]`.

The fast path skips that copy because `ArrayList.toArray()` provably returns a fresh `Object[]`.
It is an **exact class check, not `instanceof`** — a subclass could override `toArray()` and
break the invariant.

### 8. `SubList` — how views actually work

`subList` returns a **view**: shared backing array, plus an `offset`, its own `size`, and its own
`modCount`. Every method begins with `checkForComodification()` comparing against `root.modCount`.

- **The idiom:** `list.subList(from, to).clear()` is the canonical range-delete. It routes to the
  `protected removeRange`, which is otherwise inaccessible from outside.
- **`updateSizeAndModCount` walks the `parent` chain** — nested sublists all get resized and
  re-synced when a descendant mutates.
- **Trap:** structurally modifying the *root* invalidates the sublist -> CME on next access.
  The javadoc calls the semantics "undefined".
- **Trap:** `SubList` is **not `Serializable`**, and it holds a strong reference to the entire
  backing list. Returning `list.subList(0, 10)` from a method leaks the whole list. Copy it out:
  `new ArrayList<>(list.subList(0, 10))`.

### 9. `batchRemove` and exception safety

```java
} catch (Throwable ex) {
    // Preserve behavioral compatibility with AbstractCollection,
    // even if c.contains() throws.
    System.arraycopy(es, r, es, w, end - r);
    w += end - r;
    throw ex;
} finally {
    modCount += end - w;
    shiftTailOverGap(es, w, end);
}
```

If `c.contains()` throws mid-pass (say an NPE from a `TreeSet` that rejects nulls), the list must
not be left half-compacted with duplicated elements. The catch block salvages the untouched tail;
the `finally` compacts regardless. A good answer to *"how do you write exception-safe mutation?"*

Also note the "Optimize for initial run of survivors" loop at the top: if nothing needs removing,
`batchRemove` returns `false` without writing anything.

---

## Tier 3 — The traps

### The `remove(int)` vs `remove(Object)` overload trap

```java
List<Integer> list = new ArrayList<>(List.of(10, 20, 30));
list.remove(1);                    // removes INDEX 1 -> the value 20
list.remove(Integer.valueOf(1));   // removes the OBJECT 1 -> no-op, returns false
```

Overload resolution prefers the primitive `int` overload without boxing. This bites everyone
working with `List<Integer>`.

### The CME that does *not* happen

```java
List<String> list = new ArrayList<>(List.of("a", "b", "c"));
for (String s : list) {
    if (s.equals("b")) list.remove(s);   // NO exception - loop just ends early
}
// list is now [a, c], and "c" was never visited
```

Why: `Itr.hasNext()` is `cursor != size` and **does not check `modCount`**. After removing the
second-to-last element, `cursor == size`, so `hasNext()` returns `false` and the loop exits
cleanly — silently skipping the last element. Remove `"a"` instead and you *do* get a CME on the
next `next()`.

This is arguably the single best question in the whole class: it proves fail-fast is genuinely
best-effort. Correct fixes: `Iterator.remove()`, or `list.removeIf(s -> s.equals("b"))`.

### `Arrays.asList` is not a `java.util.ArrayList`

`Arrays.asList(...)` returns `java.util.Arrays$ArrayList` — a fixed-size, array-backed view.
`set` works; `add` / `remove` throw `UnsupportedOperationException`. `List.of(...)` is fully
immutable *and* rejects `null` elements. Neither is `java.util.ArrayList`.

### Memory is not reclaimed by removal

Add 1M elements, remove 999,999, and a ~1M-slot array is still alive. `clear()` nulls the element
references (see the loop in `clear()`, which exists precisely so the elements become collectible)
but keeps the array itself. Only `trimToSize()` shrinks the backing store.

### `elementData` is package-private, not private

```java
transient Object[] elementData; // non-private to simplify nested class access
```

This avoids synthetic accessor methods for `Itr`, `SubList`, and `ArrayListSpliterator`.
Nest-based access control (Java 11+) made this less necessary, but the comment remains.

---

## Comparison table

| | `ArrayList` | `LinkedList` | `Vector` | `CopyOnWriteArrayList` |
| --- | --- | --- | --- | --- |
| Backing store | array | doubly-linked nodes | array | volatile array |
| Random access | O(1) | O(n) | O(1) | O(1) |
| Insert at head | O(n) | O(1) | O(n) | O(n) + full copy |
| Growth factor | 1.5x | n/a | **2x** | exact |
| Thread-safe | no | no | yes (per method) | yes |
| Iterator | fail-fast | fail-fast | fail-fast | **snapshot, never CME** |
| Memory / element | 1 reference | 1 ref + node (~24B) | 1 reference | 1 reference |

**The nuance that scores points:** `LinkedList` beating `ArrayList` on insertion is mostly
theoretical. `ArrayList.add(0, x)` is a single `System.arraycopy` — a JIT intrinsic that compiles
down to `memmove`, absurdly fast and cache-friendly. `LinkedList` first needs an O(n) pointer
chase to find the position, and every node hop is a potential cache miss. **Use `ArrayDeque`, not
`LinkedList`, when you need a queue or deque.** `LinkedList` is almost never the right answer.

On `Vector`: per-method synchronization does not make *compound* operations safe —
`if (!v.contains(x)) v.add(x)` still races. That is why it is legacy. The modern options are
`Collections.synchronizedList` (external locking still needed for compound ops and iteration) or
`CopyOnWriteArrayList` (read-heavy, write-rare workloads only).

---

## Practice questions

Answer these out loud, not in your head.

1. Prove `add` is amortized O(1). (Geometric series: n appends cost roughly 3n element copies at
   a 1.5x growth factor.)
2. Why does `hashCode()` snapshot and re-check `modCount` around `hashCodeRange`?
3. What does "late-binding" mean for `ArrayListSpliterator`? (`fence = -1` until first use;
   `getFence()` binds both size and `expectedModCount` on the first call — so structural changes
   between `spliterator()` and the first traversal are legal.)
4. Why does the spliterator report `ORDERED | SIZED | SUBSIZED` but not `IMMUTABLE` or `NONNULL`?
5. Why does `Itr.forEachRemaining` update `cursor` only at the end of the loop?
   ("update once at end to reduce heap write traffic")
6. `clone()` sets `v.modCount = 0` — why does that matter?
7. Implement your own resizable list with `add`, `get`, `remove`, and correct growth. The growth
   policy plus the `arraycopy` shift *is* the whole exercise.
8. How would you make an `ArrayList` thread-safe, and what are the trade-offs of each option?
9. Why does `equals()` have a separate `equalsArrayList` fast path instead of always using
   `equalsRange`?
10. What happens if you call `list.sort(...)` while holding an iterator? Why?

---

## One-page cheat sheet

```
DEFAULT_CAPACITY            = 10
growth                      = old + (old >> 1)          // 1.5x
new ArrayList()             -> lazy, 0 bytes until first add, then 10
new ArrayList(0)            -> 1, 2, 3, 4, 6, 9, 13, 19 ...
new ArrayList(n)            -> exactly n
max size                    ~ Integer.MAX_VALUE

modCount++  on: add, remove, clear, addAll, trimToSize, sort, replaceAll
modCount    NOT on: set, get

hasNext()   = cursor != size        // no modCount check -> the silent-skip bug
next()      = checks modCount first

remove(int)      -> by index
remove(Object)   -> by value        // List<Integer> hazard

capacity shrinks ONLY via trimToSize()
clear() nulls elements (GC) but keeps the array
subList() is a live view, not Serializable, holds the whole parent alive
```

---

*Source: `java.util.ArrayList`, OpenJDK 21+. Read the real file — it is ~1800 lines and about
half of it is javadoc.*
