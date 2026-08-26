# Hashing — SDE III Prep (Final List)

**17 problems · 3 Easy / 11 Medium / 3 Hard · 5 days**

Tick the checkbox when solved. Mark the **Hint?** column if you needed help — those get re-solved first.

> **Scope note:** Hashing is a *technique*, not a topic — most of it is already covered. This block is deliberately short and design-heavy, because that's where the remaining SDE III signal is.

### Already covered elsewhere — do not re-solve

| Pattern | Where |
|---|---|
| Prefix sum + hashmap | Arrays — 560, 974, 525 ✔ |
| Two-sum family / two-pointer sums | Arrays — 15, 11 ✔ |
| Frequency signatures as map keys | Strings — 49 ✔ |
| Rolling hash | Strings — 1044 ✔ |
| Index-as-hash (no map at all) | Arrays — 448, 287, 41 ✔ |

---

## Foundations / HashSet (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1 | Two Sum | Easy | |
| [ ] | 128 | Longest Consecutive Sequence | Med | |

> 128 is the one that matters — O(n) with a set, starting a run only at sequence **heads**. The O(n log n) sort version misses the point entirely.

## Frequency Counting & Bucketing (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 347 | Top K Frequent Elements | Med | |
| [ ] | 451 | Sort Characters By Frequency | Med | |
| [ ] | 954 | Array of Doubled Pairs | Med | |

> Do 347 **three ways** and know the tradeoffs: heap `O(n log k)`, bucket sort `O(n)`, quickselect `O(n)` average. Standard follow-up: *"which would you pick if k is close to n?"*

## k-Sum Generalization (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 454 | 4Sum II | Med | |

> Meet-in-the-middle: split into two halves, hash one, look up the other. `O(n²)` instead of `O(n³)`. This is the generalization that 15's two-pointer approach does **not** teach you.

## Prefix Sum + Hashmap (1 new)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 523 | Continuous Subarray Sum | Med | |

> Only one new — 560, 974, 525 already covered this. 523 adds the "same remainder, length ≥ 2" wrinkle. If short on time, skip and re-solve 974 instead.

## Rolling Hash / Double Hashing (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 187 | Repeated DNA Sequences | Med | |

> Cheap and fast after 1044. Use it as the place to reason about **double hashing** — why a single hash function risks collisions and how a second modulus fixes it.

## Custom Hash Keys / Canonical Forms (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 205 | Isomorphic Strings *(bidirectional map)* | Easy | |
| [ ] | 149 | Max Points on a Line | Hard | |
| [ ] | 2013 | Detect Squares | Med | |

> **149 is the key problem in this block.** Slope as a hash key forces you to confront canonical forms: floating-point equality is wrong, so reduce `(dy, dx)` by GCD and normalize the sign. Handle vertical lines and duplicate points. This is the same reasoning that shows up in real system work.
>
> 2013 is counting on a composite `(x, y)` key — the "how do I properly hash a tuple in Java" question.

## Collision Handling (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 705 | Design HashMap | Easy | |

> Labelled Easy — implement it with **separate chaining, a real load factor, and resize**, not an array of size 10⁶. That's the only version worth doing.
>
> Be ready to discuss: chaining vs open addressing, load factor tradeoffs, and Java's `HashMap` treeification at 8 nodes per bucket.

## Design (5) — highest value on this page

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 146 | LRU Cache | Med | |
| [ ] | 460 | LFU Cache | Hard | |
| [ ] | 380 | Insert Delete GetRandom O(1) | Med | |
| [ ] | 981 | Time Based Key-Value Store | Med | |
| [ ] | 895 | Maximum Frequency Stack | Hard | |

All five are *hashmap plus something else*:

| # | Structure | Note |
|---|---|---|
| 146 | hashmap + doubly linked list | Write your **own** DLL, not `LinkedHashMap` — interviewers remove the library |
| 460 | hashmap + freq→DLL map + min-freq pointer | Genuinely hard; budget real time |
| 380 | hashmap + array, swap-to-end deletion | 381 (with duplicates) is the follow-up |
| 981 | hashmap + binary search on timestamps | Bridges to the binary search block |
| 895 | hashmap of stacks + max-freq counter | Same shape as 460 — do it after |

