# CLAUDE.md

## How to respond to problem questions

When I ask about a problem (LeetCode or otherwise), answer in this order:

1. **Thinking behind the approach** — how to *get* to the solution, not the solution itself.
   - What the constraints (n, value ranges, time limits) are telling us before we write anything.
   - What the brute force is and precisely *why* it's too slow / what work it repeats.
   - The observation or invariant that unlocks the better approach — the "aha", stated as a
     chain of reasoning I could have arrived at myself.
   - Which known pattern this maps to (two pointers, sliding window, monotonic stack,
     binary search on answer, DP over subsets, etc.) and the signal that pointed there.
   - Approaches that look tempting but fail, and the specific case that breaks them.

2. **The approach** — the algorithm in prose/pseudocode.
   - Step-by-step, invariants maintained at each step.
   - Time and space complexity, with justification.
   - Edge cases and tricky inputs.

3. **The code** — **only if I explicitly ask for it.**
   - Do not write, sketch, or paste a full solution unprompted.
   - Do not create or edit solution files unprompted.
   - Short illustrative snippets (a few lines showing an index update or a comparator) are fine
     inside step 2 if they clarify the mechanics; a complete working solution is not.
   - When I do ask: Java, matching the style of the existing files in `solutions/`.

If I say "just the code" or "give me the solution", skip straight to it.

## How to explain concepts and algorithms

Explain at the level of an **SDE III** — someone who already knows the fundamentals and wants
depth, not a tutorial.

- Assume fluency in data structures, complexity analysis, and standard algorithms. Don't
  re-explain what a hash map or recursion is.
- Lead with the *why*: what problem the technique exists to solve, and what it costs.
- Cover the invariant / correctness argument, not just the mechanics. Why does it actually work?
- Give the amortized and worst-case analysis, and where the constant factors or cache behavior
  actually matter in practice.
- Compare against the alternatives and state the trade-off explicitly — when you'd reach for
  this vs. something else.
- Mention real-world / system-design usage where it exists (e.g. where this shows up in
  databases, schedulers, compilers, distributed systems).
- Call out the failure modes, degenerate inputs, and common implementation bugs.
- Be direct and dense. Skip the analogies-for-beginners and the recap of basics.

## Repo conventions

- Solutions live in `solutions/`, named `<problem-number>.<slug>.java`.
- Question bank lives in `solutions/lcQuestions/`.
