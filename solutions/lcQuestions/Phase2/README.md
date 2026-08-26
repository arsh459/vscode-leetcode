# Phase 2 — SDE III (16 weeks, 1.5h/day)

**207 problems + 11 from-scratch exercises · 96 sessions · ~6 days/week**

Phase 1 gave you the patterns. Phase 2 is the other half of the Reference set — the Hards, the
depth, and the eleven things with no LeetCode entry that you'll actually be asked to *build*.

Daily driver: [schedule.md](schedule.md). Prerequisite: [Phase 1](../Phase1/README.md) complete,
including its exit criteria. Starting Phase 2 with shaky templates is the one way to waste it.

---

## The pace math, and why it's slower

| | Phase 1 | Phase 2 |
|---|---|---|
| Weeks × days | 13 × 6 | **16 × 6** |
| New-material sessions | 64 | **80** |
| Problems | 215 | **207** |
| Per session | ~3.4 | **~2.6** |
| Hard density | ~8% | **~45%** |
| From-scratch exercises | 0 | **11** |

Same daily budget, fewer problems, four extra weeks. That's the Hard density doing its work —
312, 84's descendants, 218, 295's variants, segment trees, Tarjan. Budget 45 minutes for a Hard
and stop pretending it's 28.

**The 30-minute rule loosens to 45 here, once.** Past 45 minutes with no approach: read, implement
unaided, mark Hint?, move on. What does *not* loosen is the revision discipline — Phase 2 material
decays faster than Phase 1 material, because there's less repetition per pattern.

---

## What Phase 2 actually adds

Not just harder versions of the same thing. Five genuinely new capabilities:

| Capability | Where it lands |
|---|---|
| **Sweep line with a structure** — 218 Skyline, lazy deletion, `TreeMap` multisets | Week 6 |
| **Range query structures** — segment tree, BIT, coordinate compression | Week 8 |
| **The hard DP families** — interval (312), bitmask (847/943/1947), digit, game theory, DP+deque | Weeks 10–12 |
| **Concurrency** — 9 problems + 4 exercises; the largest single gap for a Java backend candidate | Weeks 13–14 |
| **Build-it-yourself** — consistent hashing ring, Bloom filter, bounded blocking queue, thread-safe LRU, RW lock, lock-free stack, TTL cache | Weeks 13–16 |

## The eleven exercises — these matter more than the Hards

No LeetCode entry, closest to what you'll be asked to produce live on a shared screen.
Priority is the Reference files' own, not mine.

| # | Exercise | Week | Priority |
|---|---|---|---|
| 1 | Bounded blocking queue — `synchronized`/`wait` **and** `ReentrantLock`+`Condition` | 13 | **Highest** |
| 2 | Thread-safe LRU cache — the four-tier progression | 14 | **Highest** |
| 3 | Consistent hashing ring + distribution test | 16 | **Highest** |
| 4 | Read-write lock from scratch | 14 | Medium |
| 5 | Lock-free counter, token bucket, Treiber stack | 14 | Medium |
| 6 | Bloom filter, honestly tested | 16 | Low |
| 7 | In-memory KV store with TTL | 15 | Medium |
| 8 | Trie `delete` | 6 | Low |
| 9 | Indexed heap / decrease-key | 5 | Low |
| 10 | Z-algorithm | 2 | Low |
| 11 | Manacher's + heapsort | 2, 1 | Low |

If the phase compresses, keep 1, 2, 3. Those three get asked directly.

---

## The part that isn't problems

**This is where SDE III is actually decided, and it isn't on the schedule** because it's how you
work every day, not a day. All of it is lifted from the Reference files:

1. **Justify, don't assert.** Every greedy answer gets an exchange argument in one sentence. Every
   "why does that work?" has an answer ready before it's asked.
2. **State the complexity of each operation**, not just the interesting one. `get`: O(1). `put`:
   O(1) amortized. `topK`: O(k log n).
3. **Ask which operation dominates** before choosing a structure. For 1244, 1146, 981, the answer
   changes with the access pattern — and asking *is* the answer they want.
4. **Volunteer the scaling follow-up, unprompted:** *"this is in-memory and single-threaded; for
   concurrency I'd use ConcurrentHashMap plus a lock on the eviction list; distributed, I'd shard
   by key hash and accept that global ordering becomes approximate."*
5. **Name the real system.** 1146 is MVCC. 1206 is Redis sorted sets. LSM compaction is external
   merge sort. Huffman is HPACK. One sentence, and it reads as breadth rather than memorization.
6. **Correct → fast → distributed**, tradeoff named at each step. That progression is the single
   most reusable answer shape in the phase.

A candidate who solves 180 of these problems with habits 1–6 clears the bar. One who solves all
207 without them does not. Weight your time accordingly.

## Premium-locked problems

About 20 problems here need LeetCode Premium: 253, 426, 545, 285, 1650, 505, 1135, 702, 1231, 774,
1188, 1242, 362, 359, 281, 348, 353, 1167, 1272, 249. Each is marked *(premium)* in the schedule.

Without a subscription: **implement from the description.** The Reference notes describe the
approach for every one of them, and 1188 and 1242 in particular are worth building against a stub
regardless — they're the two most realistic concurrency problems in the set.

## Revision policy — heavier than Phase 1

Day 6 of every week, ~90 minutes:

1. **Everything marked Hint? that week, cold.**
2. **The week's anchor set** — named per week, drawn from 2–5 weeks back.
3. **One Phase 1 template**, written from scratch on a blank file. Rotate through the nine in the
   Phase 1 exit criteria. A template you can't produce cold in week 12 is a template you lost.

The Reference files prescribe two cold passes per block (roughly day N+7 and day N+21 of that
block). The weekly anchors implement that; don't skip a Day 6 to gain a problem day.

## If you fall behind

`Bit/Math II → Math Extras problems (keep Exercise A) → Design premiums → Backtracking II → Strings II tail → Linked List II`

**Never cut:** DP II (13 days), Graphs II (8 days), Trees II segment-tree days, 218, or the three
Highest-priority exercises. Those are the phase.

---

## Exit criteria — SDE III ready

**Write cold:** segment tree (point update, range query) and BIT; Dijkstra variants that minimize
the maximum edge; Tarjan low-link (bridges *and* articulation points from the same DFS); interval
DP by length; bitmask DP state setup; a bounded blocking queue two ways; a consistent hashing ring.

**Explain cold, in one or two sentences each:** why `notifyAll` causes a thundering herd and
`Condition` doesn't; why Java's missing decrease-key doesn't break Dijkstra's complexity class;
why a sparse table can't do range sums; why 518 and 377 differ by loop order; why arbitrage is a
negative cycle under `-log(rate)`; which of Coffman's four conditions your deadlock fix breaks;
why Bloom filter negatives are authoritative.

**Behaviourally:** produce an exchange argument for any greedy solution; give the
correct → fast → distributed progression for any structure; name the production system behind any
design problem in the set.

## What Phase 3 gets

Three problems moved out of this phase as genuinely rare — **644** (parametric search),
**715** (Range Module), **587** (convex hull) — plus every technique the Reference files put in
their own *Genuinely Skippable* table. See [../Phase3/README.md](../Phase3/README.md), and read
its warning before starting it.
