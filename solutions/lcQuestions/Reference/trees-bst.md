# Trees & BST — SDE III Prep (Final List)

**40 problems · 8 Easy / 23 Medium / 9 Hard · 9 days**

Tick the checkbox when solved. Mark the **Hint?** column if you needed help — those get re-solved first.

> **Framing:** trees are the highest-frequency topic in real interview loops after arrays — they're the default warm-up and the default medium. The good news is that ~70% of tree problems are one of three shapes: *return a value up from children*, *pass a value down from the parent*, or *traverse level by level*. Identify which before you write anything.

### Already covered elsewhere

| # | Problem | Where |
|---|---|---|
| 173 | BST Iterator | Stacks ✔ |
| 341 | Flatten Nested List Iterator | Stacks ✔ |

---

## Traversals — Iterative and Recursive (4)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 94 | Inorder Traversal *(recursive + iterative + Morris)* | Easy | |
| [ ] | 144 | Preorder Traversal *(iterative)* | Easy | |
| [ ] | 145 | Postorder Traversal *(iterative — hardest of the three)* | Easy | |
| [ ] | 102 | Level Order Traversal | Med | |

> Do **all three** iteratively. Postorder iterative is the one people can't produce under pressure — either two stacks, or reverse of a modified preorder. Know one cleanly.
>
> Implement **Morris inorder** once on 94 for the `O(1)`-space answer. You need to be able to say *"there's a threaded-tree approach with O(1) space"* and sketch it, not write it from memory.

## Level-Order Variants (4)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 103 | Zigzag Level Order Traversal | Med | |
| [ ] | 199 | Binary Tree Right Side View | Med | |
| [ ] | 662 | Maximum Width of Binary Tree | Med | |
| [ ] | 987 | Vertical Order Traversal | Hard | |

> All four are one BFS with a different accumulator. 662 needs **index arithmetic** (`2i`, `2i+1`) with an offset to avoid overflow on skewed trees — that's the actual content. 987's tiebreak rules (column, then row, then value) are fiddly by design.

## Depth, Balance, Diameter (4)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 104 | Maximum Depth | Easy | |
| [ ] | 110 | Balanced Binary Tree | Easy | |
| [ ] | 543 | Diameter of Binary Tree | Easy | |
| [ ] | 124 | Binary Tree Maximum Path Sum | Hard | |

> **This is the most important progression in the block.** 543 → 124 is the same insight: the recursive function *returns* the best downward path, while a side variable *records* the best path that bends at the current node. Once you see that split, a whole family opens up.
>
> On 110, the naive version is `O(n²)`. The `O(n)` version returns `-1` as a sentinel for "unbalanced." Show both, mention the improvement yourself.

## Path Problems (4)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 112 | Path Sum | Easy | |
| [ ] | 113 | Path Sum II | Med | |
| [ ] | 437 | Path Sum III *(prefix sum on tree)* | Med | |
| [ ] | 129 | Sum Root to Leaf Numbers | Med | |

> **437 is the sleeper.** It's the prefix-sum-plus-hashmap trick from Arrays (560), applied along a root-to-node path with backtracking on the way out. That cross-topic recognition is exactly the SDE III signal.

## Lowest Common Ancestor (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 236 | LCA of a Binary Tree | Med | |
| [ ] | 235 | LCA of a BST | Med | |
| [ ] | 1483 | Kth Ancestor of a Tree Node *(binary lifting)* | Hard | |

> 236 is asked constantly. 235 is the BST shortcut (walk down comparing values) — know why it's `O(h)` not `O(n)`.
>
> 1483 is **binary lifting**: precompute `up[node][2^k]` ancestors, answer queries in `O(log n)`. Also the technique behind `O(log n)` LCA with preprocessing. Worth one session.

