# Phase 2 — 16-Week Schedule

Same conventions as Phase 1: tick the day when it's clear, mark **Hint?** in the Reference table,
Day 6 re-solves. *(premium)* = needs a subscription; implement from the Reference description
otherwise. ✔ = already in your repo.

---

## Week 1 — Arrays II + Sorting II
> [../Reference/arrays.md](../Reference/arrays.md) · [../Reference/sorting.md](../Reference/sorting.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | Monotonic deque, window edge cases | 239, 1004, 918 | [ ] |
| 2 | **The at-most-K trick** | 1248 *(both ways)*, 992 | [ ] |
| 3 | 2-D prefix sum, remainder counting | 974, 304, 435 | [ ] |
| 4 | Voting II, diagonal, in-place encoding | 229, 498, 289, 1470 | [ ] |
| 5 | Stability, radix, heapsort | 937, 164, **heapsort on 912** | [ ] |
| 6 | **Revision** | Hint? set + cold: 239, 992 · template: monotonic stack | [ ] |

Day 2: solve 1248 **both** ways — `atMost(k) − atMost(k−1)` and prefix-sum + hashmap — and be able
to say why they're equivalent. Day 4: 289's point is packing two states into one cell's spare bits,
which is a different trick from 189's reversal.

## Week 2 — Strings II + Hashing II
> [../Reference/strings.md](../Reference/strings.md) · [../Reference/hashing.md](../Reference/hashing.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | KMP payoff + **Z-algorithm** *(exercise 10)* | 214 | [ ] |
| 2 | Rolling hash + **Manacher's** *(exercise 11)* | 1044 | [ ] |
| 3 | Parens + unary minus, wildcard DP | 224, 44 | [ ] |
| 4 | RLE, serialization, tokenization | 38, 271 *(premium)*, 165, 12, 249 *(premium)* | [ ] |
| 5 | Frequency bucketing, remainder wrinkle | 451, 954, 523 | [ ] |
| 6 | **Revision** | Hint? set + cold: 214, 224 · template: lowerBound/upperBound | [ ] |

Day 1 is one problem and one implementation: write the Z-array, then solve 214 with it. Day 2:
1044 is binary search on answer *plus* Rabin-Karp — do the Manacher pass on 5 in the same session
so both `O(n)` string techniques land together.

## Week 3 — Hashing II + Binary Search II
> [../Reference/hashing.md](../Reference/hashing.md) · [../Reference/binary-search.md](../Reference/binary-search.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | **Canonical forms**, composite keys, collisions | 149, 2013, 705 | [ ] |
| 2 | LFU + frequency buckets | 460, 895 | [ ] |
| 3 | Duplicates break the invariant, index parity | 154, 540, 852 | [ ] |
| 4 | On-answer variants, exponential search | 1552, 2064, 702 *(premium)* | [ ] |
| 5 | **Binary search on value + count ≤ x** | 378, 668 | [ ] |
| 6 | **Revision** | Hint? set + cold: 149, 460 · template: union-find | [ ] |

Day 1: 149 is the block's key problem — slope as a key forces GCD reduction and sign normalization;
floats are wrong and knowing why is the point. Day 2: 460 and 895 are the same architecture, and
both are 146 generalized. Day 5: 378 and 668 are one idea in two dressings.

## Week 4 — Binary Search II + Linked List II + Stacks II
> [../Reference/binary-search.md](../Reference/binary-search.md) · [../Reference/linked-list.md](../Reference/linked-list.md) · [../Reference/stacks-queues.md](../Reference/stacks-queues.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | Pair distance, chocolate, gas stations | 719, 1231 *(premium)*, 774 *(premium)* | [ ] |
| 2 | Pairs, three-technique composite, O(1)-space sort | 24, 143, 148, 61 | [ ] |
| 3 | Two-chain splice, multilevel flatten | 86, 328, 430 | [ ] |
| 4 | Queue-from-stacks, RPN, ring buffers | 225, 150, 622, 641 | [ ] |
| 5 | 132 pattern, **maximal rectangle** | 456, 85 | [ ] |
| 6 | **Revision** | Hint? set + cold: 719, 148, 85 · template: BFS with levels | [ ] |

Day 2: 148 is the one place bottom-up merge sort on a list is genuinely required — `O(1)` space
rules out recursion. Day 5: 85 is 84 applied row by row; if it doesn't fall out in 30 minutes,
your 84 isn't clean enough yet.

## Week 5 — Stacks II + Heaps II
> [../Reference/stacks-queues.md](../Reference/stacks-queues.md) · [../Reference/heaps.md](../Reference/heaps.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | Contribution counting, good subarray | 1793, 2104, 828 | [ ] |
| 2 | Prefix sum + deque, **max stack** | 862, 716 *(premium)* | [ ] |
| 3 | **Lazy deletion** — the technique Week 6 needs | 632, 480 | [ ] |
| 4 | Greedy + heap, two orderings at once | 767, 502, 1029 *(contrast — not a heap)* | [ ] |
| 5 | Reduce-largest, feed merge + **exercise 9** | 1962, 355, 253 *(premium)*, indexed heap | [ ] |
| 6 | **Revision** | Hint? set + cold: 862, 480 · template: Dijkstra | [ ] |

Day 3 is load-bearing for the whole phase. `PriorityQueue.remove(Object)` is `O(n)`, which quietly
ruins window complexity; the delayed-removal map is the fix, and 218 next week depends on it.
Day 5's exercise: add a `position` map to a hand-rolled heap and expose `decreaseKey`.

## Week 6 — Intervals & Skyline + Greedy II + Tries II
> [../Reference/intervals-sweep-line.md](../Reference/intervals-sweep-line.md) · [../Reference/greedy.md](../Reference/greedy.md) · [../Reference/tries.md](../Reference/tries.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | **The Skyline Problem** — full session | 218 | [ ] |
| 2 | Interval subtraction; the four techniques | 1272 *(premium)*, cold re-solve 218 | [ ] |
| 3 | Two-pass greedy, activity selection | 1005, 135, 646 | [ ] |
| 4 | Coverage greedy, deadline scheduling, Huffman | 1326, 630, 1167 *(premium)* | [ ] |
| 5 | Trie+backtracking, aggregates + **exercise 8** | 212, 720, 677, trie `delete` | [ ] |
| 6 | **Revision** | Hint? set + cold: 218, 135 · template: backtracking skeleton | [ ] |

**218 is the single highest-value Hard in Phase 2** — a well-known Google/Amazon/Meta ask and the
fullest expression of sweep line. Three things to get deliberately right: event ordering at ties,
removing a specific height (`TreeMap<Integer,Integer>` multiset with `lastKey()`, or lazy deletion),
and emitting only when the running max changes. It gets re-solved on day 2 on purpose.

## Week 7 — Tries II + Trees II
> [../Reference/tries.md](../Reference/tries.md) · [../Reference/trees-bst.md](../Reference/trees-bst.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | **Bitwise trie / XOR**, offline queries | 421, 1707, 745 | [ ] |
| 2 | Width, vertical order, N-ary | 662, 987, 429 | [ ] |
| 3 | Root-to-leaf numbers, subtree aggregation | 129, 508, 106, 449 | [ ] |
| 4 | BST search/balance/DLL, boundary | 700, 1382, 426 *(premium)*, 545 *(premium)* | [ ] |
| 5 | Successor, LCA with parents, **binary lifting** | 285 *(premium)*, 1650 *(premium)*, 1483 | [ ] |
| 6 | **Revision** | Hint? set + cold: 421, 987 · template: three tree shapes | [ ] |

Day 1: 421 is the highest-leverage non-obvious trie application — insert 32-bit representations,
walk greedily toward the opposite bit, `O(32n)` instead of `O(n²)`. Day 5: 1650 is problem 160
(linked-list intersection) in disguise; noticing that is worth more than solving it.

## Week 8 — Trees II + Graphs II
> [../Reference/trees-bst.md](../Reference/trees-bst.md) · [../Reference/graphs.md](../Reference/graphs.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | Tree DP — flow across edges, cameras | 979, 968 | [ ] |
| 2 | **Rerooting** + segment tree / BIT, written once | 834, 307 | [ ] |
| 3 | **Counting with a BIT** *(merge sort first, then BIT)* | 315, 493 | [ ] |
| 4 | Two-technique composites, enclaves | 934, 1020, 1162 | [ ] |
| 5 | Board BFS, leaf peeling, bipartition | 909, 310, 886 | [ ] |
| 6 | **Revision** | Hint? set + cold: 834, 315 · template: Kahn's topo sort | [ ] |

Day 2 is where you write a segment tree (or BIT) **once, cleanly, and keep it** — point update plus
range query. Day 3: do the merge-sort-with-counting version first (it reads as your own work and
reinforces divide and conquer), then the BIT version with coordinate compression.

## Week 9 — Graphs II
> [../Reference/graphs.md](../Reference/graphs.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | **Deriving the constraint graph** | 269 *(premium)*, 2115 | [ ] |
| 2 | Union-find Hards | 839, 685 | [ ] |
| 3 | Nodes-are-routes, probability, maze | 815, 1514, 505 *(premium)* | [ ] |
| 4 | Minimize the maximum, **0-1 BFS** | 778, 1368 | [ ] |
| 5 | Path counting, MST premium, geometry graph | 1976, 1135 *(premium)*, 2101 | [ ] |
| 6 | **Revision** | Hint? set + cold: 269, 778 · template: union-find | [ ] |

Day 1: **269 is the highest-signal problem in the graph block** — the sort is easy, deriving the
edges from the word list is the interview. You have an empty `269.alien-dictionary.java` in the
repo; finish it here. Day 3: 815's whole difficulty is realizing the nodes are *routes*, not stops.
Day 4: 778 has three valid solutions (modified Dijkstra, binary search + BFS, sorted union-find) —
being able to justify a choice among them is exactly the SDE III conversation.

## Week 10 — Graphs II + DP II
> [../Reference/graphs.md](../Reference/graphs.md) · [../Reference/dp.md](../Reference/dp.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | **Tarjan** bridges *and* articulation points, Euler, colour DP | 1192, 332, 1857 | [ ] |
| 2 | Tickets, rod cutting, Nim, stone weight II | 983, 343, 292, 1049 | [ ] |
| 3 | Bitmask-or-backtrack, **backwards DP** | 698, 174 | [ ] |
| 4 | Two-agent state, counting LIS | 1463, 673 | [ ] |
| 5 | 2-D LIS with the descending tiebreak, interleaving | 354, 97 | [ ] |
| 6 | **Revision** | Hint? set + cold: 1192, 174 · template: segment tree | [ ] |

Day 1: add the articulation-point condition to the same DFS as the bridge condition — five extra
lines, and stating both from one traversal is the whole ask. Day 3: **174 must be solved backwards**
from the destination; understanding why forward DP fails is a genuine insight and a favourite probe.

## Week 11 — DP II
> [../Reference/dp.md](../Reference/dp.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | Distinct subsequences, LCS **reconstruction** | 115, 1092 | [ ] |
| 2 | Regex DP, min insertions | 10, 1312 | [ ] |
| 3 | Two-layer DP, triangulation | 132, 1039 | [ ] |
| 4 | Interval DP, minimax cost | 1547, 375 | [ ] |
| 5 | **Burst Balloons** — full session | 312, 1000 | [ ] |
| 6 | **Revision** | Hint? set + cold: 312, 132 · template: 0/1 vs unbounded knapsack | [ ] |

Order matters and it's built into the week: 1039 → 1547 → **312** → 1000. Building up to 312 works
far better than starting there. Its insight — iterate over which balloon bursts **last** — is the
hardest single idea in common interview DP, and 1000 is the payoff check.

## Week 12 — DP II + Backtracking II
> [../Reference/dp.md](../Reference/dp.md) · [../Reference/backtracking.md](../Reference/backtracking.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | k-transaction state machine, game theory | 188, 486, 877 | [ ] |
| 2 | Stone Game II, probability DP | 1140, 688, 837 | [ ] |
| 3 | **DP + monotonic deque**, digit DP | 1696, 1425, 233, 902 | [ ] |
| 4 | **Bitmask DP** — four distinct shapes | 847, 1125, 526, 943, 1947 | [ ] |
| 5 | Combinations, constraint pruning | 77, 216, 93 | [ ] |
| 6 | **Revision** | Hint? set + cold: 1425, 188, 847 · template: interval DP by length | [ ] |

Day 3: 1696 before 1425. DP transitions optimizable by a deque is a genuine differentiator — most
candidates don't know it exists. Day 4 is five problems because at SDE III you need to *recognize*
bitmask DP and set up the state (the tell is `n ≤ 20`), not produce a full TSP implementation;
1947's state reduction from `dp[i][mask]` to `dp[mask]` is the one to actually derive.

## Week 13 — Backtracking II + Concurrency
> [../Reference/backtracking.md](../Reference/backtracking.md) · [../Reference/concurrency.md](../Reference/concurrency.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | Palindrome partitioning, **N-Queens** | 131, 51 | [ ] |
| 2 | **Expression Add Operators** | 282, 37 ✔ *(re-verify)* | [ ] |
| 3 | Ordering & signalling | 1114 *(three ways)*, 1115, 1279 | [ ] |
| 4 | Three/four-thread state, barriers | 1116, 1195, 1117 | [ ] |
| 5 | **Deadlock** + **exercise 1** | 1226, bounded blocking queue *(both versions)* | [ ] |
| 6 | **Revision** | Hint? set + cold: 51, 282, exercise 1 | [ ] |

Day 3: solve 1114 with `Semaphore`, `CountDownLatch`, **and** `synchronized`+`wait`/`notifyAll` —
comparing the three is how you learn which is idiomatic. Never a spin loop; busy-waiting passes on
LeetCode and fails a real review. Day 5: know which of Coffman's four conditions each dining-
philosophers fix breaks — that's the crossover into the OS round.

## Week 14 — Concurrency + Design II
> [../Reference/concurrency.md](../Reference/concurrency.md) · [../Reference/design.md](../Reference/design.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | Producer-consumer, crawler + **exercise 2** | 1188 *(premium)*, 1242 *(premium)*, thread-safe LRU | [ ] |
| 2 | **Exercises 4 & 5** | RW lock from scratch; lock-free counter, token bucket, Treiber stack | [ ] |
| 3 | Rate limiting, lazy iteration | 362 *(premium)*, 359 *(premium)*, 900, 1352 | [ ] |
| 4 | Calendar ladder — the sweep-line delta map | 731, 732 | [ ] |
| 5 | Copy-on-write, leaderboard, telemetry | 1146, 1244, **Design Underground System** | [ ] |
| 6 | **Revision** | Hint? set + cold: exercise 2, 732 · read the Java Concurrency Reference | [ ] |

Day 1's exercise 2 is the most common "now make it thread-safe" follow-up in existence, because 146
is the most common design problem. Walk the four tiers out loud: `synchronized` everywhere →
read-write lock (and notice `get()` mutates recency, so it's a *write*) → sharded locks →
Caffeine's approximate LRU, which trades exactness for throughput. **The fourth tier's reasoning is
the senior answer.** Day 2: name the ABA problem with a concrete X-Y-X sequence.

## Week 15 — Design II + Bit/Math II
> [../Reference/design.md](../Reference/design.md) · [../Reference/bit-math.md](../Reference/bit-math.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | **All O`one**, iterators, games | 432, 281 *(premium)*, 348 *(premium)*, 353 *(premium)* | [ ] |
| 2 | **Skiplist** + **exercise 7** | 1206, in-memory KV store with TTL | [ ] |
| 3 | Bit reversal, mod-k counting, power-of-three | 190, 137, 326, 118 | [ ] |
| 4 | Carry propagation, range AND, Gray code, base-26 | 371, 201, 89, 168, 171 | [ ] |
| 5 | Super pow, division without `/`, permutation cycles | 372, 29, 765 | [ ] |
| 6 | **Revision** | Hint? set + cold: 432, 1206 · template: BIT | [ ] |

Day 1: **432 completes the 146/460 family** — a doubly linked list of frequency buckets plus a
key→bucket map, all `O(1)`. Do it even if you skip the premiums. Day 2: 1206 is rarely asked and
worth doing anyway — *"probabilistic balancing, expected O(log n), far simpler than red-black,
which is why Redis uses it"* is real system-design ammunition. TTL exercise: name all three expiry
strategies and that Redis uses lazy + sampled active.

## Week 16 — Bit/Math II + Math Extras + the three exercises that get asked
> [../Reference/bit-math.md](../Reference/bit-math.md) · [../Reference/math-extras-advanced.md](../Reference/math-extras-advanced.md)

| Day | Focus | Problems | Done |
|---|---|---|---|
| 1 | **Fisher-Yates, weighted random** + reservoir sampling | 384, 528 | [ ] |
| 2 | GCD, factorization, Catalan, long division | 1071, 172, 96, 166 | [ ] |
| 3 | Reservoir + rejection sampling, **matrix exponentiation** | 398, 470, 509 *(three ways)* | [ ] |
| 4 | **Exercise 3 — consistent hashing ring** + distribution test | — | [ ] |
| 5 | **Exercise 6 — Bloom filter** + read all of Part 2 | — | [ ] |
| 6 | **Final assessment** | 2 unseen Hards, 45 min each, timed, narrated | [ ] |

Day 1 punches above its problem count: Fisher-Yates, weighted random and reservoir sampling all
show up in design conversations — A/B bucketing, weighted load balancing, log sampling, virtual
nodes. Day 4 is the highest-value exercise in the phase: hash 100,000 keys across 10 servers with
1 virtual node, then with 150, and watch the variance collapse. That test is what makes the "why
virtual nodes" answer yours. Day 5's Part 2 reading is 30 minutes and the cheapest value per
minute in the whole plan — Bloom filters, count-min sketch, HyperLogLog, B-tree vs LSM.

---

## Coverage summary

| Block | Problems | Days | Block | Problems | Days |
|---|---|---|---|---|---|
| Arrays II | 12 | 4 | Trees II | 20 | 7 |
| Sorting II | 2 | 1 | Graphs II | 21 | 8 |
| Strings II | 9 | 4 | DP II | 35 | 13 |
| Hashing II | 8 | 3 | Backtracking II | 6 | 3 |
| Binary search II | 11 | 4 | Concurrency | 9 | 5 |
| Linked list II | 7 | 2 | Design II | 14 | 5 |
| Stacks II | 11 | 4 | Bit / math II | 14 | 4 |
| Heaps II | 8 | 3 | Math extras | 7 | 4 |
| Intervals & skyline | 2 | 2 | | | |
| Greedy II | 6 | 2 | **Total** | **207 + 11 ex** | **80 + 16 rev** |
| Tries II | 6 | 2 | | | |

DP II + Graphs II + Trees II = 76 problems over 28 days — **35% of the phase's days.** Same rule as
Phase 1: that ratio is the plan.
