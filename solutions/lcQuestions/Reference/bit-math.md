# Bit Manipulation & Math — SDE III Prep (Final List)

**16 problems · 4 Easy / 11 Medium / 1 Hard · 4 days**

Tick the checkbox when solved. Mark the **Hint?** column if you needed help — those get re-solved first.

> **Framing:** this block is low-frequency but high-embarrassment. Nobody gets hired for solving 191, but stumbling on "count the set bits" or "why does `Math.abs(Integer.MIN_VALUE)` return a negative number" reads badly for a Java engineer at SDE III.
>
> Treat it as **fluency drilling**, not problem solving. Most of these should take under 15 minutes. The randomized-algorithm section is the exception — reservoir sampling and weighted random genuinely appear in system design conversations, so give those real attention.

### Already covered elsewhere

| # | Problem | Where |
|---|---|---|
| 268 | Missing Number | Arrays ✔ *(XOR solution)* |
| 421, 1707 | Maximum XOR — bitwise trie | Tries ✔ |
| 78 | Subsets via bitmask | Backtracking ✔ |
| 149 | Max Points on a Line *(GCD canonical form)* | Hashing ✔ |
| 847, 1125, 526, 943 | Bitmask DP | DP ✔ |

---

## Bit Fundamentals (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 191 | Number of 1 Bits | Easy | |
| [ ] | 338 | Counting Bits | Easy | |
| [ ] | 190 | Reverse Bits | Easy | |

> 191: know **both** the naive loop and **Brian Kernighan's** `n &= (n - 1)`, which runs in `O(set bits)` rather than `O(32)`. Say which you're using and why.
>
> 338 is bit manipulation *and* DP — `dp[i] = dp[i >> 1] + (i & 1)`. A nice small demonstration that these categories overlap.
>
> 190's follow-up is "what if this is called millions of times?" → precomputed byte lookup table with caching. Have the answer.

## XOR Tricks (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 136 | Single Number | Easy | |
| [ ] | 137 | Single Number II *(appears 3×)* | Med | |
| [ ] | 260 | Single Number III *(two singles)* | Med | |

> 136 is the XOR-cancellation idea. 137 needs **bit-position counting mod 3** (or the two-mask state machine) — the XOR trick doesn't generalize, and understanding *why* is the point.
>
> **260 is the best of the three:** XOR everything to get `a ^ b`, isolate any set bit with `x & -x`, then partition the array by that bit and XOR each group separately. `x & -x` (lowest set bit) is an idiom worth having permanently.

## Bit Arithmetic & Ranges (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 371 | Sum of Two Integers *(no `+`)* | Med | |
| [ ] | 201 | Bitwise AND of Numbers Range | Med | |
| [ ] | 89 | Gray Code | Med | |

> 371 is carry propagation by hand: `sum = a ^ b`, `carry = (a & b) << 1`, repeat. Java's signed shift handling makes this fiddlier than it looks.
>
> 201's insight is that the answer is the **common binary prefix** of the range endpoints — shift both right until equal, then shift back. Elegant and non-obvious.
>
> 89 is `i ^ (i >> 1)`. One line once you know it; impossible to derive under pressure if you don't. Just learn it.

## Fast Exponentiation & Modular Arithmetic (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 50 | Pow(x, n) | Med | |
| [ ] | 372 | Super Pow | Med | |

> **50 is the most likely problem in this block to actually appear.** Binary exponentiation, `O(log n)`. The trap is `n = Integer.MIN_VALUE` — negating it overflows. Handle it with a `long` cast and *mention that you spotted it*; that catch is the signal.
>
> 372 adds modular arithmetic and a digit-array exponent. Reinforces `(a * b) % m` overflow handling — cast to `long` before multiplying.

## Primes & Number Theory (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 204 | Count Primes *(Sieve of Eratosthenes)* | Med | |

> Write the sieve once, correctly: start the inner loop at `i * i`, step by `i`. Know the complexity is `O(n log log n)` and be able to say roughly why. One problem is enough — segmented sieves don't appear at SDE III.

## Integer Conversion Edge Cases (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 7 | Reverse Integer | Med | |
| [ ] | 29 | Divide Two Integers *(no `/` or `%`)* | Med | |

> **These are overflow-discipline problems, not algorithm problems.** 7 requires checking for overflow *before* the multiply, not after. 29 requires handling `Integer.MIN_VALUE / -1` and doing division by repeated bit-shifted subtraction.
>
> Same family as atoi (8) in the Strings block. The interviewer is watching whether you enumerate edge cases unprompted — this is a communication drill.

## Randomized Algorithms (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 384 | Shuffle an Array *(Fisher-Yates)* | Med | |
| [ ] | 528 | Random Pick with Weight | Med | |