## Construction & Serialization (5)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 105 | Construct from Preorder and Inorder | Med | |
| [ ] | 106 | Construct from Inorder and Postorder | Med | |
| [ ] | 108 | Convert Sorted Array to BST | Easy | |
| [ ] | 297 | Serialize and Deserialize Binary Tree | Hard | |
| [ ] | 449 | Serialize and Deserialize BST | Med | |

> On 105, the `O(n)` version uses an index map for inorder positions; the naive `Arrays.copyOfRange` version is `O(n²)`. Say which you're writing.
>
> **297's real content is format design** — null markers, delimiters, why preorder works and level-order also works but inorder alone doesn't. That reasoning connects directly to the length-prefixing discussion from Hashing (271).
>
> 889 (pre + post) is a good extra if you want to prove you understand *why* inorder is the one that disambiguates.

## BST Operations (6)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 98 | Validate BST | Med | |
| [ ] | 700 | Search in a BST | Easy | |
| [ ] | 701 | Insert into a BST | Med | |
| [ ] | 450 | Delete Node in a BST | Med | |
| [ ] | 230 | Kth Smallest Element in a BST | Med | |
| [ ] | 99 | Recover Binary Search Tree | Med | |

> **98 is the classic trap** — checking only `left < node < right` locally is wrong. Pass min/max bounds down, or do an inorder scan tracking the previous value. Interviewers *want* you to fall for it.
>
> 450 is the only BST op with real case analysis (0, 1, 2 children; successor replacement). Don't skip it — it's the one that's actually asked.
>
> 230's follow-up: *"what if the tree is modified frequently?"* → augment nodes with subtree counts. Have the answer ready.

## BST Transformation (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 538 | Convert BST to Greater Tree *(reverse inorder)* | Med | |
| [ ] | 1382 | Balance a BST | Med | |
| [ ] | 426 | Convert BST to Sorted DLL *(premium — else skip)* | Med | |

> 538 is reverse inorder with an accumulator — trivially easy once you see it, and a good check that you're not locked into left-to-right thinking.

## Tree DP / Rerooting (4)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 337 | House Robber III | Med | |
| [ ] | 979 | Distribute Coins in Binary Tree | Med | |
| [ ] | 968 | Binary Tree Cameras | Hard | |
| [ ] | 834 | Sum of Distances in Tree *(rerooting)* | Hard | |

> 337 is the gateway — return a `(rob, skip)` pair from each node. This "return a tuple of states" idea is the core of all tree DP.
>
> 979's insight (the answer is the sum of `|flow|` across every edge) is genuinely elegant and worth the time.
>
> **834 is the rerooting technique** — compute the answer for one root, then derive every other root in `O(1)` from its parent. Two DFS passes. This appears in harder graph rounds too.

## Segment Tree / BIT (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 307 | Range Sum Query — Mutable | Med | |
| [ ] | 315 | Count of Smaller Numbers After Self | Hard | |
| [ ] | 493 | Reverse Pairs | Hard | |

> 307 is where you write a segment tree (or BIT) **once**, cleanly, and keep it. Point update + range query.
>
> 315 and 493 both have three valid solutions: BIT with coordinate compression, merge sort with counting, or a balanced BST. **Do the merge-sort version first** — it's more likely to be accepted as "your own work" and it reinforces divide and conquer. Then know the BIT version.
>
> Lazy propagation is worth *understanding* but is rarely required. Don't burn a day on it.

---

## 9-Day Schedule

| Day | Problems | Done |
|---|---|---|
| 1 | 94, 144, 145, 102, 104 | [ ] |
| 2 | 103, 199, 662, 987 | [ ] |
| 3 | 110, 543, **124**, 112 | [ ] |
| 4 | 113, 437, 129, 236, 235 | [ ] |
| 5 | 105, 106, 108, 297, 449 | [ ] |
| 6 | 98, 700, 701, 450, 230 | [ ] |
| 7 | 99, 538, 1382, 426, 1483 | [ ] |
| 8 | 337, 979, 968, 834 | [ ] |
| 9 | 307, 315, 493 | [ ] |

