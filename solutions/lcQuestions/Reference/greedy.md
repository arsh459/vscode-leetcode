# Greedy — SDE III Prep (Final List)

**8 new problems · 2 Easy / 4 Medium / 2 Hard · 2 days**

Tick the checkbox when solved. Mark the **Hint?** column if you needed help — those get re-solved first.

> **Why this block is small but not skippable:** greedy problems were mostly absorbed into other blocks (intervals in Arrays, greedy+heap in Heaps, greedy+stack in Stacks). What was *not* covered is the thing that actually gets tested — **justifying that greedy is correct.**
>
> Interviewers rarely ask "solve this greedily." They ask "why does that work?" and "how do you know a greedy choice doesn't lock you out of the optimum?" A right answer with no justification reads as pattern-matching. This block is 8 problems and one skill.

### Already covered elsewhere

| # | Problem | Where |
|---|---|---|
| 435 | Non-overlapping Intervals | Arrays ✔ |
| 763 | Partition Labels | Arrays ✔ |
| 56, 57 | Merge / Insert Interval | Arrays ✔ |
| 45, 55 | Jump Game II / Jump Game | DP ✔ *(55 as the greedy-beats-DP contrast)* |
| 122 | Stock II | DP ✔ |
| 621 | Task Scheduler | Heaps ✔ |
| 502, 1642 | IPO, Furthest Building | Heaps ✔ |
| 767 | Reorganize String | Heaps ✔ |
| 253 / 1094 | Meeting Rooms II / Car Pooling | Heaps ✔ |
| 402, 316 | Remove K Digits, Remove Duplicate Letters | Stacks ✔ |
| 179, 406 | Largest Number, Queue Reconstruction | Sorting ✔ |
| 968 | Binary Tree Cameras | Trees ✔ |

---

## Warm-Up — Sort Then Take (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 455 | Assign Cookies | Easy | |
| [ ] | 1005 | Maximize Sum Of Array After K Negations | Easy | |

> Both are "sort, then make the locally obvious choice." Fast, and useful for practising the justification out loud on something where the argument is easy: *why is matching the smallest sufficient cookie to the greediest child never worse than any alternative?*

## The Two Canonical Greedy Problems (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 134 | Gas Station | Med | |
| [ ] | 135 | Candy | Hard | |

> **134 is the most-asked greedy problem that wasn't already in your plan.** Two insights: total gas ≥ total cost means a solution exists; and if you run out at station `j` starting from `i`, no station between `i` and `j` can be a valid start either. That second one is the greedy justification, and it's the whole interview.
>
> **135 is the two-pass greedy** — left to right for ascending runs, right to left for descending, take the max at each index. The reason one pass fails is that a constraint can come from either direction. This "sweep both ways and combine" idea also appears in 238 (Product of Array Except Self) and 42 — notice the family.

## Interval Scheduling Greedy (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 452 | Minimum Number of Arrows to Burst Balloons | Med | |
| [ ] | 646 | Maximum Length of Pair Chain | Med | |
| [ ] | 1024 | Video Stitching | Med | |

> 452 and 646 are both **classic activity selection** — sort by *end* time, take greedily. 435 (in Arrays) is the same algorithm counting removals instead of selections. Three problems, one algorithm; the value is in seeing that.
>
> **Sorting by end time rather than start time is the crux.** Be able to argue it: the interval that finishes earliest leaves the most room for everything after it, so choosing it is never worse than choosing any other.
>
> 1024 is minimum-intervals-to-cover-a-range, which is a *different* greedy — sort by start, then repeatedly jump to the farthest reachable end. Contrast it with 452 deliberately; they look alike and the algorithms differ.

## Covering / Reach Greedy (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1326 | Minimum Number of Taps to Open to Water a Garden | Hard | |

> Reduces exactly to **45 Jump Game II** once you convert each tap into a reachable interval. Solving it and then *recognizing* it's 45 in disguise is the point — that reduction instinct is what separates senior candidates on unfamiliar problems.

---

## 2-Day Schedule

