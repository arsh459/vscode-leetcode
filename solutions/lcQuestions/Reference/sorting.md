# Sorting — SDE III Prep (Supplementary Block)

**5 problems · 0 Easy / 5 Medium / 0 Hard · 1–2 days**

Tick the checkbox when solved. Mark the **Hint?** column if you needed help — those get re-solved first.

> **Why this block is tiny:** sorting is a technique layer, not a topic. Most of it was already absorbed into other blocks. This list closes the four genuine gaps that distribution left behind, plus two things that have no LeetCode problem at all and belong in your notes rather than your tracker.
>
> **Best placement: right after Arrays.** 912 and 179 reinforce partitioning and comparator reasoning before you need both everywhere else.

---

## Coverage Audit

What's already done, so you don't re-solve it:

| Sub-topic | Where | Status |
|---|---|---|
| Quickselect / nth element | 215, 973, 75 | ✔ Covered |
| Counting / bucket sort | 347, 451 | ✔ Covered |
| Count inversions, reverse pairs, smaller-after-self | 315, 493 | ✔ Covered well |
| Merge K sorted streams | 23, 373, 632 | ✔ Covered |
| Cyclic sort family | 448, 287, 41, 268 | ✔ Covered well |
| Merge sort on a linked list | 148 | ✔ Covered |
| Multi-key sort with a tricky tiebreak | 354, 692 | Partial → reinforced below |
| Merge sort / quicksort from scratch | — | **Gap → 912** |
| Comparator transitivity | — | **Gap → 179** |
| Multi-key comparator design | — | **Gap → 406, 937** |
| Radix sort | — | **Gap → 164 (optional)** |
| Heapsort | — | **No problem — exercise on 912** |
| External / memory-bounded sorting | — | **No problem — system design notes** |

---

## Implement From Scratch (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 912 | Sort an Array | Med | |

> The test constraints effectively ban `Arrays.sort` — that's the point. Implement **three** algorithms on this one problem:
>
> 1. **Merge sort** — stable, `O(n log n)` guaranteed, `O(n)` auxiliary
> 2. **Quicksort** — in-place, `O(n log n)` average / `O(n²)` worst. Use a **randomized pivot** or median-of-three; the LeetCode test set includes adversarial sorted input specifically to kill naive last-element pivots
> 3. **Heapsort** — in-place heapify, then repeatedly swap root to the end. `O(n log n)` worst case, not stable
>
> **The interview content here is the comparison**, not the code. Be able to say: merge sort when you need stability or guaranteed bounds; quicksort when you need in-place and average-case speed; heapsort when you need guaranteed `O(n log n)` *and* `O(1)` space and don't care about stability. That last combination is why heapsort exists at all.

## Comparator Transitivity (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 179 | Largest Number | Med | |

> **The biggest gap in the original plan, and a frequently-asked problem.**
>
> Sort the numbers as strings with `(b + a).compareTo(a + b)`. The code is three lines. The interview is whether you can argue the comparator is a **valid total order** — that it's transitive, antisymmetric, and consistent.
>
> Try to explain it out loud: if `ab ≥ ba` and `bc ≥ cb`, why does `ac ≥ ca` follow? Most candidates write the right comparator and can't justify it. Being able to is the differentiator, and it connects directly to the `IllegalArgumentException` trap in the Java notes below.
>
> Edge case: all zeros → `"000"` must become `"0"`.

## Multi-Key Sorting (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 406 | Queue Reconstruction by Height | Med | |
| [ ] | 937 | Reorder Data in Log Files | Med | |

> **406 is the canonical "sort by one key so the second becomes tractable" problem.** Sort height descending, k ascending, then insert each person at index `k`. The insight is that once taller people are placed, shorter people don't affect their counts — so `k` becomes a direct index. Same family as 354 (Russian Doll Envelopes) in your DP block: **sort one dimension so the other becomes a simple scan.**
>
> **937 is an Amazon favorite** and it's a stability problem. Letter-logs sort by content then identifier; digit-logs must preserve their original relative order. If you use a stable sort with a comparator that returns `0` for all digit-log pairs, stability handles it for free — and knowing that's *why* it works is the point.

## Radix / Bucket Sort (1, optional)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 164 | Maximum Gap | Med | |

> The only realistic place radix or bucket sort is required rather than optional. The pigeonhole argument (with `n` values in a range, some bucket of width `(max-min)/(n-1)` must be empty) is elegant.
>
> **Skip this if you're short on time** — it's rarely asked. Do know when linear-time sorting applies: bounded integer keys, and you're willing to trade space for time. That conversation matters more than the problem.

