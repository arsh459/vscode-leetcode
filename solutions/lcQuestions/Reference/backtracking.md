# Backtracking — SDE III Prep (Final List)

**15 problems · 0 Easy / 11 Medium / 4 Hard · 4 days**

Tick the checkbox when solved. Mark the **Hint?** column if you needed help — those get re-solved first.

> **Framing:** backtracking is the most *template-able* topic in the plan. Nearly every problem is the same recursive skeleton with three variables swapped: what the choices are, when to prune, and when to record. Learn the skeleton properly on the first four problems and the rest are variations.
>
> The two things that actually get tested: **duplicate handling** (sort + skip) and **pruning** (recognizing a dead branch early). Everything else is bookkeeping.

### Already covered elsewhere

| # | Problem | Where |
|---|---|---|
| 212 | Word Search II *(trie + backtracking)* | Tries ✔ |
| 698 | Partition to K Equal Sum Subsets | DP ✔ |
| 131 | Palindrome Partitioning | *listed below — pairs with 132 in DP* |

---

## Subsets (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 78 | Subsets | Med | |
| [ ] | 90 | Subsets II *(duplicates)* | Med | |

> Start here. 78 both ways — recursive include/exclude **and** bitmask iteration (`for mask in 0..2^n`). The bitmask version connects to your bit manipulation block.
>
> **90 introduces the duplicate rule**, which recurs in 40 and 47: sort first, then `if (i > start && nums[i] == nums[i-1]) continue;`. Understand *why* `i > start` and not `i > 0` — that condition is the entire trick, and getting it wrong either drops valid answers or emits duplicates.

## Permutations (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 46 | Permutations | Med | |
| [ ] | 47 | Permutations II *(duplicates)* | Med | |

> 46 has two idioms: a `used[]` boolean array, or in-place swapping. Know both — the swap version is `O(1)` extra space and interviewers sometimes ask for it.
>
> 47's duplicate skip is subtly different from 90's because position matters, not just selection. Work out why on paper.

## Combinations (4)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 77 | Combinations | Med | |
| [ ] | 39 | Combination Sum *(reuse allowed)* | Med | |
| [ ] | 40 | Combination Sum II *(each used once, duplicates)* | Med | |
| [ ] | 216 | Combination Sum III *(fixed count)* | Med | |

> **39 vs 40 is the pair that matters.** The only structural difference is whether the recursive call passes `i` or `i + 1` — reuse vs consume. One character, completely different problem.
>
> Prune on all of these: if the remaining target goes negative, return immediately. On sorted input you can `break` instead of `continue`, which is strictly better and worth saying out loud.

## Grid / Path Search (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 79 | Word Search | Med | |
| [ ] | 212 | Word Search II *(already in Tries)* | Hard | |

> 79 is the visited-marker discipline problem: mark before recursing, **unmark on the way out**. The clean idiom is to mutate the board in place (`board[i][j] = '#'`) and restore — no extra space.
>
> If you did 212 in the Tries block, 79 is a 10-minute warm-up. Do it anyway; the mechanics need to be automatic.

## String Partitioning (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 131 | Palindrome Partitioning | Med | |
| [ ] | 93 | Restore IP Addresses | Med | |

> 131 is enumerate-all-partitions plus a palindrome check. The optimization — precompute an `isPalindrome[i][j]` table — is the same table 132 (in DP) needs. Solve them near each other.
>
> 93 is pure constraint pruning: 4 segments, each 0–255, no leading zeros. Very common phone screen, and it's really an edge-case-enumeration exercise dressed as backtracking.

## Classic Constraint Puzzles (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 51 | N-Queens | Hard | |
| [ ] | 37 | Sudoku Solver | Hard | |

> **51 is the canonical backtracking Hard.** The `O(1)` conflict check using three boolean arrays (column, `r+c` diagonal, `r-c+n` anti-diagonal) is the part interviewers want — the naive `O(n)` scan per placement works but signals less.
>
> 37 is the same idea in two dimensions: three sets of bitmasks or boolean arrays for row, column, and 3×3 box. Heavy on bookkeeping, light on insight. Do it once so it's not new.

## Expression / Advanced (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 17 | Letter Combinations of a Phone Number | Med | |
| [ ] | 282 | Expression Add Operators | Hard | |

