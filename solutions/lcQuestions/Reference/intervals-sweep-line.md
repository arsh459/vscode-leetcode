# Intervals & Sweep Line — SDE III Prep (Supplementary Block)

**4 new problems · 0 Easy / 2 Medium / 2 Hard · 1 day**

Tick the checkbox when solved. Mark the **Hint?** column if you needed help — those get re-solved first.

> **Why this block is tiny:** intervals were distributed across Arrays, Heaps, Greedy, and Design, and that mostly worked. This closes the three real gaps — most importantly **218 Skyline**, which is a well-known Hard that fell between blocks.
>
> **Best placement: right after Greedy**, since 218 builds on the sweep-line idea and 986 on two-pointer interval logic.

---

## Coverage Audit

Already done — don't re-solve:

| Sub-topic | Where | Status |
|---|---|---|
| Merge intervals | 56 | Arrays ✔ |
| Insert interval | 57 | Arrays ✔ |
| Non-overlapping / activity selection | 435, 452, 646 | Arrays + Greedy ✔ |
| Partition by last occurrence | 763 | Arrays ✔ |
| Difference array (bounded index range) | 1109 | Arrays ✔ |
| Sweep line with events | 1094, 253 | Arrays + Heaps ✔ |
| Meeting rooms — min resources | 253 / 1094 | Heaps ✔ |
| Incremental booking with overlap limits | 729, 731, 732 | Design ✔ |
| Interval covering / minimum taps | 1024, 1326 | Greedy ✔ |
| Job scheduling by end time + binary search | 1235 | DP ✔ |
| **Interval intersection of two lists** | — | **Gap → 986** |
| **Skyline / sweep with heights** | — | **Gap → 218** |
| **Remove / subtract intervals** | — | **Gap → 1272** |
| **Interval merge + split under updates** | — | **Gap → 715 (optional)** |

---

## Two-List Intersection (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 986 | Interval List Intersections | Med | |

> Two sorted lists, two pointers, advance whichever ends first. The intersection is `[max(starts), min(ends)]` when that's valid.
>
> Short and clean, but it's the one interval mechanic not covered elsewhere — 56 and 57 both operate on a *single* list. The two-pointer-over-two-sorted-lists idea also appears in database merge joins, worth mentioning if the conversation goes there.

## Sweep Line with Heights (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 218 | The Skyline Problem | Hard | |

> **The notable gap.** A well-known Hard asked at Google, Amazon, and Meta, and it's the fullest expression of sweep line: event points sorted by x, a max-heap (or `TreeMap` multiset) of active heights, emit a key point whenever the maximum changes.
>
> Three things that make it hard, all worth working through deliberately:
> 1. **Event ordering at ties** — starts before ends at the same x, and taller starts before shorter ones, or you emit spurious points
> 2. **Removing a specific height from a heap** — `PriorityQueue.remove(Object)` is `O(n)`. Use **lazy deletion** (the technique from the Heaps block) or a `TreeMap<Integer, Integer>` as a multiset with `lastKey()`
> 3. **Deduplication** — only emit when the running max actually changes
>
> This is the payoff problem for two earlier techniques (lazy deletion, sweep line). If you solve one Hard from this file, solve this one.
>
> Also solvable by divide and conquer (merge two skylines, like merge sort). Know it exists; the sweep-line version is what's expected.

## Interval Subtraction & Range Maintenance (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1272 | Remove Interval *(premium)* | Med | |
| [ ] | 715 | Range Module | Hard | |

> 1272 is the inverse of 57 — subtracting instead of adding. Each existing interval either survives whole, gets clipped on one side, gets split in two, or vanishes. Four cases, and enumerating them cleanly *is* the problem. If premium-locked, do 715 instead; it subsumes this.
>
> **715 is the most fiddly problem in this file** — `addRange`, `queryRange`, `removeRange` on a `TreeMap<Integer, Integer>` of disjoint intervals, merging and splitting as you go. It's genuinely the same logic as an interval tree or a range-based allocator.
>
> **Do 715 only if you have time.** It's rarely asked directly, but the `TreeMap`-of-disjoint-intervals technique is the reusable part, and it's the same structure behind 729/731/732 in your Design block. If you skip the problem, at least be able to describe the approach.

---

## 1-Day Schedule

| Day | Problems | Done |
|---|---|---|
| 1 | 986, **218**, 1272, 715 *(optional)* | [ ] |

218 takes most of the session. Fold 986 in as a warm-up.

---

## Revision

Re-solve **cold** on:

- **Day 8** — 218, plus anything marked Hint?
- **Day 22** — same

218 specifically. It combines enough techniques that solving it once doesn't mean you have it.

---

## Trim to 2 If Pressed

986, 218

Cut: 1272, 715.

---

## The Four Interval Techniques

Every interval problem across your entire plan is one of these four. Knowing which one applies is the whole recognition task.

**1. Sort and sweep (single list).**
Sort by start (for merging) or by end (for selection), then one linear pass.
→ 56, 57, 435, 452, 646, 763, 986

