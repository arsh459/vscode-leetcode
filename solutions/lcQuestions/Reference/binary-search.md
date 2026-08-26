# Binary Search — SDE III Prep (Final List)

**28 problems (27 new + 1 crossover) · 4 Easy / 14 Medium / 10 Hard · 7 days**

Tick the checkbox when solved. Mark the **Hint?** column if you needed help — those get re-solved first.

> **Why this block matters most:** binary search on answer is the most under-practiced pattern relative to how often it decides an interview. The Hard-heavy split below is correct — these Hards are formulaic once you have the template, not genuinely difficult. Don't rush this block.

---

## Classic / Bounds (4)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 704 | Binary Search | Easy | |
| [ ] | 35 | Search Insert Position | Easy | |
| [ ] | 34 | Find First and Last Position of Element | Med | |
| [ ] | 744 | Find Smallest Letter Greater Than Target | Easy | |

> Write `lowerBound` and `upperBound` **once, correctly**, and reuse them for the rest of your prep. 34 is just those two called back to back.
>
> **Pick one loop invariant and never deviate.** Half-open `[lo, hi)` is cleanest. Off-by-one bugs come almost entirely from switching conventions mid-prep.

## Rotated & Modified Sorted Arrays (5)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 33 | Search in Rotated Sorted Array | Med | |
| [ ] | 81 | Search in Rotated Sorted Array II *(duplicates)* | Med | |
| [ ] | 153 | Find Minimum in Rotated Sorted Array | Med | |
| [ ] | 154 | Find Minimum in Rotated Sorted Array II | Hard | |
| [ ] | 540 | Single Element in a Sorted Array | Med | |

> 81 is where duplicates break the invariant and the worst case degrades to `O(n)` — be able to explain **why**, not just handle it. 540 uses index parity, a genuinely different idea.

## Peak / Mountain (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 162 | Find Peak Element | Med | |
| [ ] | 852 | Peak Index in a Mountain Array | Med | |

> 162 is *binary search without a sorted array* — a local comparison tells you which half must contain a peak. This unlocks the answer-space thinking in the next section.

## Binary Search on Answer — **the core section** (8)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1011 | Capacity To Ship Packages Within D Days | Med | |
| [ ] | 875 | Koko Eating Bananas | Med | |
| [ ] | 410 | Split Array Largest Sum | Hard | |
| [ ] | 1482 | Minimum Number of Days to Make m Bouquets | Med | |
| [ ] | 1552 | Magnetic Force Between Two Balls | Med | |
| [ ] | 2064 | Minimized Maximum of Products Distributed to Any Store | Med | |
| [ ] | 1231 | Divide Chocolate *(premium — else skip)* | Hard | |
| [ ] | 774 | Minimize Max Distance to Gas Station *(premium — else skip)* | Hard | |

**The three-step template — every problem above is this:**

1. Identify the answer range `[lo, hi]`
2. Write a **monotonic** `feasible(x)` predicate
3. Binary search for the boundary where feasibility flips

> 1011 and 875 are the same problem in different clothes. 410 is the canonical *minimize the maximum* — if you can solve 410 cold **and** explain why the greedy feasibility check is correct, you own the pattern.
>
> **Order matters: 1011 → 875 → 410.**

## Kth Element / Merged Order (4)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 4 | Median of Two Sorted Arrays | Hard | |
| [ ] | 378 | Kth Smallest Element in a Sorted Matrix | Med | |
| [ ] | 668 | Kth Smallest Number in Multiplication Table | Hard | |
| [ ] | 719 | Find K-th Smallest Pair Distance | Hard | |

> 4 searches the **partition point**, not the value — a different mental model, and the most commonly asked Hard in this block.
>
> 378, 668, 719 are all *binary search on value + count how many ≤ x*. One idea, three dressings.

## 2-D Search (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 74 | Search a 2D Matrix *(treat as flat array)* | Med | |
| [ ] | 240 | Search a 2D Matrix II *(staircase from corner)* | Med | |

> These were flagged as at-risk in the Arrays file — they land here.
>
> **240 is not binary search.** It's an `O(m+n)` staircase walk. Know the distinction cold: interviewers ask 74, then pivot to 240 to see whether you notice the structural difference.

## Floating Point / Precision (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 69 | Sqrt(x) | Easy | |

> Do the integer version, then the float version. Know why you loop on precision (`hi - lo > 1e-6`) rather than `lo < hi` — and that **fixed-iteration** (`for i in 0..100`) is the safer interview choice, since it can't hang.

## Unbounded / Infinite (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 702 | Search in a Sorted Array of Unknown Size *(premium)* | Med | |

> Exponential search — double the bound until you overshoot, then binary search inside it. If premium-locked, just know the technique; it's ~10 lines and appears as a follow-up more often than standalone.

## Applied / Crossover (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1044 | Longest Duplicate Substring *(already in Strings)* | Hard | |

> Count it once. Revisit here specifically as **binary search on answer length** — good proof the pattern crosses topic boundaries.

---

## 7-Day Schedule

