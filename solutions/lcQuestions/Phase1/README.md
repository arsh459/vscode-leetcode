# Phase 1 — SDE II Coverage (13 weeks, 1.5h/day)

**215 problems · 16 topics · 78 sessions · ~6 days/week**

The goal of this phase is **well-rounded SDE II readiness**: every pattern that decides a
standard coding round, none of the SDE III depth. Phase 2 picks up what's left.

Daily driver: [schedule.md](schedule.md). Problem detail, Java notes, and pattern tables
live in the Reference files — this phase selects from them, it doesn't replace them.

---

## The pace math

| | |
|---|---|
| 13 weeks × 6 days | 78 sessions (day 7 is off — take it) |
| minus 1 revision day per week | **64 new-problem sessions** |
| 90 minutes ÷ ~3 problems | **~28 min per problem** |
| **Total** | **215 problems** (of the ~429 in `Reference/`) |

28 minutes per problem is the binding constraint, and it is deliberately tight. It only works
with the **30-minute rule** below. Without that rule this plan takes five months, not three.

**The 30-minute rule.** If you have no working approach at 30 minutes, stop. Read the editorial,
understand the idea, implement it yourself without looking, mark **Hint?**, move on. A problem
you struggled through for 70 minutes and a problem you marked Hint? and re-solve cold next week
cost the same total time — but the second one you'll still have in three months.

---

## What's in, and what waits for Phase 2

| Topic | Phase 1 | In Reference | Cut for now |
|---|---|---|---|
| Arrays | 25 | 42 | 2D prefix sum, at-most-K, circular Kadane, Majority II, Game of Life |
| Hashing | 5 | 17 | Design HashMap, Max Points on a Line, LFU, Freq Stack |
| Strings | 13 | 23 | KMP payoff (214), rolling hash (1044), wildcard/regex DP, calculators w/ parens |
| Sorting | 3 | 5 | radix (164), log reorder (937) |
| Binary search | 15 | 29 | kth-in-matrix family (378/668/719), median of two sorted, parametric |
| Linked list | 13 | 17 | 148 sort list, 86/328 partition, 430 flatten |
| Stacks & queues | 13 | 27 | 85, 862, 828, 2104, max stack, circular deque |
| Heaps | 10 | 20 | sliding window median, IPO, smallest range, Design Twitter |
| Greedy + intervals | 5 | 14 | Candy, Course Schedule III, **Skyline (218)**, Range Module |
| Trees & BST | 25 | 45 | segment tree / BIT, tree DP hards, binary lifting, rerooting, boundary |
| Tries | 4 | 10 | bitwise trie / XOR (421, 1707), 745, 677 |
| Graphs | 27 | 48 | Tarjan bridges, Eulerian, 0-1 BFS, 685, 839, MST premium, SCC |
| DP | 30 | 62 | **bitmask, digit, interval, game theory, probability**, 174, 115, 10 |
| Backtracking | 9 | 15 | N-Queens, Sudoku, 282, palindrome partitioning, IP restore |
| Bit / math | 10 | 22 | Single Number II, 371, 201, 89, 372, 29, sampling (384/528/398/470) |
| Design | 8 | 17 | LFU, skiplist, calendars II/III, snapshot array, All O'one, TTL cache |
| **Concurrency** | **0** | **9 + 4 exercises** | **all of it** — see the note below |
| Math extras / advanced | 0 | 7 + 2 exercises | Bloom filter, consistent hashing, HLL, LSM/B-tree |

**Concurrency is the one judgment call worth flagging.** It's absent from Phase 1 because it
almost never appears in an SDE II *coding* round. But you're a Java backend engineer, and
`concurrency.md` is right that "now make it thread-safe" is a standard follow-up. If your loop
includes a Java-depth round, pull **1114, 1115, 1226 and Exercise 1 (bounded blocking queue)**
forward — they fit in the Week 13 slack.

---

## The rules (from the Reference files, condensed)

1. **State the approach and the complexity before you type.** For DP, finish the sentence
   *"`dp[i][j]` = …"* out loud. If you can't, you're not ready to code.
2. **Re-derive, don't recall.** Solving 560 by remembering "prefix sum + map" is not knowing it.
3. **Dry-run on a small example unprompted**, before anyone asks.
4. **Write compilable Java.** Real types, real names, no pseudocode.
5. **Mark Hint? honestly.** That column is the entire revision system. Under-marking it is the
   only way to actually fail this plan.
6. **Do the follow-up.** "Now in O(1) space", "now it's a stream." That's where the level is set.

## Revision policy

Day 6 of every week, ~90 minutes, in this order:

1. **Everything marked Hint? that week**, cold — no notes, from scratch.
2. **The week's anchor set** (named per week in the schedule) — problems from 2–5 weeks back
   that decay fastest.
3. Whatever's left over from a day you didn't finish.

Day 6 is also the shock absorber. If Week 5 ran long, Day 6 is where it lands. That's the
design, not a failure.

## If you fall behind

Cut in this order. Never cut in a different order, and never cut a graphs or DP day.

`Bit/Math → Design → Sorting → Tries → Strings tail → Heaps tail → Linked list tail`

Graphs (27) and DP (30) are 27% of this phase. Every Reference file repeats the same line —
**protect the graphs-and-DP ratio** — and it's the one instruction in that set I'd follow
without argument.

## Already done

You have solutions in the repo for **1, 4, 11, 15, 16, 37, 42, 88, 274, 283, 572**. Seven of
those are on the Phase 1 list and appear as re-verifications (marked ✔ in the schedule) rather
than new work — Day 1 and Week 5's stack day are lighter than they look because of it.

---

## Exit criteria — what "Phase 1 done" means

Ticking 215 boxes isn't the finish line. These are:

**Write cold, from memory, no reference:**

- `lowerBound` / `upperBound` with one loop invariant you never deviate from
- The monotonic stack template (indices, not values)
- BFS with level tracking, and multi-source BFS seeding
- Kahn's topological sort
- Union-find with path compression and union by size
- Dijkstra with push-duplicate / skip-stale (Java has no decrease-key)
- The backtracking skeleton, including the copy-on-record and the undo
- The three tree shapes: bottom-up return, top-down state, level-by-level
- 0/1 knapsack (capacity **backwards**) vs unbounded (capacity **forwards**)

**Behaviourally:**

- Name the pattern within ~60 seconds for anything in a Reference Pattern Recognition table
- Solve an unseen Medium in 25 minutes, state definition stated before coding
- Catch your own bug before the interviewer does

If any template above isn't automatic at the end of Week 13, that's the Phase 2 warm-up —
not a reason to extend Phase 1.
