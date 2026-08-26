# Strings — SDE III Prep (Final List)

**23 problems · 6 Easy / 13 Medium / 4 Hard · 6 days**

Tick the checkbox when solved. Mark the **Hint?** column if you needed help — those get re-solved first.

> **Scope note:** Sliding-window string problems (3, 76, 424, 438) live in the **Arrays** list — already done. Edit distance (72) and longest palindromic subsequence (516) live in the **DP** list. Don't double-solve; do make sure they don't fall through the gap between blocks.

---

## Palindromes / Expand-Around-Center (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 125 | Valid Palindrome | Easy | |
| [ ] | 5 | Longest Palindromic Substring | Med | |
| [ ] | 647 | Palindromic Substrings | Med | |

> 5 and 647 are the same expand-around-center loop with a different accumulator. After 5, 647 should take 5 minutes — that's the point.

## Manacher's (0 new)

| ✔ | # | Task | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 5 | Re-do Longest Palindromic Substring in O(n) with Manacher's | Med | |

> Not a separate problem — a second pass on 5. Being able to say *"there's an O(n) approach with Manacher, here's the idea"* is the signal. Writing it from memory under pressure is not expected.

## Anagrams / Frequency Signatures (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 242 | Valid Anagram | Easy | |
| [ ] | 49 | Group Anagrams | Med | |
| [ ] | 249 | Group Shifted Strings *(premium — else skip)* | Med | |

> On 49, know **both** signature schemes: sorted-string key `O(n·k log k)` vs count-array key `O(n·k)`. Interviewers ask which is better and when.

## String Matching — KMP / Z (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 28 | Find the Index of the First Occurrence *(implement KMP)* | Easy | |
| [ ] | 459 | Repeated Substring Pattern *(LPS array trick)* | Easy | |
| [ ] | 214 | Shortest Palindrome *(KMP or Z on `s + '#' + rev(s)`)* | Hard | |

> 28 is labelled Easy — do **not** solve it with `indexOf`. Build the LPS array by hand. 214 is the payoff: looks unrelated to matching until you see the trick.

## Rolling Hash (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1044 | Longest Duplicate Substring *(binary search + Rabin-Karp)* | Hard | |

> Optional if short on time, but it's the one place rolling hash is genuinely required rather than optional. Also a binary-search-on-answer crossover.

## Longest Common Prefix / Substring / Subsequence (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 14 | Longest Common Prefix | Easy | |
| [ ] | 718 | Maximum Length of Repeated Subarray *(common **substring**, DP)* | Med | |
| [ ] | 1143 | Longest Common Subsequence | Med | |

> 718 vs 1143 is the substring/subsequence distinction — one resets on mismatch, one carries the max forward. Know why that single line differs.

## Compression / RLE (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 443 | String Compression *(in-place, O(1) space)* | Med | |
| [ ] | 38 | Count and Say | Med | |

## Parsing / Expression Evaluation (4)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 20 | Valid Parentheses | Easy | |
| [ ] | 227 | Basic Calculator II *(`+ − × ÷`, no parens)* | Med | |
| [ ] | 394 | Decode String *(nested, stack-based)* | Med | |
| [ ] | 224 | Basic Calculator *(parentheses + unary minus)* | Hard | |

> Do 227 → 224 in that order. 224's unary minus and nested-sign handling is a classic place people write buggy code under time pressure. 772 (Calculator III) unifies both if you want one more.

## Word Break / Wildcard / Regex (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 139 | Word Break | Med | |
| [ ] | 44 | Wildcard Matching | Hard | |

> 10 (Regular Expression Matching) is the harder sibling. Pick **one** of 44/10 — not both. 44 is the more common ask.

## Encode / Decode / Serialization (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 271 | Encode and Decode Strings *(premium)* | Med | |
| [ ] | 165 | Compare Version Numbers *(free substitute — tokenization + edge cases)* | Med | |

> 271's real content is **why length-prefixing beats delimiters**. If you can articulate that, you don't strictly need to solve it.

## Roman / Integer ↔ String Conversion (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 13 | Roman to Integer | Easy | |
| [ ] | 12 | Integer to Roman | Med | |
| [ ] | 8 | String to Integer (atoi) | Med | |

> 8 is pure edge-case discipline — whitespace, sign, overflow clamping to `Integer.MAX_VALUE` / `MIN_VALUE`, invalid trailing chars. Treat it as a **communication drill**, not an algorithm.

## Implementation Discipline (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 151 | Reverse Words in a String *(O(1) space version)* | Med | |

> Multiple spaces, trailing spaces, reverse-all-then-reverse-each. Optional extra: **68 Text Justification** — no algorithm, pure grind, asked at Amazon/Google. Do it once if you have spare time.

---

## 6-Day Schedule

| Day | Problems | Done |
|---|---|---|
| 1 | 125, 5, 647, 242 | [ ] |
| 2 | 49, 28 *(KMP by hand)*, 459 | [ ] |
| 3 | 214, 1044, 14, 151 | [ ] |
| 4 | 718, 1143, 443, 38 | [ ] |
| 5 | 20, 227, 394, 224 | [ ] |
| 6 | 139, 44, 13, 12, 8, 165 | [ ] |

