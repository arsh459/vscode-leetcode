# Networking — Topic Index

Reference checklist. Tick a row when you can **explain it out loud**, not when you've read it.

**★** = must know · **★★** = highest yield, expect it to be asked

> **Scope:** protocols and mechanisms. Load balancers, CDNs, API gateways, WebSocket *scaling*,
> REST/gRPC API design, JWT and OAuth2 are **not** here — system design and Spring Boot tracks.
> This file is what's underneath them.

[← index](README.md) · [1 Foundations](#1-foundations) · [2 Physical & Data Link](#2-physical--data-link-layer) · [3 Network Layer](#3-network-layer--ip) · [4 Transport](#4-transport-layer) · [5 DNS](#5-dns) · [6 HTTP](#6-http) · [7 TLS](#7-tls--https) · [8 WebSocket](#8-websocket--realtime) · [9 Other Protocols](#9-other-application-protocols) · [10 Security](#10-network-security) · [11 Drills](#11-hands-on-drills)

---

## 1. Foundations

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | | LAN / WAN / MAN, network topologies | |
| [ ] | ★★ | **OSI seven layers** | The function of each, not the mnemonic |
| [ ] | ★★ | **TCP/IP model** and how it maps to OSI | |
| [ ] | ★ | PDU at each layer | Frame → packet → segment → data |
| [ ] | ★★ | **Encapsulation and decapsulation** | Which header is added at each layer, in order |
| [ ] | ★ | Connection-oriented vs connectionless | |
| [ ] | ★ | Circuit switching vs packet switching | |
| [ ] | ★ | Bandwidth, throughput, latency, jitter | Distinguish bandwidth from throughput |
| [ ] | ★ | Delay components | Propagation, transmission, queuing, processing |
| [ ] | ★ | **Bandwidth-delay product** | The in-flight bytes needed to saturate a path |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | **What happens end to end when you type a URL and press enter?** Practise this aloud — DNS, TCP, TLS, HTTP. Interviewers use it to see how deep you go on demand |
| [ ] | Trace the headers added to your data as it goes from application down to the wire |
| [ ] | Bandwidth vs throughput vs latency — why does a high-bandwidth, high-latency link feel slow? |

---

## 2. Physical & Data Link Layer

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | | Transmission media — twisted pair, coax, fibre, wireless | |
| [ ] | | Simplex, half duplex, full duplex | |
| [ ] | | Framing; bit stuffing and byte stuffing | |
| [ ] | ★ | Error detection — parity, checksum, **CRC** | |
| [ ] | | Error correction — Hamming code | |
| [ ] | ★ | Stop-and-wait ARQ | |
| [ ] | ★★ | **Go-Back-N and Selective Repeat** | Window mechanics, buffer needs, ACK behaviour |
| [ ] | ★★ | **Sliding window protocol** | The concept TCP flow control builds on |
| [ ] | ★ | MAC addresses | |
| [ ] | ★★ | **ARP and the ARP cache** | IP → MAC on a local segment; RARP |
| [ ] | ★ | Ethernet, **CSMA/CD**, CSMA/CA | Why CD is obsolete on switched full-duplex links |
| [ ] | ★ | Collision domain vs broadcast domain | |
| [ ] | ★★ | Hub vs switch vs bridge vs router | Which layer each operates at, and what each forwards on |
| [ ] | | Switching modes — store-and-forward, cut-through | |
| [ ] | | VLANs and trunking | |
| [ ] | | Spanning Tree Protocol | Why loops are fatal at L2 |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | Go-Back-N vs Selective Repeat — buffer requirements and behaviour on a single loss |
| [ ] | A switch and a router both "forward" — what's actually different? |
| [ ] | Why doesn't a modern switched Ethernet need CSMA/CD? |

---

## 3. Network Layer / IP

### 3.1 Addressing

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | IPv4 address structure, classes A–E | |
| [ ] | ★★ | **Subnetting, subnet mask, CIDR** | Enough to read `10.0.0.0/16` and split a block |
| [ ] | ★ | VLSM and supernetting | |
| [ ] | ★★ | Private ranges (RFC 1918), **NAT and PAT** | |
| [ ] | ★ | Special addresses | Loopback, broadcast, network address, APIPA |
| [ ] | ★★ | **IPv6** | 128-bit, simplified header, no router fragmentation, no broadcast, SLAAC |
| [ ] | ★ | IPv4 vs IPv6 comparison; dual-stack | Why adoption is slow |

### 3.2 IP mechanics

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | **IPv4 header fields** | TTL, protocol, identification, fragmentation flags, checksum |
| [ ] | ★★ | **MTU and fragmentation** | 1500 typical; the DF bit |
| [ ] | ★★ | **Path MTU Discovery and MTU black holes** | When ICMP is blocked, PMTUD breaks and connections hang |
| [ ] | ★ | TTL and hop limits | |
| [ ] | ★ | IP options | |

### 3.3 Routing

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | Routing table, next-hop forwarding, default route | How a router decides |
| [ ] | ★ | **Longest prefix match** | |
| [ ] | ★ | Static vs dynamic routing | |
| [ ] | ★ | Distance vector vs link state | Count-to-infinity; split horizon |
| [ ] | ★ | RIP, OSPF | Know the family each belongs to |
| [ ] | ★★ | **BGP** | Autonomous systems, path vector; why a misconfiguration causes global outages |
| [ ] | ★ | Unicast, broadcast, multicast, anycast | And why multicast rarely works on the public internet |
| [ ] | ★★ | **DHCP** | The DORA exchange |

### 3.4 ICMP & diagnostics

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | What ICMP is for | Control and error messages, not data transport |
| [ ] | ★★ | **How `ping` works** | Echo request / echo reply |
| [ ] | ★★ | **How `traceroute` works** | Incrementing TTL; each router returns Time Exceeded at 0 |
| [ ] | ★ | ICMP message types | Destination Unreachable, Time Exceeded, Fragmentation Needed |
| [ ] | ★★ | Why blocking all ICMP is a mistake | It breaks PMTUD → §3.2 |
| [ ] | | `mtr` as ping + traceroute | |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | Split `192.168.1.0/24` into four equal subnets. Give the ranges and broadcast addresses |
| [ ] | What is an MTU black hole, and why does it produce a *hang* rather than an error? |
| [ ] | Why does IPv6 remove router fragmentation? |
| [ ] | Why can a BGP mistake at one ISP take a large site offline globally? |
| [ ] | Explain traceroute's mechanism. Why does each hop reply? |
| [ ] | A security team blocks all ICMP. What breaks, and why is it hard to diagnose? |
| [ ] | Why might traceroute show `* * *` for a hop that's forwarding traffic fine? |

---

## 4. Transport Layer

### 4.1 Basics

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | Port numbers — well-known, registered, ephemeral | |
| [ ] | ★★ | Socket = IP + port; the 4-tuple identifying a connection | |
| [ ] | ★★ | **Socket API lifecycle** | `socket` → `bind` → `listen` → `accept` / `connect` → `send`/`recv` → `close` |
| [ ] | ★ | Multiplexing and demultiplexing | |
| [ ] | ★★ | **TCP vs UDP** | What each guarantees and what it costs |

### 4.2 TCP — connection management

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | TCP segment header and flags | SYN, ACK, FIN, RST, PSH, URG |
| [ ] | ★★ | **Three-way handshake** | And why three, not two |
| [ ] | ★★ | **Four-way teardown**, half-close | |
| [ ] | ★★ | **TCP state machine** | `LISTEN`, `SYN_SENT`, `SYN_RCVD`, `ESTABLISHED`, `FIN_WAIT_1/2`, `CLOSE_WAIT`, `LAST_ACK`, `TIME_WAIT` |
| [ ] | ★★ | **`TIME_WAIT`** | Why 2×MSL; why it causes real production problems; which side gets it |
| [ ] | ★★ | **`CLOSE_WAIT` accumulation** | Always an application bug — you didn't `close()` |
| [ ] | ★ | ISN, sequence and acknowledgement numbers | |
| [ ] | ★ | `RST` — when it's sent | |
| [ ] | ★ | SYN flood and SYN cookies | |

### 4.3 TCP — reliability & performance

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | Cumulative ACK, delayed ACK | |
| [ ] | ★★ | Retransmission, **RTO**, Karn's algorithm, exponential backoff | Why a lossy path stalls in multi-second steps |
| [ ] | ★★ | **Fast retransmit and fast recovery** | Three duplicate ACKs, without waiting for the RTO |
| [ ] | ★ | Selective ACK (SACK) | |
| [ ] | ★★ | **Flow control — sliding window** | Receiver-driven; zero-window and window probes |
| [ ] | ★ | Window scaling | Why the 16-bit window field isn't a limit anymore |
| [ ] | ★ | Silly window syndrome | |
| [ ] | ★★ | **Congestion control** | Slow start, congestion avoidance, AIMD; `cwnd` and `ssthresh` |
| [ ] | ★★ | **Flow control ≠ congestion control** | Who is being protected in each |
| [ ] | ★ | Variants — Tahoe, Reno, NewReno, **CUBIC**, **BBR** | BBR models bandwidth and RTT rather than reacting to loss |
| [ ] | ★★ | **Nagle's algorithm + delayed ACK interaction** | The bad interaction; `TCP_NODELAY` |
| [ ] | ★★ | **Head-of-line blocking** | The reason HTTP/3 exists |
| [ ] | ★★ | TCP keep-alive vs HTTP keep-alive | Different things, same name |
| [ ] | | TCP Fast Open | |

### 4.4 Sockets in production

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | **SYN queue vs accept queue** | Two separate queues; `listen()` backlog sizes the second. Overflow drops SYNs silently |
| [ ] | ★★ | `SO_REUSEADDR` vs `SO_REUSEPORT` | Rebinding a port in `TIME_WAIT` vs load-balancing across processes — commonly confused |
| [ ] | ★★ | **Ephemeral port exhaustion** | The other half of the `TIME_WAIT` story, for outbound-heavy services |
| [ ] | ★ | Socket buffer sizing | `SO_RCVBUF` / `SO_SNDBUF` |

### 4.5 UDP & QUIC

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | UDP header; statelessness | |
| [ ] | ★★ | What UDP gives up, and what you rebuild on top | |
| [ ] | ★ | When to prefer UDP | DNS, video, gaming, tunnels |
| [ ] | ★★ | **Why QUIC chose UDP** | Escape TCP head-of-line blocking and stack ossification |
| [ ] | ★ | QUIC features | Streams, integrated TLS 1.3, connection migration, 0-RTT |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | Why three packets in the handshake? What breaks with two? |
| [ ] | 30,000 sockets in `TIME_WAIT`. What's happening and what do you do? Which side are you? |
| [ ] | Sockets stuck in `CLOSE_WAIT` instead — different diagnosis. What is it? |
| [ ] | Distinguish flow control from congestion control. Who's protecting whom in each? |
| [ ] | Small messages, noticeable latency, no congestion. Likely cause? |
| [ ] | Connections refused under load but CPU is idle. Which queue overflowed? |
| [ ] | What does BBR do differently from CUBIC, and why does it help on lossy links? |
| [ ] | 100ms RTT, 1 Gbps link. Roughly how many bytes must be in flight to saturate it? |
| [ ] | Video calls use UDP and lose packets. Why is that better than TCP retransmitting? |

---

## 5. DNS

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | The hierarchy — root, TLD, authoritative | |
| [ ] | ★★ | **Full resolution chain** | Stub resolver → recursive resolver → root → TLD → authoritative |
| [ ] | ★ | Recursive vs iterative queries | Who does which |
| [ ] | ★★ | Record types | A, AAAA, CNAME, MX, TXT, NS, SOA, PTR, SRV, CAA |
| [ ] | ★ | CNAME restrictions | Why you can't CNAME a zone apex |
| [ ] | ★★ | **TTL and caching** | "DNS propagation" is really just cache expiry |
| [ ] | | Negative caching | |
| [ ] | ★ | Zone files, zone transfer (AXFR/IXFR) | |
| [ ] | ★ | Round-robin DNS, GeoDNS | Load distribution and its limits |
| [ ] | ★ | DNSSEC | Authenticity — stops tampering |
| [ ] | ★ | DNS over HTTPS / TLS | Privacy — stops eavesdropping |
| [ ] | ★ | Why DNS is a common outage cause | |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | Walk through resolving `api.example.com` from a cold cache |
| [ ] | You lowered TTL to 60s and changed an A record. Some users still hit the old server. Why? |
| [ ] | DNSSEC and DoH — which stops tampering, which stops eavesdropping? |

---

## 6. HTTP

### 6.1 Core

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | Request and response anatomy | Start line, headers, body |
| [ ] | ★ | URI vs URL vs URN; URL structure | |
| [ ] | ★★ | **Methods; safe vs idempotent** | PUT is idempotent, POST isn't; this is what governs retries |
| [ ] | ★★ | **Status codes** | Families; 401 vs 403; 301 vs 302 vs 307 vs 308 |
| [ ] | ★ | Header categories | General, request, response, entity |
| [ ] | ★★ | **Caching headers** | `Cache-Control`, `ETag`, `If-None-Match`, `Last-Modified`, `If-Modified-Since`, `Vary` |
| [ ] | ★ | Conditional requests and 304 | |
| [ ] | ★★ | **Cookies** | `SameSite`, `HttpOnly`, `Secure`, `Domain`/`Path` scope, expiry |
| [ ] | ★ | Sessions vs tokens | Where state lives |
| [ ] | ★ | Content negotiation, compression, chunked transfer encoding | |
| [ ] | ★★ | Keep-alive and connection reuse | |
| [ ] | ★ | Proxies — forward vs reverse; `X-Forwarded-For` | |

### 6.2 Versions

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | HTTP/1.0 vs 1.1 | Persistent connections, `Host`, pipelining and why it failed |
| [ ] | ★★ | **HTTP/2** | Binary framing, streams, multiplexing, HPACK, per-stream flow control |
| [ ] | ★ | HTTP/2 server push | And why it was abandoned |
| [ ] | ★★ | **Why HTTP/2 still has head-of-line blocking** | It's at the TCP level, not the HTTP level |
| [ ] | ★★ | **HTTP/3 over QUIC** | Independent streams, 0-RTT, connection migration |

### 6.3 Browser security model

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | Same-origin policy | What counts as an origin |
| [ ] | ★★ | **CORS** | Simple vs preflighted requests; `Access-Control-*` headers; why the *browser* does this |
| [ ] | ★★ | **CSRF** and token defences | And why `SameSite=Lax` changed things |
| [ ] | ★ | XSS — reflected, stored, DOM | Boundary with the security track |
| [ ] | | CSP, HSTS | |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | A client retries a failed request. Which methods are safe to retry blindly, and why? |
| [ ] | Explain `ETag` — what does it solve that `Cache-Control` alone doesn't? |
| [ ] | HTTP/2 multiplexes over one connection. So why does HTTP/3 exist? |
| [ ] | Explain CORS to someone who thinks it's a browser bug |
| [ ] | Why doesn't CORS protect the server? What actually does? |

---

## 7. TLS / HTTPS

### 7.1 Crypto primitives

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | Symmetric vs asymmetric encryption | Cost difference is the whole reason for the handshake design |
| [ ] | ★★ | **Hashing vs encryption vs encoding** | Base64 is not encryption |
| [ ] | ★ | Digital signatures; MAC and HMAC | |
| [ ] | ★ | Key exchange — Diffie-Hellman, ECDHE | |

### 7.2 The protocol

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | Certificates, X.509, chain of trust, CAs, root store | What a certificate actually *proves* |
| [ ] | ★★ | **TLS 1.2 handshake** | Which parts asymmetric, which symmetric, and **why both** |
| [ ] | ★★ | **TLS 1.3** | 1-RTT; 0-RTT and its replay risk |
| [ ] | ★ | Cipher suites and negotiation | |
| [ ] | ★ | **Perfect forward secrecy** | |
| [ ] | ★ | **Session resumption** | Session IDs vs session tickets — 0-RTT is this taken further |
| [ ] | ★ | **SNI** | And what it leaks; ECH as the fix |
| [ ] | ★★ | **ALPN** | How client and server agree on `h2` *during* the handshake — the seam with §6 |
| [ ] | ★ | **Revocation — CRL, OCSP, OCSP stapling** | Why the mechanism is weak |
| [ ] | ★ | mTLS | |
| [ ] | ★★ | **What HTTPS protects and what it doesn't** | SNI leaks the hostname; traffic analysis works |
| [ ] | | HSTS, certificate pinning, Certificate Transparency | |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | Why asymmetric for the handshake and symmetric for the session? Why not one or the other? |
| [ ] | An attacker on the same wifi sees your HTTPS traffic. What can they learn? |
| [ ] | How does a browser learn a certificate was revoked, and why is that mechanism weak? |
| [ ] | Where does the client find out the server speaks HTTP/2? Why must it happen there? |
| [ ] | What does a certificate actually prove — and what does it not? |

---

## 8. WebSocket & Realtime

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★★ | **Upgrade handshake** | HTTP 101, `Upgrade`/`Connection`, `Sec-WebSocket-Key`/`Accept` |
| [ ] | ★★ | **Framing** | Opcodes, payload length encoding, fragmentation |
| [ ] | ★★ | **Why client→server frames are masked** | |
| [ ] | ★★ | Ping/pong and close codes | |
| [ ] | ★★ | **Half-open connections** | Why TCP doesn't tell you the client is gone |
| [ ] | ★ | Backpressure on a WebSocket | |
| [ ] | ★★ | **WebSocket vs SSE vs long polling vs short polling** | Build the tradeoff table yourself |
| [ ] | ★ | WebRTC basics — STUN, TURN, ICE | How peers get through NATs |

**Explain aloud:**

| ✔ | Check |
|---|---|
| [ ] | Why does the WebSocket handshake start as HTTP rather than being its own protocol? |
| [ ] | Why are client-to-server frames masked? → [answer](#answer-keys) |
| [ ] | How do you know a client is gone when TCP hasn't told you? |
| [ ] | SSE vs WebSocket — when is SSE the better choice? |

> **You've built on this protocol.** Getting the mechanics precise here is what lets the scaling
> discussion in a design round rest on something solid.

---

## 9. Other Application Protocols

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | SMTP, IMAP, POP3 | The email send/retrieve split |
| [ ] | ★ | FTP vs SFTP vs FTPS | Control and data connections; active vs passive |
| [ ] | ★ | SSH | Key-based auth, port forwarding |
| [ ] | | Telnet | And why it's dead |
| [ ] | | SNMP, NTP | |
| [ ] | ★ | Email delivery path | MX lookup → SMTP relay → mailbox |

---

## 10. Network Security

| ✔ | ★ | Topic | Notes |
|---|---|---|---|
| [ ] | ★ | Firewalls — stateless packet filter vs stateful | |
| [ ] | ★ | VPN and tunneling; IPSec | Encapsulating one protocol inside another |
| [ ] | ★ | DoS vs DDoS; amplification attacks | |
| [ ] | ★ | Man-in-the-middle, ARP spoofing, DNS spoofing | |
| [ ] | ★ | Packet sniffing; why switches don't fully prevent it | |
| [ ] | | Port scanning | |
| [ ] | | L4 vs L7 load balancing | Boundary — details in the system design track |

---

## 11. Hands-on Drills

Tick when actually run. An afternoon with these teaches more than a week of reading.

| ✔ | ★ | Drill | What you should see |
|---|---|---|---|
| [ ] | ★★ | `tcpdump -i any port 8080` against a local server | A real SYN / SYN-ACK / ACK, then the FIN exchange |
| [ ] | ★ | `ss -tan \| awk '{print $1}' \| sort \| uniq -c` | The state distribution; find `TIME_WAIT` |
| [ ] | ★★ | `traceroute google.com` | Increasing TTL, one hop per line, `* * *` where ICMP is filtered |
| [ ] | ★★ | `ping -M do -s 1472 google.com`, then `-s 1473` | 1472 + 8 ICMP + 20 IP = 1500. One byte more fails |
| [ ] | ★ | `dig +trace example.com` | The whole resolution chain, root → TLD → authoritative |
| [ ] | ★ | `dig` a record, note the TTL, repeat immediately | TTL counting down inside the resolver cache |
| [ ] | ★ | `openssl s_client -connect example.com:443 -alpn h2` | The chain, the negotiated protocol and cipher |
| [ ] | ★ | `curl -v --http1.1` vs `--http2` on the same URL | Header framing difference, connection reuse |
| [ ] | | `lsof -i` / `lsof -p <pid>` | Which sockets and files a process holds |
| [ ] | | `ip route` / `arp -a` | Your routing table and ARP cache |

---

## Resources

- **High Performance Browser Networking** (free online, Grigorik) — the best source for TCP, TLS, HTTP/2 and WebSockets. Chapters 1–4 plus the WebSocket chapter.
- **Cloudflare learning center** — short, accurate articles on DNS, TLS and BGP.
- **GfG Computer Networks tutorial** — strong on §1–§3 and the ARQ/sliding-window material in §2, which is where its exam-shaped coverage is best. Thin on §4.4, §6.2 and §7; use HPBN there.
- **`dig`, `tcpdump`, `curl -v`, `openssl s_client`, `ss`, `traceroute`** — the six that matter.

---

## Answer Keys

Kept out of the checks so re-reading stays retrieval, not recognition.

- **§8, frame masking:** a cache-poisoning defence. An unmasked, attacker-controlled payload could be crafted to look like a valid HTTP request to an intermediary proxy that doesn't understand WebSocket. Per-frame random masking makes the bytes on the wire unpredictable, so the attacker can't choose them.
