package String;

import java.util.ArrayList;

public class KMP {

    // KMP = Knuth Morris Pratt, pattern searching in O(n + m)
    // n = text length, m = pattern length

    // Naive approach: try to match pattern at every index of text -> O(n * m)
    // Problem with naive: on a mismatch at pattern index j, it throws away everything
    // and restarts from text index i - j + 1. But we already KNOW
    // text[i-j .. i-1] == pat[0 .. j-1]. That comparison work is being repeated.

    // The idea: since the matched part is a prefix of the pattern, the only useful
    // shift is the one where some prefix of the pattern lines up with a suffix of
    // what we already matched. Anything shorter is wasted, anything longer is wrong.
    // So we precompute, for every prefix of the pattern, the longest proper prefix
    // of it that is also a suffix of it -> the LPS array.

    // LPS[i] = length of longest proper prefix of pat[0..i] which is also its suffix
    // "proper" means it cannot be the whole string itself, otherwise LPS[i] = i+1 always

    // pat   = a b a b d
    // lps   = 0 0 1 2 0
    // at index 3 ("abab"), "ab" is both prefix and suffix -> 2

    // Building LPS: two pointers, len = length of current matched prefix, i = current index
    // if pat[i] == pat[len] -> the border extends by one, lps[i] = ++len
    // if they differ and len > 0 -> we cannot extend, but the next best candidate border
    //    is the border of the border, so fall back to len = lps[len-1] (do NOT move i)
    // if len == 0 -> no border possible here, lps[i] = 0, move on
    public static int[] buildLps(String pat) {
        int m = pat.length();
        int[] lps = new int[m];

        int len = 0;
        int i = 1; // start at 1, lps[0] is always 0 since a single char has no proper prefix

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else if (len > 0) {
                len = lps[len - 1]; // fall back to the next shorter border, retry same i
            } else {
                lps[i] = 0;
                i++;
            }
        }

        return lps;
    }

    // Searching: i walks the text and NEVER goes back, j walks the pattern
    // on match -> advance both
    // on mismatch with j > 0 -> j = lps[j-1], i stays. this slides the pattern forward
    //    by (j - lps[j-1]) while keeping the already verified overlap
    // on mismatch with j == 0 -> nothing matched, just move i

    // Time O(n + m): i only increases, so at most n increments. j goes up at most once
    // per i-step and every fallback strictly decreases it, so total fallbacks <= n.
    // Space O(m) for the lps array.
    public static ArrayList<Integer> search(String text, String pat) {
        ArrayList<Integer> matches = new ArrayList<>();

        int n = text.length();
        int m = pat.length();

        if (m == 0 || m > n) {
            return matches;
        }

        int[] lps = buildLps(pat);

        int i = 0; // pointer on text
        int j = 0; // pointer on pattern

        while (i < n) {
            if (text.charAt(i) == pat.charAt(j)) {
                i++;
                j++;

                if (j == m) {
                    matches.add(i - m); // full pattern consumed, match starts here

                    // reset to lps[m-1], not 0, so overlapping matches are still found
                    // ("aa" in "aaaaa" -> 0,1,2,3)
                    j = lps[j - 1];
                }
            } else if (j > 0) {
                j = lps[j - 1]; // common bug: writing lps[j] here, that skips valid shifts
            } else {
                i++;
            }
        }

        return matches;
    }

    public static int firstOccurrence(String text, String pat) {
        ArrayList<Integer> matches = search(text, pat);
        return matches.isEmpty() ? -1 : matches.get(0);
    }

    public static void main(String[] args) {
        String text = "ababcabcabababd";
        String pat = "ababd";

        int[] lps = buildLps(pat);
        System.out.print("lps: ");
        for (int x : lps) {
            System.out.print(x + " ");
        }
        System.out.println();

        System.out.println("matches: " + search(text, pat));
        System.out.println("first: " + firstOccurrence(text, pat));

        System.out.println("overlapping: " + search("aaaaa", "aa"));
        System.out.println("absent: " + firstOccurrence("abcdef", "gh"));
    }
}