| Day | Problems | Done |
|---|---|---|
| 1 | 455, 1005, 134, 135 | [ ] |
| 2 | 452, 646, 1024, 1326 | [ ] |

---

## Revision

Re-solve **cold** (no notes, from scratch) on:

- **Day 9** — everything marked Hint?, plus 134, 135, 1326
- **Day 23** — same set

---

## Trim to 5 If Pressed

134, 135, 452, 1024, 1326

Cut: 455, 1005, 646.

---

## The Exchange Argument — The Actual Skill

This is what the block is for. When you propose a greedy solution, the follow-up is always some version of *"how do you know that's optimal?"* There are two standard proof shapes, and you should be able to produce one in a sentence or two.

**1. Exchange argument (most common).**
Assume an optimal solution `O` that differs from your greedy solution `G`. Find the first place they diverge. Show you can swap `O`'s choice for `G`'s choice without making `O` worse. Repeat, and `O` becomes `G` — so `G` is also optimal.

*Example, 452:* suppose the optimal solution's first arrow is not at the earliest end point. Move it to the earliest end point. Every balloon it burst before is still burst (they all extend past that point), and possibly more are. Not worse. Therefore choosing the earliest end is safe.

**2. Greedy stays ahead.**
Show that after every step, your partial solution is at least as good as any other partial solution of the same size.

*Example, 45 / 1326:* after `k` jumps, greedy's reachable frontier is at least as far as any other strategy's after `k` jumps. So greedy never needs more jumps.

**Say one of these out loud when you propose a greedy solution.** You don't need a formal proof — you need to show you know one exists and roughly what shape it takes. That single sentence is a large fraction of the greedy score.

---

## When Greedy Fails — Know The Tells

Reaching for greedy when the problem needs DP is a worse error than the reverse, because greedy code looks clean and runs fast while being wrong.

| Tell | Why greedy breaks | Use instead |
|---|---|---|
| A choice now changes what's *available* later in a non-monotonic way | The locally best choice can block a better global path | DP |
| The problem asks to **count** solutions, not find one | Greedy produces one answer, not a count | DP |
| Items have both a weight and a value, capacity is bounded (0/1 knapsack) | Highest value-per-weight first is provably suboptimal | DP |
| You need the optimal *split point* and it isn't determinable locally | No local rule identifies the right split | Interval DP |
| Two constraints interact (e.g. cost *and* count limit) | Optimizing one greedily can violate the other | DP with a 2-D state |
| Small `n` (≤ 20) with an odd-looking constraint | Usually a hint the structure isn't greedy-friendly | Bitmask DP |

**The honest diagnostic:** try to construct a counterexample to your own greedy rule *before* you code it. Spend 30 seconds. If you can't find one and you can sketch an exchange argument, proceed and say so. If you find one, you've just saved yourself a wrong answer — and mentioning that you looked is itself a good signal.

**Coin change is the canonical cautionary tale.** Largest-coin-first works for `{1, 5, 10, 25}` and fails for `{1, 3, 4}` with target 6 (greedy gives 4+1+1 = 3 coins; optimal is 3+3 = 2). Have this example ready — it's the cleanest one-line demonstration that greedy needs justification, not intuition.

---

## Pattern Recognition Check

| Signal in the problem | Approach |
|---|---|
| Maximum non-overlapping intervals | Sort by **end**, take greedily |
| Minimum removals to make non-overlapping | Same algorithm, count the rest |
| Minimum points/arrows to hit all intervals | Sort by end, place at each end point |
| Minimum intervals to **cover** a range | Sort by start, jump to farthest reachable end |
| Minimum jumps / taps / stations to reach the end | Greedy frontier expansion (45 family) |
| Minimum rooms / resources for overlapping intervals | Min-heap of end times, or sweep line |
| Constraint applies from both directions | Two passes, combine with max |
| Circular array, find a valid starting point | Prefix-sum reasoning + "no start before the failure point" |
| Assign smallest sufficient resource to each demand | Sort both, two pointers |
| Repeatedly take the best available, set changes over time | Greedy + heap *(Heaps block)* |
| Build the lexicographically best result by removal | Greedy + monotonic stack *(Stacks block)* |
| Arrange items to optimize a combined value | Custom comparator, verify transitivity *(Sorting block)* |
| Count the number of optimal solutions | **Not greedy — DP** |
| Bounded capacity with weights *and* values | **Not greedy — knapsack DP** |

