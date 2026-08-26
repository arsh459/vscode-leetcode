# Linked Lists — SDE III Prep (Final List)

**16 problems · 6 Easy / 8 Medium / 2 Hard · 4 days**

Tick the checkbox when solved. Mark the **Hint?** column if you needed help — those get re-solved first.

> **Scope note:** Linked lists are largely an SDE I/II filter. At SDE III they appear as a warm-up or embedded inside a design problem — you already wrote a doubly linked list for LRU in the Hashing block. This list is deliberately short and Easy-skewed. These are **speed problems**; you should finish most in under 15 minutes.
>
> The value here isn't the algorithms — it's **pointer discipline under pressure**. Every problem below is failed by losing a reference, not by not knowing the approach.

---

## Reversal (4)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 206 | Reverse Linked List | Easy | |
| [ ] | 92 | Reverse Linked List II *(between positions)* | Med | |
| [ ] | 25 | Reverse Nodes in k-Group | Hard | |
| [ ] | 24 | Swap Nodes in Pairs | Med | |

> Do 206 **both** iteratively and recursively — the recursive version is asked as a follow-up specifically to test whether you can reason about the unwinding.
>
> **Order: 206 → 92 → 25.** 25 is 92 in a loop with a length check, and it's the most commonly asked Hard in this block. Use a dummy head on all three.

## Cycle Detection (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 141 | Linked List Cycle | Easy | |
| [ ] | 142 | Linked List Cycle II *(find start)* | Med | |
| [ ] | 143 | Reorder List | Med | |

> 142's phase 2 — reset one pointer to head, advance both at speed 1, they meet at the cycle start. Be able to **justify why**, not just recite it. *"Why does that work?"* is a standard probe.
>
> 143 is find-middle + reverse + merge — a three-technique composite, good integration check.

## Two Pointers / Middle / Nth (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 876 | Middle of the Linked List | Easy | |
| [ ] | 19 | Remove Nth Node From End of List | Med | |

> 19's edge case — removing the head — is where the dummy node earns its keep. Interviewers watch whether you reach for it **unprompted**.

## Merging & Sorting (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 21 | Merge Two Sorted Lists | Easy | |
| [ ] | 23 | Merge k Sorted Lists | Hard | |
| [ ] | 148 | Sort List *(merge sort, O(1) space)* | Med | |

> 23 has two valid answers — min-heap `O(N log k)` and divide-and-conquer pairwise merge `O(N log k)`. Know **both** and the space difference (`O(k)` vs `O(log k)` stack).
>
> 148 is the one place bottom-up merge sort on a list is genuinely required: the "`O(n log n)` time and `O(1)` space" constraint rules out recursion's stack.

## Intersection & Structural (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 160 | Intersection of Two Linked Lists | Easy | |
| [ ] | 234 | Palindrome Linked List *(O(1) space)* | Easy | |

> Both labelled Easy, both with an `O(1)`-space trick people miss:
> - **160** — switch heads at the end to equalize traversal lengths
> - **234** — reverse the second half in place, compare, then **restore it**. Restoring is the part interviewers actually care about.

## Partition & Rearrangement (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 86 | Partition List | Med | |
| [ ] | 328 | Odd Even Linked List | Med | |

> Same shape — two dummy heads, build two chains, splice at the end. Do 86 and 328 becomes free.

## Deep Copy / Complex Structure (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 138 | Copy List with Random Pointer | Med | |
| [ ] | 430 | Flatten a Multilevel Doubly Linked List | Med | |

> 138 has a hashmap solution and an `O(1)`-space interleaving solution. **Show the map version first, then mention the interleaving** — that progression is the signal, not the clever answer alone.
>
> 430 is iterative DFS on a list structure.

## Arithmetic (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 2 | Add Two Numbers | Med | |

> 445 (Add Two Numbers II — digits in forward order) is the follow-up: stack, or reverse both. Know it exists; no need to solve separately.

---

## 4-Day Schedule

| Day | Problems | Done |
|---|---|---|
| 1 | 206, 92, 24, 141, 876 | [ ] |
| 2 | 142, 19, 21, 143 | [ ] |
| 3 | 23, 148, 160, 234 | [ ] |
| 4 | 86, 328, 138, 430, 2, 25 | [ ] |

