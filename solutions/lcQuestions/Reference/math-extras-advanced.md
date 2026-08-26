# Math Extras & Advanced Topics — SDE III Prep

**7 new problems · 2 Easy / 5 Medium · 1–2 days**
**Plus a conceptual reading list with no problems attached**

Tick the checkbox when solved. Mark the **Hint?** column if you needed help — those get re-solved first.

> **Two things in one file.** The first half closes the genuine number-theory and geometry gaps left by the Bit & Math block. The second half is the *Advanced / Occasional* material — structures that appear in system design conversations far more than in coding rounds, where the right investment is **being able to describe them**, not implement them.
>
> **Read the second half. Do not grind it.** Every hour spent implementing a count-min sketch is an hour not spent on graphs.

---

## Part 1 — Math & Number Theory Gaps

### Coverage audit

| Sub-topic | Where | Status |
|---|---|---|
| Prime sieve | 204 | Bit/Math ✔ |
| Fast exponentiation | 50 | Bit/Math ✔ |
| Modular arithmetic | 372 | Bit/Math ✔ |
| Overflow-safe arithmetic | 7, 29 | Bit/Math ✔ |
| Fisher-Yates shuffle | 384 | Bit/Math ✔ |
| Weighted random | 528 | Bit/Math ✔ |
| GCD as a canonical form | 149 | Hashing ✔ |
| Combinatorics via DP | 62, 377 | DP ✔ |
| **GCD / LCM dedicated** | — | **Gap → 1071** |
| **Divisor counting / factorization** | — | **Gap → 172** |
| **Base conversion & digit handling** | — | **Gap → 166** |
| **Catalan numbers** | — | **Gap → 96** |
| **Reservoir sampling** | — | **Gap → 398** |
| **Rejection sampling** | — | **Gap → 470** |
| **Matrix exponentiation** | — | **Gap → 509 (exercise)** |
| **Convex hull / geometry** | — | **Gap → 587 (optional)** |

### GCD & Factorization (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1071 | Greatest Common Divisor of Strings | Easy | |
| [ ] | 172 | Factorial Trailing Zeroes | Med | |

> 1071's trick: if a common divisor string exists, it's `s.substring(0, gcd(len1, len2))` — and you verify by checking `str1 + str2 == str2 + str1`. Both halves are non-obvious, and it forces you to write Euclid's algorithm.
>
> 172 is factorization reasoning without factorizing — count factors of 5 (`n/5 + n/25 + n/125 + ...`), because 2s are always in surplus. Clean, and a good check that you reason about *why* rather than simulating.

### Combinatorics & Base Conversion (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 96 | Unique Binary Search Trees | Med | |
| [ ] | 166 | Fraction to Recurring Decimal | Med | |

> 96 is the **Catalan number** recurrence — `C(n) = Σ C(i) · C(n-1-i)`. Worth doing because Catalan numbers also count valid parentheses (22), balanced bracket sequences, and triangulations (1039). Recognizing "that's Catalan" is a small but real signal.
>
> 166 is long division with cycle detection via a hashmap of remainder→position. Heavy on edge cases (sign, `Integer.MIN_VALUE`, zero numerator) — same discipline family as atoi and 7.

### Randomized Sampling (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 398 | Random Pick Index | Med | |
| [ ] | 470 | Implement Rand10 Using Rand7 | Med | |

> **398 is reservoir sampling**, which was flagged as read-only in the Bit & Math block. Solve it properly here. The `O(1)`-space single-pass version — keep the current candidate with probability `1/count` — is the one that matters, and it's the direct answer to *"how would you sample 1% of requests for logging?"* in a design round.
>
> 470 is **rejection sampling** — generate a uniform value in `[1, 49]`, reject anything above 40, map down. Be able to compute the expected number of calls (`49/40 ≈ 1.225` per attempt), because that's the follow-up. Uniformity arguments come up whenever load distribution or A/B bucketing does.

### Matrix Exponentiation (1 exercise)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 509 | Fibonacci Number *(solve 3 ways)* | Easy | |

> The problem is trivial; the **exercise** is not. Solve it three ways: `O(n)` DP, then closed-form, then **matrix exponentiation** — `[[1,1],[1,0]]^n` with binary exponentiation for `O(log n)`.
>
> Matrix exponentiation is the technique for any linear recurrence with a huge `n` (`n ≤ 10^18`). Rarely required, but when it *is* required nothing else works, and recognizing the tell (linear recurrence + astronomically large n) is the whole skill.