Day 9 is three problems because the segment tree / BIT implementation is the work, not the problem count.

---

## Revision

Re-solve **cold** (no notes, from scratch) on:

- **Day 16** — everything marked Hint?, plus 124, 297, 98, 437, 834, 315
- **Day 30** — same set, plus anything that needed a hint on day 16

---

## Trim to 26 If Pressed

94, 145, 102, 103, 199, 104, 110, 543, 124, 113, 437, 236, 235, 105, 297, 98, 450, 230, 99, 538, 337, 979, 834, 307, 315, 987

Cut: 144, 662, 112, 129, 1483, 106, 108, 449, 700, 701, 1382, 426, 968, 493.

---

## The Three Shapes

Before writing code, decide which shape the problem is. This single habit prevents most tree bugs.

**1. Bottom-up — return a value from children**
```java
int dfs(TreeNode node) {
    if (node == null) return 0;
    int left  = dfs(node.left);
    int right = dfs(node.right);
    // combine, possibly update a global side-answer
    return combine(left, right, node.val);
}
```
Used by: 104, 543, 124, 110, 337, 979, 968.

**2. Top-down — pass state from parent to children**
```java
void dfs(TreeNode node, State s) {
    if (node == null) return;
    State next = update(s, node.val);
    dfs(node.left, next);
    dfs(node.right, next);
}
```
Used by: 98 (bounds), 129 (accumulated number), 112/113 (remaining sum), 437 (prefix sums).

**3. Level by level — BFS with a queue**
```java
Queue<TreeNode> q = new ArrayDeque<>();
while (!q.isEmpty()) {
    int size = q.size();          // freeze the level size
    for (int i = 0; i < size; i++) { ... }
}
```
Used by: 102, 103, 199, 662, 987.

> **The tuple return.** When bottom-up needs to report more than one thing (best-downward *and* best-bending; rob *and* skip), return a small array or record. Don't reach for a global unless you need exactly one accumulator.

---

## Pattern Recognition Check

| Signal in the problem | Approach |
|---|---|
| Depth, height, diameter, max path | Bottom-up return + global side-answer |
| Root-to-leaf path with a running condition | Top-down state passing |
| "Per level" / "right side view" / width | BFS with frozen level size |
| Validate BST | Top-down min/max bounds, or inorder + prev |
| Kth smallest / sorted order in BST | Inorder traversal, early exit |
| BST with repeated queries + updates | Augment nodes with subtree size |
| Two nodes' common ancestor | 236 recursion, or BST value comparison |
| Ancestor **k** levels up, many queries | Binary lifting |
| Rebuild a tree from traversals | Recursion + index map for inorder positions |
| Convert tree ↔ string | Preorder with null markers |
| Count paths summing to K (any start) | Prefix sum map + backtrack on exit |
| Choose-or-skip on each node | Tree DP, return a state tuple |
| Answer for **every** node as root | Rerooting — two DFS passes |
| Range query with point updates | Segment tree or BIT |
| Count inversions / smaller-after-self | Merge sort counting, or BIT + compression |

---

## Java Notes

- Recursion depth: a skewed tree of 10⁵ nodes **will** blow the default stack. Say so, and know the iterative fallback.
- `TreeMap` / `TreeSet` are red-black trees — `floorKey`, `ceilingKey`, `firstKey`, `pollFirst` are your `O(log n)` BST operations when you don't need to hand-roll one.
- `TreeMap.subMap` / `headMap` / `tailMap` are range queries for free — useful in calendar and interval design problems.
- For BIT, 1-indexed arrays make the `i += i & -i` idiom clean. Off-by-one bugs here are almost always a 0-index mistake.
- Prefer an explicit `Deque<TreeNode>` for iterative traversal; `Stack` is legacy (same note as the Stacks block).
- When a problem gives `Node` with a `parent` pointer, that's a hint the intended solution walks *upward* — don't rebuild the tree.

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
| **Trees + BST** | **40** | **✔ list built** |
| Tries | 10 | |
| Graphs | 48 | |
| DP | 58 | |
| Backtracking | 15 | |
| Bit / math | 16 | |
| Design | 12 | |

