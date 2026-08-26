# Phase 3 — Catalogue

Three tiers, ordered by the probability it ever appears in front of you. Read
[README.md](README.md) first — particularly the part about this phase not improving your SDE III
odds.

*(premium)* = LeetCode subscription required.

---

## Tier 1 — Rare but real

Low, non-zero interview probability: Google algorithm-heavy rounds, quant/HFT, teams that write
their own index structures. **Every entry here has real LeetCode problems** — implement them.

### 1. Segment tree with lazy propagation

Defer range updates at a node and push them down only when a query needs to descend. Turns
range-update + range-query from `O(n)` per update into `O(log n)`.

**Why it's above the line:** `trees-bst.md` says lazy propagation is *"worth understanding but
rarely required — don't burn a day on it."* At SDE III the plain point-update segment tree from
Phase 2 is the expected ceiling.

| Problems | Diff |
|---|---|
| 699 Falling Squares | Hard |
| 850 Rectangle Area II | Hard |
| 2286 Booking Concert Tickets Together | Hard |
| 2158 Amount of New Area Painted Each Day *(premium)* | Hard |
| **715 Range Module** *(promoted from Phase 2)* | Hard |

> **If asked:** *"range updates with range queries needs lazy propagation — you store a pending
> delta at each node and push it down on the way to a query, so both stay `O(log n)`. For
> range-update/point-query a difference array plus a BIT is simpler and usually enough."*

### 2. Matrix exponentiation for linear recurrences

Any linear recurrence becomes a matrix power, computable in `O(k³ log n)` by binary exponentiation.
You built the 2×2 Fibonacci case in Phase 2 (509); this is the general tool.

**The tell:** a linear recurrence with `n ≤ 10¹⁸`. Nothing else works at that size.

| Problems | Diff |
|---|---|
| 790 Domino and Tromino Tiling | Med |
| 552 Student Attendance Record II | Hard |
| 1220 Count Vowels Permutation | Hard |

> **If asked:** *"the transition is linear and fixed, so I can write it as a matrix and binary-
> exponentiate — `O(k³ log n)` instead of `O(nk)`. Worth it once n gets past what a linear scan can
> touch."*

### 3. Digit DP — hard variants

State `(position, tight, started, …)` over the decimal representation. Phase 2 does 233 and 902;
these add tighter constraints and set-membership state.

| Problems | Diff |
|---|---|
| 1012 Numbers With Repeated Digits | Hard |
| 2376 Count Special Integers | Hard |
| 1397 Find All Good Strings | Hard *(digit DP **+ KMP** — the composite)* |

> **If asked:** *"counting numbers up to N with a digit property is digit DP — I walk positions
> keeping a `tight` flag for whether the prefix equals N's prefix, plus whatever property state the
> problem needs."*

### 4. Bitmask DP hard variants + SOS DP

Phase 2 covers four bitmask shapes (BFS+mask, set cover, TSP, assignment). What's above the line is
**sum-over-subsets** — computing an aggregate over every subset of every mask in `O(2ⁿ · n)` rather
than `O(3ⁿ)` — and problems where the mask isn't the obvious dimension.

| Problems | Diff |
|---|---|
| 1178 Number of Valid Words for Each Puzzle | Hard |
| 1994 The Number of Good Subsets | Hard |
| 1799 Maximize Score After N Operations | Hard |
| 1815 Maximum Number of Groups Getting Fresh Donuts | Hard |
| 1595 Minimum Cost to Connect Two Groups of Points | Hard |

> **If asked:** *"iterating submasks of every mask is `O(3ⁿ)`; SOS DP does the same aggregation
> dimension-by-dimension in `O(2ⁿ·n)`. And 1595 is min-cost bipartite matching — solvable exactly
> with the Hungarian algorithm in `O(n³)`, but with n ≤ 12 bitmask DP is simpler and fast enough."*

### 5. Aho-Corasick — multi-pattern matching

A trie plus KMP-style failure links, so you match *all* patterns against a text in one pass:
`O(text + patterns + matches)`. The natural extension of the Phase 1/2 trie work.