### Geometry (optional)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 587 | Erect the Fence *(convex hull)* | Hard | |

> **Skip unless you're targeting a graphics/maps/geo team.** If you do it, Andrew's monotone chain is the cleanest implementation, and the cross-product orientation test is the reusable primitive.
>
> What to know without solving it: **cross product sign gives orientation** (clockwise / counter-clockwise / collinear), and that's the foundation of hull construction, line intersection, and point-in-polygon. One paragraph of understanding is worth more than one Hard solved.

---

## Part 2 — Advanced / Occasional (Read, Don't Grind)

These appear in *system design* conversations and occasionally as a "have you heard of" probe. For each: know what it does, its tradeoff, and where it's used in a real system. **Zero implementation required.**

### Probabilistic Data Structures

| Structure | What it does | Tradeoff | Where it's used |
|---|---|---|---|
| **Bloom filter** | Set membership | No false negatives, tunable false positives; can't delete | Cassandra/LevelDB SSTable lookups, CDN cache filters, username availability pre-checks |
| **Counting Bloom filter** | Bloom + deletion | 4× the memory | When you need removal |
| **Count-min sketch** | Approximate frequency counts | Overestimates only, sublinear memory | Heavy-hitter detection, rate limiting at scale, trending topics |
| **HyperLogLog** | Approximate distinct count | ~2% error in ~12 KB for billions of items | Redis `PFCOUNT`, unique-visitor analytics |
| **Skiplist** | Ordered set, expected `O(log n)` | Probabilistic balancing, far simpler than red-black | Redis sorted sets, LevelDB memtable *(implemented — LC 1206)* |
| **Consistent hashing** | Distribute keys across N nodes | Only `1/N` keys remap on membership change | Cassandra, DynamoDB, memcached clients *(covered in Hashing block)* |

**The one thing to get right about Bloom filters:** the false-positive direction. *"Might be present"* vs *"definitely absent."* That asymmetry is why they're placed in front of expensive disk lookups — a negative is authoritative and saves the read. If you can only remember one fact from this table, remember that one.

**Sizing question you should be able to answer:** for a target false-positive rate `p` and `n` items, bits `m ≈ -n·ln(p)/(ln2)²` and optimal hash count `k ≈ (m/n)·ln2`. You don't need the formula memorized — you need to know the *shape*: roughly 10 bits per element gets you ~1% false positives.

### Streaming & Memory-Bounded Algorithms

Already covered in earlier blocks; consolidated here for revision:

| Problem | Answer | Where covered |
|---|---|---|
| Top-K from an infinite stream | Bounded min-heap of size K | Heaps ✔ |
| Sample K uniformly from an unbounded stream | Reservoir sampling | 398 above ✔ |
| Running median of a stream | Two heaps | Heaps (295) ✔ |
| Sort more data than RAM | External merge sort — chunk, sort, k-way merge | Sorting ✔ |
| Count distinct items in a huge stream | HyperLogLog | Above |
| Find heavy hitters in a huge stream | Count-min sketch | Above |
| Distributed top-K | Local top-K per shard, then merge | Heaps ✔ |

**The general framing for any "doesn't fit in memory" question:** *can I process it in one pass with bounded state, can I chunk it and merge, or do I need to accept an approximation?* Those three options cover nearly every answer, and naming all three before picking one is the senior move.

### Storage Structures (structural understanding only)

| Structure | Optimized for | Key idea |
|---|---|---|
| **B-tree / B+tree** | Read-heavy, range scans | High fan-out, shallow depth, node = disk page. Powers most SQL indexes. |
| **LSM tree** | Write-heavy | Buffer writes in a memtable, flush to sorted files, compact in background. Powers Cassandra, RocksDB, Kafka-adjacent stores. |

**The tradeoff to be able to state:** B-trees give better read and range-scan performance; LSM trees give far better write throughput at the cost of read amplification and background compaction work. And — the connection worth making — **LSM compaction is external merge sort**, the same algorithm from your Sorting block. Naming that link reads as real systems understanding rather than memorized bullet points.

This is your DBMS-indexing prep, so treat it as revision rather than new material.