---

## Two Things With No LeetCode Problem

### Heapsort

Implement it once as a third solution to 912. The mechanics:

1. Build a max-heap in place via bottom-up `siftDown` from index `n/2 - 1` down to 0 — this is `O(n)`, not `O(n log n)`
2. Repeatedly swap `arr[0]` with `arr[i]`, shrink the heap, `siftDown` the new root

**Why it matters in interviews:** it's the answer to *"can you sort in `O(n log n)` worst case with `O(1)` extra space?"* Merge sort needs `O(n)` auxiliary; quicksort's worst case is `O(n²)`. Heapsort is the one that gives you both — at the cost of stability and cache locality, which is why real libraries prefer Timsort and introsort.

### External / Memory-Bounded Sorting

**System design content, not a coding problem.** Put this in your design notes next to consistent hashing.

The scenario: sort 100 GB with 1 GB of RAM. The answer:

1. **Split into runs.** Read chunks that fit in memory, sort each in place, write each sorted run to disk. 100 GB / ~800 MB usable ≈ 125 runs.
2. **K-way merge.** Open all runs, read one buffer from each, use a min-heap of size K to emit the global minimum, refilling buffers as they drain.
3. **Multi-pass if K is too large.** If you can't hold K buffers in memory at once, merge in groups and do multiple passes — `log_K(runs)` passes total.

**Expected follow-ups and the answers:**

| Question | Answer |
|---|---|
| How do you pick chunk size? | Available RAM minus space for the merge buffers and heap. Leave headroom. |
| How do you pick K? | RAM / buffer size. Larger K means fewer passes but smaller buffers and more random I/O. |
| Why buffered reads instead of one record at a time? | Sequential disk I/O is orders of magnitude faster than random. The buffer amortizes seeks. |
| What if this needs to be distributed? | This is essentially MapReduce's shuffle-and-sort phase — partition by key range, sort locally, merge. |
| Where does this appear in real systems? | Database `ORDER BY` on results exceeding `work_mem`, LSM-tree compaction, Spark's external shuffle. |

That last row is worth memorizing. Naming LSM compaction as external merge sort is the kind of remark that reads as genuine systems understanding, and it ties back to your Kafka and database prep.

---

## 1–2 Day Schedule

| Day | Problems | Done |
|---|---|---|
| 1 | 912 *(all three algorithms)*, 179 | [ ] |
| 2 | 406, 937, 164 *(optional)* + read external sorting notes | [ ] |

If you're compressing: do 912 and 179 on one day and fold 406/937 into the Arrays block.

---

## Revision

Re-solve **cold** (no notes, from scratch) on:

- **Day 9** — everything marked Hint?, plus 179 and the quicksort partition from 912
- **Day 23** — same set

The partition routine specifically: you'll use it in 215, 75, and 973, so it should be muscle memory.

---

## Trim to 3 If Pressed

912, 179, 406

Cut: 937, 164.

---

## Choosing A Sort — The Decision You'll Be Asked To Justify

| Situation | Algorithm | Why |
|---|---|---|
| Need stability (equal elements keep order) | Merge sort / Timsort | Quicksort and heapsort are not stable |
| Need in-place, average speed matters most | Quicksort with randomized pivot | `O(log n)` stack, good cache behaviour |
| Need guaranteed `O(n log n)` **and** `O(1)` space | Heapsort | The only one that gives both |
| Only need the kth element, not full order | Quickselect | `O(n)` average, not `O(n log n)` |
| Only need the top K | Bounded heap | `O(n log k)` and `O(k)` memory |
| Keys are bounded small integers | Counting sort | `O(n + k)` |
| Keys are fixed-width numbers or strings | Radix sort | `O(d · n)` |
| Values roughly uniform over a known range | Bucket sort | `O(n)` expected |
| Data doesn't fit in memory | External merge sort | Chunk, sort, k-way merge |
| Data arrives as a stream, need order maintained | `TreeMap` / skiplist / heap | No full sort possible |
| Nearly-sorted input | Insertion sort or Timsort | `O(n)` on nearly-sorted data |

**The general principle worth stating in an interview:** if you're about to sort and then take one element, you're doing `O(n log n)` work for an `O(n)` answer. Quickselect or a heap is usually the right correction — and noticing that unprompted is exactly the optimization instinct SDE III looks for.

---

## Pattern Recognition Check

