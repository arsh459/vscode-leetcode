# DBMS — Topic Index

Reference checklist. Tick a row when you can **explain it out loud**, not when you've read it.

**★** = must know · **★★** = highest yield, expect it to be asked

> **Scope:** database *internals and theory*. Replication, sharding, CAP, NoSQL selection,
> connection pooling, and JPA/N+1 are **not** here — system design and Spring Boot tracks.

[← index](README.md) · [1 Foundations](#1-foundations--the-relational-model) · [2 Relational Algebra](#2-relational-algebra--calculus) · [3 SQL](#3-sql) · [4 Normalization](#4-normalization) · [5 Indexing](#5-indexing--file-organization) · [6 Query Processing](#6-query-processing--optimization) · [7 Transactions](#7-transactions--recovery) · [8 Concurrency](#8-concurrency-control) · [9 Storage](#9-storage--performance-internals) · [10 Drills](#10-hands-on-drills)

---

## 1. Foundations & the Relational Model

### 1.1 Database basics

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | | What a DBMS is; DBMS vs file system | |
| [ ] | ★ | Three-schema architecture | Physical, logical, view — and *data independence* |
| [ ] | | Data models | Relational, hierarchical, network, object, document |
| [ ] | | DBMS architecture | 1-tier, 2-tier, 3-tier |
| [ ] | | Schema vs instance | |
| [ ] | | DDL / DML / DCL / TCL | Warm-up question |
| [ ] | | Database users and the DBA role | |

### 1.2 The relational model

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | | Relation, tuple, attribute, domain, degree, cardinality | Vocabulary |
| [ ] | ★ | Relational integrity constraints | Domain, key, entity integrity, referential integrity |
| [ ] | ★ | Super key, candidate key, primary key | |
| [ ] | | Alternate key, composite key | |
| [ ] | ★ | Foreign key, referential actions | `CASCADE`, `SET NULL`, `RESTRICT`, `NO ACTION` |
| [ ] | ★ | Surrogate vs natural key | Why surrogate usually wins |
| [ ] | ★★ | NULL semantics / three-valued logic | `NULL = NULL` is not true |
| [ ] | ★ | Why `NOT IN` returns nothing with a NULL in the subquery | The classic NULL trap |

### 1.3 ER modeling

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | Entity, entity set, **weak entity** | Weak entity needs an identifying relationship |
| [ ] | | Attribute types | Simple, composite, multivalued, derived, key |
| [ ] | | Relationship type, relationship set, degree | Unary, binary, ternary |
| [ ] | ★★ | Cardinality ratios | 1:1, 1:N, M:N |
| [ ] | ★ | Participation constraints | Total vs partial |
| [ ] | | Generalization, specialization, aggregation | |
| [ ] | ★★ | **ER → relational schema conversion** | The most-asked ER exercise |
| [ ] | ★ | Junction / associative tables | How M:N becomes two 1:N |
| [ ] | | Enhanced ER (EER) notation | |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | Why does `NOT IN` return zero rows when the subquery contains a NULL? |
| [ ] | Convert an M:N relationship that has its own attributes into tables. Where do the attributes go? |
| [ ] | Super key vs candidate key vs primary key — precisely. |

---

## 2. Relational Algebra & Calculus

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | Selection σ, projection π, rename ρ | |
| [ ] | ★ | Union, set difference, intersection | Union-compatibility requirement |
| [ ] | ★ | Cartesian product × | |
| [ ] | ★★ | Joins — theta, equi, natural | |
| [ ] | ★ | Outer joins — left, right, full | |
| [ ] | ★ | **Division ÷** | The "for all" operator |
| [ ] | | Generalized projection, aggregate operators | |
| [ ] | | Assignment, and expression trees | |
| [ ] | | Tuple relational calculus (TRC) | Declarative counterpart; know it exists |
| [ ] | | Domain relational calculus (DRC) | |
| [ ] | ★ | Why it matters | It's what the planner manipulates when it rewrites your SQL → §6 |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | Express "students enrolled in *every* course" in relational algebra. → [answer](#answer-keys) |
| [ ] | Which relational algebra operators are primitive, and which are derived? |

---

## 3. SQL

### 3.1 Core

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | DDL — `CREATE`, `ALTER`, `DROP`, `TRUNCATE` | `TRUNCATE` vs `DELETE` vs `DROP` |
| [ ] | ★ | Constraints | `NOT NULL`, `UNIQUE`, `CHECK`, `DEFAULT`, PK, FK |
| [ ] | ★ | DML — `INSERT`, `UPDATE`, `DELETE`, upsert | |
| [ ] | ★★ | **Logical query processing order** | `FROM` → `WHERE` → `GROUP BY` → `HAVING` → `SELECT` → `ORDER BY` → `LIMIT`. Explains most alias and aggregate errors |
| [ ] | | `WHERE` operators | `BETWEEN`, `LIKE`, `IN`, `IS NULL` |
| [ ] | | `ORDER BY`, `LIMIT`/`OFFSET`, `DISTINCT` | |
| [ ] | ★ | Aggregate functions | `COUNT(*)` vs `COUNT(col)` with NULLs |
| [ ] | ★★ | `GROUP BY` vs `HAVING` | `WHERE` filters rows, `HAVING` filters groups |
| [ ] | ★★ | Joins in SQL — inner, left, right, full, cross, self | |
| [ ] | ★ | Set operations | `UNION` vs `UNION ALL`, `INTERSECT`, `EXCEPT` |

### 3.2 Advanced

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | Subqueries — scalar, row, table, **correlated** | |
| [ ] | ★★ | `EXISTS` vs `IN` vs `JOIN` | Semantics, NULL behaviour, and which is faster when |
| [ ] | ★ | CTEs (`WITH`) and recursive CTEs | |
| [ ] | ★★ | **Window functions** | `ROW_NUMBER`, `RANK`, `DENSE_RANK`, `NTILE`, `LAG`/`LEAD` |
| [ ] | ★★ | `PARTITION BY` and the frame clause | `ROWS`/`RANGE BETWEEN` |
| [ ] | | `CASE`, `COALESCE`, `NULLIF` | |
| [ ] | ★ | Views | Stored query; updatable views and their limits |
| [ ] | ★ | Materialized views | Stored *result*; refresh strategies |
| [ ] | | Stored procedures and functions | |
| [ ] | | Triggers | Mostly: why teams avoid them |
| [ ] | | Cursors | And why set-based beats row-by-row |
| [ ] | | `GRANT` / `REVOKE` | |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | Why can't `WHERE` reference an aggregate? Answer from the processing order, not memory. |
| [ ] | "Second-highest salary per department" — two ways: window function and correlated subquery. |
| [ ] | `UNION` vs `UNION ALL` — which is faster and why? |
| [ ] | View vs materialized view — which speeds up a slow query, and why doesn't the other? |

---

## 4. Normalization

### 4.1 Functional dependency theory

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | Functional dependency `X → Y` | |
| [ ] | | Trivial vs non-trivial FDs | |
| [ ] | ★ | Full vs partial dependency | |
| [ ] | ★ | Transitive dependency | |
| [ ] | ★ | Armstrong's axioms | Reflexivity, augmentation, transitivity (+ union, decomposition, pseudo-transitivity) |
| [ ] | ★★ | **Attribute closure `X⁺`** | How you actually compute candidate keys |
| [ ] | ★★ | **Finding all candidate keys from an FD set** | The most-asked exercise in this area |
| [ ] | ★ | Prime vs non-prime attributes | |
| [ ] | ★ | Canonical / minimal cover | |
| [ ] | | Equivalence of two FD sets | |

### 4.2 Normal forms

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | Insert, update, delete anomalies | The reason normalization exists |
| [ ] | ★ | 1NF | Atomic attributes |
| [ ] | ★ | 2NF | No partial dependency on a candidate key |
| [ ] | ★★ | 3NF | No transitive dependency; or the RHS is prime |
| [ ] | ★★ | BCNF | Every determinant is a superkey |
| [ ] | ★ | 4NF and multivalued dependencies | |
| [ ] | | 5NF and join dependencies | Know the name |
| [ ] | ★★ | **Lossless join decomposition** | Binary case: `R1∩R2 → R1` or `R1∩R2 → R2` in `F⁺` — the shared attributes must be a **superkey** of one side |
| [ ] | ★★ | **Dependency preservation** | |
| [ ] | ★ | 3NF vs BCNF tradeoff | 3NF is always achievable lossless *and* dependency-preserving; BCNF may not be both |
| [ ] | ★★ | **Deliberate denormalization** | When it's correct, not a failure |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | `R(A,B,C,D)` with `A→B, B→C`. Find all candidate keys. Show the closure computation. |
| [ ] | What problem does 3NF solve, and what does it cost at read time? |
| [ ] | Why can a BCNF decomposition fail to preserve dependencies? What do you do about it? |
| [ ] | State the lossless-join condition precisely. |

---

## 5. Indexing & File Organization

### 5.1 File organization

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | Pages / blocks — the physical unit of I/O | |
| [ ] | ★ | Heap file vs sorted file | |
| [ ] | | Tuple layout, slotted pages, row headers | |
| [ ] | ★ | Static hashing | Bucket overflow |
| [ ] | ★ | Dynamic / extendible hashing | |
| [ ] | ★ | Row-oriented vs column-oriented | OLTP vs OLAP; why columnar compresses better |

### 5.2 Index structures

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | Index basics — search key, index entry, ordered index | |
| [ ] | ★ | **Dense vs sparse index** | Sparse needs one entry per *page* — why a clustered index can be sparse |
| [ ] | ★ | Primary vs secondary index | |
| [ ] | ★★ | **Clustered vs non-clustered** | InnoDB clusters on the PK. **Postgres has no clustered index at all** — `CLUSTER` is a one-time reorder that decays on the next update |
| [ ] | | Multilevel index | The step before a B-tree |
| [ ] | ★ | B-tree | |
| [ ] | ★★ | **B+tree structure** | High fan-out, shallow depth, leaf-linked for range scans |
| [ ] | ★★ | **Why B+tree, not BST or hash, for disk** | Node = page; give the real reason, not "shallower" |
| [ ] | ★ | B+tree insertion and deletion | Node split, merge, redistribution |
| [ ] | ★ | **Page splits, fill factor, index fragmentation** | The mechanism behind the UUIDv4 problem in §5.4 |
| [ ] | ★ | Hash index | Equality only, no range |
| [ ] | ★ | Bitmap index | Low-cardinality columns in OLAP |
| [ ] | | Partial / filtered index | |
| [ ] | | Full-text / inverted index | |
| [ ] | | Spatial index — R-tree | Know the name |

### 5.3 Using indexes well

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | **Composite index and the leftmost prefix rule** | The most-asked indexing question |
| [ ] | ★★ | Covering index / index-only scan | |
| [ ] | ★★ | Cardinality and selectivity | Why an index on a boolean is near-useless |
| [ ] | ★★ | **When an index hurts** | Write amplification, insert cost, storage, planner confusion |
| [ ] | ★★ | Why a function on an indexed column kills it | `WHERE YEAR(created) = 2026`; expression indexes as the fix |
| [ ] | ★ | Implicit type cast defeating an index | |
| [ ] | ★ | Index column order vs `ORDER BY` | When an index also removes the sort |

### 5.4 Key choice

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | Auto-increment vs UUIDv4 vs UUIDv7/ULID | |
| [ ] | ★★ | Why a random PK degrades clustered inserts | State it via page splits, not "it's slower" |
| [ ] | ★ | DB constraint vs application validation | Where a rule belongs |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | Index on `(a, b, c)`. Which queries use it: filter on `a`; on `b`; on `a` and `c`; on `a` and `b`? Why? |
| [ ] | 10M rows, `status` with 3 distinct values. Index it? What changes your answer? |
| [ ] | Why is a B+tree better than a balanced BST for a disk-backed index? The real reason. |
| [ ] | Write throughput dropped after adding three indexes. Explain the mechanism. |
| [ ] | Why does a random UUID primary key degrade insert performance on a clustered index? |
| [ ] | Your uniqueness check in application code has a race. What's the fix? → [answer](#answer-keys) |

---

## 6. Query Processing & Optimization

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | Query processing pipeline | Parse → rewrite → optimize → execute |
| [ ] | | Query tree / logical plan | |
| [ ] | ★★ | **Reading `EXPLAIN` / `EXPLAIN ANALYZE`** | Estimated vs actual rows is *the* signal |
| [ ] | ★★ | Scan types | Sequential, index, index-only, bitmap heap |
| [ ] | ★ | Why a sequential scan is sometimes *correct* | Selectivity and random-I/O cost |
| [ ] | ★★ | **Join algorithms** | Nested loop, block nested loop, index nested loop, sort-merge, hash join — and when each is picked |
| [ ] | ★ | Join order and its search space | |
| [ ] | | Rewrite stage | Predicate pushdown, subquery flattening, view inlining |
| [ ] | ★ | Cost-based optimization | The I/O + CPU cost model |
| [ ] | ★★ | Statistics — histograms, `n_distinct`, MCVs | |
| [ ] | ★ | `ANALYZE`, autoanalyze, stale statistics | Why stale stats cause bad plans |
| [ ] | ★ | Column correlation and misestimation | Why two predicates aren't independent |
| [ ] | ★★ | **Sorting — in-memory vs external merge sort** | |
| [ ] | ★★ | `work_mem`, hash-aggregate spill | Why a plan degrades non-linearly with data size |
| [ ] | | Materialization vs pipelining | |
| [ ] | ★★ | Common causes of slow queries | Missing index, function on column, implicit cast, `SELECT *`, spilling sort, stale stats |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | When would a planner correctly choose a sequential scan over an available index? |
| [ ] | Walk through diagnosing a slow query, in order. |
| [ ] | `EXPLAIN ANALYZE` shows estimated rows = 10, actual = 400,000. What does that mean, and the two usual causes? |
| [ ] | A query is fine at 10k rows and 40× slower at 100k with the same plan shape. What changed? |
| [ ] | Nested loop vs hash join — when does the planner pick each? |

---

## 7. Transactions & Recovery

### 7.1 Transactions

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | Transaction concept and states | Active, partially committed, committed, failed, aborted |
| [ ] | ★★ | **ACID** | Be precise about what C actually means, and who enforces it |
| [ ] | ★ | `COMMIT`, `ROLLBACK`, `SAVEPOINT` | |
| [ ] | | Autocommit and implicit transactions | |

### 7.2 Recovery

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | **Write-ahead logging (WAL)** | Why log-first gives durability *and* atomicity |
| [ ] | ★ | Log record structure, LSN | |
| [ ] | ★★ | **Redo vs undo** | And why you need both |
| [ ] | ★ | Deferred vs immediate database modification | |
| [ ] | ★★ | **Checkpointing** | Bounds recovery time; causes periodic I/O spikes |
| [ ] | ★★ | Crash recovery walkthrough | |
| [ ] | ★ | ARIES (conceptual) | Analysis → redo → undo |
| [ ] | | Shadow paging | The alternative nobody uses |
| [ ] | ★★ | `fsync`, group commit, why durability costs latency | Same idea as OS §7 |
| [ ] | ★ | Backup types and **PITR** | Full/incremental/differential; replay WAL onto a base backup |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | Which of ACID does the database enforce, and which is really the application's job? |
| [ ] | How does WAL give you both durability and crash recovery? Why not just write the data pages? |
| [ ] | What does a checkpoint do, and why does it cause a latency spike? |
| [ ] | How does point-in-time recovery work, and what must you have retained? |

> **Cross-link:** the filesystem journal (OS §7) and the database WAL solve the same problem with the
> same technique — durably record the intent before mutating in place.

---

## 8. Concurrency Control

### 8.1 Anomalies and isolation levels

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | Lost update | |
| [ ] | ★★ | Dirty read | |
| [ ] | ★★ | Non-repeatable read | |
| [ ] | ★★ | Phantom read | |
| [ ] | ★★ | **Write skew** | The anomaly snapshot isolation allows and people forget |
| [ ] | ★ | Read skew | |
| [ ] | ★★ | Isolation levels | Read Uncommitted, Read Committed, Repeatable Read, Serializable |
| [ ] | ★★ | **The level × anomaly matrix** | Build the 4×4 from memory. That artifact is what gets asked for |
| [ ] | ★★ | **How RC and RR actually differ** | RC takes a new snapshot *per statement*; RR takes one *per transaction*. Every anomaly difference falls out of this |
| [ ] | ★ | Engine defaults | Postgres: Read Committed. MySQL InnoDB: Repeatable Read |
| [ ] | ★★ | Snapshot isolation ≠ serializable | Write skew is the proof |
| [ ] | ★ | Serializable Snapshot Isolation (SSI) | What Postgres does at Serializable; aborts on dangerous structures |

### 8.2 Serializability theory

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | Schedules — serial, non-serial, complete | |
| [ ] | ★★ | Conflicting operations | Same data item, different transactions, at least one write |
| [ ] | ★★ | **Conflict serializability** | |
| [ ] | ★★ | **Precedence graph and the cycle test** | Cycle ⇒ not conflict-serializable |
| [ ] | ★ | View serializability | Strictly broader; NP-hard to test — know that and move on |
| [ ] | ★ | Recoverable schedules | Commit only after every transaction you read from has committed |
| [ ] | ★★ | Cascadeless schedules, cascading rollback | Why dirty reads are dangerous beyond being wrong |
| [ ] | ★ | Strict schedules | |
| [ ] | | Blind writes | |

### 8.3 Protocols

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | Lock modes — shared, exclusive, update | The compatibility matrix |
| [ ] | ★ | Lock granularity — row, page, table | And lock escalation |
| [ ] | ★★ | **Gap locks / next-key locks** | Why MySQL RR blocks phantom inserts |
| [ ] | ★★ | **Two-phase locking (2PL)** | Growing and shrinking phases |
| [ ] | ★ | Strict 2PL, rigorous 2PL, conservative 2PL | Which guarantees cascadelessness |
| [ ] | ★★ | **MVCC** | How readers avoid blocking writers — the most important idea here |
| [ ] | ★★ | **MVCC garbage collection** | Postgres: dead tuples + `VACUUM`. InnoDB: undo log + purge thread |
| [ ] | ★★ | Table and index bloat | When `VACUUM` can't keep up, or a long transaction holds back the horizon |
| [ ] | ★ | Transaction ID wraparound | Why Postgres eventually refuses writes if autovacuum is broken |
| [ ] | ★★ | Optimistic vs pessimistic locking | The failure mode of each |
| [ ] | ★ | Validation-based / OCC phases | Read, validation, write |
| [ ] | ★ | Timestamp ordering protocol | |
| [ ] | | Thomas write rule | |
| [ ] | | Multiple granularity locking, intention locks | |
| [ ] | ★★ | **Locking reads** | `FOR UPDATE`, `FOR SHARE`, **`FOR UPDATE SKIP LOCKED`** — how you build a job queue in SQL |

### 8.4 Deadlocks

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | Deadlock conditions in a DB context | |
| [ ] | ★★ | **Wait-for graph and cycle detection** | |
| [ ] | ★★ | Victim selection and rollback | |
| [ ] | ★ | Prevention — wait-die, wound-wait | Timestamp-based, break circular wait |
| [ ] | ★ | Lock timeouts | |
| [ ] | ★★ | Reducing deadlocks in application code | Consistent lock ordering, shorter transactions, smaller scope |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | Give a concrete write-skew example. → [answer](#answer-keys) |
| [ ] | Derive, from the snapshot rule alone, why RC permits non-repeatable reads and RR doesn't. |
| [ ] | Why doesn't MySQL's Repeatable Read suffer phantom reads the way the standard says it should? |
| [ ] | Explain MVCC to someone who knows nothing about databases. |
| [ ] | If readers never block writers, what happens to old row versions? What goes wrong when they aren't reclaimed? |
| [ ] | A reporting query has been open six hours. Why does that bloat an unrelated, heavily-updated table? |
| [ ] | Given a schedule over three transactions, build the precedence graph and decide conflict-serializability. |
| [ ] | Two transactions deadlock. What does the DB do, and what should the application do? |
| [ ] | Build a work queue where ten workers never hand out the same row twice. |

---

## 9. Storage & Performance Internals

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | **Buffer pool / shared buffers** | The database's own page cache |
| [ ] | ★ | Buffer replacement policy | LRU, LRU-K, clock sweep; why naive LRU fails under a big scan |
| [ ] | ★ | Dirty pages, background writer, flushing | |
| [ ] | ★★ | Working set fitting in memory — the performance cliff | |
| [ ] | ★ | Interaction with the OS page cache; `O_DIRECT` | Double buffering |
| [ ] | ★★ | **LSM tree vs B-tree** | Write-optimized vs read-optimized |
| [ ] | ★★ | Compaction; write / read / space amplification | The cost LSM pays |
| [ ] | ★ | Memtable, SSTables, bloom filters | |
| [ ] | ★ | Columnar compression | Run-length, dictionary, delta |
| [ ] | ★★ | **Table partitioning** | Range, list, hash; partition pruning |
| [ ] | ★ | Sequential vs random I/O | Still true on SSDs, less dramatic |
| [ ] | ★ | OLTP vs OLAP vs HTAP | |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | Query is fast most of the time, occasionally 50× slower. Buffer pool explanation? |
| [ ] | Why does an LSM tree give better write throughput than a B-tree? What does it cost? |
| [ ] | Why does adding RAM help a database more than adding CPU, up to a point? |
| [ ] | Why does a database maintain its own buffer pool when the OS already has a page cache? |

---

## 10. Hands-on Drills

Twenty minutes of each beats two hours of reading. Tick when actually run.

| ✔ | ★ | Drill | What you should see |
|---|---|---|---|
| [ ] | ★★ | Build a ~1M row table. Query, `EXPLAIN ANALYZE`, add index, re-run | Seq Scan → Index Scan, and the row-estimate line |
| [ ] | ★ | `EXPLAIN ANALYZE` a query that sorts more than `work_mem` | `external merge Disk: …` in the plan |
| [ ] | ★★ | Two `psql` sessions: non-repeatable read at Read Committed, then the same interleaving at Repeatable Read | The snapshot rule, made visible |
| [ ] | ★★ | Same two sessions: a phantom, then **write skew** at Repeatable Read | Two rows, each transaction checking the other |
| [ ] | ★★ | Repeat the write skew at Serializable | A serialization failure instead of a wrong result |
| [ ] | ★ | Force a deadlock — two rows, updated in opposite order | Read the exact error the loser gets |
| [ ] | ★ | `SELECT … FOR UPDATE SKIP LOCKED` from both sessions | Disjoint row sets |
| [ ] | ★ | Update a table in a loop, then check `pg_stat_user_tables` | Dead tuples accumulating, then `VACUUM` reclaiming |
| [ ] | | Compare `COUNT(*)` on a heap vs a covering index | Index-only scan |

---

## Resources

- **Designing Data-Intensive Applications** — ch. 3 (storage engines), ch. 7 (transactions). Read both twice.
- **Use The Index, Luke** (free online) — best indexing resource that exists. The composite-index section alone is worth an hour.
- **Postgres docs** — `EXPLAIN`, and routine vacuuming. The clearest statement of why MVCC needs a garbage collector.
- **GfG DBMS tutorial** — strong on §1–§4 and §8.2, the classical exam-shaped material. Thin on §6 and §9; use DDIA and the Postgres docs there.

---

## Answer Keys

Kept out of the checks so re-reading stays retrieval, not recognition.

- **§2, "every course":** relational division. Notice how awkward the SQL equivalent is — a double `NOT EXISTS`.
- **§5, uniqueness race:** a `UNIQUE` constraint. Only the database can enforce it atomically; check-then-insert in application code always has a window.
- **§8, write skew:** two doctors on call. Each transaction checks that *another* doctor is on call, sees the other, and goes off duty. Both commit; nobody is on call. No row was written twice, so no write-write conflict was ever detected.