**2. Event-based sweep line.**
Convert each interval into two events (`+1` at start, `−1` at end), sort all events by coordinate, process in order maintaining a running count or a structure of active items.
→ 253, 1094, 732, 218

**3. Difference array.**
When the coordinate space is small and bounded, skip the sorting — increment at start, decrement at end+1, prefix-sum at the end.
→ 1109, 1094, 2848

**4. Ordered map of disjoint intervals.**
Maintain the intervals themselves in a `TreeMap`, merging and splitting on insert/delete. Use when you need to *query* the current interval set, not just aggregate over it.
→ 729, 731, 715, 1272

**The choice between 2 and 3:** difference array is `O(n + range)` and simpler, but only works when the coordinate range is small enough to allocate. Sweep line is `O(n log n)` and works on arbitrary coordinates. State which constraint drove your choice — that's the interview content.

---

## The Event-Ordering Rule

The single most common bug in sweep-line problems. Get this right by convention rather than by debugging:

| Situation | Rule | Why |
|---|---|---|
| Intervals `[1,3]` and `[3,5]` — do they overlap? | **Ask.** Half-open `[start, end)` means no; closed `[start, end]` means yes | Changes the answer for meeting rooms |
| Start and end at the same coordinate | For "min resources," process the **end first** (a room frees up before the next meeting needs it) | Otherwise you over-count rooms |
| Same coordinate, multiple starts (218) | Process **taller first** | Otherwise you emit a key point that's immediately superseded |
| Same coordinate, start and end (218) | Process **starts before ends** | A building starting where another ends shouldn't dip to zero |

**Ask about closed vs half-open before you code.** It takes five seconds and it's the difference between right and wrong on 253. Interviewers notice the question.

---

## Pattern Recognition Check

| Signal in the problem | Approach |
|---|---|
| Combine overlapping intervals | Sort by start, merge forward |
| Insert one interval into a sorted list | Three-phase scan: before, overlapping, after |
| Maximum non-overlapping count | Sort by **end**, greedy select |
| Minimum removals for non-overlap | Same, count the rest |
| Minimum rooms / resources / platforms | Sweep line, or min-heap of end times |
| Maximum concurrent overlaps at any point | Sweep line, running count, track max |
| Overlaps between **two** sorted lists | Two pointers, advance the earlier end |
| Skyline / outline of stacked rectangles | Sweep line + max-heap with lazy deletion |
| Many range updates, one final read | Difference array |
| Bounded small coordinate range | Difference array over sweep line |
| Add/remove/query ranges over time | `TreeMap` of disjoint intervals |
| Subtract an interval from a set | Four-case split logic |
| Book only if no conflict | `TreeMap.floorKey` / `ceilingKey` |
| Cover a target range with fewest intervals | Greedy — sort by start, jump to farthest end |
| Best value subset of non-overlapping intervals | DP + binary search (1235) |

---

## Java Notes

- `TreeMap` is the workhorse here. `floorKey`, `ceilingKey`, `higherEntry`, `lowerEntry`, `subMap`, `headMap`, `tailMap` — all `O(log n)`. Most of 715, 729, 731, 732 is 15–20 lines with it.
- For 218's active-height multiset, `TreeMap<Integer, Integer>` (height → count) with `lastKey()` gives `O(log n)` max **and** `O(log n)` arbitrary removal, which a `PriorityQueue` can't. Cleaner than lazy deletion here.
- Sorting event arrays: `Arrays.sort(events, Comparator.comparingInt((int[] e) -> e[0]).thenComparingInt(e -> e[1]))` — and encode the tie-break *into* the second field's sign so ordering falls out naturally (negative heights for starts is the standard trick in 218).
- Never `(a, b) -> a[0] - b[0]` — coordinates in these problems reach `Integer.MAX_VALUE`. Use `Integer.compare`.
- Difference arrays need `n + 1` length so `diff[end + 1]--` doesn't go out of bounds.
- `int[]{start, end}` is fine and idiomatic; a `record Interval(int start, int end)` reads better if you're writing a full class and shows you're on a modern Java version.

---

## Progress Across the Plan

| Area | Target | Status |
|---|---|---|
| Arrays | 39 | ✔ |
| Sorting | 5 | ✔ |
| Strings | 23 | ✔ |
| Hashing | 17 | ✔ |
| Binary search | 28 | ✔ |
| Linked list | 16 | ✔ |
| Stack / queue / monotonic | 25 | ✔ |
| Heap | 20 | ✔ |
| Greedy | 8 | ✔ |
| **Intervals & sweep line** | **4** | **✔ list built** |
| Trees + BST | 40 | ✔ |
| Tries | 10 | ✔ |
| Graphs | 48 | ✔ |
| DP | 58 | ✔ |
| Backtracking | 15 | ✔ |
| Bit / math | 16 | ✔ |
| Design | 12 | ✔ |
| Concurrency | 9 + 4 ex | ✔ |

**Running total: 392 + 4 exercises.**
