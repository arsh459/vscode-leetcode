# Phase 1 — 13-Week Schedule

Tick the day when every problem on it is solved. Mark **Hint?** per problem in the Reference
file's own table — that's what Day 6 re-solves.

Week/Day numbering is relative, not calendar-dated. Miss a day, shift; the plan survives it.
✔ = already in your repo, re-verify quickly rather than re-solving from scratch.

---

## Week 1 — Arrays I · Two pointers, sliding window, prefix sum
> [../Reference/arrays.md](../Reference/arrays.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | Two pointers | 283 , 88 , 15 , 11 , **438** | [ ] |
| 2 | Variable window | 3, 209, 424 | [ 424 ] |
| 3 | Window + prefix sum | 76, 560, 525 | [ ] |
| 4 | Difference array, prefix/suffix, Kadane | 1109, 238, 53 | [ ] |
| 5 | Kadane, partition, quickselect | 152, 75, 215 | [ ] |
| 6 | **Revision** | Hint? set + cold: 3, 76 | [ ] |

Day 1 is four new problem — use the spare time to get the sliding-window
skeleton clean, because days 2–3 depend on it.

## Week 2 — Arrays II + Hashing
> [../Reference/arrays.md](../Reference/arrays.md) · [../Reference/hashing.md](../Reference/hashing.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | Cyclic sort / index marking | 448, 287, 41 | [ ] |
| 2 | Intervals, permutation | 56, 57, 763, 31 | [ ] |
| 3 | Matrix, rotation, voting | 54, 48, 73, 189, 169 | [ ] |
| 4 | HashSet, frequency, bucketing | 1 ✔, 128, 347 | [ ] |
| 5 | Meet-in-middle, canonical keys, rolling hash | 454, 205, 187 | [ ] |
| 6 | **Revision** | Hint? set + cold: 560, 41, 128 | [ ] |

Do **347 three ways** (heap, bucket, quickselect) on day 4 — it's the one problem here with a
guaranteed follow-up.

## Week 3 — Strings + Sorting
> [../Reference/strings.md](../Reference/strings.md) · [../Reference/sorting.md](../Reference/sorting.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | Palindromes, expand-around-center | 125, 5, 647 | [ ] |
| 2 | Anagram signatures, KMP **by hand** | 242, 49, 28 | [ ] |
| 3 | LPS trick, compression, in-place | 459, 443, 151, 14 | [ ] |
| 4 | Stack parsing | 20, 227, 394 | [ ] |
| 5 | Sort from scratch, comparators | 912 *(merge + quick)*, 179, 406 | [ ] |
| 6 | **Revision** | Hint? set + cold: 5, 28, 49 | [ ] |

Day 2: **do not solve 28 with `indexOf`** — build the LPS array. Day 5: 179 is three lines of code
and one transitivity argument; the argument is the problem.

## Week 4 — Binary Search + Linked List I
> [../Reference/binary-search.md](../Reference/binary-search.md) · [../Reference/linked-list.md](../Reference/linked-list.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | Bounds — write these once, reuse forever | 704, 35, 34, 744 | [ ] |
| 2 | Rotated arrays, peak | 33, 81, 153, 162 | [ ] |
| 3 | **Binary search on answer** | 1011, 875, 410 | [ ] |
| 4 | On answer, 2-D, precision | 1482, 74, 240, 69 | [ ] |
| 5 | Reversal, cycles, merge | 206, 141, 876, 21, 160 | [ ] |
| 6 | **Revision** | Hint? set + cold: 410, 33, 34; re-verify 4 ✔ | [ ] |

**Day 3 is the highest-leverage session in the first month.** 1011 → 875 → 410 in that order,
and write `feasible(x)` before the search every time. Note that 240 is *not* binary search — know
why cold, because 74→240 is a standard pivot.

## Week 5 — Linked List II + Stacks I
> [../Reference/linked-list.md](../Reference/linked-list.md) · [../Reference/stacks-queues.md](../Reference/stacks-queues.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | Partial reversal, nth-from-end, palindrome | 92, 19, 234, 2 | [ ] |
| 2 | k-group, merge k, cycle start, deep copy | 25, 23, 142, 138 | [ ] |
| 3 | Stack mechanics, next greater | 155, 232, 496, 503 | [ ] |
| 4 | Monotonic stack, lexicographic greedy | 739, 901, 402, 316 | [ ] |
| 5 | **Histogram** | 84, 42 ✔ *(redo with stack)* | [ ] |
| 6 | **Revision** | Hint? set + cold: 25, 84, 142 | [ ] |

Day 5 is two problems on purpose. **84 gets the full session** — the Reference file's bar is
producing it cold in under 20 minutes, and that's the right bar.

## Week 6 — Stacks II + Heaps + Design I
> [../Reference/stacks-queues.md](../Reference/stacks-queues.md) · [../Reference/heaps.md](../Reference/heaps.md) · [../Reference/design.md](../Reference/design.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | Contribution counting, parsing, lazy iterator | 907, 32, 173, 1249 | [ ] |
| 2 | The size-K inversion, top K | 703, 1046, 973, 692 | [ ] |
| 3 | K-way merge, scheduling | 373, 621, 1834 | [ ] |
| 4 | **Two heaps**, sweep line, exchange argument | 295, 1094, 1642 | [ ] |
| 5 | **Hashmap + structure** | 146, 380, 981 | [ ] |
| 6 | **Revision** | Hint? set + cold: 146, 295, 907 | [ ] |

Day 5: write your **own** doubly linked list for 146 — interviewers remove `LinkedHashMap`. 146 is
the single most-asked design problem in existence; it gets re-solved again in Week 13.

## Week 7 — Trees I
> [../Reference/trees-bst.md](../Reference/trees-bst.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | Traversals — all three **iteratively** | 94, 144, 145, 104 | [ ] |
| 2 | Level order variants | 102, 103, 199 | [ ] |
| 3 | **Depth → diameter → max path** | 110, 543, 124 | [ ] |
| 4 | Path problems, prefix sum on a tree | 112, 113, 437 | [ ] |
| 5 | LCA, construction from traversals | 236, 235, 105 | [ ] |
| 6 | **Revision** | Hint? set + cold: 124, 437, 236 | [ ] |

Day 3 is the most important progression in the block: 543 → 124 is one insight (return the best
downward path, *record* the best bending path). Day 4's 437 is Week 1's 560 applied to a tree —
notice that yourself before reading the note.

## Week 8 — Trees II + Tries + Greedy/Intervals
> [../Reference/trees-bst.md](../Reference/trees-bst.md) · [../Reference/tries.md](../Reference/tries.md) · [../Reference/greedy.md](../Reference/greedy.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | Serialization, BST validation | 297, 98, 108 | [ ] |
| 2 | BST operations | 701, 450, 230 | [ ] |
| 3 | Recovery, reverse inorder, tree DP | 99, 538, 337 | [ ] |
| 4 | Trie core + prefix lookup | 208, 211, 648, 1268 | [ ] |
| 5 | Activity selection, coverage, intersection | 455, 134, 452, 1024, 986 | [ ] |
| 6 | **Revision** | Hint? set + cold: 297, 98, 450, 208 | [ ] |

Day 5: for every greedy answer, say the **exchange argument** out loud. "Sort by end time" is
half the answer; "because the earliest finish leaves the most room" is the other half.

## Week 9 — Graphs I
> [../Reference/graphs.md](../Reference/graphs.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | Grid traversal + the border inversion | 200, 695, 130, 417 | [ ] |
| 2 | **Multi-source BFS** | 994, 542, 1091 | [ ] |
| 3 | Clone, weighted DFS, implicit state graph | 133, 399, 752 | [ ] |
| 4 | Word ladder, topological sort | 127, 207, 210 | [ ] |
| 5 | Cycles, union-find | 802, 547, 684 | [ ] |
| 6 | **Revision** | Hint? set + cold: 200, 127, 207 | [ ] |

Day 1: solve 200 three ways (DFS, BFS, union-find). Day 2: seed **all** sources before the loop —
running BFS per source is the mistake this section exists to prevent. Day 5: write union-find once,
with path compression and union by size, and reuse it for the rest of the phase.

## Week 10 — Graphs II + DP I
> [../Reference/graphs.md](../Reference/graphs.md) · [../Reference/dp.md](../Reference/dp.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | Union-find applied | 721, 990, 1319 | [ ] |
| 2 | MST, **Dijkstra** | 1584, 743, 1631 | [ ] |
| 3 | Bellman-Ford, Floyd-Warshall, bipartite | 787, 1334, 785 | [ ] |
| 4 | DAG DP / memoized DFS | 329, 1466 | [ ] |
| 5 | Memo → table → O(1) space | 70, 746, 198, 213 | [ ] |
| 6 | **Revision** | Hint? set + cold: 743, 787, 721 | [ ] |

Day 2: 1584 with **both** Kruskal and Prim. Day 3: understand why plain Dijkstra on node alone is
*wrong* for 787 — that's the follow-up, every time. Day 5: each of these four three ways
(recursion+memo → table → space-optimized). Practise the progression where it's trivial.

## Week 11 — DP II
> [../Reference/dp.md](../Reference/dp.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | 1-D linear, greedy contrast | 91, 55, 45 | [ ] |
| 2 | **Coin change / unbounded knapsack** | 322, 518, 377 | [ ] |
| 3 | Squares, 0/1 knapsack | 279, 416, 494 | [ ] |
| 4 | 2-D capacity, grid DP | 474, 62, 63 | [ ] |
| 5 | Grid DP | 64, 120, 221 | [ ] |
| 6 | **Revision** | Hint? set + cold: 322, 416, and 518 vs 377 | [ ] |

**518 vs 377 on day 2 is the most instructive pair in the whole plan** — same inputs, and only the
loop order differs (coins outer → combinations; target outer → permutations). Day 3: 1-D 0/1
knapsack iterates capacity **backwards**; know what forward iteration silently turns it into.

## Week 12 — DP III + Backtracking I
> [../Reference/dp.md](../Reference/dp.md) · [../Reference/backtracking.md](../Reference/backtracking.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | LIS + common substring/subsequence | 300, 1143, 718 | [ ] |
| 2 | Two-string DP | 72, 583, 516 | [ ] |
| 3 | Stock state machine | 122, 309, 714 | [ ] |
| 4 | Word break, DP + binary search | 139, 1235 | [ ] |
| 5 | Subsets, permutations, **the duplicate rule** | 17, 78, 90, 46, 47 | [ ] |
| 6 | **Revision** | Hint? set + cold: 72, 300, 62 | [ ] |

Day 1: 300 both ways — `O(n²)` and `O(n log n)` patience. Day 5: derive the two duplicate-skip
conditions on `[1,2,2]` rather than memorizing them; 90 and 47 differ for a reason.

## Week 13 — Backtracking II + Bit/Math + Design II + Mock
> [../Reference/backtracking.md](../Reference/backtracking.md) · [../Reference/bit-math.md](../Reference/bit-math.md) · [../Reference/design.md](../Reference/design.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | Combinations (`i` vs `i+1`), grid, guided generation | 39, 40, 79, 22 | [ ] |
| 2 | Bit fundamentals, XOR, power checks | 191, 136, 260, 338, 231 | [ ] |
| 3 | Fast exponentiation, sieve, **overflow discipline** | 50, 204, 7, 13, 8 | [ ] |
| 4 | Booking, iterators, undo/redo | 729, 284, 1472, 341, 933 | [ ] |
| 5 | **Mock round** — 2 unseen Mediums, 45 min each, timed, out loud | — | [ ] |
| 6 | **Final sweep** | Every problem still marked Hint?, plus re-solve 146 | [ ] |

Days 2–3 are drills: if any single problem passes 20 minutes, read the idiom and move on — the
idiom is the deliverable. 7, 13 and 8 are **edge-case communication drills**, not algorithms;
enumerate the cases aloud before coding, which is exactly what's being scored.

Day 5 is the real assessment. Pick two Mediums you've never seen (any topic from this phase),
set a timer, narrate the whole thing. Whatever pattern you failed to name in 60 seconds is your
Phase 2 starting point.

---

## Coverage summary

| Topic | Phase 1 | Days | Topic | Phase 1 | Days |
|---|---|---|---|---|---|
| Arrays | 25 | 8 | Trees & BST | 25 | 8 |
| Hashing | 5 | 2 | Tries | 4 | 1 |
| Strings | 13 | 4 | Graphs | 27 | 9 |
| Sorting | 3 | 1 | DP | 30 | 10 |
| Binary search | 15 | 4 | Backtracking | 9 | 2 |
| Linked list | 13 | 3 | Bit / math | 10 | 2 |
| Stacks & queues | 13 | 4 | Design | 8 | 2 |
| Heaps | 10 | 3 | Greedy + intervals | 5 | 1 |

**215 problems · 64 new-problem days · 13 revision days · 1 mock day**

Graphs + DP = 57 problems, 19 days — **27% of the phase.** That ratio is the plan.
