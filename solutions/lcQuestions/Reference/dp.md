# Dynamic Programming — SDE III Prep (Final List)

**58 problems · 2 Easy / 34 Medium / 22 Hard · 13 days**

Tick the checkbox when solved. Mark the **Hint?** column if you needed help — those get re-solved first.

> **The largest block, deliberately.** DP is where interviews are lost — not because the problems are hard, but because DP is the one topic where pattern recognition genuinely cannot be faked. You either see the state definition or you don't.
>
> **Non-negotiable process for every problem here:**
> 1. Define the state in words before writing code — *"`dp[i][j]` = the answer for the first `i` of X and `j` of Y"*
> 2. Write the recurrence
> 3. Identify base cases
> 4. Determine iteration order
> 5. **Then** optimize space
>
> Skipping straight to a loop is why people fail DP rounds. Say the state definition out loud in the interview; it's most of the signal.

### Already covered elsewhere

| # | Problem | Where |
|---|---|---|
| 139 | Word Break | Strings ✔ |
| 1143 | Longest Common Subsequence | Strings ✔ |
| 718 | Maximum Length of Repeated Subarray | Strings ✔ |
| 44 | Wildcard Matching | Strings ✔ |
| 53, 152, 918 | Kadane family | Arrays ✔ |
| 121, 123 | Stock I and III | Arrays ✔ |
| 337, 979, 968, 834 | Tree DP | Trees ✔ |
| 329, 1857 | DAG DP / memoized DFS | Graphs ✔ |

---

## Memoization → Tabulation Foundations (4)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 70 | Climbing Stairs | Easy | |
| [ ] | 746 | Min Cost Climbing Stairs | Easy | |
| [ ] | 198 | House Robber | Med | |
| [ ] | 213 | House Robber II *(circular)* | Med | |

> Do each one **three ways**: recursion + memo, bottom-up table, then space-optimized to `O(1)`. This progression is the entire method — practise it here where the problems are trivial so it's automatic later.
>
> 213's circular trick (run 198 twice, excluding first or last) is a reusable pattern — same as 918 in Arrays.

## 1-D Linear DP (5)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 91 | Decode Ways | Med | |
| [ ] | 55 | Jump Game *(greedy — contrast case)* | Med | |
| [ ] | 45 | Jump Game II | Med | |
| [ ] | 983 | Minimum Cost For Tickets | Med | |
| [ ] | 1235 | Maximum Profit in Job Scheduling | Hard | |

> 91's edge cases (leading zeros, `"06"`, `"0"`) are the actual difficulty — enumerate them before coding.
>
> **55 is here as a contrast case:** it looks like DP and greedy is strictly better. Recognizing when *not* to reach for DP matters.
>
> **1235 is DP + binary search** — sort by end time, binary search for the last non-conflicting job. Direct crossover with your binary search block, and a very common Hard.

## Coin Change / Unbounded Knapsack (4)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 322 | Coin Change *(min coins)* | Med | |
| [ ] | 518 | Coin Change II *(count ways)* | Med | |
| [ ] | 377 | Combination Sum IV *(count **permutations**)* | Med | |
| [ ] | 279 | Perfect Squares | Med | |

> **518 vs 377 is the single most instructive pair in this block.** Same inputs, and the only difference is **loop order**: coins outer → combinations; target outer → permutations. If you can explain why, you understand knapsack iteration order, and that understanding prevents a whole class of bugs.

## 0/1 Knapsack Family (5)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 416 | Partition Equal Subset Sum | Med | |
| [ ] | 494 | Target Sum | Med | |
| [ ] | 1049 | Last Stone Weight II | Med | |
| [ ] | 474 | Ones and Zeroes *(2-D capacity)* | Med | |
| [ ] | 698 | Partition to K Equal Sum Subsets | Med | |

> 416, 494, and 1049 are **the same problem** with different framing — all reduce to "can we hit a target subset sum." Solve 416, then derive the other two; that derivation is the skill.
>
> For 1-D space optimization on 0/1 knapsack, iterate the capacity **backwards**. Forward iteration silently turns it into unbounded knapsack. Know why.
>
> 698 is bitmask DP or backtracking with pruning — appears again in the bitmask section.

## Grid DP (7)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 62 | Unique Paths | Med | |
| [ ] | 63 | Unique Paths II | Med | |
| [ ] | 64 | Minimum Path Sum | Med | |
| [ ] | 120 | Triangle | Med | |
| [ ] | 221 | Maximal Square | Med | |
| [ ] | 174 | Dungeon Game | Hard | |
| [ ] | 1463 | Cherry Pickup II | Hard | |