> 17 is the gentlest possible backtracking problem — use it as a warm-up on day 1 if you want.
>
> **282 is the hardest problem in this block** and the most instructive. The difficulty is the multiplication precedence: you must carry the previous operand separately so you can retroactively fix `a + b * c`. Also has real overflow traps (use `long`) and a leading-zero rule. Worth a full session.
>
> 301 (Remove Invalid Parentheses) is a good alternative Hard if 282 doesn't land — BFS by removal count is the cleaner solution there.

## Bonus — Recognize, Don't Grind (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 22 | Generate Parentheses | Med | |

> Constraint-guided generation: track open and close counts, only branch where valid. Never generates an invalid candidate — which is what separates *good* backtracking from *generate-then-filter*. Short, elegant, frequently asked.

---

## 4-Day Schedule

| Day | Problems | Done |
|---|---|---|
| 1 | 17, 78, 90, 46, 47 | [ ] |
| 2 | 77, 39, 40, 216, 22 | [ ] |
| 3 | 79, 131, 93, 51 | [ ] |
| 4 | 37, **282** | [ ] |

Day 4 is two problems because both are bookkeeping-heavy and 282 needs real thought.

---

## Revision

Re-solve **cold** (no notes, from scratch) on:

- **Day 11** — everything marked Hint?, plus 90, 40, 47, 51, 282
- **Day 25** — same set, plus anything that needed a hint on day 11

The duplicate-handling problems (90, 40, 47) are the ones that decay. Revisit them specifically.

---

## Trim to 10 If Pressed

78, 90, 46, 47, 39, 40, 79, 131, 51, 22

Cut: 17, 77, 216, 93, 37, 282.

---

## The Template

Every problem above is this, with three slots filled differently.

```java
void backtrack(State state, int start, List<Result> out) {
    if (isComplete(state)) {          // slot 1: when to record
        out.add(new ArrayList<>(state.path));   // COPY, don't add the live list
        return;
    }
    for (int i = start; i < choices.length; i++) {
        if (shouldSkip(i, start)) continue;     // slot 2: pruning + dedup
        state.apply(choices[i]);                // choose
        backtrack(state, i + 1, out);           // slot 3: i vs i+1 = reuse vs consume
        state.undo(choices[i]);                 // un-choose  ← the bug lives here
    }
}
```

**The four places bugs happen, in order of frequency:**

1. **Adding the live list instead of a copy.** `out.add(path)` adds a reference; every result ends up empty or identical. Always `new ArrayList<>(path)`.
2. **Forgetting to undo.** State leaks into sibling branches. If results are wrong in a way that looks like contamination, this is it.
3. **`i` vs `i + 1`** in the recursive call. Reuse-allowed vs use-once.
4. **Duplicate skip condition.** `i > start` (skip duplicates at this level) vs `i > 0` (skips too much).

---

## The Duplicate Rule

Three problems (90, 40, 47) hinge on this. It's worth having exactly right.

**For subsets and combinations** — sort, then skip repeats at the same recursion level:
```java
Arrays.sort(nums);
for (int i = start; i < nums.length; i++) {
    if (i > start && nums[i] == nums[i - 1]) continue;   // same level only
    ...
}
```
The `i > start` guard allows a duplicate to be used *deeper* in the path (so `[2,2]` is still generated) but prevents two branches at the same level from starting with the same value.

**For permutations** — position matters, so the guard is about the `used[]` array:
```java
Arrays.sort(nums);
for (int i = 0; i < nums.length; i++) {
    if (used[i]) continue;
    if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;   // prior dup unused
    ...
}
```
The `!used[i-1]` condition enforces that duplicates are consumed left to right, so only one ordering of identical elements survives.

**Don't memorize these — derive them once on `[1, 2, 2]` and they'll stick.**

---

## Pruning: What Separates Passing From TLE

| Situation | Prune |
|---|---|
| Running sum exceeds target, input sorted | `break` (not `continue`) — all later values are worse |
| Remaining elements can't reach the target | Compare remaining suffix sum against what's needed |
| Partial candidate already violates a rule | Check *before* recursing, not at the leaf |
| Grid cell already on the current path | Visited marker, restored on exit |
| Dictionary prefix left the trie | Stop the branch immediately (212) |
| Placing a queen conflicts | `O(1)` set lookup, not an `O(n)` scan |

**The general principle:** validate as early as possible in the recursion, never at the leaf. Generate-then-filter is the difference between an accepted solution and a timeout, and interviewers watch for which one you reach for.

---

## Pattern Recognition Check