**Running total: 207 / ~360.**

---

## Addendum — Final Coverage Audit

Trees had the most gaps of any block. Five problems plus three conceptual items.

### Missing problems (5)

| ✔ | # | Problem | Diff | Why it was missing | Hint? |
|---|---|---|---|---|---|
| [ ] | 545 | Boundary of Binary Tree *(premium)* | Med | "boundary traversal" was in the outline | |
| [ ] | 285 | Inorder Successor in BST *(premium)* | Med | "inorder successor/predecessor" was in the outline | |
| [ ] | 1650 | LCA III — with parent pointers *(premium)* | Med | "LCA with parent pointers" was in the outline | |
| [ ] | 429 | N-ary Tree Level Order Traversal | Med | "N-ary trees" was in the outline | |
| [ ] | 508 | Most Frequent Subtree Sum | Med | "count subtrees" was in the outline | |

**545** is three separate traversals stitched together (left boundary, leaves, reversed right boundary) with careful handling of the root and single-child cases. Tedious rather than clever, but it's asked, and the tedium is the test.

**285** has two solutions worth knowing: BST-property descent in `O(h)` without a parent pointer, and the parent-pointer walk-up version. If premium-locked, implement it against your own BST from 700/701.

**1650** is the linked-list intersection problem (160) in disguise — walk up from both nodes, equalize depths, converge. **Noticing that it's 160 is the point**, and that reduction is worth more than the problem.

**429** is 102 with a children list instead of left/right. Nearly free, and it makes the point that your BFS template isn't binary-specific. 589 (N-ary preorder) is equally free if you want a second.

**508** is bottom-up subtree aggregation into a frequency map — the "return a value up, record it globally" shape from the Three Shapes section, applied to counting.

### Conceptual items (no problems)

**Self-balancing trees — AVL and red-black.** You need the vocabulary, not the implementation. Nobody asks you to code a red-black tree at SDE III; they ask what guarantees it gives.

| | AVL | Red-black |
|---|---|---|
| Balance invariant | Heights of subtrees differ by ≤ 1 | No two consecutive red nodes; equal black-height on all paths |
| Height bound | ~1.44 log n — **more strictly balanced** | ~2 log n |
| Rotations per insert/delete | More | Fewer |
| Better for | Read-heavy workloads | Write-heavy workloads |
| Used by | Some in-memory indexes | **Java's `TreeMap`/`TreeSet`**, C++ `std::map`, Linux CFS scheduler |

Know the **four AVL rotation cases** by name (LL, RR, LR, RL) and that LR/RL are just two single rotations composed. Know that red-black trades a looser height bound for fewer restructuring operations, which is why standard libraries chose it.

**Tree isomorphism** (from the outline). Two trees are isomorphic if one can become the other by swapping children. Recursive check: `same(a.left, b.left) && same(a.right, b.right)` **or** `same(a.left, b.right) && same(a.right, b.left)`. That's LC 951 (Flip Equivalent Binary Trees) if you want the problem — 10 minutes.

**Sparse table for static range min/max.** Precompute `sparse[i][j]` = the answer for the range starting at `i` of length `2^j`. Build in `O(n log n)`, query in **`O(1)`** by overlapping two power-of-two ranges.

The tradeoff versus a segment tree, which is the interview content:

| | Sparse table | Segment tree |
|---|---|---|
| Query | `O(1)` | `O(log n)` |
| Updates | **Not supported** | `O(log n)` |
| Space | `O(n log n)` | `O(n)` |
| Requires | An **idempotent** operation (min, max, gcd) | Any associative operation |

