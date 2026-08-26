# Design Problems (DSA-flavored) — SDE III Prep (Final List)

**12 new problems · 1 Easy / 8 Medium / 3 Hard · 3 days**

Tick the checkbox when solved. Mark the **Hint?** column if you needed help — those get re-solved first.

> **Why this block is short:** most of the classic design problems were already absorbed into earlier blocks where they taught a data structure. This list covers only what's genuinely new.
>
> **Why it still matters more than its size suggests:** design problems are the closest thing in a coding round to your LLD round, and they're graded differently. Nobody cares whether you find a clever trick — they care whether you clarify the API before coding, pick the right structure for the stated access pattern, state the complexity of *each* operation, and write code that would survive review. That's the whole game here.

### Already covered elsewhere — 16 design problems done

| # | Problem | Where |
|---|---|---|
| 146 | LRU Cache | Hashing ✔ |
| 460 | LFU Cache | Hashing ✔ |
| 380 | Insert Delete GetRandom O(1) | Hashing ✔ |
| 981 | Time Based Key-Value Store | Hashing ✔ |
| 895 | Maximum Frequency Stack | Hashing ✔ |
| 705 | Design HashMap | Hashing ✔ |
| 155 | Min Stack | Stacks ✔ |
| 622 | Design Circular Queue | Stacks ✔ |
| 641 | Design Circular Deque | Stacks ✔ |
| 173 | BST Iterator | Stacks ✔ |
| 341 | Flatten Nested List Iterator | Stacks ✔ |
| 703 | Kth Largest in a Stream | Heaps ✔ |
| 355 | Design Twitter | Heaps ✔ |
| 208 | Implement Trie | Tries ✔ |
| 211 | Add and Search Words | Tries ✔ |
| 307 | Range Sum Query — Mutable | Trees ✔ |

---

## Rate Limiting & Time Windows (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 933 | Number of Recent Calls | Easy | |
| [ ] | 362 | Design Hit Counter *(premium)* | Med | |
| [ ] | 359 | Logger Rate Limiter *(premium)* | Easy | |

> **The most system-design-adjacent problems on this page.** 933 is a sliding-window log with a queue. 362 is the same thing with the crucial follow-up: *"what if there are thousands of hits per second?"* → bucketed circular array, `O(1)` memory instead of `O(hits)`.
>
> If both premiums are locked, implement a **token bucket** and a **sliding window counter** from scratch as an exercise. That's the actual content, and it's directly reusable in your system design round when rate limiting comes up.
>
> Be ready to discuss: fixed window vs sliding window log vs sliding window counter vs token bucket vs leaky bucket, and the memory/accuracy tradeoff between them.

## Calendar & Interval Booking (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 729 | My Calendar I | Med | |
| [ ] | 731 | My Calendar II | Med | |
| [ ] | 732 | My Calendar III | Hard | |

> A clean difficulty ladder on one API — do all three in order.
>
> - **729**: `TreeMap.floorKey` / `ceilingKey` to detect overlap in `O(log n)`
> - **731**: track double-booked intervals separately, or use the delta-count map
> - **732**: the **sweep-line delta map** — `TreeMap<Integer, Integer>` with `+1` at start, `-1` at end, then a running prefix max
>
> 732's solution is the same technique as 253 (Meeting Rooms II) but maintained incrementally under insertions. Recognizing that connection out loud is worth points.
>
> 715 (Range Module) is the harder sibling — interval merge/split on a `TreeMap`. Do it only if you have time; it's the most fiddly problem in this block.

## Snapshot & Versioned State (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1146 | Snapshot Array | Med | |
| [ ] | 1352 | Product of the Last K Numbers | Med | |

> **1146 is copy-on-write** — store `(snapId, value)` pairs per index, binary search on read. This is the DSA-scale version of MVCC, which you already know from your DBMS prep. That connection (*"this is how Postgres does snapshot isolation"*) is exactly the kind of cross-domain remark that lands at SDE III.
>
> 1352 is prefix products with the zero-reset trick. Short, and the zero handling is the whole problem.

## Iterators & Streaming Interfaces (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 284 | Peeking Iterator | Med | |
| [ ] | 900 | RLE Iterator | Med | |