| Signal in the problem | Approach |
|---|---|
| "Kth largest / smallest" | Quickselect or bounded heap — **not** a full sort |
| "Top K" | Bucket sort `O(n)`, heap `O(n log k)`, or quickselect |
| Count pairs out of order | Merge sort with counting |
| Arrange to form the largest/smallest number | Custom comparator — **verify transitivity** |
| Two attributes where one unlocks the other | Sort by attribute A, then process/insert by B |
| Groups where one group must keep input order | Stable sort + comparator returning 0 within that group |
| Values in `[1, n]`, find missing or duplicate | Cyclic sort / index marking — `O(1)` space |
| Bounded integer keys, need linear time | Counting or radix sort |
| Maximum gap between consecutive sorted values | Bucket sort + pigeonhole |
| Merge many sorted sources | Min-heap of K heads |
| More data than RAM | External merge sort |
| Sorted order needed while inserting | `TreeMap` / `TreeSet`, not a re-sort |

---

## Java Notes — The Comparator Traps

These matter more than the algorithms in this block. Every one is a real production bug pattern.

**1. `a - b` overflows.**
```java
// WRONG — overflows when a is large positive and b large negative
Arrays.sort(arr, (a, b) -> a - b);

// RIGHT
Arrays.sort(arr, (a, b) -> Integer.compare(a, b));
Arrays.sort(arr, Comparator.comparingInt(x -> x));
```
`Integer.MAX_VALUE - (-1)` wraps to a negative number, so your comparator reports the wrong order and the sort silently produces garbage.

**2. `IllegalArgumentException: Comparison method violates its general contract!`**
Thrown by `Arrays.sort` on objects (Timsort) when your comparator isn't a valid total order — non-transitive, or inconsistent with itself. Timsort detects the inconsistency mid-merge and bails.

The usual causes: subtraction overflow (above), a comparator that reads mutable state that changes during the sort, or returning inconsistent results for equal-ranked items. **This is a genuine production incident pattern** — good thing to be able to describe if the conversation goes there. It's also exactly why 179's transitivity argument matters.

**3. Stability guarantees differ by overload.**
- `Arrays.sort(int[])` and other primitive arrays → **dual-pivot quicksort, not stable** (stability is meaningless for primitives, but the worst case is `O(n²)` on adversarial input)
- `Arrays.sort(Object[])` and `Collections.sort` → **Timsort, stable**, `O(n log n)` guaranteed

If you need guaranteed `O(n log n)` on primitives with adversarial input, box them or shuffle first. Knowing this distinction is a real Java-depth signal.

**4. Multi-key comparators — use the fluent API.**
```java
// Height descending, then k ascending
people.sort(Comparator.comparingInt((int[] p) -> -p[0])
                      .thenComparingInt(p -> p[1]));

// Or with explicit reversal
people.sort(Comparator.comparingInt((int[] p) -> p[0]).reversed()
                      .thenComparingInt(p -> p[1]));
```
Hand-rolled multi-key subtraction is where bugs live, especially when only *one* key reverses. The fluent version makes the direction of each key explicit.

**5. `reversed()` reverses the whole chain built so far.**
`Comparator.comparing(A).thenComparing(B).reversed()` reverses **both** A and B — not just B. If you want only B reversed, put `.reversed()` on B's comparator: `.thenComparing(B, Comparator.reverseOrder())`.

**6. `Comparator.comparing` with a boxing extractor is slower.**
Prefer `comparingInt` / `comparingLong` / `comparingDouble` in hot paths — the generic version boxes on every comparison.

**7. `List.sort` vs `Collections.sort` vs `stream().sorted()`.**
`List.sort` mutates in place. `stream().sorted()` allocates a new list and is slower — fine for readability, worth noting if the interviewer asks about allocation.

---

## Progress Across the Plan

| Area | Target | Status |
|---|---|---|
| Arrays | 39 | ✔ |
| **Sorting (supplementary)** | **5** | **✔ list built** |
| Strings | 23 | ✔ |
| Hashing | 17 | ✔ |
| Binary search | 28 | ✔ |
| Linked list | 16 | ✔ |
| Stack / queue / monotonic | 25 | ✔ |
| Heap | 20 | ✔ |
| Trees + BST | 40 | ✔ |
| Tries | 10 | ✔ |
| Graphs | 48 | ✔ |
| DP | 58 | ✔ |
| Backtracking | 15 | ✔ |
| Bit / math | 16 | ✔ |
| Design | 12 | ✔ |

**Total: 371 problems across 15 blocks.** ~253 with all trim lists applied.