> **This section punches well above its problem count.**
>
> 384: Fisher-Yates, iterating **backwards**, swapping with `random(0, i]`. Be able to argue it's uniform. The naive "swap with a random index anywhere" version is subtly biased — knowing that is the point.
>
> 528 is prefix sums + binary search. Direct crossover with your binary search block, and it's the mechanism behind weighted load balancing and consistent hashing with virtual nodes — mention that connection if it comes up in system design.
>
> **Also read (no problem needed): reservoir sampling.** Sampling `k` items uniformly from a stream of unknown length, in `O(k)` memory. This comes up in system design far more than in coding rounds — "how would you sample 1% of requests for logging?" — and 398 (Random Pick Index) is the LeetCode version if you want to solve it.

---

## 4-Day Schedule

| Day | Problems | Done |
|---|---|---|
| 1 | 191, 338, 190, 136, 137, 260 | [ ] |
| 2 | 371, 201, 89, 50 | [ ] |
| 3 | 372, 204, 7, 29 | [ ] |
| 4 | 384, 528, + read reservoir sampling | [ ] |

Days 1–3 are drills — if any single problem takes over 25 minutes, look at the solution, understand the idiom, and move on. The idiom is the deliverable, not the struggle.

---

## Revision

Re-solve **cold** (no notes, from scratch) on:

- **Day 11** — everything marked Hint?, plus 260, 50, 201, 384, 528
- **Day 25** — same set, plus anything that needed a hint on day 11

---

## Trim to 10 If Pressed

191, 136, 260, 371, 50, 204, 7, 384, 528, 338

Cut: 190, 137, 201, 89, 372, 29.

---

## Bit Idioms To Have Permanently