> **174 is the one worth real attention.** It must be solved *backwards* from the destination, because the constraint (health never drops to zero) isn't decomposable forward. Understanding why forward DP fails here is a genuine insight, and interviewers love asking about it.
>
> 1463 is two-agent DP — state is `(row, col1, col2)`. Multi-agent state expansion is a recurring idea. 741 (Cherry Pickup I) is the harder single-agent-round-trip version; skip unless you have time.

## Longest Increasing Subsequence (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 300 | Longest Increasing Subsequence | Med | |
| [ ] | 673 | Number of Longest Increasing Subsequences | Med | |
| [ ] | 354 | Russian Doll Envelopes | Hard | |

> Do 300 **both** ways: `O(n²)` DP and `O(n log n)` patience/binary-search. The `O(n log n)` version is expected at SDE III.
>
> **354 is the payoff** — sort by width ascending, height *descending* on ties, then LIS on heights. The descending tiebreak is the whole trick, and forgetting it is the standard failure.

## String DP (6)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 72 | Edit Distance | Med | |
| [ ] | 583 | Delete Operation for Two Strings | Med | |
| [ ] | 97 | Interleaving String | Med | |
| [ ] | 115 | Distinct Subsequences | Hard | |
| [ ] | 10 | Regular Expression Matching | Hard | |
| [ ] | 516 | Longest Palindromic Subsequence | Med | |

> **72 is the canonical two-string DP** and the most-asked problem in this section. Get the three-operation recurrence and the base row/column exactly right.
>
> 583 reduces to LCS — spot that rather than deriving fresh.
>
> 10 vs 44 (in Strings): `*` means different things in each. Do both eventually; if choosing one, 10 is more commonly asked despite being harder.
>
> 516 and 72 were flagged in the Strings file as at-risk of falling through the gap. They land here.

## Palindrome Partitioning DP (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 132 | Palindrome Partitioning II | Hard | |
| [ ] | 1312 | Minimum Insertion Steps to Make a String Palindrome | Hard | |

> 132 needs a precomputed `isPalindrome[i][j]` table plus a min-cut DP on top — two-layer DP, which is a step up in structure.
>
> 1312 reduces to `n - LPS(s)`. Recognizing the reduction is faster than deriving a new recurrence.

## Interval DP (5)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1039 | Minimum Score Triangulation of Polygon | Med | |
| [ ] | 312 | Burst Balloons | Hard | |
| [ ] | 1547 | Minimum Cost to Cut a Stick | Hard | |
| [ ] | 375 | Guess Number Higher or Lower II | Med | |
| [ ] | 1000 | Minimum Cost to Merge Stones | Hard | |

> **312 is the hardest common interview DP.** The insight — iterate over which balloon is burst *last*, not first — is unintuitive and is the whole problem. Once you have it, 1039 and 1547 are the same shape.
>
> **Order: 1039 → 1547 → 312 → 1000.** Building up to 312 works far better than starting there.
>
> The template: `for (len) for (i) { j = i + len; for (k = i+1; k < j; k++) ... }`. Length-outer iteration is what makes interval DP work.

## Stock Problems (4)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 122 | Best Time to Buy and Sell Stock II | Med | |
| [ ] | 188 | Best Time to Buy and Sell Stock IV *(k transactions)* | Hard | |
| [ ] | 309 | Best Time to Buy and Sell Stock with Cooldown | Med | |
| [ ] | 714 | Best Time to Buy and Sell Stock with Transaction Fee | Med | |

> **All six variants are one state machine:** `hold` / `sold` / `rest`, with transitions constrained by the variant. Solve 188 generally (`dp[k][hold]`) and the rest are special cases.
>
> 121 and 123 are already in Arrays — this completes the family.

## Bitmask DP (4)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 847 | Shortest Path Visiting All Nodes | Hard | |
| [ ] | 1125 | Smallest Sufficient Team | Hard | |
| [ ] | 526 | Beautiful Arrangement | Med | |
| [ ] | 943 | Find the Shortest Superstring | Hard | |

> **847 is BFS + bitmask state** — the cleanest introduction, and it doubles as a graph problem. Start here.
>
> 1125 is set cover via bitmask. 943 is TSP in disguise. The recognition tell is always the same: **`n ≤ 20` in the constraints.** That's the signal to consider `2^n` states.
>
> At SDE III you should recognize bitmask DP and be able to set up the state. You will not usually be *required* to produce a full TSP implementation.

