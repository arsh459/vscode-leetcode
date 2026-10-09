/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Find the Index of the First Occurrence in a String
 *
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 *
 * algorithms
 * Easy (47.32%)
 * Likes:    7866
 * Dislikes: 599
 * Total Accepted:    4.4M
 * Total Submissions: 9.2M
 * Testcase Example:  '"sadbutsad"\n"sad"'
 *
 * Given two strings needle and haystack, return the index of the first
 * occurrence of needle in haystack, or -1 if needle is not part of
 * haystack.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= haystack.length, needle.length <= 10^4
 * haystack and needle consist of only lowercase English characters.
 * 
 * 
 */

// @lc code=start
class Solution {

    public int[] buildLps(String pat){        
        int[] lps = new int[pat.length()];
        lps[0] = 0;

        int len = 0;
        int i = 1;

        while(i<pat.length()){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else if(len > 0){
                len = lps[len-1];
            }
            else{
                lps[i] = 0;
                i++;
            }
        }

        return lps;
    }

    public int strStr(String haystack, String needle) {
        int[] lps = buildLps(needle);

        int i=0;
        int j=0;

        while(i<haystack.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;

                if(j==needle.length()){
                    return i-needle.length();
                }
            }
            else if(j>0){
                j=lps[j-1];
            }
            else{
                i++;
            }
        }

        return -1;
    }
}
// @lc code=end