### Genuinely Skippable

Know only that these exist. Do not read further unless a specific interviewer asks.

| Technique | Verdict |
|---|---|
| Union-Find with rollback | Competitive programming, not interviews |
| Mo's algorithm (offline range queries) | Competitive programming |
| Heavy-light decomposition | Competitive programming |
| Suffix automaton | Competitive programming |
| Segment tree with lazy propagation | Understand the *concept* (defer updates, push down on query). Almost never required to implement at SDE III |
| Network flow / Edmonds-Karp | Rare, mostly Google. Know: max-flow min-cut theorem, bipartite matching reduces to max flow. Do not implement |
| Suffix array + LCP | Know it exists and that it solves substring problems in `O(n log n)`. Rolling hash usually suffices |
| FFT / NTT | Not an interview topic |

---

## Part 3 — Two From-Scratch Implementation Exercises

Everything in Part 2 is read-only **except these two**. Both get asked as coding or LLD problems, neither has a LeetCode entry, and both are short. Write each as a complete compiling class with a small test harness — same treatment as the four concurrency exercises.

### Exercise A — Consistent Hashing Ring

**~40 lines. The single most interview-relevant item in this file.**

This appears as an LLD problem at companies that operate their own sharding, and it's the concrete backing for the sharding answer you'll give in system design. Having implemented it changes that answer from recited to demonstrated.

**Interface to build:**
```java
class ConsistentHashRing {
    ConsistentHashRing(int virtualNodesPerServer);
    void addServer(String server);
    void removeServer(String server);
    String getServer(String key);
}
```

**Implementation shape:**
- `TreeMap<Long, String>` as the ring — hash position → server name
- `addServer`: insert `virtualNodesPerServer` entries at `hash(server + "#" + i)`
- `getServer`: `ring.ceilingEntry(hash(key))`, falling back to `ring.firstEntry()` for **wraparound** past the end of the ring
- `removeServer`: remove all that server's virtual node entries
- Use a well-distributed hash (MD5/SHA-1 truncated to a long, or Murmur). `String.hashCode()` clusters badly and will make your distribution test look wrong

**Be ready to answer:**

| Question | Answer |
|---|---|
| Why virtual nodes? | With one point per server, ring positions are uneven and load can differ by 2–3×. 100–200 virtual nodes per server smooths it to within a few percent. |
| How many keys remap when a server leaves? | Roughly `1/N` — only the keys that mapped to that server's arcs. |
| Why not `hash(key) % N`? | Changing `N` changes almost every key's assignment. That's a full cache flush or a full data reshuffle. |
| What's the tradeoff of more virtual nodes? | Better balance, more memory and slightly slower lookup (larger `TreeMap`). |
| How do you handle replication? | Walk clockwise from the key's position and take the next `R` **distinct** physical servers. |
| Where is this used in production? | Cassandra and DynamoDB partitioning, memcached client-side sharding, Envoy's ring-hash load balancer. |

**Write a distribution test.** Hash 100,000 keys across 10 servers and print the per-server counts, first with 1 virtual node and then with 150. Seeing the variance collapse is what makes the "why virtual nodes" answer yours rather than borrowed.

### Exercise B — Bloom Filter

**~20 lines. The reasoning matters more than the code, and the reasoning is already in Part 2.**

**Interface to build:**
```java
class BloomFilter {
    BloomFilter(int expectedInsertions, double falsePositiveRate);
    void add(String item);
    boolean mightContain(String item);   // note the name — it's the whole point
}
```

**Implementation shape:**
- Size the bit array: `m = (int) Math.ceil(-n * Math.log(p) / (Math.log(2) * Math.log(2)))`
- Hash count: `k = (int) Math.round((double) m / n * Math.log(2))`
- Use a `long[]` as the bit array (`bits[i >>> 6] |= 1L << (i & 63)`), or `java.util.BitSet` if allowed
- Generate `k` independent hashes from **two** base hashes: `h(i) = h1 + i * h2`, then `Math.floorMod(h, m)`. Computing k separate cryptographic hashes is wasteful and unnecessary

**Be ready to answer:**