**Don't extend past day 4.** If a problem isn't clicking, note it and move on — it'll come back in revision.

---

## Revision

Re-solve **cold** (no notes, from scratch) on:

- **Day 11** — everything marked Hint?, plus 25, 148, 23, 138, 234
- **Day 25** — same set, plus anything that needed a hint on day 11

---

## Trim to 11 If Pressed

206, 92, 25, 142, 19, 21, 23, 148, 234, 138, 2

Cut: 24, 141, 876, 143, 160, 86, 328, 430.

---

## What's Actually Being Tested

Three habits, all mechanical. Drill them until they're automatic.

**1. Dummy head.**
If the operation can modify or remove the first node, create a dummy. Skipping this is the single most common source of null-pointer bugs in these problems.

```java
ListNode dummy = new ListNode(0);
dummy.next = head;
// ... work with dummy.next ...
return dummy.next;
```

**2. Save before you break.**
`next = cur.next` **before** you reassign `cur.next`. Every reversal bug is a missing version of this line.

```java
while (cur != null) {
    ListNode next = cur.next;   // save first
    cur.next = prev;            // then rewire
    prev = cur;
    cur = next;
}
```

**3. Draw it.**
Four nodes on paper, arrows redrawn each step. Interviewers explicitly like seeing this — it's the closest thing linked lists have to a "shows their work" signal, and it catches your own bugs before they do.

---

## Pattern Recognition Check

| Signal in the problem | Approach |
|---|---|
| Reverse all / part / in groups | Iterative 3-pointer + dummy head |
| Detect a loop | Floyd's fast & slow |
| Find where the loop starts | Floyd, then reset one pointer to head |
| Find the middle | Fast & slow (`fast.next != null && fast.next.next != null`) |
| Nth from the end | Two pointers, gap of n, dummy head |
| Merge 2 sorted | Dummy head + single pass |
| Merge k sorted | Min-heap, or divide & conquer pairwise |
| Sort in `O(1)` space | Bottom-up merge sort |
| Two lists converge | Equalize lengths by switching heads |
| Palindrome, `O(1)` space | Reverse second half, compare, restore |
| Split into two groups | Two dummy heads, splice at the end |
| Copy with extra pointers | Hashmap old→new, or interleave-and-split |
| Nested / multilevel | Iterative DFS with an explicit stack |

---

## Edge Cases To Check Every Time

- Empty list (`head == null`)
- Single node
- Two nodes (breaks many "middle" implementations)
- Operation targets the **head**
- Operation targets the **tail**
- `k` larger than list length (25)
- All nodes identical
- Cycle present when the algorithm assumes none

---

## Progress Across the Plan

| Area | Target | Status |
|---|---|---|
| Arrays | 39 | ✔ list built |
| Strings | 23 | ✔ list built |
| Hashing | 17 | ✔ list built |
| Binary search | 28 | ✔ list built |
| **Linked list** | **16** | **✔ list built** |
| Stack / queue / monotonic | 25 | |
| Heap | 20 | |
| Trees + BST | 40 | |
| Tries | 10 | |
| Graphs | 45–50 | |
| DP | 55–60 | |
| Backtracking | 15 | |
| Bit / math | 15 | |
| Design | 15 | |

**Running total: 122 / ~350.**

**Protect the graphs-and-DP ratio.**

---

## Addendum — Final Coverage Audit

Two items from the original outline that this list missed.

| ✔ | # | Problem | Diff | Why it was missing | Hint? |
|---|---|---|---|---|---|
| [ ] | 61 | Rotate List | Med | "Reorder, partition, **rotate**, remove Nth" — rotate wasn't in the list | |

**On 61:** find the length, `k %= length` (the modulo is the part people forget when `k > n`), then find the new tail at position `length - k - 1`, split, and reconnect. Cheap problem, and the `k % length` normalization is exactly the same idea as 189 Rotate Array in the Arrays block.

**Cycle length** (also in the outline, no separate problem needed): once Floyd's fast and slow pointers meet inside the cycle, hold one pointer still and advance the other until they meet again — the number of steps is the cycle length. Add this as a two-line extension when you re-solve 142. Worth being able to state, since the natural follow-up to 142 is *"and how long is the cycle?"*

**Revised count: 17 problems.**