**Why idempotency matters:** the two overlapping ranges double-count the intersection. That's harmless for `min`/`max`/`gcd` but wrong for `sum` — which is why you can't build a sparse table for range sums. That's the answer if asked "why not use a sparse table for 307?"

**2-D BIT / range updates on a BIT.** Two extensions worth knowing without implementing:
- **Range update + point query:** store differences instead of values, then a prefix sum gives the value at a point
- **Range update + range query:** two BITs, one tracking `i * delta`. Standard technique, rarely required
- **2-D BIT:** nested `i += i & -i` loops over both dimensions, `O(log m · log n)` per operation. Used for 2-D range sums with updates (the mutable version of 304)

**Revised count: 45 problems.** Slot 429 and 508 into day 2 and day 8; the three premiums onto day 7 if you have access, otherwise skip them and implement 285 against your own BST.

---

## Addendum 2 — Residual Coverage Check

Two outline items still missing. Both conceptual, no new problems.

### Tarjan's offline LCA

From the outline: "LCA — binary tree, BST, with parent pointers, **offline (Tarjan)**, binary lifting." You have the first three plus binary lifting (1483). Tarjan's offline algorithm is the remaining one.

**The setup:** you're given *all* the LCA queries up front (hence "offline"). Instead of answering each independently, you do a single DFS and answer queries as you go.

**How it works:** DFS the tree. When you finish processing a node `u`, union it into its parent's set (union-find). Mark `u` as visited. For each query `(u, v)` where `v` is already visited, the answer is `find(v)`'s set representative — because the ancestor set that `v` currently belongs to is exactly their LCA.

**Complexity:** `O((V + Q) · α(V))` — effectively linear for `V` nodes and `Q` queries. Compare:

| Method | Preprocessing | Per query | Requires all queries up front |
|---|---|---|---|
| Naive recursion (236) | none | `O(n)` | No |
| Binary lifting (1483) | `O(n log n)` | `O(log n)` | No |
| Euler tour + sparse table | `O(n log n)` | **`O(1)`** | No |
| **Tarjan offline** | none | `O(α(n))` amortized | **Yes** |

**Why it's worth knowing:** it's the cleanest example of the general **offline query** technique — reordering or batching queries to make them collectively cheaper. You've already met that idea in 1707 (Tries — sort queries by limit). Being able to name the pattern in two different settings is the signal.

No LeetCode problem exists for it. Know the union-find-during-DFS mechanic and the "all queries known in advance" precondition.

**Note the sparse table row above** — Euler tour flattens the tree to an array, then range-minimum over depths gives LCA in `O(1)`. That connects the sparse table from Addendum 1 to LCA, which is its most common real use.

### Construction from level-order + inorder

From the outline: "Construct from traversals (pre+in, post+in, **level+in**)." You have 105 and 106; there's no LeetCode problem for level-order + inorder.

**The approach:** the first element of the level-order sequence is the root. Split inorder at the root to get the left and right subtree *value sets*. Then filter the remaining level-order sequence into two subsequences by membership in those sets — level-order restricted to a subtree is still a valid level-order for that subtree. Recurse.

**Why it's more awkward than 105/106:** with preorder or postorder, the subtree boundaries are contiguous slices, so you recurse on index ranges. With level-order they're **interleaved**, so you have to partition by membership rather than slice — which costs `O(n)` per level and makes the naive version `O(n²)`.

**The question actually worth being able to answer:** *which pairs of traversals uniquely determine a binary tree?*

| Pair | Unique? |
|---|---|
| Preorder + inorder | Yes |
| Postorder + inorder | Yes |
| Level-order + inorder | Yes |
| Preorder + postorder | **No** — ambiguous for nodes with a single child |
| Any pair **without** inorder | Generally no |

**Inorder is the one that disambiguates**, because it's the only traversal that tells you which nodes are left versus right of the root. That's the insight 297's format-design discussion depends on, and it's a clean thing to be able to state.

**Count unchanged: 45 problems.**
