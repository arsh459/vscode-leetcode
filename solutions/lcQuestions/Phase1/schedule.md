# Phase 1 — 10-Week Schedule

Tick the day when every problem on it is solved. Mark **Hint?** per problem in the Reference
file's own table — that's what the final sweep re-solves.

**7 days a week, Sunday included. No weekly revision day** — revision happens inline: whenever a
problem is marked Hint?, re-solve it cold before starting the next day, and the Week 10 final sweep
picks up whatever is still marked.

**Re-planned Fri 9 Oct 2026** after a 3-week break. Dates below are the target; Weeks run
Mon → Sun. Miss a day, shift everything after it by one — never double up. Target finish: **Sun 29 Nov**.
✔ = already in your repo, re-verify quickly rather than re-solving from scratch.

---

## Week 1 — Arrays I · Two pointers, sliding window, prefix sum ✅ done
> [../Reference/arrays.md](../Reference/arrays.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | Variable window | 3, 209, 424 | ✅ |
| 2 | Window + prefix sum | 76, 560, 525 | ✅ |
| 3 | Difference array, prefix/suffix, Kadane | 1109, 238, 53 | ✅ |
| 4 | Kadane, partition, quickselect, Two pointers | 152, 75, 215, 283, 88, 11 | ✅ |
| 5 | Two pointers | **438** | ✅ |

## Week 2 — Arrays II + Hashing ✅ done
> [../Reference/arrays.md](../Reference/arrays.md) · [../Reference/hashing.md](../Reference/hashing.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | Cyclic sort / index marking | 448, 287, 41 | ✅ |
| 2 | Intervals, permutation | 56, 57 | ✅ |
| 3 | Matrix, rotation, voting | 54, 48, 73, 189, 169 | ✅ |
| 4 | HashSet, frequency, bucketing | 1, 128, 347, 205, 187 | ✅ |
| 5 | Meet-in-middle, canonical keys, rolling hash | ~~15, 454~~ → W3D1, 763, 31 | ✅ |

**15 and 454 are carried into Week 3 Day 1.** Do them first that day, before the palindrome block —
15 is the two-pointer-after-sort template the rest of the phase assumes, and 454 is the
meet-in-the-middle idea you still owe yourself.

## Week 3 — Carry-over + Strings + Sorting + Binary Search I
> [../Reference/strings.md](../Reference/strings.md) · [../Reference/sorting.md](../Reference/sorting.md) · [../Reference/binary-search.md](../Reference/binary-search.md)

| Day | Date | Focus | Problems | Done |
|---|---|---|---|---|
| 1 | — | palindromes, expand-around-center |125, 5, 647 | [ ✅ ] |
| 2 | — | Anagram signatures| 242, 49| [ ✅ ] |
| 3 | — | Compression, in-place |  443 | [ ✅] |
| 4 | — | Reverse words, sums, KMP, LPS trick, stack | 151, 15, 454, 28, 459, 20 | [ ✅ ] |
| 4b | Fri 9 Oct | Re-entry · stack parsing, longest common prefix | 227, 394, 14 | [ ] |
| 5 | Sat 10 Oct | Sort from scratch, comparators | 912 *(merge + quick)*, 179, 406 | [ ] |
| 6–7 | Sun 11 Oct | Bounds + rotated arrays, peak | 704, 35, 34, 744, 33, 81, 153, 162 ✔ | [ ] |

Day 4b (re-entry after the Sep 17 – Oct 8 gap): before 227, re-solve **15** and **28** cold, ~10 min
each, no peeking — if either stalls, mark it Hint?. Then 227 (single pass, one stack, apply `*`/`/`
immediately, defer `+`/`-` as signed pushes — drop the string-splicing attempt), 394, 14.
Day 5: 179 is three lines of code and one transitivity argument; the argument is the problem.
Day 6–7 is two days folded into Sunday so every week ends on Sunday. It's lighter than it looks:
704 and 35 are five-minute warm-ups and 162 is a re-verify. The four bounds (704, 35, 34, 744) are
the templates every later binary search reuses — get them exactly right once, then 33/81/153 are
the same template with a "which half is sorted" check.

## Week 4 — Binary Search II + Linked List + Stacks I
> [../Reference/binary-search.md](../Reference/binary-search.md) · [../Reference/linked-list.md](../Reference/linked-list.md) · [../Reference/stacks-queues.md](../Reference/stacks-queues.md)

| Day | Date | Focus | Problems | Done |
|---|---|---|---|---|
| 1 | Mon 12 Oct | **Binary search on answer** | 1011, 875, 410 | [ ] |
| 2 | Tue 13 Oct | On answer, 2-D, precision | 1482, 74, 240, 69 | [ ] |
| 3 | Wed 14 Oct | Reversal, cycles, merge | 206, 141, 876, 21, 160 | [ ] |
| 4 | Thu 15 Oct | Partial reversal, nth-from-end, palindrome | 92, 19, 234, 2 | [ ] |
| 5 | Fri 16 Oct | k-group, merge k, cycle start, deep copy | 25, 23, 142, 138 | [ ] |
| 6 | Sat 17 Oct | Stack mechanics, next greater | 155, 232, 496, 503 | [ ] |
| 7 | Sun 18 Oct | Monotonic stack, lexicographic greedy | 739, 901, 402, 316 | [ ] |

**Day 1 is the highest-leverage session in the phase.** 1011 → 875 → 410 in that order, and write
`feasible(x)` before the search every time. Day 2: 240 is *not* binary search — know why cold,
because 74→240 is a standard pivot.

## Week 5 — Histogram + Heaps + Design I + Trees I
> [../Reference/stacks-queues.md](../Reference/stacks-queues.md) · [../Reference/heaps.md](../Reference/heaps.md) · [../Reference/design.md](../Reference/design.md) · [../Reference/trees-bst.md](../Reference/trees-bst.md)

| Day | Date | Focus | Problems | Done |
|---|---|---|---|---|
| 1 | Mon 19 Oct | **Histogram** | 84, 42 ✔ *(redo with stack)* | [ ] |
| 2 | Tue 20 Oct | Contribution counting, parsing, lazy iterator | 907, 32, 173, 1249 | [ ] |
| 3 | Wed 21 Oct | The size-K inversion, top K | 703, 1046, 973, 692 | [ ] |
| 4 | Thu 22 Oct | K-way merge, scheduling | 373, 621, 1834 | [ ] |
| 5 | Fri 23 Oct | **Two heaps**, sweep line, exchange argument | 295, 1094, 1642 | [ ] |
| 6 | Sat 24 Oct | **Hashmap + structure** | 146, 380, 981 | [ ] |
| 7 | Sun 25 Oct | Traversals — all three **iteratively** | 94, 144, 145, 104 | [ ] |

Day 1 is two problems on purpose. **84 gets the full session** — the bar is producing it cold in
under 20 minutes. Day 6: write your **own** doubly linked list for 146 — interviewers remove
`LinkedHashMap`. 146 is the single most-asked design problem in existence; it comes back in the
Week 10 final sweep.

## Week 6 — Trees II + BST
> [../Reference/trees-bst.md](../Reference/trees-bst.md)

| Day | Date | Focus | Problems | Done |
|---|---|---|---|---|
| 1 | Mon 26 Oct | Level order variants | 102, 103, 199 | [ ] |
| 2 | Tue 27 Oct | **Depth → diameter → max path** | 110, 543, 124 | [ ] |
| 3 | Wed 28 Oct | Path problems, prefix sum on a tree | 112, 113, 437 | [ ] |
| 4 | Thu 29 Oct | LCA, construction from traversals | 236, 235, 105 | [ ] |
| 5 | Fri 30 Oct | Serialization, BST validation | 297, 98, 108 | [ ] |
| 6 | Sat 31 Oct | BST operations | 701, 450, 230 | [ ] |
| 7 | Sun 1 Nov | Recovery, reverse inorder, tree DP | 99, 538, 337 | [ ] |

Day 2 is the most important progression in the block: 543 → 124 is one insight (return the best
downward path, *record* the best bending path). Day 3's 437 is Week 1's 560 applied to a tree —
notice that yourself before reading the note.

## Week 7 — Tries + Greedy/Intervals + Graphs I
> [../Reference/tries.md](../Reference/tries.md) · [../Reference/greedy.md](../Reference/greedy.md) · [../Reference/graphs.md](../Reference/graphs.md)

| Day | Date | Focus | Problems | Done |
|---|---|---|---|---|
| 1 | Mon 2 Nov | Trie core + prefix lookup | 208, 211, 648, 1268 | [ ] |
| 2 | Tue 3 Nov | Activity selection, coverage, intersection | 455, 134, 452, 1024, 986 | [ ] |
| 3 | Wed 4 Nov | Grid traversal + the border inversion | 200, 695, 130, 417 | [ ] |
| 4 | Thu 5 Nov | **Multi-source BFS** | 994, 542, 1091 | [ ] |
| 5 | Fri 6 Nov | Clone, weighted DFS, implicit state graph | 133, 399, 752 | [ ] |
| 6 | Sat 7 Nov | Word ladder, topological sort | 127, 207, 210 | [ ] |
| 7 | Sun 8 Nov | Cycles, union-find | 802, 547, 684 | [ ] |

Day 2: for every greedy answer, say the **exchange argument** out loud. "Sort by end time" is half
the answer; "because the earliest finish leaves the most room" is the other half. Day 3: solve 200
three ways (DFS, BFS, union-find). Day 4: seed **all** sources before the loop — running BFS per
source is the mistake this section exists to prevent. Day 7: write union-find once, with path
compression and union by size, and reuse it for the rest of the phase.

## Week 8 — Graphs II + DP I
> [../Reference/graphs.md](../Reference/graphs.md) · [../Reference/dp.md](../Reference/dp.md)

| Day | Date | Focus | Problems | Done |
|---|---|---|---|---|
| 1 | Mon 9 Nov | Union-find applied | 721, 990, 1319 | [ ] |
| 2 | Tue 10 Nov | MST, **Dijkstra** | 1584, 743, 1631 | [ ] |
| 3 | Wed 11 Nov | Bellman-Ford, Floyd-Warshall, bipartite | 787, 1334, 785 | [ ] |
| 4 | Thu 12 Nov | DAG DP / memoized DFS | 329, 1466 | [ ] |
| 5 | Fri 13 Nov | Memo → table → O(1) space | 70, 746, 198, 213 | [ ] |
| 6 | Sat 14 Nov | 1-D linear, greedy contrast | 91, 55, 45 | [ ] |
| 7 | Sun 15 Nov | **Coin change / unbounded knapsack** | 322, 518, 377 | [ ] |

Day 2: 1584 with **both** Kruskal and Prim. Day 3: understand why plain Dijkstra on node alone is
*wrong* for 787 — that's the follow-up, every time. Day 5: each of these four three ways
(recursion+memo → table → space-optimized). Practise the progression where it's trivial.
**Day 7 is the most instructive pair in the whole plan** — 518 vs 377, same inputs, only the loop
order differs (coins outer → combinations; target outer → permutations).

## Week 9 — DP II + DP III
> [../Reference/dp.md](../Reference/dp.md)

| Day | Date | Focus | Problems | Done |
|---|---|---|---|---|
| 1 | Mon 16 Nov | Squares, 0/1 knapsack | 279, 416, 494 | [ ] |
| 2 | Tue 17 Nov | 2-D capacity, grid DP | 474, 62, 63 | [ ] |
| 3 | Wed 18 Nov | Grid DP | 64, 120, 221 | [ ] |
| 4 | Thu 19 Nov | LIS + common substring/subsequence | 300, 1143, 718 | [ ] |
| 5 | Fri 20 Nov | Two-string DP | 72, 583, 516 | [ ] |
| 6 | Sat 21 Nov | Stock state machine | 122, 309, 714 | [ ] |
| 7 | Sun 22 Nov | Word break, DP + binary search | 139, 1235 | [ ] |

Day 1: 1-D 0/1 knapsack iterates capacity **backwards**; know what forward iteration silently turns
it into. Day 4: 300 both ways — `O(n²)` and `O(n log n)` patience.

## Week 10 — Backtracking + Bit/Math + Design II + Mock
> [../Reference/backtracking.md](../Reference/backtracking.md) · [../Reference/bit-math.md](../Reference/bit-math.md) · [../Reference/design.md](../Reference/design.md)

| Day | Date | Focus | Problems | Done |
|---|---|---|---|---|
| 1 | Mon 23 Nov | Subsets, permutations, **the duplicate rule** | 17, 78, 90, 46, 47 | [ ] |
| 2 | Tue 24 Nov | Combinations (`i` vs `i+1`), grid, guided generation | 39, 40, 79, 22 | [ ] |
| 3 | Wed 25 Nov | Bit fundamentals, XOR, power checks | 191, 136, 260, 338, 231 | [ ] |
| 4 | Thu 26 Nov | Fast exponentiation, sieve, **overflow discipline** | 50, 204, 7, 13, 8, 29 | [ ] |
| 5 | Fri 27 Nov | Booking, iterators, undo/redo | 729, 284, 1472, 341, 933 | [ ] |
| 6 | Sat 28 Nov | **Mock round** — 2 unseen Mediums, 45 min each, timed, out loud | — | [ ] |
| 7 | Sun 29 Nov | **Final sweep** | Every problem still marked Hint?, plus re-solve 146 | [ ] |

Day 1: derive the two duplicate-skip conditions on `[1,2,2]` rather than memorizing them; 90 and 47
differ for a reason. Days 3–4 are drills: if any single problem passes 20 minutes, read the idiom and
move on — the idiom is the deliverable. 7, 13 and 8 are **edge-case communication drills**, not
algorithms; enumerate the cases aloud before coding, which is exactly what's being scored.

Day 6 is the real assessment. Pick two Mediums you've never seen (any topic from this phase), set a
timer, narrate the whole thing. Whatever pattern you failed to name in 60 seconds is your Phase 2
starting point.

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

**215 problems · 65 problem days · 1 mock day · 1 final sweep — 10 weeks, 7 days each**

Weeks 1–2 + Week 3 Days 1–4 done. **52 days remain: Fri 9 Oct → Sun 29 Nov, Sunday included, no revision days.**

Graphs + DP = 57 problems, 19 days — **27% of the phase.** That ratio is the plan.
