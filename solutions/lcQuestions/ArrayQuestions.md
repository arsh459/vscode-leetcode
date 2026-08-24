# Arrays

**39 problems · 4 Easy / 30 Medium / 5 Hard · 10 days**

Tick the checkbox when solved. Mark the **Hint?** column if you needed help — those get re-solved first.

---

## Two Pointers (4)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 283 | Move Zeroes | Easy | |
| [ ] | 88 | Merge Sorted Array | Easy | |
| [ ] | 15 | 3Sum | Med | |
| [ ] | 11 | Container With Most Water | Med | |

## Sliding Window — Fixed (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 438 | Find All Anagrams in a String | Med | |
| [ ] | 239 | Sliding Window Maximum *(monotonic deque)* | Hard | |

## Sliding Window — Variable (5)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 3 | Longest Substring Without Repeating Characters | Med | |
| [ ] | 209 | Minimum Size Subarray Sum | Med | |
| [ ] | 424 | Longest Repeating Character Replacement | Med | |
| [ ] | 1004 | Max Consecutive Ones III | Med | |
| [ ] | 76 | Minimum Window Substring | Hard | |

## At-Most-K Trick (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1248 | Count Number of Nice Subarrays | Med | |
| [ ] | 992 | Subarrays with K Different Integers | Hard | |

> Solve 1248 **both ways** — `atMost(k) - atMost(k-1)` and prefix-sum + hashmap. Know why they're equivalent.

## Prefix Sum (4)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 560 | Subarray Sum Equals K | Med | |
| [ ] | 525 | Contiguous Array | Med | |
| [ ] | 974 | Subarray Sums Divisible by K | Med | |
| [ ] | 304 | Range Sum Query 2D – Immutable | Med | |

## Prefix + Suffix (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 238 | Product of Array Except Self | Med | |

## Difference Array / Sweep Line (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1109 | Corporate Flight Bookings | Med | |
| [ ] | 1094 | Car Pooling *(sweep line; 253 if you have premium)* | Med | |

## Kadane (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 53 | Maximum Subarray | Med | |
| [ ] | 152 | Maximum Product Subarray | Med | |
| [ ] | 918 | Maximum Sum Circular Subarray | Med | |

## Partition / Quickselect (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 75 | Sort Colors | Med | |
| [ ] | 215 | Kth Largest Element *(quickselect)* | Med | |

## Cyclic Sort / Index Marking (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 448 | Find All Numbers Disappeared in an Array | Easy | |
| [ ] | 287 | Find the Duplicate Number | Med | |
| [ ] | 41 | First Missing Positive | Hard | |

## Intervals (4)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 56 | Merge Intervals | Med | |
| [ ] | 57 | Insert Interval | Med | |
| [ ] | 435 | Non-overlapping Intervals | Med | |
| [ ] | 763 | Partition Labels | Med | |

## Matrix (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 54 | Spiral Matrix | Med | |
| [ ] | 48 | Rotate Image | Med | |
| [ ] | 73 | Set Matrix Zeroes | Med | |

## Voting / Permutation / Rearrangement (4)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 169 | Majority Element | Easy | |
| [ ] | 229 | Majority Element II | Med | |
| [ ] | 31 | Next Permutation | Med | |
| [ ] | 189 | Rotate Array | Med | |

## Bonus (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 42 | Trapping Rain Water | Hard | |

---

## 10-Day Schedule

| Day | Problems | Done |
|---|---|---|
| 1 | 283, 88, 15, 11 | [ ] |
| 2 | 438, 3, 209, 424 | [ ] |
| 3 | 1004, 76, 239 | [ ] |
| 4 | 1248, 992, 560, 525 | [ ] |
| 5 | 974, 304, 238, 1109 | [ ] |
| 6 | 1094, 53, 152, 918 | [ ] |
| 7 | 75, 215, 448, 287 | [ ] |
| 8 | 41, 56, 57, 435 | [ ] |
| 9 | 763, 54, 48, 73 | [ ] |
| 10 | 169, 229, 31, 189, 42 | [ ] |

**Move to binary search on day 11 — whether or not everything felt clean.**

---

## Revision

Re-solve **cold** (no notes, from scratch) on:

- **Day 17** — everything marked Hint?, plus 15, 76, 992, 41, 42
- **Day 31** — same set, plus anything that needed a hint on day 17

---

## Practice Rules

- **Re-derive, don't recall.** If you solved 560 by remembering "prefix sum + map," you haven't learned it.
- **State complexity before coding.** Say the input-size → target-complexity reasoning out loud.
- **Do the follow-ups.** "Now in O(1) space" / "now it's a stream" — that's where SDE III is decided.
- **Write compilable Java**, not pseudocode. Correct types, no drift.
- **Dry-run on a small example unprompted**, before the interviewer asks.
- **Find your own bugs.** Self-correcting is a stronger signal than being right the first time.

---

## Pattern Recognition Check

Before moving on, you should identify the right pattern within ~60 seconds of reading a new problem:

| Signal in the problem | Pattern |
|---|---|
| Sorted array, pair/triplet sum | Two pointers, opposite ends |
| "Contiguous subarray" + constraint that can be violated then fixed | Variable sliding window |
| "Exactly K" distinct/odd/sum | `atMost(K) - atMost(K-1)` |
| "Count subarrays with sum = K" (with negatives) | Prefix sum + hashmap |
| Max/min over every window of size K | Monotonic deque |
| Many range updates, one final read | Difference array |
| Start/end events, count overlaps | Sweep line |
| Values in range [1, n], find missing/duplicate | Cyclic sort / index marking |
| Kth largest/smallest, no full sort needed | Quickselect |
| Max/min contiguous sum or product | Kadane |
| O(1) extra space demanded on a full array | In-place encoding or reversal trick |

---

## Where Arrays Sit in the Whole Plan

Arrays are ~15–20% of coding rounds. Don't overinvest — graphs (45–50) and DP (55–60) should each get more than this list.

| Area | Target |
|---|---|
| **Arrays** | **39** |
| Strings | 20–25 |
| Binary search | 25–30 |
| Linked list | 15 |
| Stack / queue / monotonic | 25 |
| Heap | 20 |
| Trees + BST | 40 |
| Tries | 10 |
| Graphs | 45–50 |
| DP | 55–60 |
| Backtracking | 15 |
| Bit / math | 15 |
| Design | 15 |

~350 total. **Protect the graphs-and-DP ratio.**