> 284 is deceptively good interview material: **wrapping an interface you don't control**, caching one element, keeping `hasNext` correct. Pure API design discipline.
>
> 900 is lazy decompression — never materialize the expanded sequence. The "don't expand what you can compute" instinct is the point.

## Ordered Structures & Advanced (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1244 | Design A Leaderboard | Med | |
| [ ] | 1206 | Design Skiplist | Hard | |

> 1244's real content is the **access-pattern tradeoff**: a hashmap gives `O(1)` updates but `O(n log n)` top-K; a `TreeMap` gives `O(log n)` updates and `O(K)` top-K. Ask which operation dominates before choosing — that question *is* the answer they want.
>
> **1206 is the one worth doing even though it's rarely asked.** Skip lists are the structure behind Redis sorted sets and LevelDB's memtable, and being able to say *"probabilistic balancing, expected `O(log n)`, far simpler than a red-black tree, which is why Redis uses it"* is real system design ammunition. Budget a full session.

## Bonus — Worth Knowing, Not Grinding

| # | Problem | Why |
|---|---|---|
| 588 | Design In-Memory File System *(premium, Hard)* | Trie-of-directories; nice LLD crossover |
| 642 | Design Search Autocomplete *(premium, Hard)* | Trie + top-K; the "real" autocomplete |
| 348 | Design Tic-Tac-Toe *(premium, Med)* | `O(1)` win check via row/col/diag counters |
| 1472 | Design Browser History | Two stacks; 10-minute problem |
| 715 | Range Module *(Hard)* | `TreeMap` interval merge/split |
| 855 | Exam Room *(Med)* | Maximize minimum distance, `TreeSet` |

Skip these unless a specific company you're targeting is known for them. 1472 is cheap if you want one more.

---

## 3-Day Schedule

| Day | Problems | Done |
|---|---|---|
| 1 | 933, 362, 359, 284, 900 | [ ] |
| 2 | 729, 731, 732, 1352 | [ ] |
| 3 | 1146, 1244, **1206** | [ ] |

Day 3 is three problems because the skiplist takes real time.

---

## Revision

Re-solve **cold** (no notes, from scratch) on:

- **Day 10** — everything marked Hint?, plus 732, 1146, 362
- **Day 24** — same set, plus anything that needed a hint on day 10

Also re-solve **146 and 460** during this block regardless of when you first did them. They're the two most-asked design problems in existence and they decay.

---

## Trim to 8 If Pressed

933, 362, 729, 732, 1146, 284, 1244, 1206

Cut: 359, 731, 1352, 900.

---

## How Design Problems Are Actually Graded

These are scored differently from algorithm problems. The code matters less; the process matters more. Work through this sequence explicitly, out loud.

**1. Clarify the API before writing anything.**
What are the exact method signatures? What's the return on a miss — null, exception, sentinel? Are keys unique? Is the input range bounded? Can values be negative? **This is the step candidates skip and interviewers score.**

**2. Ask which operations dominate.**
"Are reads or writes more frequent?" changes the answer for 1244, 1146, and 981. A design that's optimal for one is wrong for the other. Asking shows you think about access patterns rather than pattern-matching to a structure.

**3. State the complexity of every method, not just the hard one.**
`get`: `O(1)`. `put`: `O(1)` amortized. `topK`: `O(k log n)`. Do this as you write each method, not as an afterthought.

**4. Write code that would pass review.**
Real class, real field declarations, sensible names, no single-letter variables outside loop indices. Handle the empty case. If you'd be embarrassed to open a PR with it, it's not SDE III code.

**5. Volunteer the scaling follow-up.**
*"This is in-memory and single-threaded. If it needed to be concurrent I'd use `ConcurrentHashMap` plus a lock on the eviction list. If it needed to be distributed I'd shard by key hash and accept that global ordering becomes approximate."*
Saying this **before** being asked is a strong senior signal, and it's the natural handoff into your system design round.

---

## Pattern Recognition Check