| Problems | Diff |
|---|---|
| 1032 Stream of Characters | Hard |
| 616 Add Bold Tag in String *(premium)* | Med |
| 758 Bold Words in String *(premium)* | Med |

> **If asked:** *"one pattern is KMP; many patterns is Aho-Corasick — build the trie, add failure
> links to the longest proper suffix that's also a prefix of some pattern, and one pass over the text
> finds every match. It's what a WAF or a profanity filter actually runs."*

### 6. Bitwise trie with offline DFS

Extends 421/1707 from Phase 2: instead of one static trie, insert and *remove* along a DFS so each
query sees exactly the ancestors it should. The offline-query technique from 1707, applied on a tree.

| Problems | Diff |
|---|---|
| 1938 Maximum Genetic Difference Query | Hard |
| 421, 1707 *(Phase 2 — prerequisites)* | Med / Hard |

> **If asked:** *"max-XOR is a bitwise trie with a greedy opposite-bit walk; the per-query
> constraint makes it offline — I sort or root the queries so the trie holds exactly the eligible
> elements when each one is answered, adding on entry and removing on exit."*

### 7. Computational geometry beyond orientation

Phase 2 stops at the cross-product orientation test. Above the line: hull construction, closest
pair, segment intersection, and spatial indexing.

| Problems | Diff |
|---|---|
| **587 Erect the Fence** *(promoted from Phase 2)* — Andrew's monotone chain | Hard |
| 963 Minimum Area Rectangle II | Med |
| 1401 Circle and Rectangle Overlapping | Med |
| 149 *(Phase 2 — prerequisite)* | Hard |
| Closest pair of points — **no LeetCode equivalent** | — |

> **If asked:** *"for a one-off closest pair I'd do divide and conquer in `O(n log n)` — the merge
> step only compares points within a `2d` strip, and at most 7 neighbours in y-order. For a live
> system answering repeated nearest-neighbour queries I'd index spatially instead — quadtree, k-d
> tree, or geohash cells."*

### 8. Persistent / versioned structures

Phase 2's 1146 is the array case. The general technique is path-copying: an update creates
`O(log n)` new nodes and shares the rest, so every version stays queryable.

| Problems | Diff |
|---|---|
| 1146 Snapshot Array *(Phase 2 — the easy case)* | Med |
| Persistent segment tree, kth-in-range — **no LeetCode equivalent** (CF/CSES) | — |

> **If asked:** *"copy-on-write with structural sharing — an update rebuilds only the path to the
> root, so all previous versions stay valid at `O(log n)` extra space per update. It's how MVCC and
> persistent collections work."*

### 9. Parametric / fractional search

Binary search a *ratio* rather than a value, transforming the feasibility check algebraically:
to test average ≥ x, subtract x from every element and ask whether a valid-length subarray has
non-negative sum.

| Problems | Diff |
|---|---|
| **644 Maximum Average Subarray II** *(premium, promoted from Phase 2)* | Hard |
| No reliable free substitute — see `binary-search.md`'s addendum | — |

> **If asked:** *"maximize-a-ratio problems binary-search the ratio itself — subtract the candidate
> out and the question becomes 'is some sum non-negative', which is linear to check."*

### 10. Min-cost matching / assignment done properly

Phase 2 solves the assignment problem with bitmask DP because `n ≤ 20`. The polynomial answer is the
**Hungarian algorithm** (`O(n³)`), and the general version is min-cost max-flow.

| Problems | Diff |
|---|---|
| 1595 Minimum Cost to Connect Two Groups of Points | Hard |
| 1947 *(Phase 2 — the bitmask version)* | Med |
| True MCMF — **CSES Flows section / AtCoder ALPC** | — |

> **If asked:** *"assignment is polynomial via Hungarian, `O(n³)`, and reduces to min-cost max-flow
> in general. With n ≤ 20 I'd still write bitmask DP — same answer, a tenth of the code."*

---

## Tier 2 — Competitive programming staples

