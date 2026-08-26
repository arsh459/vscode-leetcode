# Tries — SDE III Prep (Final List)

**10 problems · 0 Easy / 6 Medium / 4 Hard · 3 days**

Tick the checkbox when solved. Mark the **Hint?** column if you needed help — those get re-solved first.

> **Framing:** the trie itself is 20 lines. The interview value is entirely in *recognizing* when a trie beats a hashmap, and in the two non-obvious applications — **trie + backtracking** on a grid, and the **bitwise trie** for XOR problems. This block is small but every problem in it earns its slot.

### Already covered elsewhere

| # | Problem | Where |
|---|---|---|
| 14 | Longest Common Prefix | Strings ✔ — *the no-trie-needed contrast case* |

---

## Core Implementation (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 208 | Implement Trie (Prefix Tree) | Med | |
| [ ] | 211 | Design Add and Search Words Data Structure | Med | |

> Write 208 **once, cleanly**, and reuse the node class for everything below. Decide up front: `TrieNode[26]` array vs `Map<Character, TrieNode>` — and be able to argue the tradeoff (array is faster and simpler for lowercase-only; map handles arbitrary alphabets and sparse nodes without wasting 26 refs per node).
>
> 211 adds `.` wildcards, which forces recursion branching over all children. That branching is the same mechanic 212 uses — do 211 first.

## Trie + Backtracking (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 212 | Word Search II | Hard | |

> **The most important problem in this block.** Naive approach: run 79 (Word Search) once per word — hopeless for large dictionaries. Trie approach: one DFS over the grid, pruning the moment the current prefix leaves the trie.
>
> Two things interviewers look for: pruning dead trie branches after a word is found, and **restoring the visited marker on the way out**. Both are where people lose points.
>
> Overlaps your Backtracking block — count it once, here.

## Prefix Lookup / Dictionary (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 648 | Replace Words | Med | |
| [ ] | 720 | Longest Word in Dictionary | Med | |
| [ ] | 1268 | Search Suggestions System | Med | |

> 648 is the shortest-root lookup — stop at the first terminal node you hit.
>
> 720 is the "every prefix must also be a word" check, which is a clean use of terminal flags during insertion order.
>
> 1268 is the practical autocomplete: walk the prefix, then collect the lexicographically smallest 3 in the subtree. **Also solvable by sorting + binary search** — know both, and know that at real scale (millions of products) the trie wins on repeated queries while sort+binary-search wins on one-off. That tradeoff conversation is the SDE III part.

## Bitwise Trie / XOR (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 421 | Maximum XOR of Two Numbers in an Array | Med | |
| [ ] | 1707 | Maximum XOR With an Element From Array | Hard | |

> **421 is the highest-leverage non-obvious application.** Insert each number's 32-bit representation into a binary trie, then for each number greedily walk toward the *opposite* bit at every level. `O(32n)` instead of `O(n²)`.
>
> There's also a prefix-hashset solution to 421 — mention it, but the trie version is the one that generalizes.
>
> 1707 adds an upper-bound constraint per query, solved by **offline processing**: sort queries by limit, insert elements as the limit grows. Offline query reordering is a technique worth having.

## Aggregation & Advanced (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 677 | Map Sum Pairs | Med | |
| [ ] | 745 | Prefix and Suffix Search | Hard | |

> 677 stores an aggregate at each node rather than just a terminal flag — the "trie as an index, not just a set" idea.
>
> 745's trick is inserting every `suffix + '#' + word` combination so a two-sided query becomes a single prefix lookup. Clever, occasionally asked, and a good demonstration of **transforming the problem to fit the data structure** rather than the reverse.
>
> 336 (Palindrome Pairs) is the harder sibling if you have spare time — skip otherwise.

---

## 3-Day Schedule

| Day | Problems | Done |
|---|---|---|
| 1 | 208, 211, 648, 720 | [ ] |
| 2 | 1268, **212**, 677 | [ ] |
| 3 | 421, 1707, 745 | [ ] |

Day 2 gives 212 room. Day 3 is the bitwise-trie session — treat it as one idea learned three times.

---

## Revision

Re-solve **cold** (no notes, from scratch) on:

- **Day 10** — everything marked Hint?, plus 212, 421, 211
- **Day 24** — same set, plus anything that needed a hint on day 10

---

## Trim to 7 If Pressed

208, 211, 212, 1268, 421, 1707, 677

Cut: 648, 720, 745.

---

## The Trie You Should Be Able To Write From Memory

```java
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord;
}

class Trie {
    private final TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) cur.children[i] = new TrieNode();
            cur = cur.children[i];
        }
        cur.isWord = true;
    }

    private TrieNode walk(String s) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            cur = cur.children[c - 'a'];
            if (cur == null) return null;
        }
        return cur;
    }

    boolean search(String word)      { TrieNode n = walk(word); return n != null && n.isWord; }
    boolean startsWith(String prefix) { return walk(prefix) != null; }
}
```