| Question | Answer |
|---|---|
| Which direction is the error? | False positives only. A negative is **authoritative** — that asymmetry is why it works. |
| Why can't you delete? | Clearing a bit may break other items sharing it. Counting Bloom filters fix this at 4× memory. |
| Rough sizing intuition? | ~10 bits per element gives ~1% false positives. |
| What happens past the expected count? | The false-positive rate degrades gracefully but steadily — you don't get errors, you get noise. Real systems track fill ratio and rebuild. |
| Where does the "in front of an expensive lookup" pattern apply? | LevelDB/RocksDB SSTable reads, Cassandra, CDN cache filters, "has this URL been crawled" checks. |
| What if you need exact membership? | You need the real set. Bloom filters are a *pre-filter*, never a replacement. |

**Test it honestly.** Insert 10,000 items sized for `p = 0.01`, then query 100,000 items you never inserted and count how many come back positive. It should land near 1%. If it's far off, your hash distribution is the problem — which is itself the lesson.

---

## 2-Day Schedule

| Day | Problems | Done |
|---|---|---|
| 1 | 1071, 172, 96, 166 | [ ] |
| 2 | 398, 470, 509 *(three ways)* + read all of Part 2 | [ ] |
| 3 | **Exercise A** (consistent hashing ring) + **Exercise B** (Bloom filter) | [ ] |

Part 2 is ~30 minutes of reading. Budget it on day 2 and don't let it expand — the tables above are the deliverable, not a starting point for research.

Part 3 is one focused session. Exercise A deserves the bulk of it; B is genuinely short once A's hashing helper exists.

---

## Revision

Re-solve **cold** on:

- **Day 9** — 398, 470, plus anything marked Hint?
- **Day 16** — **Exercise A** (consistent hashing ring), from scratch
- **Day 23** — same as day 9, and **re-read Part 2's tables** rather than re-solving anything

Part 2 is the only material in your entire plan where re-reading beats re-solving — it's vocabulary, not skill. Part 3 is the opposite: Exercise A is the one thing in this file you should be able to produce live, so it gets its own revision slot.

---

## Trim to 4 If Pressed

1071, 96, 398, 470

Cut: 172, 166, 509, 587.

**Keep regardless of how tight things get:**
- **All of Part 2's reading** — 30 minutes, cheapest value in the plan per minute spent
- **Exercise A** (consistent hashing ring) — it's the one implementation here that gets asked directly, and it doubles as system design prep

Exercise B is the first thing to cut from Part 3 if you only have one session. The Part 2 reasoning covers what interviewers actually probe about Bloom filters.

---

## Java Notes

- GCD: `int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }`. LCM is `a / gcd(a,b) * b` — **divide before multiplying** or you overflow.
- `BigInteger.gcd()` exists, as does `BigInteger.modPow()` for modular exponentiation. Know they exist; hand-roll in interviews unless told otherwise.
- `Random.nextInt(n)` is exclusive of `n`. For reservoir sampling, `rand.nextInt(++count) == 0` is the idiomatic keep-with-probability-1/count check.
- `ThreadLocalRandom.current()` over `new Random()` in concurrent code — avoids contention on the shared seed. Small detail, reads well.
- Matrix exponentiation: use `long[][]` and apply the modulus inside the multiply, not after.
- `Math.floorMod(a, b)` gives a non-negative result for negative `a`, unlike `%`. **Essential in both Part 3 exercises** — hash values are routinely negative and `hash % m` will hand you a negative index.

**For the Part 3 exercises specifically:**

- `TreeMap.ceilingEntry(k)` returns `null` past the last key — that `null` is your wraparound signal, so fall back to `firstEntry()`. Forgetting this is the one bug in Exercise A.
- `String.hashCode()` is not a distribution-quality hash. For the ring, use `MessageDigest.getInstance("MD5")` and take the first 8 bytes as a `long`, or write a small Murmur3. Your distribution test will show you why this matters.
- `BitSet` handles the bit array in Exercise B cleanly (`set(i)`, `get(i)`, auto-resizing). If the interviewer wants it hand-rolled: `long[] bits = new long[(m + 63) >>> 6]`, then `bits[i >>> 6] |= 1L << (i & 63)`. The `& 63` works because Java masks shift counts mod 64 for `long`.
- Guava has both (`Hashing.consistentHash`, `BloomFilter`). Mention you know they exist, then write your own — the point is the reasoning.
- `MessageDigest` instances are **not** thread-safe. If the conversation turns to making the ring concurrent, that's a real detail worth catching, alongside using a `ConcurrentSkipListMap` instead of `TreeMap` for the ring itself.

