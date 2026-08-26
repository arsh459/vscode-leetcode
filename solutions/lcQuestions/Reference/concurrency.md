# Concurrency-Flavored DSA (Java) — SDE III Prep (Final List)

**9 LeetCode problems + 4 from-scratch exercises · 3 days**

Tick the checkbox when solved. Mark the **Hint?** column if you needed help — those get re-solved first.

> **This was the largest gap in the plan, and it matters most for you specifically.** You're interviewing as a Java backend developer at SDE III. Concurrency questions are near-certain — either as a coding problem, as a follow-up to a design problem (*"now make this thread-safe"*), or in the Java depth round.
>
> **What's actually being tested:** not whether you can write a clever algorithm, but whether you reason correctly about **shared mutable state**. Can you identify the critical section? Do you know why `volatile` isn't a lock? Do you avoid busy-waiting? Do you use the right primitive rather than reaching for `synchronized` on everything?
>
> LeetCode's concurrency section is small and slightly artificial, but it's the only structured practice available, and the four from-scratch exercises at the end are closer to what you'll actually be asked.

---

## Ordering & Signalling (4)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1114 | Print in Order | Easy | |
| [ ] | 1115 | Print FooBar Alternately | Med | |
| [ ] | 1116 | Print Zero Even Odd | Med | |
| [ ] | 1195 | Fizz Buzz Multithreaded | Med | |

> **Start with 1114 and solve it three ways** — `Semaphore`, `CountDownLatch`, and `synchronized` + `wait`/`notifyAll`. Same problem, three primitives; comparing them is how you learn which is idiomatic.
>
> 1115 is strict alternation between two threads. The clean answer is two semaphores, one initialized to 1 and one to 0 — a **binary semaphore ping-pong**. This pattern generalizes to producer-consumer.
>
> 1116 extends to three threads with a state condition. 1195 to four. Both are the same shape; once 1115 clicks, these are fast.
>
> **The anti-pattern to avoid:** a `while (!myTurn) {}` spin loop. It passes on LeetCode and would be rejected in a real review. If you catch yourself busy-waiting, that's the signal you need a condition variable or semaphore.

## Bounded Buffer / Producer-Consumer (1)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1188 | Design Bounded Blocking Queue *(premium)* | Med | |

> **The single most likely concurrency problem to appear in a real interview.** If premium-locked, implement it from scratch anyway — it's exercise #1 below.
>
> Three ways to write it, in increasing sophistication:
> 1. `synchronized` + `wait()` / `notifyAll()` — always use `notifyAll`, and always wait in a `while` loop (spurious wakeups)
> 2. `ReentrantLock` + two `Condition` objects (`notFull`, `notEmpty`) — strictly better, because you signal only the threads that can make progress
> 3. Two `Semaphore`s (`emptySlots`, `filledSlots`) + a lock for the structure
>
> Being able to explain why version 2 beats version 1 — `notifyAll` wakes every waiter including ones that will immediately re-block, causing a thundering herd — is a genuine senior-level answer.

## Classic Synchronization Problems (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1117 | Building H2O | Med | |
| [ ] | 1226 | The Dining Philosophers | Med | |

> 1117 is a **barrier** problem — two hydrogen and one oxygen must group before any proceed. Solvable with semaphores plus a `CyclicBarrier`, or with careful counting. It's the cleanest introduction to "wait until a group condition holds."
>
> **1226 is the deadlock problem**, and it's the one worth real time because deadlock comes up in the OS fundamentals round too. Know at least two solutions and why each breaks a deadlock condition:
>
> | Solution | Condition broken |
> |---|---|
> | Order the forks (always take lower-numbered first) | Circular wait |
> | Limit to N-1 concurrent diners (semaphore) | Hold and wait |
> | `tryLock` with timeout and release-on-failure | No preemption |
>
> Being able to name **Coffman's four conditions** (mutual exclusion, hold and wait, no preemption, circular wait) and say which your fix eliminates is exactly the crossover between this block and your OS prep.

## Applied Concurrency (2)

| ✔ | # | Problem | Diff | Hint? |
|---|---|---|---|---|
| [ ] | 1242 | Web Crawler Multithreaded *(premium)* | Med | |
| [ ] | 1279 | Traffic Light Controlled Intersection | Easy | |

