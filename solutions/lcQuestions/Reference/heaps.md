# Heaps / Priority Queues — SDE III Prep (Final List)

**20 new problems (+2 crossovers referenced) · 2 Easy / 12 Medium / 6 Hard · 5 days**

Tick the checkbox when solved. Mark the **Hint?** column if you needed help — those get re-solved first.

> **Why heaps punch above their conceptual weight:** they're the natural answer to *top K* and *streaming*, and streaming problems are where interviewers probe whether you reason about memory bounds. The algorithm is easy; the follow-up is the interview.

### Already covered elsewhere — referenced, not re-counted

| # | Problem | Where |
|---|---|---|
| 347 | Top K Frequent Elements | Hashing ✔ |
| 23 | Merge k Sorted Lists | Linked Lists ✔ |
| 378 | Kth Smallest in a Sorted Matrix | Binary Search ✔ — *mention the heap alternative there* |

---

## Heap Fundamentals (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 215 | Kth Largest Element *(in Hashing — redo with heap)* | Med | |
| [ ] | 703 | Kth Largest Element in a Stream | Easy | |

> 703 teaches the key insight cheaply: to track the Kth **largest**, keep a **min**-heap of size K. That inversion is unintuitive and it underpins the entire top-K section.
>
> Also be ready to explain **heapify's `O(n)` build vs n insertions at `O(n log n)`** — a standard *"are you sure?"* follow-up.

## Top K (3 new)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 973 | K Closest Points to Origin | Med | |
| [ ] | 692 | Top K Frequent Words | Med | |
| [ ] | 1046 | Last Stone Weight | Easy | |
| [ ] | 347 | Top K Frequent Elements *(already in Hashing)* | Med | |

> 973 is canonical, and the follow-up is always *"what if points arrive as a stream and don't fit in memory?"* — answer: bounded max-heap of size K. That's the whole point of the pattern.
>
> 692 adds a lexicographic tiebreak, so the comparator **flips direction between the two keys**. That comparator is a common place to write a subtle bug — write it carefully.

## Merge K Sorted (2 new)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 373 | Find K Pairs with Smallest Sums | Med | |
| [ ] | 632 | Smallest Range Covering Elements from K Lists | Hard | |
| [ ] | 23 | Merge k Sorted Lists *(already in Linked Lists)* | Hard | |

> 373 is *k-way merge on an implicit grid* — never materialize all n² pairs, expand lazily from the heap. Generalizes to a lot of real problems.
>
> 632 is the strongest problem in this block: pull the min, note the current max, advance that list. Also solvable with a sliding window — know both.

## Two Heaps / Median (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 295 | Find Median from Data Stream | Hard | |
| [ ] | 480 | Sliding Window Median | Hard | |

> **295 is the highest-value problem here.** Max-heap for the lower half, min-heap for the upper, rebalance so sizes differ by at most one. Asked constantly, and it's the standard bridge into *"now design this for a distributed stream"* — direct system design overlap.
>
> 480 is 295 with deletions, which heaps don't support natively. Two approaches: **lazy deletion** with a delayed-removal map, or a `TreeSet`-based multiset. Do the lazy-deletion version — it's the reusable technique.

## Scheduling / Intervals with Heap (4)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 253 | Meeting Rooms II *(premium — heap version)* | Med | |
| [ ] | 621 | Task Scheduler | Med | |
| [ ] | 1834 | Single-Threaded CPU | Med | |
| [ ] | 767 | Reorganize String | Med | |

> If 253 is locked, **1094 Car Pooling** covers the same shape — you already have it in Arrays. Do the **heap** variant there instead of the difference-array one.
>
> 621 has both a heap simulation and an `O(1)` math formula. Do the heap version first (it generalizes), then learn the formula because interviewers ask for the optimization.
>
> 1834 is a simulation with time advancement — the closest thing on LeetCode to real scheduler logic, and a nice bridge to your OS fundamentals.
>
> 767 is greedy-with-heap: always place the most frequent remaining character that isn't the previous one.