---

## Progress Across the Plan — COMPLETE

| Area | Count | Status |
|---|---|---|
| Arrays | 39 | ✔ |
| Sorting | 5 | ✔ |
| Strings | 23 | ✔ |
| Hashing | 17 | ✔ |
| Binary search | 28 | ✔ |
| Linked list | 16 | ✔ |
| Stack / queue / monotonic | 25 | ✔ |
| Heap | 20 | ✔ |
| Greedy | 8 | ✔ |
| Intervals & sweep line | 4 | ✔ |
| Trees + BST | 40 | ✔ |
| Tries | 10 | ✔ |
| Graphs | 48 | ✔ |
| DP | 58 | ✔ |
| Backtracking | 15 | ✔ |
| Bit / math | 16 | ✔ |
| **Math extras + advanced** | **7 + 2 exercises** | **✔ list built** |
| Design | 12 | ✔ |
| Concurrency | 9 + 4 exercises | ✔ |

**Total: 399 problems + 6 from-scratch exercises across 19 blocks.**
**With every trim list applied: ~265 problems + 3 exercises.**

Every sub-topic from the original SDE III DSA outline now has a home. Nothing is uncovered.

**The six from-scratch exercises, consolidated** — these have no LeetCode entry and are the closest thing in the plan to what you'll actually be asked to build live:

| Exercise | File | Priority |
|---|---|---|
| Bounded blocking queue *(two ways)* | Concurrency | **Highest** |
| Thread-safe LRU cache | Concurrency | **Highest** |
| Read-write lock from scratch | Concurrency | Medium |
| Lock-free counter + token bucket | Concurrency | Medium |
| Consistent hashing ring | Math extras (Part 3) | **Highest** |
| Bloom filter | Math extras (Part 3) | Low — reasoning covered in Part 2 |

If you cut everything else in these two files, keep the three marked Highest.

---

## Addendum — Residual Coverage Check

One geometry item from the original outline not covered.

### Closest pair of points (conceptual)

From the outline: "Geometry basics: cross product, orientation, line intersection, convex hull, **closest pair of points**." Cross product, orientation, and convex hull are covered via 587. The closest-pair problem is the remaining one, and it has no LeetCode equivalent.

**The problem:** given `n` points in a plane, find the two closest. Brute force is `O(n²)`.

**Divide and conquer, `O(n log n)`:**
1. Sort by x, split at the median into left and right halves
2. Recurse on each half; let `d = min(dLeft, dRight)`
3. **The merge step is the insight** — any cross-pair closer than `d` must lie within a vertical strip of width `2d` around the split line
4. Sort the strip's points by y, and compare each only against the next **at most 7** points in y-order. That constant bound is provable from geometry: a `d × 2d` rectangle can hold at most 8 points that are pairwise ≥ `d` apart

**Why it's worth 15 minutes of reading:** it's one of the classic non-obvious divide-and-conquer results, and the "bounded constant in the merge step" argument is the kind of reasoning interviewers probe when they ask *"how do you know the merge is linear?"* The answer isn't "it looks linear" — it's the packing argument.

**The interview-realistic alternative.** If asked this live, the expected answer at SDE III is usually the **spatial grid / bucketing** approach rather than divide and conquer: bucket points into cells of side `d` for a candidate `d`, and only compare points in adjacent cells. Simpler to explain, and it's what real systems do — the same idea behind geohashing, quadtrees, and "find nearby drivers" in a ride-hailing design question.

**Make the design connection:** *"for a one-off computation I'd do divide and conquer for O(n log n); for a live system answering nearest-neighbour queries repeatedly, I'd index spatially — quadtree, k-d tree, or geohash cells — because the query pattern is repeated lookups, not a single batch computation."* That framing is worth more than the algorithm.

**Line intersection** (also in the outline): two segments intersect iff the orientations `(p1,q1,p2)`, `(p1,q1,q2)`, `(p2,q2,p1)`, `(p2,q2,q1)` show the endpoints of each straddling the other's line — all four computed with the cross-product sign. Plus collinear-overlap special cases. One paragraph is sufficient; it's the same orientation primitive as convex hull.

**Count unchanged: 7 problems + 2 exercises.**
