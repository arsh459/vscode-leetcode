# Phase 3 — Above the SDE III Bar

**No calendar. No day count. A menu, not a schedule.**

Everything here sits *above* what an SDE III loop tests. That's the definition of this phase, and
it has a consequence worth stating plainly before anything else.

---

## Read this first

**Phase 3 does not improve your SDE III odds.** If the goal is an offer, every hour here is an hour
not spent on the thing that actually decides the round — which at this level is rarely a harder
algorithm and almost always the habits from [Phase 2](../Phase2/README.md): justifying a greedy
choice, stating per-operation complexity, asking which access pattern dominates, volunteering the
scaling follow-up.

Concretely: **doing Phase 3 before Phase 2 is complete and revised twice is negative expected
value.** `math-extras-advanced.md` says the same thing about its own advanced section — *"every hour
spent implementing a count-min sketch is an hour not spent on graphs"* — and that judgment is
correct.

So there are exactly three good reasons to be here:

1. **You're targeting a loop that genuinely reaches this tier** — Google L5+ algorithm-heavy rounds,
   quant/HFT, or a systems team that writes its own index structures. Even then it's Tier 1 only.
2. **Phase 2 is done, revised, and you have runway left.** Then Tier 1 is a reasonable use of it.
3. **You want to, for its own sake.** Legitimate, and honestly the most likely reason anyone
   finishes this material. Just don't file it under interview prep.

If none of those apply, close this file and go re-solve 312 cold.

---

## The corpus changes

This is the structural thing to understand. Phases 1 and 2 are LeetCode-shaped because interview
prep is LeetCode-shaped. **Phase 3 mostly isn't on LeetCode at all** — flow, Mo's algorithm, HLD,
centroid decomposition, suffix automata and FFT have essentially no LeetCode representation,
because they don't appear in interviews.

| Resource | What it's for | Why |
|---|---|---|
| **CSES Problem Set** | The backbone. ~400 problems, ordered, no noise | Best-structured advanced set that exists. Its Tree Algorithms, Range Queries, Flows and String sections *are* Tier 2 |
| **AtCoder Educational DP Contest** (A–Z) | Advanced DP, in order | 26 problems that cover every DP shape past Phase 2, ending at CHT (task Z) |
| **AtCoder Library Practice Contest** | Reference implementations | The canonical way to learn FFT, MCMF, lazy segment trees, 2-SAT with a checker |
| **Codeforces Div 1 C+ / Div 2 E+** | Everything with no clean tutorial | Editorials are the actual teaching material at this level |
| **USACO Platinum** | Technique-per-problem, well written | Good analyses; slower pace than CF |

LeetCode stops being the right tool here. Fighting that is how people spend six months on Tier 2
and learn less than the CSES Range Queries section teaches in three weeks.

## How to use the catalogue

[catalogue.md](catalogue.md) has three tiers, ordered by the only axis that matters here —
**probability it ever appears in front of you.**

| Tier | Interview probability | Treatment |
|---|---|---|
| **Tier 1 — Rare but real** | Low, non-zero (Google, quant, infra) | **Implement.** Every entry has real LeetCode problems |
| **Tier 2 — CP staples** | ~Zero | Read the technique, implement if it interests you. CSES/CF only |
| **Tier 3 — Name-only** | Zero | Know the name and the one-line purpose. Nothing more |

Each Tier 1 entry carries a **"if asked" sentence.** For almost everything in this phase, being
able to say the sentence *is* the entire interview-relevant payload — which is exactly the argument
`math-extras-advanced.md` makes for its Part 2 reading list, and it generalizes to the whole tier.

## If you do it anyway — a working order

Tier 1, in dependency order. Roughly 6–8 weeks at 1.5h/day if you implement rather than skim.

1. **Segment tree with lazy propagation** — extends the Phase 2 tree you already wrote; unlocks
   the most Tier 1 problems (4 real LeetCode Hards)
2. **Matrix exponentiation** — you built the `O(log n)` Fibonacci version in Phase 2; generalize it
3. **Digit DP, hard variants** — extends Phase 2's 233/902
4. **Bitmask DP, hard variants + SOS DP** — extends Phase 2's 847/943/1947
5. **Aho-Corasick** — extends your trie; LC 1032 is a genuine ask
6. **Bitwise trie with offline DFS** — extends Phase 2's 421/1707
7. **Geometry: convex hull, orientation, closest pair** — includes 587, promoted from Phase 2
8. **Persistent / versioned structures** — extends 1146
9. **Parametric search** — includes 644, promoted from Phase 2
10. **Min-cost matching / assignment** — the Hungarian algorithm you named but didn't implement

Then stop and reassess. Tier 2 is a different hobby, not the next step.

## Promoted from Phase 2

Three problems moved here as genuinely rare, on the Reference files' own assessment:

| # | Problem | Why it's here |
|---|---|---|
| 644 | Maximum Average Subarray II *(premium)* | `binary-search.md` calls parametric search *"rare in interviews"* and marks it cut-first |
| 715 | Range Module | `intervals-sweep-line.md`: *"rarely asked directly, do it only if you have time"* — the most fiddly problem in that file |
| 587 | Erect the Fence | `math-extras-advanced.md`: *"skip unless you're targeting a graphics/maps/geo team"* |

All three are still worth the reading even if you never solve them — the *techniques* (parametric
transformation, `TreeMap` of disjoint intervals, cross-product orientation) appear as follow-ups
far more often than these problems appear as questions.

## There's no exit criterion

Phases 1 and 2 have one because they have a target: an interview. This phase doesn't, so measuring
completion is the wrong frame. Two honest checks instead:

- **Am I still able to produce the Phase 1 and Phase 2 templates cold?** If a month of Tier 2 has
  cost you your union-find or your interval DP, the trade was bad. Rotate one Phase 1/2 template
  into every session as a warm-up.
- **Is this making me better at the thing I'm optimizing for, or just harder to impress?** Both are
  fine answers. Only one of them is prep.