| Requirement | Structure |
|---|---|
| `O(1)` get + `O(1)` eviction by recency | Hashmap + doubly linked list |
| `O(1)` eviction by frequency | Hashmap + freq→DLL + min-freq pointer |
| `O(1)` insert, delete, **and** random | Hashmap + array, swap-to-end |
| "Value at time T" | Hashmap → sorted list + binary search |
| "Events in the last N seconds" | Queue, or bucketed circular array for high volume |
| Overlap detection on insert | `TreeMap.floorKey` / `ceilingKey` |
| Max concurrent overlaps, incremental | Sweep-line delta map + running prefix max |
| Read a historical version | Copy-on-write `(version, value)` pairs + binary search |
| Top-K, frequent **updates** | Hashmap + heap, or `TreeMap` — ask which dominates |
| Ordered set with `O(log n)` rank queries | Skiplist, or `TreeMap` + BIT |
| Prefix / autocomplete queries | Trie, optionally with cached top-K per node |
| Range sum with point updates | BIT or segment tree |
| Wrap an interface, add lookahead | Cache one element, forward `hasNext` |
| Lazy expansion of compressed data | Compute on demand, never materialize |
| Undo / redo | Two stacks |

---

## Java Notes

- **`TreeMap` is your most underused tool in this block.** `floorKey`, `ceilingKey`, `higherKey`, `firstEntry`, `pollFirstEntry`, `subMap`, `headMap`, `tailMap` — all `O(log n)`. Most calendar and interval design problems are 15 lines with it.
- `LinkedHashMap` with `accessOrder = true` and an overridden `removeEldestEntry` gives you an LRU in 5 lines. **Know it, mention it, then write the manual version** — interviewers ask for the manual one.
- `Collections.binarySearch` on a `List` returns `-(insertionPoint) - 1` on miss. Used constantly in 1146 and 981.
- `ArrayDeque` for queue-based rate limiters. `ArrayDeque` cannot hold `null`.
- For concurrency follow-ups, know the actual names: `ConcurrentHashMap`, `ReentrantReadWriteLock`, `AtomicLong`, `CopyOnWriteArrayList`, `Semaphore`. Naming the right primitive is most of the credit.
- Generics in a design problem (`class TimeMap<K, V>`) reads better than `String`-hardcoded, and it's free. Do it when the signature allows.
- `record` (Java 16+) for immutable value holders like `(timestamp, value)` — cleaner than a static nested class and shows you're current.

---

## The Connection To Your Other Tracks

This block is the bridge. Several of these map one-to-one onto things you're studying separately:

| Design problem | Maps to |
|---|---|
| 362 Hit Counter | Rate limiting — API gateway design |
| 732 My Calendar III | Meeting room allocation, resource scheduling |
| 1146 Snapshot Array | **MVCC** — your DBMS isolation-level prep |
| 1206 Skiplist | Redis sorted sets, LevelDB memtable |
| 146 LRU / 460 LFU | Cache eviction policies — caching layer design |
| 355 Design Twitter | News feed fanout — the classic system design question |
| 981 Time-Based KV | Versioned storage, event sourcing |
| 705 Design HashMap | Java `HashMap` internals — your Java depth round |

When one of these comes up in a coding round, naming the real-world system it corresponds to costs you one sentence and reads as genuine breadth rather than memorization.

---

## Progress Across the Plan — COMPLETE

| Area | Target | Status |
|---|---|---|
| Arrays | 39 | ✔ |
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
| **Design** | **12** | **✔ list built** |

**Total: 366 problems across 14 blocks.**

**Trimmed totals if time is short: ~250.** Every block has a trim list — use them rather than skipping a block entirely. A thin pass over graphs beats a thorough pass over linked lists.

**Non-negotiables if you can only protect three things:** graphs, DP, and the revision cycles. The revision cycles are the ones people cut first and regret most.

---

## Addendum — Final Coverage Audit

Four outline items missed — three problems and one exercise.

| ✔ | # | Problem | Diff | Why it was missing | Hint? |
|---|---|---|---|---|---|
| [ ] | — | **Design Underground System** *(search by name)* | Med | "Design underground/train system" was in the outline | |
| [ ] | 281 | Zigzag Iterator *(premium)* | Med | "Iterator design: flatten nested, peeking, **zigzag**, BST" | |
| [ ] | 348 | Design Tic-Tac-Toe *(premium)* | Med | "Design tic-tac-toe / snake game" | |