**Then move on — don't extend strings past day 6.**

---

## Revision

Re-solve **cold** (no notes, from scratch) on:

- **Day 13** — everything marked Hint?, plus 5, 28, 214, 224, 44
- **Day 27** — same set, plus anything that needed a hint on day 13

---

## Trim to 15 If Pressed

125, 5, 647, 49, 28, 459, 214, 1143, 443, 227, 394, 224, 139, 8, 13

Cut: 1044, 44, 718, 38, 20, 14, 12, 242, 151, 165, 271.

---

## Pattern Recognition Check

Identify the right approach within ~60 seconds of reading the problem:

| Signal in the problem | Approach |
|---|---|
| Count / find palindromic substrings | Expand around center (Manacher if O(n) demanded) |
| Group strings that are rearrangements | Frequency signature as hashmap key |
| Find pattern in text, O(n+m) required | KMP — build LPS array |
| "Repeated substring", periodicity | LPS array: `n % (n - lps[n-1]) == 0` |
| Prepend/append to make palindrome | KMP or Z on `s + '#' + reverse(s)` |
| Longest duplicated substring, large n | Binary search on length + rolling hash |
| Two strings, contiguous match | DP, reset to 0 on mismatch |
| Two strings, non-contiguous match | DP, carry `max(up, left)` on mismatch |
| Nested brackets, `k[...]` structure | Stack of (count, partial string) |
| Infix arithmetic, precedence | Stack; hold previous operand for `×` `÷` |
| Parentheses + signs | Stack of (result, sign) at each `(` |
| Can string be segmented by dictionary | DP over prefixes + word set |
| `?` / `*` matching | 2-D DP, or two-pointer with backtrack for 44 |
| Serialize a list of arbitrary strings | Length-prefix, not delimiters |
| Parse-and-clamp with messy input | No algorithm — enumerate edge cases aloud first |

---

## Why 23 Is Enough

Strings *feel* big, but most string interview questions live in other blocks:

| What gets asked | Where it's covered |
|---|---|
| Longest substring without repeats, min window, anagram windows | **Arrays** — sliding window ✔ |
| Edit distance, palindromic subsequence, regex DP | **DP block** |
| Valid parentheses, decode string, calculators | Stack block *(kept here — fine either way)* |
| Word search, word ladder | Backtracking / graphs |

Strip those out and the string-specific core is small: palindromes, matching, parsing, conversions.

**The real risk is not count — it's problem type.** A large share of string questions are implementation-and-edge-case discipline (atoi, version compare, text justification). Those are failed through sloppiness, not through missing a pattern. More problems doesn't fix that. Clarifying requirements aloud and enumerating edge cases *before* writing code does.

---

## Progress Across the Plan

| Area | Target | Status |
|---|---|---|
| Arrays | 39 | ✔ list built |
| **Strings** | **23** | **✔ list built** |
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

~350 total. **Protect the graphs-and-DP ratio.**

---

## Addendum 2 — Residual Coverage Check

One outline item mentioned but never actually taught.

### Z-algorithm (implement once)

The outline lists it alongside KMP and Rabin-Karp as a distinct technique. In this file it appears only as *"KMP **or Z** on `s + '#' + rev(s)`"* for 214 — an alternative, never the primary. That's not coverage.

**Implement it once, on 214.** No separate problem needed.

**What it computes:** `z[i]` = the length of the longest substring starting at `i` that matches a prefix of the whole string. Build in `O(n)` using a sliding `[l, r]` window of the rightmost match found so far.

```java
int[] zFunction(String s) {
    int n = s.length();
    int[] z = new int[n];
    for (int i = 1, l = 0, r = 0; i < n; i++) {
        if (i < r) z[i] = Math.min(r - i, z[i - l]);
        while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) z[i]++;
        if (i + z[i] > r) { l = i; r = i + z[i]; }
    }
    return z;
}
```

**Z vs KMP — the comparison to be able to make:**

| | KMP (LPS array) | Z-array |
|---|---|---|
| What it stores | Longest proper prefix that is also a suffix, per position | Longest prefix-match starting at each position |
| Pattern matching | Run on the pattern, then scan the text | Run on `pattern + '#' + text`, look for `z[i] == patternLength` |
| Mental model | Failure links — "where do I fall back to?" | Direct prefix-match lengths |
| Which is easier to derive live | KMP is more standard; **Z is easier to get right** because there's no failure-link recursion |

**Why it's worth 20 minutes:** many candidates half-remember KMP's LPS construction and produce a subtly wrong version under pressure. The Z-array is shorter, has one loop, and solves the same problems. Having it as a fallback means you're never stuck on a string-matching question.

**Where it's cleaner than KMP:** 214 (Shortest Palindrome) — `z` on `s + '#' + reverse(s)` gives the answer directly. Also periodicity checks and counting distinct substrings.

**Count unchanged: 23 problems.** This is an implementation exercise inside 214.