| Operation | Expression |
|---|---|
| Check bit `i` | `(n >> i) & 1` |
| Set bit `i` | `n \| (1 << i)` |
| Clear bit `i` | `n & ~(1 << i)` |
| Toggle bit `i` | `n ^ (1 << i)` |
| Lowest set bit (isolate) | `n & -n` |
| Clear lowest set bit | `n & (n - 1)` |
| Is power of two | `n > 0 && (n & (n - 1)) == 0` |
| Count set bits | `Integer.bitCount(n)` — or Kernighan by hand |
| All bits below `i` | `(1 << i) - 1` |
| Iterate all subsets of a mask | `for (int s = mask; s > 0; s = (s - 1) & mask)` |
| Swap without temp | `a ^= b; b ^= a; a ^= b;` *(don't actually do this)* |
| Multiply / divide by 2^k | `n << k` / `n >> k` |

**The two most useful:** `n & (n - 1)` and `n & -n`. They show up in Kernighan's count, power-of-two checks, BIT indexing, and problem 260.

---

## Pattern Recognition Check

| Signal in the problem | Approach |
|---|---|
| One element appears once, others twice | XOR everything |
| One appears once, others 3× (or k×) | Count bits per position mod k |
| Two elements appear once | XOR all, split by `x & -x`, XOR each group |
| Max/min XOR pair | Bitwise trie *(in Tries)* |
| Count set bits for `0..n` | DP: `dp[i] = dp[i>>1] + (i & 1)` |
| AND/OR over a range of integers | Find the common binary prefix |
| Arithmetic without arithmetic operators | Carry propagation with `^` and `&` |
| `x^n` with large `n` | Binary exponentiation `O(log n)` |
| Anything mod a large prime | Cast to `long` before every multiply |
| Count/list primes ≤ n | Sieve of Eratosthenes |
| Enumerate all subsets, `n ≤ 20` | Bitmask iteration |
| Reverse/convert an integer | Overflow check **before** the operation |
| Uniform random shuffle | Fisher-Yates, iterate backwards |
| Weighted random selection | Prefix sums + binary search |
| Sample k from a stream of unknown size | Reservoir sampling |
| Slope / ratio as a hash key | GCD-reduce and normalize sign *(in Hashing)* |

---

## Java Notes — The Ones That Actually Bite

These are worth knowing cold; a Java-focused interviewer will notice.

- **`>>` vs `>>>`.** `>>` is arithmetic (sign-extending), `>>>` is logical (zero-filling). For bit counting or reversal on possibly-negative ints, you almost always want `>>>`. Using `>>` with a negative number gives an infinite loop.
- **`Math.abs(Integer.MIN_VALUE)` returns `Integer.MIN_VALUE`** — negative. There's no positive counterpart in two's complement. This breaks 7, 29, and 50 if unhandled.
- **`1 << 32` is `1`, not `0`.** Shift counts are taken mod 32 for `int` (mod 64 for `long`). Use `1L << k` when `k` can reach 32+.
- **`int` overflow is silent.** No exception. Use `Math.addExact` / `multiplyExact` if you want it loud, or cast to `long`.
- **`(a * b) % m` overflows before the mod applies.** Cast first: `((long) a * b) % m`.
- **`Integer.MAX_VALUE + 1 == Integer.MIN_VALUE`.** Comes up in binary search midpoints and DP sentinels.
- Useful built-ins: `Integer.bitCount`, `highestOneBit`, `lowestOneBit`, `numberOfTrailingZeros`, `reverse`, `toBinaryString`. Know they exist; be able to hand-roll `bitCount` if asked.
- `Random.nextInt(bound)` is exclusive of `bound` — off-by-one source in Fisher-Yates.
- For 384, `Collections.shuffle` exists but implementing Fisher-Yates is the point of the problem.

---

## What This Block Is Actually For

Three things, in order of interview value:

**1. Not fumbling the basics.** "Count the set bits," "is this a power of two," "reverse the bits" — these are 5-minute warm-ups that set the tone for a round. Being fast and confident here buys goodwill.

**2. Overflow discipline as a signal.** Spotting `Integer.MIN_VALUE` before the interviewer mentions it, casting to `long` before a multiply, checking overflow before rather than after — these read as *production engineer*, not *LeetCode grinder*. That distinction matters more at SDE III than at SDE II.

**3. Randomized algorithms bridging to system design.** Fisher-Yates, weighted random, and reservoir sampling all appear in design conversations: A/B test bucketing, weighted load balancing, log sampling, virtual nodes in consistent hashing. This is the section that pays off outside the coding round.

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
| Backtracking | 15 | ✔ |
| **Bit / math** | **16** | **✔ list built** |
| Design | 12 | |

**Running total: 354 / ~366.**

---

## Addendum — Final Coverage Audit

Math had the second-most gaps after trees. Six problems plus two conceptual items.

### Missing problems (6)

| ✔ | # | Problem | Diff | Why it was missing | Hint? |
|---|---|---|---|---|---|
| [ ] | 231 | Power of Two | Easy | "Power of two/three/four checks" — was in the idiom table but not as a problem | |
| [ ] | 326 | Power of Three | Easy | Same. Note that the bit trick **doesn't** work here | |
| [ ] | 118 | Pascal's Triangle | Easy | "Combinatorics: nCr, Pascal's triangle" | |
| [ ] | 168 | Excel Sheet Column Title | Easy | "Base conversion" — 166 is long division, not base conversion | |
| [ ] | 171 | Excel Sheet Column Number | Easy | The inverse direction | |
| [ ] | 765 | Couples Holding Hands | Hard | "Permutation cycles" | |

**231 / 326 together are the point.** 231 is `n > 0 && (n & (n-1)) == 0` — a one-liner because 2 is the base of the representation. **326 has no bit trick**, because 3 isn't. The options are repeated division, or `1162261467 % n == 0` (the largest power of 3 in an `int`). Doing both back to back is what teaches you that bit tricks are base-2-specific, which is a genuinely useful thing to have internalized. 342 (Power of Four) is a third variant with a mask trick — optional.

**118** builds `nCr` iteratively without factorials, which is the overflow-safe way to compute binomial coefficients. Also connects to 96 (Catalan) in the math-extras file and to 62 (Unique Paths) in DP — all the same combinatorial machinery.

**168 / 171** are base-26 conversion with a **1-indexed twist** (there's no "zero" digit — A is 1, and Z→AA wraps without a 0). That off-by-one is the whole difficulty, and it makes them better problems than they look. 168 needs `(n - 1) % 26` and `n = (n - 1) / 26`.

**765 is the permutation-cycle problem.** The minimum number of swaps to sort a permutation into cycles is `n - (number of cycles)`. Solvable with union-find (count components) or by walking cycles directly. Same family as 41 and 442 in Arrays, but the *cycle-counting* framing is distinct and it's the outline item.

### Extended Euclid & modular inverse (conceptual)

**Extended Euclid** finds `x, y` such that `ax + by = gcd(a, b)`. Its main use in interviews is computing a **modular inverse**: if `gcd(a, m) = 1`, then `a·x ≡ 1 (mod m)` and `x` is what you multiply by instead of dividing.

**Two ways to compute it:**
- **Fermat's little theorem** (when `m` is prime): `a^(m-2) mod m`, using your fast exponentiation from 50. This is the one to reach for — it's three lines of code you already have.
- **Extended Euclid** (general `m`): the iterative back-substitution version

**When you need it:** any counting problem that asks for the answer mod 10⁹+7 and involves division — binomial coefficients, combinatorics DP. You can't just divide under a modulus, so you multiply by the inverse instead.

**What to say:** *"division doesn't distribute over a modulus, so I'd compute the modular inverse — since 10⁹+7 is prime, that's `a^(m-2) mod m` by Fermat, reusing binary exponentiation."* That's the complete answer.

### Divisor counting & prime factorization (conceptual)

From the outline. Trial division up to `√n` gives the factorization in `O(√n)`. The divisor count follows from the exponents: if `n = p₁^a · p₂^b · …`, then the number of divisors is `(a+1)(b+1)…`.

**The one thing worth knowing:** to factorize *many* numbers, precompute a **smallest-prime-factor sieve** — a modified Sieve of Eratosthenes storing the smallest prime factor of each value. Then any number factorizes in `O(log n)` by repeated division. This is the standard technique when a problem asks about factors of every element in a large array.

172 (already on your list) is divisor reasoning without factorizing; this is the general tool.

**Revised count: 22 problems.** All six additions are Easy or mechanical except 765 — slot the five easy ones into days 1–3 as warm-ups, and 765 onto day 4.
