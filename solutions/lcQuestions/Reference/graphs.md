# Graphs — SDE III Prep (Final List)

**48 problems · 1 Easy / 31 Medium / 16 Hard · 11 days**

Tick the checkbox when solved. Mark the **Hint?** column if you needed help — those get re-solved first.

> **This and DP are the two blocks that decide the coding rounds.** Everything before this was setup. Do not compress this block to save time elsewhere.
>
> The thing that makes graphs hard isn't any single algorithm — it's that half the problems don't *look* like graphs. Dependency resolution, currency conversion, word transformation, account merging, flight routing: all graphs in disguise. The recognition is the skill.

### Already covered elsewhere

| # | Problem | Where |
|---|---|---|
| 128 | Longest Consecutive Sequence | Hashing ✔ — *has a union-find solution worth noting* |
| 212 | Word Search II | Tries ✔ |

---

## Grid Traversal — DFS/BFS Foundations (6)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 200 | Number of Islands | Med | |
| [ ] | 695 | Max Area of Island | Med | |
| [ ] | 130 | Surrounded Regions | Med | |
| [ ] | 417 | Pacific Atlantic Water Flow | Med | |
| [ ] | 934 | Shortest Bridge | Med | |
| [ ] | 1020 | Number of Enclaves | Med | |

> 200 is the single most-asked graph problem in existence. Know DFS, BFS, **and** union-find versions.
>
> **130, 417, and 1020 all use the same inversion:** instead of finding interior regions, start from the *border* and mark what's reachable. That reframing is the lesson — recognize it once and three problems collapse into one.
>
> 934 is DFS to identify one island, then BFS outward — a two-technique composite.

## Multi-Source BFS (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 994 | Rotting Oranges | Med | |
| [ ] | 542 | 01 Matrix | Med | |
| [ ] | 1162 | As Far from Land as Possible | Med | |

> **Seed the queue with all sources, then BFS once.** People run BFS per source and get `O(n²)` — the whole point is that one pass gives every cell its distance to the *nearest* source. If you internalize one thing from this section, it's that.

## BFS on Implicit Graphs (5)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1091 | Shortest Path in Binary Matrix | Med | |
| [ ] | 127 | Word Ladder | Hard | |
| [ ] | 752 | Open the Lock | Med | |
| [ ] | 815 | Bus Routes | Hard | |
| [ ] | 909 | Snakes and Ladders | Med | |

> **The core idea of this section: the graph is never given to you.** Nodes are states (a word, a lock combination, a board square), edges are legal transitions. Building the adjacency lazily is the work.
>
> 127's `O(26 · L)` neighbour generation vs bucketing by wildcard pattern is a real optimization discussion. Also mention **bidirectional BFS** — halves the search frontier, and knowing it exists is a strong signal.
>
> 815 is the one where you must realize the nodes are **routes**, not stops. Getting that wrong makes it impossible; getting it right makes it easy.

## Clone & Basic Graph (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 133 | Clone Graph | Med | |
| [ ] | 399 | Evaluate Division | Med | |

> 133 is the graph version of 138 (Copy List with Random Pointer) — hashmap from old node to new. Same idea, different shape; notice that.
>
> 399 is weighted DFS where edge weights multiply. Also solvable with **weighted union-find**, which is a nice bridge to the next section.

## Topological Sort & Cycle Detection (6)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 207 | Course Schedule | Med | |
| [ ] | 210 | Course Schedule II | Med | |
| [ ] | 802 | Find Eventual Safe States | Med | |
| [ ] | 310 | Minimum Height Trees | Med | |
| [ ] | 269 | Alien Dictionary *(premium)* | Hard | |
| [ ] | 2115 | Find All Possible Recipes from Given Supplies | Med | |