> **1242 is the most realistic problem in the block** — a thread pool, a concurrent visited set, work distribution, and knowing when to shut down. Uses `ExecutorService`, `ConcurrentHashMap.newKeySet()`, and either `CompletableFuture` or a `CountDownLatch`/`Phaser` for completion detection.
>
> The termination question (*"how do you know when all work is done, given workers can create more work?"*) is genuinely hard and genuinely asked. Options: an `AtomicInteger` of outstanding tasks, a `Phaser`, or `ForkJoinPool` with `RecursiveAction`.
>
> If premium-locked, build it against a stub — it's worth the time regardless.
>
> 1279 is a straightforward single-lock state machine. Fast.

---

## Four From-Scratch Exercises

No LeetCode problem exists for these, and **they're closer to what you'll actually be asked** than anything above. Write each as a complete, compiling class with a small test harness.

### Exercise 1 — Bounded Blocking Queue

Implement `put(T)` and `take()` with a fixed capacity. Write it **twice**: once with `synchronized`/`wait`/`notifyAll`, once with `ReentrantLock` + two `Condition`s.

**Be ready to answer:**
- Why `while (full) wait()` and not `if (full) wait()`? *(spurious wakeups, and the condition may be re-falsified between notify and reacquire)*
- Why `notifyAll` and not `notify` in version 1? *(with mixed producers and consumers, `notify` can wake the wrong kind of waiter and deadlock)*
- What does the `Condition` version buy you? *(targeted signalling — no thundering herd)*
- How would you make it fair? *(`new ReentrantLock(true)` — and know it costs throughput)*

### Exercise 2 — Thread-Safe LRU Cache

Take your 146 solution and make it concurrent. This is the **most common "now make it thread-safe" follow-up in existence**, because 146 is the most common design problem.

**Progression to walk through out loud:**
1. `synchronized` on every method — correct, but serializes all reads
2. `ReentrantReadWriteLock` — better for read-heavy workloads, *but* note that `get()` mutates the recency list, so it's actually a write. This realization is the interesting part.
3. Segment/shard the cache by key hash, lock per segment — this is what `ConcurrentHashMap` did pre-Java 8
4. Mention what production systems do: Caffeine uses lock-free reads with a write-ahead buffer and amortized eviction, accepting approximate LRU for throughput

**The senior answer is #4's reasoning**: strict LRU ordering under concurrency requires serialization, so real caches trade exactness for throughput. Say that.

### Exercise 3 — Read-Write Lock (from scratch)

Implement a reader-writer lock with `readLock()`, `readUnlock()`, `writeLock()`, `writeUnlock()` using only `synchronized` and `wait`/`notifyAll`.

**Be ready to discuss:**
- Reader preference vs writer preference, and **writer starvation**
- How you'd make it fair (queue waiting writers, block new readers behind them)
- Why `ReentrantReadWriteLock` exists and when a plain `ReentrantLock` is actually faster *(short critical sections — the RW bookkeeping overhead dominates)*
- `StampedLock` and optimistic reads (Java 8+) as the modern alternative

### Exercise 4 — Lock-Free Counter and Rate Limiter

**Counter:** implement with `AtomicInteger` using a CAS retry loop, then compare to `synchronized` and to `LongAdder`. Know that `LongAdder` beats `AtomicLong` under high contention because it shards into per-thread cells and sums on read.

**Rate limiter:** implement a **token bucket** that's thread-safe. This is the direct crossover with 362 (Design Hit Counter) from your Design block and with rate limiting in your system design prep.

**Be ready to discuss:**
- What CAS is, and the **ABA problem** (`AtomicStampedReference` as the fix)
- Why lock-free ≠ wait-free
- When CAS retry loops perform *worse* than a lock (high contention — the retries burn CPU)

---

## 3-Day Schedule

| Day | Problems | Done |
|---|---|---|
| 1 | 1114 *(three ways)*, 1115, 1116, 1195, 1279 | [ ] |
| 2 | 1117, **1226**, Exercise 1 *(bounded queue, both versions)* | [ ] |
| 3 | 1242, Exercise 2 *(thread-safe LRU)*, Exercises 3–4 | [ ] |