**Design Underground System** is the most realistic problem in this block and it's not premium. Two hashmaps: one for in-progress journeys keyed by customer id, one for `(start, end)` → running total plus count. `getAverageTime` is a division. The design content is the follow-up: *"how would you handle a customer who never checks out?"* (TTL eviction) and *"how would you shard this?"* (by route pair, since averages are per-route). Genuinely close to real telemetry aggregation.

**281** is round-robin across k iterators using a queue of iterators — pop one, take an element, push it back if it still has elements. Generalizes cleanly to k lists, which is the follow-up. Complements 284 (Peeking) and 341 (Flatten Nested), and together the three cover the iterator-design family from the outline.

**348** is the `O(1)`-win-check design: maintain row counts, column counts, and two diagonal counts, incrementing by +1/−1 per player. A move is a win when any counter hits ±n. The naive `O(n²)` board scan works and signals much less — the counter approach is the answer they want. If premium-locked, implement it from the description; it's 30 lines.

### In-memory KV store with TTL (exercise, no LeetCode problem)

From the outline. This is the most practically-relevant thing on the page and has no LeetCode equivalent — worth writing.

**Interface:**
```java
class TTLCache<K, V> {
    void put(K key, V value, long ttlMillis);
    V get(K key);          // null if absent or expired
    int size();            // live entries only
}
```

**The design question is *when* expiry happens**, and there are three strategies. Be able to name all three and their tradeoffs:

| Strategy | How | Tradeoff |
|---|---|---|
| **Lazy** | Check expiry on read, remove if stale | Zero background cost, but dead entries occupy memory indefinitely if never read |
| **Active** | Background thread scans and evicts | Bounded memory, costs a thread and a scan; usually **sampled** rather than full-scan |
| **Priority queue** | Min-heap ordered by expiry time | Precise eviction, but `O(log n)` per write and a stale-entry problem when TTLs are updated |

**Redis uses lazy plus sampled active expiry** — it checks a random sample of keys periodically rather than scanning everything, accepting that some dead keys linger. Naming that is the senior answer, and it's the same accept-approximation-for-throughput reasoning as approximate LRU in Exercise 2 of the Concurrency block.

**Follow-ups to have ready:** how do you make it thread-safe (the three-tier answer from the Concurrency block); how do you cap total size (combine TTL with LRU eviction, which is what a real cache does); and how does TTL interact with a write-through cache (the backing store has no TTL, so you're only expiring the cached copy).

**Revised count: 15 problems + 1 exercise.** The Design block is now the closest thing in your plan to LLD-round practice — the exercise above especially, since "design a cache with expiry" is a standard LLD prompt.

---

## Addendum 2 — Residual Coverage Check

Three outline items still missing. **432 is the significant one.**

| ✔ | # | Problem | Diff | Outline item | Hint? |
|---|---|---|---|---|---|
| [ ] | 432 | All O`one Data Structure | Hard | "Design a data structure with O(1) insert/delete/**getMin**" | |
| [ ] | 716 | Max Stack *(premium)* | Hard | "Min stack, **max stack**" | |
| [ ] | 353 | Design Snake Game *(premium)* | Med | "Design tic-tac-toe / **snake game**" | |

**432 is the real gap and it's worth doing properly.** The outline asked for `O(1)` insert, delete, and get-min — 155 (Min Stack) only gives that for LIFO access, which isn't the same thing. 432 wants `inc(key)`, `dec(key)`, `getMaxKey()`, `getMinKey()`, all `O(1)`, with arbitrary keys.

The structure is a **doubly linked list of frequency buckets**, each bucket holding a set of keys at that count, plus a hashmap from key → bucket. `inc` moves a key to the adjacent bucket (creating it if needed); min and max are the list's head and tail. This is **exactly the LFU (460) architecture** generalized — if you did 460, you already have the machinery, and recognizing that is most of the value.

Do this one even if you skip the two premiums. It's the third member of the 146/460 family and it completes the pattern.

**716** — see the Stacks & Queues addendum for the full note. Counted once, there.

**353** is grid simulation with a deque for the snake body plus a set for `O(1)` self-collision detection. The design question is *"why both a deque and a set?"* — the deque gives you head/tail ordering, the set gives you constant-time collision checks. Maintaining two views of the same data for different access patterns is the transferable idea. Skip if premium-locked; it's the least valuable of the three.

**Revised count: 17 problems + 1 exercise** (716 counted in Stacks).
