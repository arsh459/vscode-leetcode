# CS Fundamentals — Index

Three topic indexes to work through in any order, against any source (GfG, OSTEP, DDIA, HPBN).
Not a schedule — a coverage map. Tick rows as you go.

| Index | Topics | ★★ | ★ | Explain-aloud checks |
|---|---|---|---|---|
| [DBMS](fundamentals-dbms.md) | 202 | 74 | 88 | 41 |
| [Networking](fundamentals-networking.md) | 169 | 73 | 77 | 39 |
| [OS & Architecture](fundamentals-os.md) | 217 | 118 | 90 | 51 |
| **Total** | **588** | **265** | **255** | **131** |

---

## How to use this

- **`[ ]` → `[x]` when you can explain it out loud**, not when you've read it. Reading a GfG article
  is the input; the tick is the output. If you can't reconstruct it unprompted a day later, untick it.
- **★★ first, then ★, then the rest.** ★★ is roughly 45% of the rows and covers most of what actually
  gets asked. A pass over only ★★ rows is a legitimate strategy under time pressure.
- **The Notes column is a retrieval prompt, not content.** It's deliberately too short to study from.
  It exists so you can check in ten seconds whether the idea is still reconstructible. If a note
  doesn't unpack into a full explanation, that row isn't done.
- **"Explain aloud" tables are the verification layer.** Tick a section's topics as you read; tick its
  checks only after answering them out loud, cold, without the file open.
- **Hands-on drills are their own section in each file.** Don't skip them — twenty minutes with
  `EXPLAIN ANALYZE`, `tcpdump`, or two `psql` sessions beats two hours of reading, and it's the
  difference between describing a mechanism and having watched it happen.
- **Answer keys** live at the bottom of each file rather than inline, so re-reading a section stays
  retrieval rather than recognition.

### Reading the ★ column

| Marker | Meaning |
|---|---|
| ★★ | Highest yield. Expect to be asked; know it cold, with the mechanism |
| ★ | Must know. Should be explainable without preparation |
| *(blank)* | Know the name and roughly what it's for. Recognition is enough |

---

## Where GfG is strong, and where it isn't

GfG's tutorials are built around the classical, exam-shaped syllabus. That's genuinely the best
available coverage for some sections and thin for others:

| Subject | GfG covers well | Go elsewhere for |
|---|---|---|
| DBMS | §1–§4 (ER, relational model, normalization, FD theory), §8.2 serializability | §6 query optimization, §9 storage internals → **DDIA**, Postgres docs |
| Networking | §1–§3 (layers, ARQ / sliding window, IP, subnetting, routing) | §4.4 production sockets, §6.2 HTTP/2–3, §7 TLS → **HPBN** |
| OS | §3–§6 (scheduling, deadlock, paging drills) | §8.2 I/O models, §9 architecture, §10 representation → **OSTEP**, Drepper |

The rows marked ★★ in those "go elsewhere" sections are the ones most likely to be missed by
working through a single tutorial front to back. Watch for them.

---

## Cross-subject dependencies

The load-bearing links between the three files. Being able to state these is worth more than any
single section:

- **DBMS §7 WAL ↔ OS §7 journaling** — same problem, same technique: durably record the intent before
  mutating in place. Running a database on a journaling filesystem means two layers of it.
- **DBMS §7 `fsync` ↔ OS §7 page cache** — why durability costs latency, from both sides.
- **DBMS §9 buffer pool ↔ OS §7 page cache** — a database reimplements the OS's cache on purpose.
  Know why.
- **OS §6.4 zero-copy ↔ OS §8.1 DMA ↔ Networking §4 TCP** — the chain is
  `sendfile` → page cache → DMA → NIC. That chain is the answer to "why is Kafka fast?"
- **Networking §3.2 MTU ↔ §3.4 ICMP** — blocking ICMP breaks Path MTU Discovery, which is why the
  failure is a hang rather than an error.
- **OS §9.1 MESI ↔ OS §9.3 store buffers** — coherence is not visibility. This distinction is the
  entire basis of the Java memory model.
- **Networking §2 sliding window ↔ §4.3 TCP flow control** — the link-layer protocol is where the
  mechanism is taught; TCP is where it's used.
- **OS §9.3 memory ordering → the Java depth track** — `happens-before` and `volatile` stop being
  arbitrary rules once you know what the hardware is doing. Read §9.3 before starting Java.

---

## The bar

Independent of how much of the index is ticked: you're in good shape when you can take any of these
and talk for five minutes, unprepared.

| ✔ | Check |
|---|---|
| [ ] | Narrate the full URL-to-render path — DNS, TCP, TLS, HTTP |
| [ ] | Why a composite index on `(a, b)` doesn't help a query filtering only on `b` |
| [ ] | Which anomalies each isolation level permits — *derived* from the snapshot rule, not memorised |
| [ ] | Explain MVCC without treating "snapshot" as a black box, and say who reclaims old versions |
| [ ] | Build a precedence graph and decide conflict-serializability |
| [ ] | Flow control vs congestion control, and why HTTP/3 abandoned TCP |
| [ ] | Diagnose `TIME_WAIT`, `CLOSE_WAIT` and accept-queue overflow as three different problems |
| [ ] | Name Coffman's four conditions and break one on demand |
| [ ] | Why an uncontended lock is nearly free and a contended one isn't |
| [ ] | `epoll` vs `select`, and why event loops exist |
| [ ] | Trace a page fault, describe thrashing, diagnose an OOM kill |
| [ ] | Zero-copy end to end: `sendfile` → page cache → DMA → NIC |
| [ ] | Journaling, and its equivalence to a database WAL |
| [ ] | Why array traversal beats linked-list traversal, mechanically |
| [ ] | Cache coherence vs visibility, and what a memory fence does |
| [ ] | Why `0.1 + 0.2 != 0.3`, mechanically |

---

## Layout

```
theory/
├── csFundamentals/
│   ├── README.md                     ← you are here
│   ├── fundamentals-dbms.md
│   ├── fundamentals-networking.md
│   └── fundamentals-os.md
└── java/                             ← Java depth track
```