Day 3 is heavy — split it if needed. Exercise 2 is the highest-value item on the whole page; don't let it get squeezed.

---

## Revision

Re-solve **cold** on:

- **Day 10** — 1115, 1226, Exercise 1, Exercise 2
- **Day 24** — same set

Exercises 1 and 2 specifically. Those are the two you're most likely to be asked to produce live.

---

## Trim to 5 If Pressed

1114, 1115, 1226, **Exercise 1**, **Exercise 2**

Cut everything else. The two exercises matter more than any five LeetCode concurrency problems.

---

## Java Concurrency Reference — Know These Cold

This is the Java-depth-round material, and it overlaps almost entirely with this block.

### Memory model

| Concept | What to be able to say |
|---|---|
| `happens-before` | The ordering guarantee that makes writes visible across threads. Established by lock release→acquire, `volatile` write→read, thread start/join, and `final` field initialization. |
| `volatile` | Guarantees **visibility** and prevents reordering. Does **not** provide atomicity — `volatile++` is still a race. |
| `synchronized` | Provides both mutual exclusion **and** visibility (the release/acquire pair). |
| Why `volatile` isn't enough for a counter | Read-modify-write is three operations; another thread can interleave. Use `AtomicInteger`. |
| Double-checked locking | Broken without `volatile` on the instance field, because of construction reordering. Classic interview question. |
| `final` field safety | Correctly-constructed immutable objects are safe to share without synchronization. This is why immutability is the cheapest concurrency strategy. |

### Locks and coordination

| Primitive | Use it when |
|---|---|
| `synchronized` | Simple mutual exclusion, short critical section |
| `ReentrantLock` | You need `tryLock`, timeouts, interruptibility, fairness, or multiple conditions |
| `Condition` | Targeted waiting — replaces `wait`/`notify` with multiple wait sets |
| `ReentrantReadWriteLock` | Read-heavy, long-ish critical sections |
| `StampedLock` | Read-heavy with optimistic reads; not reentrant |
| `Semaphore` | Limit concurrent access to N permits |
| `CountDownLatch` | Wait for N one-time events (not reusable) |
| `CyclicBarrier` | Wait for N threads repeatedly (reusable) |
| `Phaser` | Dynamic party count, multi-phase coordination |
| `Exchanger` | Two threads swap objects |

### Concurrent collections

- `ConcurrentHashMap` — lock striping pre-Java 8, CAS + synchronized bins after. `computeIfAbsent` is atomic; `get` then `put` is **not**.
- `ConcurrentHashMap.newKeySet()` — the concurrent `Set`. Use this, not `Collections.synchronizedSet`.
- `CopyOnWriteArrayList` — read-heavy, write-rare. Every write copies the array.
- `BlockingQueue` family — `ArrayBlockingQueue` (bounded), `LinkedBlockingQueue` (optionally bounded), `SynchronousQueue` (no capacity, direct handoff), `PriorityBlockingQueue`, `DelayQueue`.
- `Collections.synchronizedMap` vs `ConcurrentHashMap` — the former locks the whole map per operation and its iterators aren't safe without external locking.

### Executors and async

- `ExecutorService` — `newFixedThreadPool`, `newCachedThreadPool`, `newSingleThreadExecutor`. **Know why `newCachedThreadPool` is dangerous** (unbounded thread creation) and why `ThreadPoolExecutor` with an explicit bounded queue and rejection policy is the production choice.
- `Future` vs `CompletableFuture` — `Future.get()` blocks; `CompletableFuture` composes (`thenApply`, `thenCompose`, `allOf`) without blocking.
- `ForkJoinPool` and work stealing — the engine behind parallel streams and `CompletableFuture`'s default executor.
- **Virtual threads (Project Loom, Java 21+)** — worth knowing in 2026. Cheap threads make thread-per-request viable again; blocking I/O no longer requires reactive style. If asked about reactive vs blocking in your Spring round, this is the current answer.
- `ThreadLocal` — and why it leaks in thread pools if not cleaned up.

### The failure modes