Interview probability ≈ zero. `math-extras-advanced.md` lists most of these in its *Genuinely
Skippable* table, and it's right. **Read the technique; implement only if it interests you.** None
of them have meaningful LeetCode representation.

| Technique | What it buys | Where to practise |
|---|---|---|
| **Max flow (Dinic), min-cut modelling** | Matching, partition, project-selection reductions | CSES *Download Speed*, *Police Chase*, *School Dance*, *Distinct Routes* |
| **Mo's algorithm** | Offline range queries in `O((n+q)√n)` when no structure exists | Codeforces; no LC equivalent |
| **Heavy-light decomposition** | Path queries on trees in `O(log² n)` | CSES *Path Queries II* |
| **Centroid decomposition** | Counting paths through a tree by divide and conquer | Codeforces |
| **Suffix array + LCP (Kasai / SA-IS)** | Substring problems in `O(n log n)` | CSES *Finding Patterns*, *Counting Patterns*, *Substring Distribution* |
| **Suffix automaton** | All distinct substrings as a DAG, linear size | Codeforces |
| **Convex hull trick / Li Chao tree** | DP transitions that are `max` over lines | AtCoder EDPC task **Z** (Frog 3) |
| **Segment tree beats** | Range chmin/chmax with amortized `O(log² n)` | Codeforces |
| **Union-find with rollback / offline dynamic connectivity** | Connectivity under edge deletion | Codeforces |
| **Sqrt decomposition** | The generic fallback when no clean structure fits | CSES Range Queries |
| **FFT / NTT** | Polynomial multiplication, convolution counting | AtCoder ALPC task **F** |
| **Number theory depth** — Möbius, CRT, Burnside, Miller-Rabin, Pollard's rho | Counting under constraints, factoring big integers | CSES Mathematics; Project Euler |
| **2-SAT** | Boolean constraint satisfaction via implication SCCs | AtCoder ALPC; CF |
| **Treap / splay / link-cut trees** | Balanced BST and dynamic trees from scratch | Codeforces |

**The one Tier 2 item with real transfer:** max-flow **min-cut modelling**. Not the implementation —
the modelling. Recognizing that a partition or selection problem *is* a min-cut is occasionally
decisive in a Google round, and `graphs.md` already tells you the expected depth: *"max-flow min-cut
theorem, Edmonds-Karp is `O(VE²)`, bipartite matching reduces to max flow. Do not spend a day
implementing it."*

---

## Tier 3 — Name-only

Know that these exist and what problem they solve. Nothing more. Reading past the one-liner is
strictly worse than re-solving a Phase 2 Hard.

| Technique | One line |
|---|---|
| Eertree (palindromic tree) | All distinct palindromic substrings in linear space |
| Wavelet tree | Range quantile / rank queries without updates |
| Kinetic segment tree | Segment tree where the comparison changes over time |
| Sqrt tree | `O(1)` range queries on associative ops with `O(n log log n)` build |
| Fractional cascading | Speeds up the same binary search across many sorted lists |
| Simplex / LP duality | Continuous optimization; occasionally reframes a combinatorial problem |
| Berlekamp-Massey | Recovers a linear recurrence from its first terms |
| Aliens trick (Lagrangian relaxation) | "Exactly k" DP by binary-searching a penalty on k |
| Slope trick | Maintains a convex piecewise-linear DP with a heap |
| Dominator tree | Control-flow analysis; occasionally graph problems |

---

## Where this stops being about interviews

Nothing in Tier 2 or 3 has appeared in a reported SDE III loop. They're here because you asked what
sits above the bar, and this is honestly what's up there — a body of technique built for a different
competition with a different scoring function.

The most useful thing on this page for your actual goal is **Tier 1 entry 1** (lazy propagation,
which extends a structure you'll already have written) and the **"if asked" sentences** — because
the interview-relevant payload of advanced material is almost always the one-sentence recognition,
not the implementation. That's the same argument `math-extras-advanced.md` makes for its Part 2
tables, and it's the argument for keeping this whole phase in proportion.