> Know **both** Kahn's (in-degree queue) and DFS with three-colour marking. Kahn's is easier to get right and gives cycle detection for free; DFS is needed when you want the recursion structure.
>
> 310 is topological *peeling from the leaves* — a different mental model worth having.
>
> **269 is the highest-signal problem here.** Deriving the constraint graph from the word list is the hard part, not the sort. If premium-locked, read the problem and solve it on paper.
>
> Directed cycle detection needs a recursion-stack marker; undirected needs parent tracking. **Confusing these is a classic bug** — be deliberate.

## Union-Find (7)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 547 | Number of Provinces | Med | |
| [ ] | 684 | Redundant Connection | Med | |
| [ ] | 721 | Accounts Merge | Med | |
| [ ] | 990 | Satisfiability of Equality Equations | Med | |
| [ ] | 1319 | Number of Operations to Make Network Connected | Med | |
| [ ] | 839 | Similar String Groups | Hard | |
| [ ] | 685 | Redundant Connection II | Hard | |

> Write union-find **once** with path compression **and** union by size, keep it, reuse it. It's 15 lines and it shows up everywhere.
>
> 721 is the most practically-flavoured problem in the block — real-world identity resolution. Know it.
>
> 685 is the directed version and requires case analysis (node with two parents vs cycle vs both). Genuinely hard, occasionally asked at Google. Do it last.
>
> **When union-find over DFS:** dynamic connectivity (edges arriving over time), or when you only need "are these connected" rather than the path.

## Minimum Spanning Tree (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1584 | Min Cost to Connect All Points | Med | |
| [ ] | 1135 | Connecting Cities With Minimum Cost *(premium)* | Med | |

> One problem, two algorithms: solve 1584 with **both** Kruskal (sort edges + union-find) and Prim (heap). Know that Prim wins on dense graphs, Kruskal on sparse. That's the whole MST interview.

## Shortest Path — Dijkstra (5)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 743 | Network Delay Time | Med | |
| [ ] | 1631 | Path With Minimum Effort | Med | |
| [ ] | 778 | Swim in Rising Water | Hard | |
| [ ] | 1514 | Path with Maximum Probability | Med | |
| [ ] | 505 | The Maze II *(premium — else skip)* | Med | |

> 743 is the clean template. Write it once with the **push-duplicate, skip-stale** pattern (Java has no decrease-key — flagged back in the Heaps block).
>
> 1631 and 778 are *modified* Dijkstra where you minimize the **maximum edge** on the path rather than the sum. Both are also solvable with binary search + BFS, or union-find with sorted edges. **Three approaches to the same problem** — this is excellent interview material, because articulating why you'd pick one is exactly the SDE III conversation.
>
> 1514 maximizes a product — negate/invert the comparator and note that Dijkstra needs the relaxation to be monotonic.

## Shortest Path — Bellman-Ford, Floyd-Warshall, 0-1 BFS (4)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 787 | Cheapest Flights Within K Stops | Med | |
| [ ] | 1334 | Find the City With the Smallest Number of Neighbors | Med | |
| [ ] | 1368 | Minimum Cost to Make at Least One Valid Path in a Grid | Hard | |
| [ ] | 1976 | Number of Ways to Arrive at Destination | Med | |

> **787 is the one to get right.** The K-stop constraint makes it Bellman-Ford (relax K+1 rounds) or Dijkstra with state `(node, stops)`. Naive Dijkstra on node alone is *wrong* — understand why, because that's the follow-up.
>
> 1334 is Floyd-Warshall in 5 lines. Know when `O(V³)` is acceptable (small dense graphs, all-pairs needed).
>
> 1368 is **0-1 BFS with a deque** — weight-0 edges push front, weight-1 push back. Beautiful technique, occasionally decisive.
>
> 1976 is Dijkstra plus path counting — combining shortest path with a DP-style count.

## Bipartite / Coloring (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 785 | Is Graph Bipartite? | Med | |
| [ ] | 886 | Possible Bipartition | Med | |

> Same problem twice — 2-colour BFS/DFS, or union-find with the "enemy" set. Do 785 and 886 is nearly free.

## SCC, Bridges, Articulation Points (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1192 | Critical Connections in a Network *(Tarjan bridges)* | Hard | |

