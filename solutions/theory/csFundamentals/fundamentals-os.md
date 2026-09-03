# Operating Systems & Computer Architecture — Topic Index

Reference checklist. Tick a row when you can **explain it out loud**, not when you've read it.

**★** = must know · **★★** = highest yield, expect it to be asked

> **Scope:** OS theory plus the architecture underneath it. JVM-specific material (`jstack`, GC,
> the Java memory model, virtual threads) is **not** here — that's the Java depth track. Container
> packaging and deployment aren't either, though the OS mechanisms containers are *built from*
> (cgroups, namespaces) are.
>
> **Computer architecture is folded in** because memory hierarchy and instruction reordering are
> what make the OS material make sense.

[← index](README.md) · [1 Introduction](#1-introduction) · [2 Processes & Threads](#2-processes--threads) · [3 Scheduling](#3-cpu-scheduling) · [4 Synchronization](#4-synchronization) · [5 Deadlocks](#5-deadlocks) · [6 Memory](#6-memory-management) · [7 Storage & Files](#7-storage--file-systems) · [8 I/O](#8-io-systems--device-management) · [9 Architecture](#9-computer-architecture) · [10 Data Representation](#10-data-representation) · [11 Drills](#11-hands-on-drills)

---

## 1. Introduction

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | What an OS does; kernel vs shell | Resource manager + abstraction layer |
| [ ] | ★ | OS types | Batch, multiprogramming, multitasking, time-sharing, real-time, distributed |
| [ ] | ★★ | **User mode vs kernel mode** | The protection boundary |
| [ ] | ★★ | **System calls** | Mechanism, categories, and *why a syscall is expensive*: mode switch, plus the KPTI page-table switch since Meltdown |
| [ ] | ★ | Kernel architectures | Monolithic, microkernel, hybrid, exokernel; Linux is monolithic-with-modules |
| [ ] | ★ | Interrupts vs traps vs faults vs signals | Four different things, often conflated |
| [ ] | ★ | Boot process | BIOS/UEFI → bootloader → kernel → init/systemd |
| [ ] | ★ | Hypervisor Type 1 vs Type 2 | Bare-metal vs hosted |
| [ ] | ★ | Containers vs VMs | Namespaces (isolation) + cgroups (limits), not virtualization |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | Why is a system call more expensive than a function call? Name every cost |
| [ ] | What does a container actually isolate, and what does it share with the host? |

---

## 2. Processes & Threads

### 2.1 Processes

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | Process concept; the address space | |
| [ ] | ★★ | **Process Control Block (PCB)** | What the kernel must save |
| [ ] | ★★ | **Process states and transitions** | New, ready, running, waiting, terminated |
| [ ] | ★★ | **Context switching and its cost** | Register save/restore, TLB flush, cache pollution |
| [ ] | ★★ | `fork`, `exec`, `wait`, `exit` | And what `fork` returns in each process |
| [ ] | ★★ | **Copy-on-write** | How `fork` on a 4GB process is instant |
| [ ] | ★ | `vfork`, `posix_spawn` | Cheaper process creation |
| [ ] | ★★ | **Zombie and orphan processes** | Why they accumulate; init reparenting |
| [ ] | ★ | Daemon processes | |
| [ ] | ★ | Process hierarchy and process groups | |

### 2.2 Threads

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | **Process vs thread — what's shared vs private** | Shared: heap, code, file descriptors. Private: stack, registers, TLS |
| [ ] | ★★ | User-level vs kernel-level threads | |
| [ ] | ★★ | **Thread models — 1:1, many-to-one, M:N** | |
| [ ] | ★ | Green threads / fibers / coroutines | The lineage that leads to virtual threads |
| [ ] | ★ | Thread pools | Why you don't create threads per task |
| [ ] | ★ | Thread safety and reentrancy | |
| [ ] | | Thread-local storage | |

### 2.3 IPC

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | **Shared memory** | Fastest, but you own the synchronization |
| [ ] | ★ | Message passing | Blocking vs non-blocking send/receive |
| [ ] | ★★ | **Pipes and named pipes (FIFO)** | |
| [ ] | ★ | Message queues | |
| [ ] | ★ | Sockets; Unix domain sockets | |
| [ ] | ★★ | **Signals** | `SIGTERM` vs `SIGKILL` vs `SIGSEGV` vs `SIGCHLD`; handlers; async-signal-safety |
| [ ] | ★ | Memory-mapped files as IPC | |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | What exactly is shared between two threads in a process, and what isn't? |
| [ ] | Why is creating a thread expensive? Give the actual costs |
| [ ] | Why is a context switch more expensive than a function call? Be specific |
| [ ] | `SIGTERM` vs `SIGKILL` — the difference from the process's point of view |
| [ ] | How can `fork` duplicate a 4GB process instantly? |
| [ ] | How does a zombie process arise, and who cleans it up? |

---

## 3. CPU Scheduling

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | Scheduler types | Long-term, medium-term, short-term; the dispatcher |
| [ ] | ★★ | **Preemptive vs non-preemptive** | |
| [ ] | ★★ | Scheduling criteria | CPU utilisation, throughput, turnaround, waiting, response time |
| [ ] | ★ | **FCFS** and the convoy effect | |
| [ ] | ★★ | **SJF and SRTF** | Optimal for average waiting time; why it's not implementable |
| [ ] | ★ | Priority scheduling | |
| [ ] | ★★ | **Starvation and aging** | |
| [ ] | ★★ | **Round robin** | Choosing the time quantum; the response/throughput tradeoff |
| [ ] | ★★ | **Multilevel queue and multilevel feedback queue** | What real schedulers approximate |
| [ ] | ★ | Computing average waiting/turnaround from a Gantt chart | The standard exam drill |
| [ ] | | Lottery and fair-share scheduling | |
| [ ] | ★ | Linux CFS | vruntime, red-black tree |
| [ ] | ★★ | **CPU-bound vs I/O-bound** | Why they want different concurrency levels — reason it, don't recite a formula |
| [ ] | ★★ | **Priority inversion and priority inheritance** | Mars Pathfinder |
| [ ] | ★ | Multiprocessor scheduling, load balancing | |
| [ ] | ★★ | **CPU affinity** | Keeping a thread on one core preserves cache warmth → §9.1 |
| [ ] | ★ | **NUMA** | Memory access cost depends on which socket owns the page |
| [ ] | ★★ | **cgroup CPU quota / CFS throttling** | Quota over a 100ms period. A throttled process looks *idle* while stalling — the canonical "bad p99 with low CPU" cause |
| [ ] | ★ | Real-time scheduling | Hard vs soft; rate monotonic, EDF |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | Why does round robin have better response time but worse throughput than FCFS? |
| [ ] | What is priority inversion and how is it solved? |
| [ ] | How does the right concurrency level differ for CPU-bound vs I/O-bound work? |
| [ ] | A service shows 30% CPU and terrible p99. How does a CPU quota produce that, and how would you confirm it? |

---

## 4. Synchronization

### 4.1 The problem

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | **Race condition; critical section** | |
| [ ] | ★★ | Critical-section requirements | Mutual exclusion, progress, bounded waiting |
| [ ] | ★★ | Why `x++` isn't atomic | Load, add, store |
| [ ] | ★ | Software solutions — Peterson's, Dekker's | Historical, but they show what's hard |

### 4.2 Primitives

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | **Hardware support** | Test-and-set, compare-and-swap, fetch-and-add |
| [ ] | ★ | **ABA problem** | |
| [ ] | ★★ | **Mutex** | |
| [ ] | ★★ | **Semaphore — binary vs counting** | `wait`/`signal` |
| [ ] | ★★ | **Mutex vs semaphore** | The real difference: ownership, not the count |
| [ ] | ★★ | **Monitor and condition variable** | |
| [ ] | ★ | Spurious wakeups | Why you wait in a `while`, not an `if` |
| [ ] | ★★ | **Spinlock vs blocking lock** | When busy-waiting is correct; adaptive locks |
| [ ] | ★★ | **Futex** | Uncontended lock = one atomic op in userspace, no syscall; only contention enters the kernel. This is *why* an uncontended lock is nearly free |
| [ ] | ★ | Cost of an atomic RMW under contention | A `lock`-prefixed instruction is cheap alone, expensive when the line is shared → §9.1 |
| [ ] | ★ | Read-write lock, barrier, latch | |
| [ ] | ★ | Lock-free and wait-free (conceptual) | |

### 4.3 Classic problems

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | **Producer-consumer / bounded buffer** | |
| [ ] | ★★ | **Readers-writers** | And the writer-starvation variant |
| [ ] | ★★ | **Dining philosophers** | |
| [ ] | | Sleeping barber, cigarette smokers | |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | Mutex vs semaphore — the real difference, not the textbook one |
| [ ] | Why is acquiring an uncontended mutex almost free, while a contended one costs microseconds? |
| [ ] | When is a spinlock better than a blocking lock? |
| [ ] | What is the ABA problem? |
| [ ] | Solve readers-writers so writers don't starve. What did you trade away? |

---

## 5. Deadlocks

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | **Coffman's four conditions** | Mutual exclusion, hold-and-wait, no preemption, circular wait |
| [ ] | ★★ | **Resource allocation graph** | Cycle detection; single vs multiple instances |
| [ ] | ★★ | **Prevention** | Break each of the four conditions; what each fix costs |
| [ ] | ★★ | **Avoidance — safe state, Banker's algorithm** | |
| [ ] | ★★ | **Detection — wait-for graph** | |
| [ ] | ★ | Recovery — victim selection, rollback, preemption | |
| [ ] | ★★ | **Livelock and starvation** | How each differs from deadlock |
| [ ] | ★ | Wait-die vs wound-wait | Timestamp-based prevention |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | Name Coffman's four conditions. For dining philosophers, which does each standard fix break? |
| [ ] | Deadlock vs livelock vs starvation — one sentence each |
| [ ] | Why do real systems mostly detect-and-recover rather than prevent? |

---

## 6. Memory Management

### 6.1 Basics

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | Logical vs physical address; the MMU | |
| [ ] | ★ | Address binding | Compile-time, load-time, execution-time |
| [ ] | ★ | Base and limit registers; protection | |
| [ ] | ★ | Swapping | |
| [ ] | ★ | Contiguous allocation — fixed vs variable partitions | |
| [ ] | ★★ | **First fit / best fit / worst fit** | |
| [ ] | ★★ | **Internal vs external fragmentation** | Which scheme suffers which |
| [ ] | ★ | Compaction | |
| [ ] | ★★ | Memory layout of a process | Text, data, BSS, heap, stack — and which way each grows |
| [ ] | ★★ | Stack vs heap allocation | |

### 6.2 Paging & segmentation

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | **Paging** | Page, frame, page table; page number + offset |
| [ ] | ★ | Page table structures | Multilevel, hashed, inverted |
| [ ] | ★★ | **TLB; hit ratio and effective access time** | The standard EAT calculation |
| [ ] | ★ | TLB flush on context switch; ASIDs | Part of why a context switch costs |
| [ ] | ★★ | **Segmentation** | Logical division vs paging's fixed frames; external fragmentation |
| [ ] | ★★ | Segmentation vs paging | What each solves; why modern systems page |
| [ ] | ★ | Segmented paging / hybrid | |
| [ ] | ★ | Shared pages; page protection bits | |

### 6.3 Virtual memory

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | **Virtual memory — why it exists** | Isolation, and the illusion of contiguous space |
| [ ] | ★★ | **Demand paging** | |
| [ ] | ★★ | **Page fault handling, step by step** | Minor vs major fault |
| [ ] | ★★ | **Page replacement** | FIFO, optimal, LRU, LRU approximations, clock / second-chance, LFU |
| [ ] | ★★ | **Belady's anomaly** | More frames can mean *more* faults under FIFO |
| [ ] | ★ | Frame allocation | Equal vs proportional; local vs global replacement |
| [ ] | ★★ | **Working set model** | The formal basis for thrashing |
| [ ] | ★★ | **Thrashing** | Cause, what it looks like in production, how to fix |
| [ ] | | Prepaging, page buffering | |
| [ ] | ★ | Swap, `swappiness`, why databases disable swap | |
| [ ] | ★★ | **Overcommit and the OOM killer** | `oom_score`; why the process killed is often not the culprit |
| [ ] | ★ | Huge pages / THP | TLB pressure |

### 6.4 Allocators & mapping

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | **Buddy allocator** | How the kernel allocates physical pages |
| [ ] | ★★ | **Slab allocator** | Caching same-size kernel objects |
| [ ] | ★ | `malloc` internals | `brk` vs `mmap`, arenas, bins |
| [ ] | ★ | Memory leak vs fragmentation | Different symptoms, different fixes |
| [ ] | ★★ | **`mmap` and memory-mapped I/O** | |
| [ ] | ★★ | **Zero-copy — `sendfile`, `splice`** | Which copies you avoid; why Kafka is fast |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | What happens, step by step, on a page fault? |
| [ ] | Service slows to a crawl, disk I/O spikes, no obvious load increase. Hypothesis? |
| [ ] | What's the working set, and how does exceeding available memory produce thrashing? |
| [ ] | What is Belady's anomaly, and what does it tell you about choosing a replacement policy? |
| [ ] | Segmentation vs paging — what does each solve, and which fragmentation does each suffer? |
| [ ] | Your container was killed with exit 137 and no stack trace. What happened, and where do you look? |
| [ ] | Explain zero-copy. Which copies are you avoiding, and why does it matter for a broker? |
| [ ] | Compute EAT given a TLB hit ratio, memory access time and page-fault rate |

---

## 7. Storage & File Systems

### 7.1 Interface

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | File concept, attributes, operations | |
| [ ] | ★★ | **File descriptor and the open file table** | Per-process table → system-wide table → inode |
| [ ] | ★ | Access methods | Sequential, direct, indexed |
| [ ] | ★ | Directory structures | Single-level, two-level, tree, acyclic graph |
| [ ] | ★★ | **A directory is a file of name→inode mappings** | |
| [ ] | ★★ | **Hard vs symbolic links** | Falls straight out of the inode model |
| [ ] | ★ | Mounting; VFS | |
| [ ] | ★ | Permissions, `umask`, ACLs | |

### 7.2 Implementation

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | **FS layout** | Superblock, inode table, data blocks |
| [ ] | ★★ | **Inode structure; direct and indirect blocks** | How a large file is addressed |
| [ ] | ★★ | Allocation methods | Contiguous, linked, indexed; FAT as a linked variant |
| [ ] | ★ | Free space management | Bit vector, linked list, grouping, counting |
| [ ] | ★ | Block size and internal fragmentation | |
| [ ] | ★ | Extents, sparse files | |
| [ ] | ★★ | **Page cache / buffer cache** | Why the first read is slow and the second isn't |
| [ ] | ★ | Read-ahead; write-back vs write-through | |
| [ ] | ★★ | **`fsync`, `fdatasync`, `O_DIRECT`** | Why durability costs latency |
| [ ] | ★★ | **Journaling** | Write intent first, then apply — the same principle as a DBMS WAL |
| [ ] | ★★ | **Journaling modes** | Writeback vs ordered vs data; the durability/performance tradeoff |
| [ ] | ★ | Copy-on-write filesystems, snapshots | |
| [ ] | ★ | `ext4`, `xfs`, `btrfs`, `zfs`, `tmpfs` | Names and roughly the differences |
| [ ] | | `fsck` and FS consistency | |

### 7.3 Disks

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | HDD geometry | Seek time, rotational latency, transfer time |
| [ ] | ★★ | **Disk scheduling** | FCFS, SSTF, SCAN, C-SCAN, LOOK, C-LOOK — mostly historical on SSDs, still a standard drill |
| [ ] | ★★ | SSD internals | Pages/blocks, erase cycles, wear levelling, TRIM, write amplification |
| [ ] | ★★ | **Sequential vs random I/O** | Still true on SSDs, less dramatic |
| [ ] | ★★ | **RAID 0 / 1 / 5 / 6 / 10** | And "RAID is not backup" |
| [ ] | ★ | RAID 5 write penalty | |
| [ ] | | Partitions, LVM | |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | Why does a database `fsync` on commit, and what does batching commits buy? |
| [ ] | What does journaling protect against, and how? Compare it to a database's WAL |
| [ ] | Metadata-only vs full data journaling — what's the tradeoff? |
| [ ] | Explain RAID 5's write penalty |
| [ ] | How does the filesystem find block 10,000 of a large file? |
| [ ] | Delete a file that another process has open. What happens, and why? |

> **The parallel worth stating:** the filesystem journal and the database WAL solve the same problem
> with the same technique. That's why running a database on a journaling filesystem means two layers
> of journaling, and why some databases bypass the filesystem with `O_DIRECT`.

---

## 8. I/O Systems & Device Management

### 8.1 Devices

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | I/O hardware — bus, controller, device registers | |
| [ ] | ★★ | **Polling vs interrupt-driven I/O** | And when polling is actually better |
| [ ] | ★★ | **Interrupt handling** | IRQ, interrupt vector table, context save |
| [ ] | ★★ | **Top half vs bottom half / softirq / tasklet** | Keep the handler short, defer the work |
| [ ] | ★ | Interrupt coalescing; NAPI | Why high-throughput NICs batch |
| [ ] | ★★ | **DMA** | The device writes to memory directly, bypassing the CPU |
| [ ] | ★★ | Why DMA is the basis of zero-copy | Connects to §6.4 |
| [ ] | ★ | Memory-mapped vs port-mapped I/O | |
| [ ] | ★ | Device drivers; block vs character devices | |
| [ ] | | Spooling, buffering, caching | |

### 8.2 I/O models

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | **Blocking I/O** | Thread-per-connection |
| [ ] | ★ | Non-blocking I/O | Why naive polling is wasteful |
| [ ] | ★★ | **I/O multiplexing — `select`, `poll`, `epoll`** | |
| [ ] | ★★ | **Why `epoll` scales where `select` doesn't** | `O(1)` readiness vs `O(n)` descriptor scan |
| [ ] | ★ | `epoll` level- vs edge-triggered | |
| [ ] | ★ | Asynchronous I/O — `io_uring`, POSIX AIO | Readiness-based vs completion-based |
| [ ] | ★★ | **The C10K problem** | How event loops answered it |
| [ ] | ★★ | **Event loop architecture** | nginx, Node, Netty |
| [ ] | ★★ | File descriptor limits, `ulimit` | Why "too many open files" happens |
| [ ] | ★★ | Thread-per-connection vs event loop | And when the event loop *loses* |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | Why is interrupt-driven I/O better than polling? When is polling actually better? → [answer](#answer-keys) |
| [ ] | What does DMA do, and why does it matter for network throughput? |
| [ ] | Why must interrupt handlers be short? |
| [ ] | Why can't you serve 100,000 connections with thread-per-connection? Do the stack-memory arithmetic |
| [ ] | `epoll` vs `select` — the complexity difference and where it comes from |
| [ ] | A server holds 50,000 connections. Which OS limits do you hit first? |
| [ ] | Narrate the full zero-copy chain: `sendfile` → page cache → DMA → NIC |

---

## 9. Computer Architecture

### 9.1 Memory hierarchy

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | Register → L1 → L2 → L3 → RAM → SSD → network | Orders of magnitude, not exact numbers |
| [ ] | ★★ | **Latency numbers worth knowing** | L1 ~1ns, RAM ~100ns, SSD ~100µs, network ~ms |
| [ ] | ★★ | **Cache lines (~64 bytes)** | You never fetch one byte — you fetch a line |
| [ ] | ★ | Cache mapping | Direct, set-associative, fully associative |
| [ ] | ★ | Write-through vs write-back; write-allocate | |
| [ ] | ★★ | **Spatial and temporal locality** | |
| [ ] | ★★ | **Why array traversal beats linked-list traversal** | Same big-O, wildly different constant. Two reasons |
| [ ] | ★★ | **Cache coherence — MESI** | How cores agree on a line's state; invalidation traffic is the cost |
| [ ] | ★★ | **False sharing** | Independent variables on one cache line; MESI ping-pongs it. Padding is the fix |
| [ ] | ★ | Prefetching | |
| [ ] | ★ | Cache-friendly layout; AoS vs SoA | |

### 9.2 CPU execution

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | Von Neumann vs Harvard architecture | |
| [ ] | ★ | Instruction cycle; RISC vs CISC | |
| [ ] | ★★ | **Pipelining; hazards and stalls** | Structural, data, control |
| [ ] | ★★ | **Branch prediction and misprediction cost** | ~15–20 cycle penalty |
| [ ] | ★★ | **Why sorted data can make a branchy loop faster** | |
| [ ] | ★ | Out-of-order execution, speculation | |
| [ ] | ★ | Superscalar; SIMD | |
| [ ] | ★★ | **Hyper-threading vs physical cores** | What's actually duplicated |
| [ ] | ★ | Amdahl's law | |

### 9.3 Memory ordering

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | **Compilers and CPUs reorder instructions** | Both do, for different reasons |
| [ ] | ★★ | **Store buffers — coherence is not visibility** | MESI doesn't save you here |
| [ ] | ★★ | **Memory barriers / fences** | |
| [ ] | ★★ | **Acquire / release semantics** | The vocabulary the Java memory model uses |
| [ ] | ★★ | **Strong vs weak memory models** | x86 relatively strong (TSO); ARM weaker |
| [ ] | ★ | Sequential consistency | |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | Two loops, identical complexity — `int[]` vs `LinkedList`. Why is one dramatically faster? Two reasons |
| [ ] | Why does sorting an array before a conditional loop sometimes speed it up dramatically? |
| [ ] | Two threads increment adjacent counters and it's 10× slower than with padding. Name the protocol doing the work |
| [ ] | What is a store buffer, and how does it cause visibility problems *even though* caches are coherent? |
| [ ] | Why might correct-looking concurrent code work on x86 and fail on ARM? |

> **§9.3 is the hardware layer under the Java memory model.** Read it before starting Java depth —
> `happens-before` and `volatile` stop being arbitrary once you know what the hardware is doing.

---

## 10. Data Representation

### 10.1 Numbers

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | Number systems and base conversion | |
| [ ] | ★★ | **Two's complement** | Why `-MIN_VALUE` is negative |
| [ ] | ★★ | Signed vs unsigned; integer overflow | |
| [ ] | ★ | Bit manipulation basics | Masks, shifts, `x & (x-1)` |
| [ ] | ★★ | **IEEE 754** | Sign, exponent, mantissa; the bias |
| [ ] | ★ | Normalized vs denormalized values | |
| [ ] | ★★ | **Why `0.1 + 0.2 != 0.3`** | The classic question — answer it mechanically |
| [ ] | ★★ | **`NaN`, `±Infinity`, `-0.0`** | `NaN != NaN` |
| [ ] | ★ | Precision limits; catastrophic cancellation | |
| [ ] | ★ | Fixed-point / decimal types for money | Why you never use `double` there |

### 10.2 Text

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | **A character set is not an encoding** | The distinction most people get wrong |
| [ ] | ★ | ASCII, Latin-1 | |
| [ ] | ★★ | **Unicode; code point vs code unit vs grapheme** | |
| [ ] | ★★ | **UTF-8 vs UTF-16 vs UTF-32** | Where each is used and why |
| [ ] | ★★ | **Why UTF-8 won** | ASCII-compatible, self-synchronizing, no endianness |
| [ ] | ★ | Surrogate pairs in UTF-16 | Why a Java `char` can't hold every code point |
| [ ] | ★ | **Endianness** | Big vs little; BOM |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | Explain mechanically why `0.1 + 0.2` isn't `0.3` |
| [ ] | Why does `NaN == NaN` return false? |
| [ ] | Unicode vs UTF-8 — what's the actual relationship? |
| [ ] | Why is UTF-8 self-synchronizing, and why does that matter? |
| [ ] | Why does an emoji have `length() == 2` in Java? |

---

## 11. Hands-on Drills

Tick when actually run.

| ✔ | ★ | Drill | What you should see |
|---|---|---|---|
| [ ] | ★★ | `strace` a small program | Every syscall it actually makes; find the ones you didn't expect |
| [ ] | ★ | `top` / `htop` under load | Load average vs CPU vs memory pressure |
| [ ] | ★ | `ps -eLf` / `pstree` | Threads per process, process hierarchy |
| [ ] | ★★ | `ss -tan \| grep TIME_WAIT \| wc -l` | Connects straight to Networking §4.2 |
| [ ] | ★★ | `lsof -p <pid>` | Open files and sockets; how fd exhaustion looks |
| [ ] | ★ | `cat /proc/<pid>/status`, `limits`, `fd/`, `smaps` | The kernel's own view of a process |
| [ ] | ★ | Trigger an OOM kill in a memory-capped container, then `dmesg \| grep -i oom` | The kill record and `oom_score` |
| [ ] | ★ | Write a false-sharing microbenchmark, then pad the struct | The 10× difference, on your own machine |
| [ ] | ★ | Time a loop over `int[]` vs `LinkedList` at 10M elements | The constant factor §9.1 predicts |
| [ ] | | `free -m`, `df -h`, `du -sh *` | |
| [ ] | | `ulimit -a` | Which limit you'd hit first |

---

## Resources

- **OSTEP** (free online). The best OS book, and readable. Read Virtualization and Concurrency in full; from Persistence read the filesystem and journaling chapters.
- **"What Every Programmer Should Know About Memory"** (Drepper) — **sections 1–3 only**; the rest is deeper than you need.
- **"Why is processing a sorted array faster than an unsorted array?"** — the StackOverflow answer. Best 10 minutes on branch prediction anywhere.
- **Julia Evans** on `strace`, debugging and systems — short and practical.
- **GfG Operating Systems tutorial** — strong on §3–§6, the classical scheduling / deadlock / paging drills. Thin on §8.2, §9 and §10; use OSTEP and Drepper there.

Skip the classic university OS course. Too much scheduling algebra, too little of what's asked.

---

## Answer Keys

Kept out of the checks so re-reading stays retrieval, not recognition.

- **§8, when polling wins:** very high-rate devices, where per-interrupt overhead dominates the work done per interrupt. This is why Linux NAPI switches from interrupts to polling under load, and why DPDK-style busy-polling exists at the extreme.