## Greedy + Heap (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1642 | Furthest Building You Can Reach | Med | |
| [ ] | 502 | IPO | Hard | |
| [ ] | 1029 | Two City Scheduling *(no heap — **contrast case**)* | Med | |

> 502 is dual-heap capital maximization: one structure sorted by capital requirement, a max-heap of currently achievable profits. The clearest *"two different orderings at once"* problem, and that idea recurs.
>
> 1642 is the exchange argument — ladders for the largest jumps, bricks for the rest; a min-heap of size `ladders` finds them online.
>
> **1029 is here deliberately as a contrast.** It looks like a heap problem and isn't — it's a sort by cost difference. Recognizing when *not* to reach for a heap is part of the skill.

## Applied / Design (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1962 | Remove Stones to Minimize the Total | Med | |
| [ ] | 355 | Design Twitter | Med | |

> 355's feed merge is a k-way heap merge over followees' tweet lists. **Direct system design overlap** — this is the DSA-scale version of a news feed. Being able to trace one to the other out loud is a strong signal.

---

## 5-Day Schedule

| Day | Problems | Done |
|---|---|---|
| 1 | 215 *(heap redo)*, 703, 1046, 973, 692 | [ ] |
| 2 | 373, 632, 621 | [ ] |
| 3 | **295, 480** | [ ] |
| 4 | 253 / 1094, 1834, 767, 1642 | [ ] |
| 5 | 502, 1029, 1962, 355 | [ ] |

**Day 3 is two Hards only** — 295 deserves the time and 480 is genuinely fiddly.

---

## Revision

Re-solve **cold** (no notes, from scratch) on:

- **Day 12** — everything marked Hint?, plus 295, 632, 502, 373, 480
- **Day 26** — same set, plus anything that needed a hint on day 12

---

## Trim to 13 If Pressed

703, 973, 692, 373, 632, 295, 253/1094, 621, 1834, 502, 1642, 355, 215

Cut: 1046, 480, 767, 1029, 1962.

---

## What Interviewers Actually Probe

**1. The size-K inversion.**
Kth **largest** → **min**-heap of size K. Kth **smallest** → **max**-heap of size K. State it out loud when you code it — it reads as deliberate rather than lucky.

**2. Why a heap and not sorting.**
The honest answer: *the data is streaming, or K ≪ n, so I get `O(n log k)` time and bounded `O(k)` memory instead of `O(n log n)` and `O(n)`.*
If K ≈ n, **sorting is fine and you should say so.** That's the actual follow-up on 347.

**3. The streaming follow-up.**
Nearly every top-K problem ends with *"now it's an infinite stream"* or *"now it doesn't fit in memory."* The bounded heap is the answer. The natural extension — **compute local top-K per shard, then merge** — connects straight to your system design block. Have that sentence ready.

**4. Lazy deletion.**
`PriorityQueue.remove(Object)` is `O(n)`, which quietly ruins the complexity of window problems. Fix: a removal-count map, popping stale entries when you peek. **The single most useful non-obvious technique in this block.**

```java
// lazy deletion pattern
Map<Integer, Integer> delayed = new HashMap<>();
void prune(PriorityQueue<Integer> pq) {
    while (!pq.isEmpty() && delayed.getOrDefault(pq.peek(), 0) > 0) {
        delayed.merge(pq.peek(), -1, Integer::sum);
        pq.poll();
    }
}
```

---

## Pattern Recognition Check

| Signal in the problem | Approach |
|---|---|
| "K largest / K most frequent / K closest" | Bounded heap of size K, inverted |
| K arriving as a stream | Same, and say the memory bound out loud |
| Merge k sorted sequences | Min-heap of k heads |
| K smallest sums / products from pairs | Heap on an implicit grid, expand lazily |
| Running median | Two heaps, rebalanced |
| Median over a sliding window | Two heaps + lazy deletion |
| Minimum rooms / resources for intervals | Min-heap of end times |
| Task or CPU scheduling with cooldown | Max-heap by frequency + cooldown queue |
| Pick greedily, best-available-so-far | Two structures: one sorted by eligibility, one heap by value |
| Repeatedly halve/reduce the largest | Max-heap |
| Feed merge across followees | K-way heap merge |
| Sorted by a *difference* between two costs | **Plain sort — not a heap** (1029) |