> One problem is the right amount. Tarjan's low-link idea (discovery time vs lowest reachable) is the content. Be able to state what Kosaraju does for SCCs without implementing it — that's sufficient at SDE III unless you're targeting a systems-heavy team.

## Eulerian Path (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 332 | Reconstruct Itinerary | Hard | |

> Hierholzer's algorithm. Also the problem where a lexicographic constraint forces a specific edge ordering (min-heap per node). Asked more than its obscurity suggests.

## DAG DP / Memoized DFS (3)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 329 | Longest Increasing Path in a Matrix | Hard | |
| [ ] | 1857 | Largest Color Value in a Directed Graph | Hard | |
| [ ] | 2101 | Detonate the Maximum Bombs | Med | |

> **329 is the bridge between graphs and DP** — memoized DFS on an implicit DAG. If you can explain why memoization is safe here (no cycles, because paths strictly increase), you understand both topics better.
>
> 1857 combines topological order with per-colour DP state. 2101 is a reachability count on a directed graph built from geometry.

## Advanced — Know It Exists (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1466 | Reorder Routes to Make All Paths Lead to the City Zero | Med | |

**Network flow / bipartite matching:** rarely asked at SDE III, but occasionally at Google. Read enough to say: *max-flow min-cut theorem, Ford-Fulkerson with BFS augmenting paths (Edmonds-Karp) is `O(VE²)`, and bipartite matching reduces to max flow.* Do **not** spend a day implementing it. If you want one problem, LC 1349 is a bitmask-DP stand-in.

---

## 11-Day Schedule

| Day | Problems | Done |
|---|---|---|
| 1 | 200, 695, 130, 417, 1020 | [ ] |
| 2 | 934, 994, 542, 1162 | [ ] |
| 3 | 1091, 752, 909, 133 | [ ] |
| 4 | 127, 815, 399 | [ ] |
| 5 | 207, 210, 802, 310 | [ ] |
| 6 | 269, 2115, 547, 684 | [ ] |
| 7 | 721, 990, 1319, 839, 685 | [ ] |
| 8 | 1584, 1135, 743, 1631 | [ ] |
| 9 | 778, 1514, 505, 787 | [ ] |
| 10 | 1334, 1368, 1976, 785, 886 | [ ] |
| 11 | 1192, 332, 329, 1857, 2101, 1466 | [ ] |

Days 1–4 are traversal mechanics and should go fast. Days 8–11 are the heavy ones — expect to slow down and don't panic about it.

---

## Revision

Re-solve **cold** (no notes, from scratch) on:

- **Day 18** — everything marked Hint?, plus 200, 127, 269, 210, 721, 743, 787, 1631, 329
- **Day 32** — same set, plus anything that needed a hint on day 18

---

## Trim to 32 If Pressed

200, 695, 130, 417, 994, 542, 1091, 127, 752, 815, 133, 399, 207, 210, 802, 269, 547, 684, 721, 990, 1319, 1584, 743, 1631, 778, 787, 1334, 1368, 785, 1192, 332, 329

Cut: 1020, 934, 1162, 909, 310, 2115, 839, 685, 1135, 1514, 505, 1976, 886, 1857, 2101, 1466.

---

## Templates Worth Having Memorized

**BFS with level tracking**
```java
Queue<int[]> q = new ArrayDeque<>();
int steps = 0;
while (!q.isEmpty()) {
    int size = q.size();
    for (int i = 0; i < size; i++) {
        int[] cur = q.poll();
        // if target -> return steps
        for (int[] d : DIRS) { /* bounds check, visited check, offer */ }
    }
    steps++;
}
```

**Kahn's topological sort**
```java
int[] indeg = new int[n];
// build graph + indegrees
Queue<Integer> q = new ArrayDeque<>();
for (int i = 0; i < n; i++) if (indeg[i] == 0) q.offer(i);
List<Integer> order = new ArrayList<>();
while (!q.isEmpty()) {
    int u = q.poll(); order.add(u);
    for (int v : adj.get(u)) if (--indeg[v] == 0) q.offer(v);
}
if (order.size() != n) return CYCLE_EXISTS;
```

