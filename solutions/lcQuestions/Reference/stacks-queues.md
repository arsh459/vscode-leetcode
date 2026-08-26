# Stacks & Queues — SDE III Prep (Final List)

**25 new problems (+3 crossovers referenced) · 4 Easy / 12 Medium / 9 Hard · 6 days**

Tick the checkbox when solved. Mark the **Hint?** column if you needed help — those get re-solved first.

> **Headline:** monotonic stack is the second-most-underpracticed pattern after binary search on answer. It converts a whole family of `O(n²)` problems to `O(n)`. Roughly half this block is monotonic stack, and that weighting is deliberate.

### Already covered elsewhere — referenced, not re-counted

| # | Problem | Where |
|---|---|---|
| 239 | Sliding Window Maximum *(monotonic deque)* | Arrays ✔ |
| 20, 227, 394, 224 | Parentheses + calculators | Strings ✔ |
| 895 | Maximum Frequency Stack | Hashing ✔ |
| 42 | Trapping Rain Water | Arrays ✔ — **revisit with the stack solution** |

---

## Basic Stack Mechanics (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 155 | Min Stack | Med | |
| [ ] | 232 | Implement Queue using Stacks | Easy | |
| [ ] | 225 | Implement Stack using Queues | Easy | |

> 155 has two solutions: stack of pairs, or the `O(1)`-extra-space encoding trick storing `2*x - min`. Show the pair version, mention the second.
>
> 232's **amortized `O(1)`** analysis (two stacks, transfer only when the out-stack is empty) is the actual interview content. Be ready to explain why *amortized*, not per-operation.

## Monotonic Stack — Next Greater / Smaller (5)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 496 | Next Greater Element I | Easy | |
| [ ] | 503 | Next Greater Element II *(circular)* | Med | |
| [ ] | 739 | Daily Temperatures | Med | |
| [ ] | 901 | Online Stock Span | Med | |
| [ ] | 456 | 132 Pattern | Med | |

> These five are the **same loop**. Learn the template once: decreasing stack, pop while `stack.top < current`, the popped element's answer is `current`.
>
> 503 adds the circular trick (iterate `2n`, mod the index). 456 is the one requiring actual thought — traverse right-to-left tracking a candidate "third" value.

## Monotonic Stack — Histogram Family (3 new)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 84 | Largest Rectangle in Histogram | Hard | |
| [ ] | 85 | Maximal Rectangle | Hard | |
| [ ] | 1793 | Maximum Score of a Good Subarray | Hard | |
| [ ] | 42 | Trapping Rain Water — *redo with stack* | Hard | |

> **84 is the single most important problem in this block.** Once you can write it cleanly with sentinel handling, 85 is 84 applied row by row, and 1793 is a variant.
>
> **Do 84 until you can produce it cold in under 20 minutes.** Common Google/Amazon ask and the gateway to the whole family.
>
> You likely solved 42 with two pointers in Arrays — do the stack version here. Both are worth having.

## Monotonic Stack — Contribution / Counting (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 907 | Sum of Subarray Minimums | Med | |
| [ ] | 2104 | Sum of Subarray Ranges | Med | |
| [ ] | 828 | Count Unique Characters of All Substrings | Hard | |

> The idea: *how many subarrays does each element dominate?* Compute each element's contribution via previous-smaller and next-smaller boundaries.
>
> 907 is canonical. **The equal-elements tiebreak is where people get it wrong** — strict on one side, non-strict on the other, or you double-count. 2104 is 907 run twice (min and max).

## Monotonic Stack — Lexicographic Greedy (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 402 | Remove K Digits | Med | |
| [ ] | 316 | Remove Duplicate Letters | Med | |

> Greedy + stack: pop while the top is worse than current **and** you still have removals left. 316 adds a "can't pop if it's the last occurrence" constraint.
>
> 1081 is a duplicate of 316 — don't do both.

## Monotonic Deque (1 new)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 862 | Shortest Subarray with Sum at Least K | Hard | |
| [ ] | 239 | Sliding Window Maximum *(already in Arrays)* | Hard | |

> 862 is prefix sum + monotonic deque, and it's the problem that shows **why** a deque is needed rather than a heap. Genuinely hard — allow time.

## Stack for Parsing (1 new)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 32 | Longest Valid Parentheses | Hard | |