## Consistent Hashing (0 problems)

No LeetCode problem exists for this — it's **system design content**. Be able to sketch:

- Hash ring, virtual nodes, and why virtual nodes fix load imbalance
- Node join/leave: only `1/n` of keys remap
- vs. naive `hash % n` — why that reshuffles nearly everything
- Real usage: Cassandra, DynamoDB, memcached clients, custom sharding layers

**Put this in your system design notes, not this tracker.**

---

## 5-Day Schedule

| Day | Problems | Done |
|---|---|---|
| 1 | 1, 128, 347, 451 | [ ] |
| 2 | 954, 454, 523, 187 | [ ] |
| 3 | 205, 149, 2013 | [ ] |
| 4 | 705, 380, 981 | [ ] |
| 5 | 146, 460, 895 | [ ] |

**Days 4–5 are design-heavy — write real, compiling Java. Full class, no sketching.** These are the ones you'll implement start-to-finish on a shared screen.

---

## Revision

Re-solve **cold** (no notes, from scratch) on:

- **Day 12** — everything marked Hint?, plus 146, 460, 380, 149
- **Day 26** — same set, plus anything that needed a hint on day 12

---

## Trim to 12 If Pressed

1, 128, 347, 454, 187, 149, 2013, 705, 146, 460, 380, 981

Cut: 451, 954, 523, 205, 895.

---

## Pattern Recognition Check

| Signal in the problem | Approach |
|---|---|
| Find pair summing to target, unsorted | Hashmap of complement |
| Longest run of consecutive values | HashSet, expand only from run heads |
| Top K by frequency | Bucket sort O(n), heap O(n log k), or quickselect |
| 3+ arrays, sum to target | Meet in the middle — hash one half |
| Count subarrays with sum / remainder property | Prefix sum + hashmap |
| Fixed-length substring seen before | Rolling hash (+ second modulus if collisions matter) |
| Geometry with slopes / points as keys | Canonical form — GCD-reduce, normalize sign, never floats |
| Composite key (tuple, pair, coordinate) | Encode as string or use a proper `hashCode`/`equals` |
| O(1) get + O(1) eviction | Hashmap + doubly linked list |
| O(1) insert, delete, **random** | Hashmap + array, swap-to-end |
| Query "value at time T" | Hashmap → sorted list + binary search |
| Sharding keys across N nodes | Consistent hashing (design, not code) |

---

## Java Notes Worth Rehearsing

- `HashMap` internals: buckets, load factor 0.75, resize doubling, treeification at 8 nodes
- `hashCode()` / `equals()` contract — why breaking it silently corrupts lookups
- Mutable objects as keys: why it's a bug
- `HashMap` vs `LinkedHashMap` vs `TreeMap` vs `ConcurrentHashMap` — when each is right
- `ConcurrentHashMap` lock striping / CAS approach vs `Collections.synchronizedMap`
- `computeIfAbsent`, `merge`, `getOrDefault` — cleaner frequency counting

---

## Progress Across the Plan

| Area | Target | Status |
|---|---|---|
| Arrays | 39 | ✔ list built |
| Strings | 23 | ✔ list built |
| **Hashing** | **17** | **✔ list built** |
| Binary search | 25–30 | |
| Linked list | 15 | |
| Stack / queue / monotonic | 25 | |
| Heap | 20 | |
| Trees + BST | 40 | |
| Tries | 10 | |
| Graphs | 45–50 | |
| DP | 55–60 | |
| Backtracking | 15 | |
| Bit / math | 15 | |
| Design | 15 | |

**Running total: 79 / ~350.**

Hashing came in at 17 vs the 15 budgeted — the overage is all design problems, which double as LLD-round prep. They earn the slot twice.

**Protect the graphs-and-DP ratio.**