## Digit DP (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 233 | Number of Digit One | Hard | |
| [ ] | 902 | Numbers At Most N Given Digit Set | Hard | |

> Rare but distinctive. State is `(position, tight, started)`. Two problems is enough to recognize the shape if it appears; don't invest more than one session.

## Probability / Expected Value (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 688 | Knight Probability in Chessboard | Med | |
| [ ] | 837 | New 21 Game | Med | |

> 837 needs a sliding-window sum over the DP array to avoid `O(n·k)` — a nice example of **optimizing a DP with a window**, which generalizes.

## Game Theory DP (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 486 | Predict the Winner | Med | |
| [ ] | 877 | Stone Game | Med | |
| [ ] | 1140 | Stone Game II | Med | |

> Minimax as DP: the state is *"best score difference achievable by the player to move."* Framing it as a **difference** rather than two separate scores halves the state space — that reframing is the lesson.

## DP + Data Structure Optimization (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1425 | Constrained Subsequence Sum | Hard | |
| [ ] | 1696 | Jump Game VI | Med | |

> Both are **DP + monotonic deque** — the transition needs a max over a sliding window of previous states. This is the crossover between your Stacks block and this one, and it's a genuine differentiator: most candidates don't know DP transitions can be optimized this way.
>
> Do 1696 first (easier), then 1425.

---

## 13-Day Schedule

| Day | Problems | Done |
|---|---|---|
| 1 | 70, 746, 198, 213, 91 | [ ] |
| 2 | 55, 45, 983, 1235 | [ ] |
| 3 | 322, 518, 377, 279 | [ ] |
| 4 | 416, 494, 1049, 474, 698 | [ ] |
| 5 | 62, 63, 64, 120, 221 | [ ] |
| 6 | 174, 1463, 300 | [ ] |
| 7 | 673, 354, 72, 583 | [ ] |
| 8 | 97, 115, 10, 516 | [ ] |
| 9 | 132, 1312, 1039, 1547 | [ ] |
| 10 | **312**, 375, 1000 | [ ] |
| 11 | 122, 188, 309, 714 | [ ] |
| 12 | 847, 1125, 526, 943 | [ ] |
| 13 | 233, 902, 688, 837, 486, 877, 1140, 1696, 1425 | [ ] |

Day 10 is three problems because 312 deserves a full session. Day 13 is long but most of those are fast once the patterns are in place — split it across two days if needed.

---

## Revision

Re-solve **cold** (no notes, from scratch) on:

- **Day 20** — everything marked Hint?, plus 322, 518, 416, 174, 300, 354, 72, 312, 188, 847, 1425
- **Day 34** — same set, plus anything that needed a hint on day 20

DP decays faster than any other topic. **Do not skip these revisions** — a pattern you solved once and never revisited is a pattern you don't have.

---

## Trim to 38 If Pressed

70, 198, 213, 91, 45, 1235, 322, 518, 377, 279, 416, 494, 474, 62, 63, 64, 120, 221, 174, 300, 673, 354, 72, 97, 115, 10, 516, 132, 1039, 312, 1547, 122, 188, 309, 847, 486, 1696, 1425

Cut: 746, 55, 983, 1049, 698, 1463, 583, 1312, 375, 1000, 714, 1125, 526, 943, 233, 902, 688, 837, 877, 1140.

---

## The Five Questions

Answer all five, in order, **out loud**, before writing any code. This is the habit that makes DP tractable.

1. **What is the state?** *"`dp[i][j]` = the answer considering the first `i` of X and `j` of Y."* If you can't finish this sentence, you're not ready to code.
2. **What is the recurrence?** How does this state depend on smaller ones?
3. **What are the base cases?** Usually `i == 0` or `j == 0`, and they're usually where the off-by-one bugs live.
4. **What is the iteration order?** Every state a transition reads must already be computed. This is why interval DP goes by length and knapsack goes backwards.
5. **Can I reduce the space?** If `dp[i]` only reads `dp[i-1]`, two rows suffice — or one, if you iterate in the right direction.

---

## Pattern Recognition Check