> Core parsing set (20, 227, 394, 224) is done in Strings. 32 is the addition worth making — three valid approaches: stack of indices, DP, or two-pass counter with `O(1)` space. Know the stack version, mention the `O(1)` one.

## Iterative Simulation of Recursion (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 341 | Flatten Nested List Iterator | Med | |
| [ ] | 173 | Binary Search Tree Iterator | Med | |

> Both are "convert recursion to an explicit stack, **lazily**."
>
> 173 previews the tree block and is a very common ask — controlled inorder with `next()` / `hasNext()`. The lazy version (push the left spine only) is what they want, **not** pre-computing the full list.

## Queue / Deque / Circular Buffer (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 622 | Design Circular Queue | Med | |
| [ ] | 641 | Design Circular Deque | Med | |
| [ ] | 933 | Number of Recent Calls | Easy | |

> 622 is real work: modular arithmetic, distinguishing full from empty, and the follow-up *"why the extra slot / why the size counter?"* 933 is a queue warm-up — 5 minutes.

## Design / Applied (1 new)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1249 | Minimum Remove to Make Valid Parentheses | Med | |

> Very frequent Meta phone screen. Two passes with an index set, or one pass with a stack of indices.

---

## 6-Day Schedule

| Day | Problems | Done |
|---|---|---|
| 1 | 155, 232, 225, 496, 503 | [ ] |
| 2 | 739, 901, 456, 402 | [ ] |
| 3 | 316, **84** | [ ] |
| 4 | 85, 1793, 907 | [ ] |
| 5 | 2104, 828, 862, 32 | [ ] |
| 6 | 341, 173, 622, 641, 933, 1249, 42 *(stack redo)* | [ ] |

**Day 3 is deliberately light — 84 gets a full session.** Day 6 is heavy but everything on it is fast.

---

## Revision

Re-solve **cold** (no notes, from scratch) on:

- **Day 13** — everything marked Hint?, plus 84, 85, 907, 402, 862, 32
- **Day 27** — same set, plus anything that needed a hint on day 13

---

## Trim to 16 If Pressed

155, 232, 503, 739, 456, 402, 316, 84, 85, 907, 862, 32, 173, 622, 1249, 341

Cut: 225, 496, 901, 1793, 2104, 828, 641, 933.

---

## The Monotonic Stack Template

Almost everything above is this shape. Internalize it and the section collapses to one idea.

```java
Deque<Integer> stack = new ArrayDeque<>();   // stores INDICES, not values
for (int i = 0; i < n; i++) {
    while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
        int idx = stack.pop();
        // arr[i]        -> next smaller element for idx
        // stack.peek()  -> previous smaller element for idx
    }
    stack.push(i);
}
// remaining elements have no next smaller — handle with a sentinel
// or a post-loop drain
```

**Tells in the problem statement:**
- "next / previous greater or smaller"
- "how many days until…" / "how far until X"
- "largest rectangle / area / span"
- "sum over **all** subarrays of min or max"
- An obvious `O(n²)` nested loop where each element only cares about nearby elements that beat it

**The two decisions you must make consciously:**
1. **Increasing or decreasing** stack
2. **Strict `>` vs non-strict `>=`**

Get the strictness wrong in a counting problem (907) and you double-count. Reason it out from a duplicate-heavy example — never guess.

**Sentinel trick:** for 84, append a `0` height at the end so the stack fully drains without a separate post-loop. Cleaner than duplicating drain logic.

---

## Pattern Recognition Check

| Signal in the problem | Approach |
|---|---|
| Next / previous greater or smaller | Monotonic stack of indices |
| Circular "next greater" | Iterate `2n`, index `% n` |
| Largest rectangle / area under bars | Monotonic increasing stack + sentinel |
| 2-D rectangle of 1s | Row-by-row heights → 84 |
| Sum of min/max over all subarrays | Contribution counting, watch strictness |
| Remove k chars for smallest/largest result | Greedy + stack, pop while worse |
| Max/min in a sliding window | Monotonic **deque** |
| Shortest subarray with sum ≥ K | Prefix sum + monotonic deque |
| Balanced brackets / nested structure | Plain stack |
| Longest valid parentheses | Stack of indices, or DP, or two-pass counter |
| Lazy traversal with `next()` / `hasNext()` | Explicit stack, push spine only |
| Fixed-capacity ring | Circular queue, modular arithmetic |
| "Recent calls in last N ms" | Queue, evict from the front |

---

## Java Notes