| Failure | Definition |
|---|---|
| Race condition | Outcome depends on thread interleaving |
| Deadlock | Circular wait; break one of Coffman's four conditions |
| Livelock | Threads keep acting but make no progress |
| Starvation | A thread never gets the resource (writer starvation in RW locks) |
| Thundering herd | `notifyAll` wakes many threads, most of which immediately re-block |
| False sharing | Independent variables on the same cache line cause contention (`@Contended`) |
| ABA problem | CAS succeeds because the value returned to its original, though it changed in between |

---

## The Follow-Up That Actually Decides This

Almost every design problem in your coding rounds can be followed by *"now make it thread-safe."* Have a **three-tier answer** ready that you can give for any structure:

1. **Coarse lock.** `synchronized` on every public method. Correct, simple, serializes everything. State this first — correctness before performance.
2. **Finer granularity.** Read-write lock if reads dominate, or shard by key hash and lock per shard. Name the tradeoff: more locks means more memory and more deadlock surface.
3. **Lock-free or approximate.** CAS on a single field, or accept approximation for throughput (Caffeine's approximate LRU, `LongAdder`'s sharded counters, sampled metrics).

Then close with the scaling sentence: *"if this needs to be distributed rather than just concurrent, the coordination moves to Redis or a consensus layer, and I'd want to know whether we can tolerate approximate results — usually we can, and that buys a lot."*

That progression — correct, then fast, then distributed, with the tradeoff named at each step — is a strong senior signal and it's the same reasoning shape your system design round wants.

---

## Progress Across the Plan

| Area | Target | Status |
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
| Trees + BST | 40 | ✔ |
| Tries | 10 | ✔ |
| Graphs | 48 | ✔ |
| DP | 58 | ✔ |
| Backtracking | 15 | ✔ |
| Bit / math | 16 | ✔ |
| Design | 12 | ✔ |
| **Concurrency** | **9 + 4 exercises** | **✔ list built** |

**Running total: 388 + 4 exercises.**

---

## Addendum — Final Coverage Audit

One outline item to extend Exercise 4 with.

### CAS-based lock-free stack (add to Exercise 4)

The outline specified "AtomicInteger, CAS-based lock-free counter/**stack**." Exercise 4 covers the counter; the stack is the natural extension and it's where CAS gets genuinely interesting.

**Implement:** a Treiber stack — `push` and `pop` on an `AtomicReference<Node>` head, using a CAS retry loop.

```java
class LockFreeStack<T> {
    private static class Node<T> { T value; Node<T> next; }
    private final AtomicReference<Node<T>> head = new AtomicReference<>();

    void push(T value) {
        Node<T> n = new Node<>();
        n.value = value;
        Node<T> old;
        do {
            old = head.get();
            n.next = old;
        } while (!head.compareAndSet(old, n));
    }

    T pop() {
        Node<T> old, next;
        do {
            old = head.get();
            if (old == null) return null;
            next = old.next;
        } while (!head.compareAndSet(old, next));
        return old.value;
    }
}
```

**Be ready to answer:**

| Question | Answer |
|---|---|
| Why is this lock-free but not wait-free? | An individual thread can retry indefinitely under contention; the *system* always makes progress, but no single thread has a bounded step count. |
| Where's the ABA problem here? | Thread A reads head = X, stalls. Others pop X, push Y, push X back. A's CAS succeeds because the reference matches, but `X.next` is now stale. Fix: `AtomicStampedReference` with a version counter. |
| Does Java's GC help? | Yes — it sidesteps the use-after-free hazard that makes this much harder in C++ (where you'd need hazard pointers or epoch reclamation). Worth mentioning; it's a real difference. |
| When would you *not* use this? | High contention — the retry loop burns CPU. A `ReentrantLock` with a short critical section often wins. Lock-free isn't automatically faster. |
| What does the JDK actually give you? | `ConcurrentLinkedQueue` and `ConcurrentLinkedDeque` are production-grade lock-free structures (Michael-Scott queue). Use those; implement your own only as an exercise. |

**The ABA question is the one that separates candidates.** Most people can write the CAS loop; far fewer can name the failure mode it hides. Have the concrete X-Y-X sequence ready.

**Count unchanged: 9 problems + 4 exercises** (Exercise 4 now has two parts: counter/rate-limiter and lock-free stack).