| Signal in the problem | Approach |
|---|---|
| "All subsets" / "power set" | Include-exclude recursion, or bitmask |
| "All permutations" | `used[]` array or in-place swapping |
| "All combinations summing to X" | Combination backtracking + target pruning |
| Input has duplicates, output must not | **Sort first**, then level-skip |
| Each element usable unlimited times | Pass `i` (not `i + 1`) in the recursion |
| Search a grid for a word/path | DFS + visited marker restored on exit |
| Many words in one grid | Trie + backtracking *(in Tries)* |
| Split a string into valid pieces | Partition backtracking + validity check |
| Place items with mutual constraints | Constraint sets for `O(1)` conflict checks |
| Insert operators into digits | Carry the previous operand for precedence |
| Generate only valid candidates | Constraint-guided branching (22) |
| Count solutions but not list them | **Probably DP, not backtracking** — check |
| `n ≤ 20` and asking for an optimum | **Probably bitmask DP, not backtracking** |

Those last two matter: if the problem asks *how many* rather than *which ones*, backtracking is usually the wrong tool. Say so.

---

## Complexity — Be Ready To State It

Interviewers ask this on every backtracking problem, and vague answers cost points.

| Problem type | Complexity |
|---|---|
| Subsets | `O(n · 2^n)` — `2^n` subsets, `O(n)` to copy each |
| Permutations | `O(n · n!)` |
| Combinations of size k | `O(k · C(n,k))` |
| Combination sum | `O(n^(target/min))` — exponential, bounded by depth |
| N-Queens | `O(n!)` upper bound, far less with pruning |
| Word search on a grid | `O(m · n · 4^L)` for word length `L` |
| Generate parentheses | `O(4^n / √n)` — the nth Catalan number |

**The honest framing:** *"the output itself is exponential, so any correct algorithm is exponential; the pruning determines the constant, not the class."* That sentence answers the "can you do better?" follow-up correctly.

---

## Java Notes

- `out.add(new ArrayList<>(path))` — the most common backtracking bug in Java is adding the mutable reference.
- `path.remove(path.size() - 1)` for the undo on a `List`; `ArrayDeque.pollLast()` if you're using a deque.
- `StringBuilder` for string-building backtracking: `sb.append(c)` then `sb.deleteCharAt(sb.length() - 1)`. Don't build with `String +` in a hot recursion.
- Mutating the input grid as a visited marker (`board[i][j] = '#'`) is accepted and `O(1)` space — but **restore it**, and mention that you're mutating the input in case the interviewer objects.
- `long` in 282 — intermediate expression values overflow `int`.
- `boolean[]` conflict arrays beat `HashSet<Integer>` for N-Queens; indices `col`, `r + c`, `r - c + n` cover the three constraint families.
- Deep recursion is bounded by `n` here (not the number of solutions), so stack overflow is rarely the issue in this block.

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
| DP | 58 | ✔ |
| **Backtracking** | **15** | **✔ list built** |
| Bit / math | 16 | |
| Design | 12 | |

**Running total: 338 / ~360.**

---

## Addendum — Final Coverage Audit

One outline item — conceptual, no problem needed.

### Iterative deepening (IDDFS)

Run DFS with a depth limit of 1, then 2, then 3, and so on until you find a solution.

**Why it isn't obviously wasteful:** in a tree with branching factor `b`, the last level contains more nodes than all previous levels combined, so re-searching the shallow levels costs a constant factor — roughly `b/(b-1)`. For `b = 10` that's about 11% overhead.

**What it buys you:** BFS's guarantee of finding the shallowest solution first, with DFS's `O(depth)` memory instead of BFS's `O(b^depth)`.

| | BFS | DFS | IDDFS |
|---|---|---|---|
| Finds shallowest solution | Yes | No | **Yes** |
| Memory | `O(b^d)` | `O(d)` | **`O(d)`** |
| Revisits nodes | No | No | Yes, ~constant factor |

**When to mention it:** any search problem where the branching factor makes BFS's queue too large but you still need the shortest solution. Puzzle solvers (15-puzzle, Rubik's) are the classic use, usually as **IDA\*** — iterative deepening with an A* heuristic on the cost bound.

**What to say if asked:** *"if BFS's memory is the constraint but I need the shallowest answer, iterative deepening gives me that in O(depth) space; re-expanding shallow levels only costs a constant factor because the frontier dominates."* That's the complete expected answer at SDE III — no implementation required.

**Related from the outline, already covered:** "rat in maze" is 79 (Word Search) with different framing — same visited-marker-restored-on-exit mechanic, no separate problem needed.

**Count unchanged: 15 problems.**