**Bitwise trie variant:** same structure with `children[2]`, inserting from bit 31 down to bit 0. For max XOR, at each level prefer `children[1 - bit]`; fall back to `children[bit]` if the preferred branch is null.

---

## When A Trie Beats A HashMap

This is the question you're actually being tested on. A `HashSet<String>` gives you `O(1)` exact lookup and beats a trie for that alone. The trie wins when you need:

| Need | Why a hashmap fails |
|---|---|
| All words with a given **prefix** | Would require scanning every key |
| **Incremental** matching (autocomplete as you type) | No way to reuse work across keystrokes |
| Early termination while walking a grid or string | No partial-match query |
| Ordered/lexicographic results within a prefix | Hashmaps are unordered |
| Shared prefix **memory savings** on large dictionaries | Stores each key in full |
| **Bit-level** greedy decisions (max XOR) | No structure over bit prefixes |

If none of those apply, say so and use a hashmap — reaching for a trie when a set would do is its own kind of wrong answer.

---

## Pattern Recognition Check

| Signal in the problem | Approach |
|---|---|
| "Starts with" / prefix queries | Trie, `walk(prefix)` |
| Wildcard `.` in the pattern | Trie + recursion branching over children |
| Many words to find in one grid/text | **One** trie traversal, prune off-trie prefixes |
| Autocomplete / top-k suggestions per prefix | Trie + collect subtree, or sort + binary search |
| Maximum / minimum XOR pair | Bitwise trie, greedy opposite-bit walk |
| XOR with a per-query upper bound | Bitwise trie + **offline** queries sorted by limit |
| Sum/count over all keys with a prefix | Store aggregates at internal nodes |
| Two-sided (prefix **and** suffix) query | Insert `suffix + '#' + word` combinations |
| Exact lookup only, no prefix work | **HashSet — not a trie** |

---

## Java Notes

- `TrieNode[26]` costs ~104 bytes of references per node even for sparse tries. On a 10⁵-word dictionary that's real memory — mention `HashMap<Character, TrieNode>` as the sparse alternative.
- Store the **word itself** (not just `isWord`) at terminal nodes in 212 — saves rebuilding the string from the DFS path.
- Prune as you go in 212: after finding a word, null out the child reference if the node has no remaining children. This is the difference between passing and TLE.
- For bitwise tries, use `int` bit extraction `(num >> i) & 1` and iterate `i` from 31 down to 0. Watch for negatives if the problem allows them — usually it doesn't, but ask.
- `char - 'a'` assumes lowercase ASCII. Confirm the alphabet in the constraints before hardcoding 26.

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
| **Tries** | **10** | **✔ list built** |
| Graphs | 48 | |
| DP | 58 | |
| Backtracking | 15 | |
| Bit / math | 16 | |
| Design | 12 | |

**Running total: 217 / ~360.**

---

## Addendum — Final Coverage Audit

Two concepts from the original outline, neither needing a new problem.

### Delete from a trie (exercise, ~15 lines)

Extend your 208 implementation with `delete(String word)`. No LeetCode problem exists, but it's a natural interview follow-up to 208 and it exposes whether you understand the structure rather than just the happy path.

**The recursive approach:** walk down to the terminal node, clear `isWord`, then on the way back up remove each child reference **only if** that child has no remaining children and is not itself a word terminal.

```java
private boolean delete(TrieNode cur, String word, int depth) {
    if (depth == word.length()) {
        if (!cur.isWord) return false;      // word wasn't present
        cur.isWord = false;
        return isEmpty(cur);                // prunable?
    }
    int i = word.charAt(depth) - 'a';
    TrieNode child = cur.children[i];
    if (child == null) return false;
    if (delete(child, word, depth + 1)) {
        cur.children[i] = null;
        return !cur.isWord && isEmpty(cur);
    }
    return false;
}
```

**The three cases to be able to name:** the word isn't present (no-op); the word is a prefix of another word (clear the flag, prune nothing); the word has a unique suffix (prune back up to the last branching node or word terminal). Getting case 2 wrong deletes valid entries — that's the bug interviewers are watching for.

### Compressed trie / radix tree (conceptual)

A standard trie stores one character per node, so a long non-branching chain costs one node per character. A **radix tree** (or PATRICIA trie) collapses each non-branching chain into a single node holding the whole substring, splitting only when a divergence appears.

| | Standard trie | Radix tree |
|---|---|---|
| Node count | One per character | One per branching point |
| Memory on sparse dictionaries | Poor | Much better |
| Implementation complexity | Trivial | Node splitting on insert is fiddly |
| Where it's used | Interviews, small alphabets | IP routing tables, Redis (`rax`), Ethereum's Merkle Patricia trie, filesystem path indexes |

**What to say if asked:** *"a standard trie wastes a node per character on long unique suffixes; a radix tree collapses those into single edges, which is why routing tables and Redis use it. The cost is that insertion has to split nodes when a new key diverges mid-edge."* That's the full expected answer — no implementation needed at SDE III.

**Count unchanged: 10 problems + 1 exercise.**