| Day | Problems | Done |
|---|---|---|
| 1 | 704, 35, 34, 744 | [ ] |
| 2 | 33, 81, 153, 154, 540 | [ ] |
| 3 | 162, 852, 1011, 875 | [ ] |
| 4 | 410, 1482, 1552 | [ ] |
| 5 | 2064, 1231, 774 *(or extras)* | [ ] |
| 6 | 4, 378, 668, 719 | [ ] |
| 7 | 74, 240, 69, 702 | [ ] |

---

## Revision

Re-solve **cold** (no notes, from scratch) on:

- **Day 14** — everything marked Hint?, plus 410, 4, 33, 875, 719
- **Day 28** — same set, plus anything that needed a hint on day 14

---

## Trim to 18 If Pressed

704, 34, 33, 81, 153, 162, 1011, 875, 410, 1482, 1552, 4, 378, 719, 74, 240, 69, 540

Cut: 35, 744, 154, 852, 2064, 1231, 774, 702.

---

## The One Thing To Get Right

Most people pass 704 and still fail 410. The gap: classic binary search searches an **array**; everything valuable searches an **answer space that isn't materialized anywhere**.

**Tells in the problem statement:**

- "minimize the maximum" / "maximize the minimum"
- "smallest capacity such that…" / "minimum speed to finish in…"
- `n ≤ 10⁵` paired with values up to `10⁹` — that value range is your search space, not the array
- Any question where checking a candidate answer is easy but finding it directly is hard

**When you see min/max optimization with a checkable condition: write `feasible(x)` first, binary search second.** The predicate is the whole problem; the search is boilerplate.

---

## Pattern Recognition Check

| Signal in the problem | Approach |
|---|---|
| Sorted array, find exact/insert position | `lowerBound` / `upperBound` |
| First and last occurrence | Both bounds, called twice |
| Sorted but rotated | Compare `mid` to `hi` to find the sorted half |
| Rotated **with duplicates** | Same, but shrink on ties — `O(n)` worst case |
| No sort order, but local slope exists | Peak search (162) |
| "Minimize the maximum X" | Binary search on answer + greedy feasibility |
| "Maximize the minimum X" | Same, with the predicate inverted |
| Kth smallest across sorted structures | Binary search on **value** + count ≤ x |
| Median of two sorted arrays | Binary search on **partition point** |
| Matrix sorted row-wise and column-wise | Staircase walk `O(m+n)` — **not** binary search |
| Matrix fully sorted when flattened | Binary search on flat index `[i/cols][i%cols]` |
| Real-valued answer | Fixed-iteration loop, not equality |
| Unknown / infinite bounds | Exponential search first, then binary |

---

## Java Notes

- `mid = lo + (hi - lo) / 2` — never `(lo + hi) / 2`. Overflow is a real interview ding.
- `Arrays.binarySearch` returns `-(insertionPoint) - 1` on miss. Know the formula; then write your own anyway.
- `Collections.binarySearch` requires the list be sorted by the comparator you pass, not `compareTo`.
- Use `long` for feasibility accumulators — sums in 410 / 1011 overflow `int` easily.
- `TreeMap.floorKey` / `ceilingKey` / `higherKey` are binary search in disguise; useful in 981 and interval problems.

---

## Progress Across the Plan

| Area | Target | Status |
|---|---|---|
| Arrays | 39 | ✔ list built |
| Strings | 23 | ✔ list built |
| Hashing | 17 | ✔ list built |
| **Binary search** | **28** | **✔ list built** |
| Linked list | 15 | |
| Stack / queue / monotonic | 25 | |
| Heap | 20 | |
| Trees + BST | 40 | |
| Tries | 10 | |
| Graphs | 45–50 | |
| DP | 55–60 | |
| Backtracking | 15 | |
| Bit / math | 15 | |
| Design | 15 | |

**Running total: 106 / ~350** (1044 counted once, in Strings).

**Protect the graphs-and-DP ratio.**

---

## Addendum — Final Coverage Audit

One item from the original outline not explicitly covered.

| ✔ | # | Problem | Diff | Why | Hint? |
|---|---|---|---|---|---|
| [ ] | 644 | Maximum Average Subarray II *(premium)* | Hard | "Fractional / parametric search" — binary searching a **ratio** rather than a value | |

**Why it's a distinct technique.** 69 (Sqrt) binary searches a real number directly. Parametric search binary searches a *candidate ratio* and transforms the feasibility check algebraically: to test whether some subarray has average ≥ `x`, subtract `x` from every element and ask whether any subarray of length ≥ k has a non-negative sum. That transformation — turning "is the ratio achievable" into "is a sum non-negative" — is the skill.

This shows up in maximize-average and minimize-ratio problems generally (e.g. "maximize profit per unit time"). Rare in interviews, but when it appears, nothing else works.

**If premium-locked:** LC 1898 or 1802 are loose substitutes, but honestly just read the technique. Know the two steps: binary search the ratio, subtract it out, check feasibility on the transformed array.

**Revised count: 29 problems.** Optional — cut this first if you're trimming.