**Union-Find (path compression + union by size)**
```java
int[] parent, size;
int find(int x) { return parent[x] == x ? x : (parent[x] = find(parent[x])); }
boolean union(int a, int b) {
    int ra = find(a), rb = find(b);
    if (ra == rb) return false;                 // already connected
    if (size[ra] < size[rb]) { int t = ra; ra = rb; rb = t; }
    parent[rb] = ra; size[ra] += size[rb];
    return true;
}
```

**Dijkstra (no decrease-key)**
```java
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
long[] dist = new long[n]; Arrays.fill(dist, Long.MAX_VALUE);
dist[src] = 0; pq.offer(new int[]{src, 0});
while (!pq.isEmpty()) {
    int[] top = pq.poll();
    if (top[1] > dist[top[0]]) continue;        // stale entry — skip
    for (int[] e : adj.get(top[0])) {
        long nd = dist[top[0]] + e[1];
        if (nd < dist[e[0]]) { dist[e[0]] = nd; pq.offer(new int[]{e[0], (int) nd}); }
    }
}
```

---

## Pattern Recognition Check

| Signal in the problem | Approach |
|---|---|
| Count / size of connected regions in a grid | DFS, BFS, or union-find |
| "Regions not touching the border" | Invert — start BFS/DFS **from** the border |
| Distance from every cell to nearest X | Multi-source BFS, all sources seeded first |
| Fewest steps / moves, unweighted | Plain BFS |
| Fewest steps between two words/states | BFS on an implicit state graph |
| Fewest steps, huge search space | Bidirectional BFS |
| Prerequisites, dependencies, ordering | Topological sort (Kahn's or DFS) |
| "Is there a cycle" — directed | DFS + recursion-stack marker, or Kahn's leftover count |
| "Is there a cycle" — undirected | Union-find, or DFS with parent tracking |
| Merge accounts / groups / equivalences | Union-find |
| Edges arriving over time, connectivity queries | Union-find (DFS can't do dynamic) |
| Connect all nodes at minimum total cost | MST — Kruskal or Prim |
| Shortest path, non-negative weights | Dijkstra |
| Shortest path, at most K edges | Bellman-Ford, or Dijkstra on `(node, k)` state |
| Negative weights or negative-cycle detection | Bellman-Ford |
| All-pairs shortest path, small V | Floyd-Warshall |
| Edge weights are only 0 or 1 | 0-1 BFS with a deque |
| Minimize the **maximum** edge on a path | Modified Dijkstra, binary search + BFS, or sorted union-find |
| Two-group partition with conflicts | Bipartite 2-colouring, or union-find |
| Edges whose removal disconnects the graph | Tarjan bridges |
| Use every edge exactly once | Eulerian path — Hierholzer |
| Longest path in a grid/DAG | Memoized DFS (DAG DP) |
| Weights multiply instead of add | Dijkstra with inverted comparator, or log-transform |

---

## Java Notes

- **No decrease-key in `PriorityQueue`.** Push duplicates and skip stale pops (`if (d > dist[u]) continue;`). Same note as Heaps — this is where it pays off.
- Use `long` for distance accumulators in 787, 743, 1976. `int` overflow on summed weights is a silent wrong answer.
- `List<List<Integer>>` adjacency is fine and readable; `int[][]` with an offset array is faster if the interviewer is counting constants.
- Grid directions: `static final int[][] DIRS = {{0,1},{1,0},{0,-1},{-1,0}};` — write it once, reuse. Add diagonals for 1091.
- Recursion depth on a 10⁵-node graph will overflow the stack. For DFS-heavy problems, either say you'd convert to iterative or use BFS.
- Mark visited **when you enqueue**, not when you dequeue. Marking on dequeue lets duplicates into the queue and can blow memory.
- `Arrays.fill(dist, Integer.MAX_VALUE)` then adding a weight overflows. Use `Long.MAX_VALUE / 2` or check before adding.

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
| **Graphs** | **48** | **✔ list built** |
| DP | 58 | |
| Backtracking | 15 | |
| Bit / math | 16 | |
| Design | 12 | |

**Running total: 265 / ~360.**

---

## Addendum — Final Coverage Audit

Five outline items not explicitly covered. **All conceptual — no new problems needed.** The 48-problem list stands.

### A* search (conceptual)

Dijkstra with a heuristic. Instead of prioritizing by `dist[node]`, prioritize by `dist[node] + h(node)` where `h` estimates the remaining distance to the target.

- **Admissible heuristic** = never overestimates → A* still finds the optimal path
- **Consistent/monotone heuristic** → no node needs reprocessing
- `h = 0` reduces A* exactly to Dijkstra
- Typical heuristics: Manhattan distance on a grid with 4-way movement, Euclidean with any-angle movement

**What to say if asked:** *"A* is Dijkstra with an admissible heuristic that biases exploration toward the goal. Same optimality guarantee, far fewer nodes expanded when the heuristic is good. It's what pathfinding in games and routing engines use."* That's the full expected answer. 1091 (Shortest Path in Binary Matrix) is where you'd mention it as an optimization over plain BFS.

### Articulation points (conceptual — you already have bridges)

Same Tarjan low-link machinery as 1192, different condition:

- **Bridge:** edge `(u, v)` where `low[v] > disc[u]` — removing the edge disconnects the graph
- **Articulation point:** vertex `u` where some child `v` has `low[v] >= disc[u]` — removing the vertex disconnects the graph
- **Root special case:** the DFS root is an articulation point iff it has more than one DFS child

Since you're implementing 1192, add the vertex condition as a five-line variant in the same function. No separate problem exists on LeetCode; being able to state both conditions from the same DFS is enough.

**Where it matters in practice:** single points of failure in a network topology — directly relevant to your system design prep on redundancy.

### All topological orderings (conceptual)

Kahn's gives *one* valid ordering. To enumerate **all** of them, it's backtracking over the in-degree-zero set: at each step, try every currently-available node, recurse, then undo.

Exponential output, so it's only ever asked for tiny inputs. **The lexicographically smallest ordering** is the practical variant, and it's Kahn's with a **min-heap** instead of a queue — that swap is worth knowing, because it's a one-word change to your template that answers a common follow-up.

### DAG shortest path via topological order

For a DAG, you don't need Dijkstra. Process vertices in topological order and relax edges once each — `O(V + E)`, and it works with **negative weights** (unlike Dijkstra) because a topological order guarantees you finalize each node before using it.

You're already doing this implicitly in 329 and 1857 (memoized DFS on a DAG). Worth being able to state explicitly: *"the graph is a DAG, so topological order plus one relaxation pass beats Dijkstra and tolerates negative edges."*

### Currency arbitrage (the disguised-graph classic)

The outline's "graph problems disguised as... currency arbitrage" — worth having ready because it's a favourite senior-round framing.

**Setup:** currencies are nodes, exchange rates are edge weights. Arbitrage exists if you can cycle back to your starting currency with more than you began — i.e. a cycle whose rate product exceeds 1.

**The trick:** Bellman-Ford minimizes *sums*, not products. Take `-log(rate)` as the edge weight. Then a product > 1 becomes a sum < 0, so **arbitrage is exactly a negative cycle**, which Bellman-Ford detects in `O(VE)` by checking whether any edge still relaxes after `V-1` rounds.

You already implement Bellman-Ford for 787. The log transform is the insight, and it generalizes: **whenever weights multiply instead of add, take logs.** Same idea as 1514 (Path with Maximum Probability) in your Dijkstra section — mention the connection.

**Count unchanged: 48 problems.** Everything above is reading and small extensions to problems already on the list.