| Signal in the problem | DP shape |
|---|---|
| "How many ways" / "min or max cost" + choices per step | 1-D linear DP |
| Choose or skip each item, fixed capacity | 0/1 knapsack — iterate capacity **backwards** |
| Unlimited reuse of each item | Unbounded knapsack — iterate capacity **forwards** |
| "Count combinations" (order doesn't matter) | Items in the outer loop |
| "Count permutations" (order matters) | Target in the outer loop |
| Grid with moves in fixed directions | Grid DP, `dp[i][j]` from neighbours |
| Constraint that only makes sense at the end | **Iterate backwards** from the destination (174) |
| Two strings, transform or align | 2-D DP `dp[i][j]` over both prefixes |
| Longest / count of increasing subsequence | `O(n²)` DP or `O(n log n)` patience |
| 2-D version of LIS | Sort one dimension (careful tiebreak), LIS the other |
| Split a sequence into optimal pieces | Interval DP — iterate by **length** |
| "Which one do I remove last" | Interval DP (312) |
| Buy/sell with constraints | State machine — `hold` / `sold` / `rest` |
| `n ≤ 20` in the constraints | **Bitmask DP** |
| Count numbers ≤ N with a digit property | Digit DP — `(pos, tight, started)` |
| Expected value or probability over steps | DP over probability, watch for window sums |
| Two players alternating optimally | Minimax DP on score **difference** |
| Transition needs max/min over a window of states | DP + **monotonic deque** |
| Transition needs a search over sorted prior states | DP + **binary search** (1235) |
| Tree structure, choose-or-skip per node | Tree DP — return a state tuple *(in Trees block)* |
| DAG or grid with strictly-increasing paths | Memoized DFS *(in Graphs block)* |

---

## Java Notes

- `int[][] dp = new int[n+1][m+1]` — the `+1` for base cases is almost always right for two-string DP. Fewer off-by-ones than 0-indexed.
- `Arrays.fill` with a sentinel (`-1`) for memo tables; use `Integer.MIN_VALUE` only when `-1` is a legal answer.
- 2-D memo with `Integer[][]` lets `null` mean "uncomputed" without a sentinel — cleaner, slightly slower.
- Use `long` for count-of-ways problems; they overflow `int` fast. Check whether the problem wants a modulus.
- Space optimization on 2-D DP: iterate `j` backwards for 0/1 knapsack, forwards for unbounded. **Getting this backwards is the most common DP bug in Java.**
- Recursion + memo blows the stack around 10⁴ depth on linear DP. Convert to bottom-up if `n ≥ 10⁵`.
- For bitmask DP, `1 << n` with `n = 20` is ~1M states — fine. `n = 25` is 33M and won't fit. Check `n` against the constraint before committing.
- `Integer.MAX_VALUE` as an "unreachable" sentinel overflows when you add to it. Use `Integer.MAX_VALUE / 2` or guard the addition.

---

## Progress Across the Plan

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
| **DP** | **58** | **✔ list built** |
| Backtracking | 15 | |
| Bit / math | 16 | |
| Design | 12 | |

**Running total: 323 / ~360.**

---

## Addendum — Final Coverage Audit

Four outline items missed. Three problems and one conceptual family.

| ✔ | # | Problem | Diff | Why it was missing | Hint? |
|---|---|---|---|---|---|
| [ ] | 1092 | Shortest Common Supersequence | Hard | "shortest common supersequence" was in the outline | |
| [ ] | 343 | Integer Break | Med | "rod cutting" was in the outline | |
| [ ] | 292 | Nim Game | Easy | "Nim, Grundy numbers (light)" was in the outline | |

**1092** is LCS plus reconstruction — build the LCS table, then walk it backwards emitting characters from both strings. **The reconstruction step is the actual content**, and it's a common follow-up to 1143 and 72 (*"now give me the actual sequence, not just the length"*). Worth doing for that reason alone.

**343** is rod cutting renamed. The DP is three lines; the interesting part is that the greedy answer (break into as many 3s as possible) is provably optimal, so there's an `O(log n)` math solution. **Solve it with DP, then derive the greedy** — that progression is a good demonstration of noticing structure.

**292** is a one-liner (`n % 4 != 0`) and takes two minutes, but it's the entry point to impartial game theory. Do it for the reasoning, not the code.

### Longest bitonic subsequence (no direct LeetCode problem)

From the outline. A bitonic subsequence increases then decreases. The technique: run **LIS from the left** and **LIS from the right**, then for each index `i` the best bitonic subsequence through `i` is `lisLeft[i] + lisRight[i] - 1`.

This is the same "sweep both directions and combine" pattern as 135 (Candy) in Greedy and 238 (Product of Array Except Self) in Arrays. Closest LeetCode problems: **845 Longest Mountain in Array** (contiguous version, Med) and **1671 Minimum Number of Removals to Make Mountain Array** (Hard) — 1671 is literally this technique. Do 1671 if you want the problem; otherwise just know the two-pass idea, since you already have 300 and the combination is mechanical.

### Nim and Grundy numbers (conceptual — "light" per the outline)

**Nim:** with piles of sizes `a, b, c, …`, the player to move loses iff the XOR of all pile sizes is 0. That XOR is called the *Nim-sum*.

**Grundy numbers (Sprague-Grundy theorem):** every impartial game position has a Grundy value `g`, computed as the **minimum excludant** (smallest non-negative integer not among the Grundy values of reachable positions). A position is losing for the player to move iff `g = 0`, and a sum of independent games has Grundy value equal to the XOR of the components' values.

**What to actually know:** the definition of mex, that `g = 0` means losing, and that independent games XOR. That's the full "light" treatment the outline asked for. If a problem needs more than this, it's a competitive-programming problem, not an interview one.

**Bounded knapsack** (also in the outline): items with a limited count `k` each. Two approaches — expand each item into `k` copies and run 0/1 knapsack, or use binary splitting (represent `k` as powers of two: 1, 2, 4, …) to get `O(n log k)` items instead of `O(nk)`. The binary splitting trick is the answer to *"can you do better than duplicating?"* No LeetCode problem; 474 (Ones and Zeroes) is the closest structurally.

**Revised count: 61 problems.** Slot 1092 onto day 8 (next to 115), 343 onto day 3, 292 onto day 13.

---

## Addendum 2 — Residual Coverage Check

Two outline items still missing.

| ✔ | # | Problem | Diff | Outline item | Hint? |
|---|---|---|---|---|---|
| [ ] | 1947 | Maximum Compatibility Score Sum | Med | Bitmask DP: "**assignment problem**" | |

**1947 is the assignment problem** — match `n` students to `n` mentors to maximize total score. The bitmask DP state is `dp[i][mask]` = best score having assigned the first `i` students using the mentors in `mask`. Since `popcount(mask) == i` is forced, you can drop the first dimension entirely and use `dp[mask]` alone — **that state reduction is the point of the problem**.

This is the fourth distinct bitmask shape, alongside 847 (BFS + mask), 1125 (set cover), and 943 (TSP). Assignment/matching is the one that appears most often in disguise — "pair up X with Y optimally" with small `n`.

Also worth knowing: the assignment problem has a polynomial solution (the **Hungarian algorithm**, `O(n³)`) and reduces to min-cost max-flow. At SDE III, say that and then solve it with bitmask DP because `n ≤ 20`. Naming the polynomial alternative without implementing it is the right calibration.

### DP + segment tree optimization (conceptual)

From the outline: "DP + monotonic deque / **segment tree** optimization (rare, but a strong signal)." You have the deque version (1425, 1696). The segment tree version is the remaining item.

**When the deque isn't enough.** A monotonic deque optimizes transitions of the form `dp[i] = max(dp[j]) + f(i)` where `j` ranges over a **sliding window** — the window's monotonic movement is what makes the deque work.

If instead the valid `j` values form a **range determined by value rather than position** — `dp[i] = max(dp[j] for all j where a[j] < a[i])` — the window isn't monotonic and the deque fails. Then you need a segment tree or BIT over the *value* domain, supporting range-max query plus point update.

**Worked example: LIS in `O(n log n)` via BIT.** Coordinate-compress the values, then for each element query the max `dp` over all smaller values and write your own `dp[i]` back at your value's position. Same complexity as the patience-sorting solution to 300, but it generalizes to variants patience sorting can't handle (weighted LIS, LIS with a value gap constraint).

**Where you've already seen the ingredients:** 315 and 493 use a BIT for counting; 1235 uses binary search over sorted prior states. This is the same family — *"my DP transition needs a query over previously-computed states, so I'll index them in a structure."*

**What to say:** *"if the transition needs a max over a sliding window, a monotonic deque gives O(1) amortized. If the valid predecessors are determined by value rather than position, I'd index the DP states in a segment tree or BIT over the compressed value domain for O(log n) per transition."* That sentence is the whole deliverable — this genuinely is rare in interviews, and recognizing it beats implementing it.

**Revised count: 62 problems.** Add 1947 to day 12 next to the other bitmask problems.