---

## Java Notes

- `PriorityQueue` is a **min**-heap by default. Max-heap: `new PriorityQueue<>(Comparator.reverseOrder())` or `(a, b) -> b - a` (use `Integer.compare` to avoid overflow).
- `new PriorityQueue<>(collection)` uses `O(n)` heapify; adding one-by-one is `O(n log n)`. Mention this when it applies.
- `peek()` / `poll()` are the only ordered operations — **iterating a `PriorityQueue` does not yield sorted order.** Common bug.
- `remove(Object)` is `O(n)`. Use lazy deletion instead.
- No decrease-key in Java's `PriorityQueue` — for Dijkstra, push a duplicate entry and skip stale pops. (Comes up again in Graphs.)
- Comparator with multiple keys: `Comparator.comparingInt(...).thenComparing(...)` — cleaner and less bug-prone than hand-rolled subtraction, and reversing only one key is explicit.
- `TreeSet` / `TreeMap` as a sorted multiset when you need `O(log n)` arbitrary deletion, which a heap can't give you.

---

## Progress Across the Plan

| Area | Target | Status |
|---|---|---|
| Arrays | 39 | ✔ list built |
| Strings | 23 | ✔ list built |
| Hashing | 17 | ✔ list built |
| Binary search | 28 | ✔ list built |
| Linked list | 16 | ✔ list built |
| Stack / queue / monotonic | 25 | ✔ list built |
| **Heap** | **20** | **✔ list built** |
| Trees + BST | 40 | |
| Tries | 10 | |
| Graphs | 45–50 | |
| DP | 55–60 | |
| Backtracking | 15 | |
| Bit / math | 15 | |
| Design | 15 | |

**Running total: 167 / ~350.**

Halfway. Remaining blocks are the heavy ones — **protect the graphs-and-DP ratio.**

---

## Addendum 2 — Residual Coverage Check

One outline item: "**Indexed heap** / decrease-key, lazy deletion pattern." Lazy deletion is covered; the indexed heap is not.

### Indexed heap (conceptual + optional exercise)

An **indexed heap** (or *indexed priority queue*) maintains a `position[]` map from element identity to its current array index inside the heap. That map is what makes `decreaseKey(element, newValue)` possible in `O(log n)` — you look up where the element lives, change its value, and sift it up.

Java's `PriorityQueue` has no such map, which is why `remove(Object)` is `O(n)` and why there's no `decreaseKey` at all.

**The three ways to handle this, in order of what you should say:**

| Approach | Cost | When |
|---|---|---|
| **Push duplicate, skip stale** on pop (`if (d > dist[u]) continue;`) | Heap grows to `O(E)`, still `O(E log E)` | **Default answer.** What everyone does in Java Dijkstra |
| **Lazy deletion** with a removal-count map | `O(log n)` amortized | Sliding-window problems where entries expire (480, 218) |
| **Indexed heap** with a position map | True `O(log n)` decrease-key, heap stays `O(V)` | When memory matters, or a textbook Dijkstra is requested |

**The complexity nuance worth stating:** textbook Dijkstra with a Fibonacci heap is `O(E + V log V)`; with a binary heap and decrease-key it's `O(E log V)`; with push-duplicates it's `O(E log E)`. Since `log E ≤ 2 log V`, these are the same asymptotic class — **the duplicate-pushing version is not worse in big-O**, only in constant factor and memory.

That's the answer if an interviewer says *"but Java has no decrease-key, doesn't that break your complexity?"* No, it doesn't, and being able to say why cleanly is a better signal than implementing an indexed heap.

**Optional exercise (~30 lines):** add a `Map<T, Integer> position` to a hand-rolled binary heap, maintain it in `swap()`, and expose `decreaseKey`. Do this only if you have spare time — the reasoning above is what gets tested.

**Count unchanged: 20 problems.**