- **Use `ArrayDeque`, not `Stack`.** `Stack` extends `Vector` and is synchronized — legacy and slower. `ArrayDeque` is the idiomatic choice for both stack and deque.
- `ArrayDeque` as a stack: `push` / `pop` / `peek`. As a queue: `offer` / `poll` / `peek`. Mixing the two vocabularies in one class is a readability ding.
- `ArrayDeque` does **not** permit `null` elements — it will throw. Use a sentinel value instead.
- `Deque<Integer>` autoboxing costs real time in tight loops; an `int[]` with a manual top pointer is faster if the interviewer cares about constants.
- `LinkedList` implements `Deque` but has worse cache behaviour — don't reach for it.
- `PriorityQueue` is **not** a deque. If you're tempted to use a heap for a sliding-window max, that's the signal you want a monotonic deque instead.

---

## Progress Across the Plan

| Area | Target | Status |
|---|---|---|
| Arrays | 39 | ✔ list built |
| Strings | 23 | ✔ list built |
| Hashing | 17 | ✔ list built |
| Binary search | 28 | ✔ list built |
| Linked list | 16 | ✔ list built |
| **Stack / queue / monotonic** | **25** | **✔ list built** |
| Heap | 20 | |
| Trees + BST | 40 | |
| Tries | 10 | |
| Graphs | 45–50 | |
| DP | 55–60 | |
| Backtracking | 15 | |
| Bit / math | 15 | |
| Design | 15 | |

**Running total: 147 / ~350.**

**Protect the graphs-and-DP ratio.**

---

## Addendum — Final Coverage Audit

One problem and one concept from the original outline.

| ✔ | # | Problem | Diff | Why it was missing | Hint? |
|---|---|---|---|---|---|
| [ ] | 150 | Evaluate Reverse Polish Notation | Med | "infix/postfix/prefix conversion **and evaluation**" — 227/224 are infix evaluation only | |

**On 150:** postfix evaluation is the easy direction — push operands, pop two on an operator, push the result. Five minutes. Do it because it makes the *conversion* discussion below concrete.

### Infix → Postfix Conversion (no LeetCode problem)

The **shunting-yard algorithm**. Worth being able to sketch, because it's the honest answer to *"how would a real parser handle this?"* and it explains why 224 is fiddly:

1. Scan the infix expression left to right
2. Operand → append to output
3. Operator → pop operators of **greater or equal precedence** to output, then push this one
4. `(` → push. `)` → pop to output until `(`, discard the `(`
5. End → pop everything remaining

Two things worth knowing:
- **Left- vs right-associativity** changes step 3 from `>=` to `>` (exponentiation is right-associative)
- Once converted to postfix, evaluation needs no precedence logic at all — which is *why* compilers and calculators convert first rather than evaluating infix directly

**The connection to make out loud:** 227 and 224 solve infix evaluation with an ad-hoc stack because the expressions are simple. A real parser converts to postfix (or builds an AST) first. If an interviewer pushes on "what if we add exponentiation, unary operators, and function calls?" — shunting-yard or recursive descent is the answer, not more special cases.

**Revised count: 26 problems.**

---

## Addendum 2 — Residual Coverage Check

One outline item: "Min stack / **max stack** in O(1)."

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 716 | Max Stack *(premium)* | Hard | |

**Why this isn't just 155 with the comparison flipped.** 155 (Min Stack) supports `push`, `pop`, `top`, `getMin`. 716 adds **`popMax`** — remove the maximum element from anywhere in the stack, not just the top. That single operation changes the problem completely, because you now need to delete from the middle while preserving stack order.

**Two approaches worth knowing:**
1. **Two stacks + a buffer.** `popMax` pops from the main stack into a temp stack until it finds the max, removes it, then pushes everything back. `O(n)` for `popMax`, `O(1)` for everything else. This is the expected answer.
2. **TreeMap of stacks + doubly linked list.** `TreeMap<Integer, List<Node>>` for `O(log n)` max lookup, DLL for `O(1)` arbitrary removal. `O(log n)` for `popMax`. This is the optimization they'll ask for.

**The interview content is the progression** — give approach 1, state that `popMax` is `O(n)`, then volunteer approach 2 when asked to improve it. It's the same "hashmap + DLL for arbitrary removal" idea as 146 and 460, applied to a stack.

If premium-locked, implement it from this description — it's a good 30 minutes and it reuses machinery you already have.

**Revised count: 27 problems.**