---

## Java Notes

- Sorting by end time: `Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]))`. Do **not** use `(a, b) -> a[1] - b[1]` — overflow, per the Sorting block notes. 452's test set includes `Integer.MIN_VALUE` / `MAX_VALUE` bounds specifically to catch this.
- 134 needs no extra space and one pass — resist the `O(n²)` simulate-every-start version, or at least state that you know it's `O(n²)` and then improve it.
- 135 is two `int[]` passes, or one array plus a reverse sweep taking `Math.max`.
- For 1024 / 45, track `currentEnd` and `farthest` as separate variables; conflating them is the standard bug.
- `Arrays.sort` on `int[][]` uses Timsort (object array of rows) — stable, guaranteed `O(n log n)`. Fine for interval problems.

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
| **Greedy** | **8** | **✔ list built** |
| Trees + BST | 40 | ✔ |
| Tries | 10 | ✔ |
| Graphs | 48 | ✔ |
| DP | 58 | ✔ |
| Backtracking | 15 | ✔ |
| Bit / math | 16 | ✔ |
| Design | 12 | ✔ |

**Running total: 379.**

---

## Addendum — Final Coverage Audit

Three outline items missed — one problem, two conceptual.

| ✔ | # | Problem | Diff | Why it was missing | Hint? |
|---|---|---|---|---|---|
| [ ] | 630 | Course Schedule III | Hard | "Task scheduling **with deadlines**" — 621 is cooldown scheduling, a different problem | |
| [ ] | 1167 | Minimum Cost to Connect Sticks *(premium)* | Med | "Huffman coding" was in the outline | |

**630 is the real deadline-scheduling greedy and it's excellent.** Sort by deadline, take everything greedily, and when the running total exceeds the current deadline, **drop the longest course taken so far** (max-heap). The exchange argument — swapping out the longest course never reduces how many you can fit — is exactly the justification skill this block exists for. It's also a genuine "greedy + heap" problem, so it slots naturally next to 502 and 1642 from the Heaps block.

**1167 is Huffman's algorithm** with the tree-building stripped out: repeatedly pull the two smallest, merge, push back the sum. If premium-locked, 2sum-style substitutes don't exist — but 1046 (Last Stone Weight, already on your list) is the same heap mechanic in reverse, and the Huffman *reasoning* is below.

### Huffman coding (conceptual)

Build an optimal prefix-free code: repeatedly merge the two lowest-frequency symbols into a subtree, and the resulting tree's depths are the code lengths.

**Why it's greedy-correct:** the two least frequent symbols must be the deepest siblings in *some* optimal tree — if they weren't, swapping them with whatever is deepest doesn't increase the weighted path length. That's a textbook exchange argument, and being able to give it is worth more than implementing the algorithm.

**Where it shows up in practice:** DEFLATE/gzip, JPEG entropy coding, and — relevant to your backend work — the static Huffman table in **HTTP/2's HPACK** header compression. Naming HPACK is a nice concrete anchor if compression comes up in a design round.

### Fractional knapsack (conceptual)

From the outline. Items can be split, so sort by **value-to-weight ratio** and take greedily, splitting the last item to fill the remaining capacity. `O(n log n)`.

**The whole reason it's in the outline** is the contrast with 0/1 knapsack: fractional is greedy-optimal, 0/1 is not. Be able to say why — with fractional items, taking the best ratio first can never lock you out, because leftover capacity is always usable. With indivisible items, a high-ratio item can consume capacity that two lower-ratio items would have filled more valuably.

**That contrast is the single most useful greedy-vs-DP example there is.** It's more convincing than the coin-change counterexample because the *only* thing that changes is divisibility. No LeetCode problem exists (it's too easy), but have the argument ready — "when does greedy fail?" is a standard question and this is the cleanest answer.

**Revised count: 10 problems.** Add 630 to day 2; 1167 only if you have premium.
