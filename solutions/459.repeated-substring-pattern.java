/*
 * @lc app=leetcode id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 *
 * https://leetcode.com/problems/repeated-substring-pattern/description/
 *
 * algorithms
 * Easy (48.80%)
 * Likes:    6943
 * Dislikes: 574
 * Total Accepted:    651.6K
 * Total Submissions: 1.3M
 * Testcase Example:  '"abab"'
 *
 * Given a string s, check if it can be constructed by taking a substring of it
 * and appending multiple copies of the substring together.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abab"
 * Output: true
 * Explanation: It is the substring "ab" twice.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aba"
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "abcabcabcabc"
 * Output: true
 * Explanation: It is the substring "abc" four times or the substring "abcabc"
 * twice.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s consists of lowercase English letters.
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



    // there is a clever trick that if string is made of multiple same substrings
    // then if two s are combined and their first and last character is removed then
    // also it should contain the previous string
    public boolean repeatedSubstringPattern(String s) {
        String str = s.substring(1,s.length()) + s.substring(0,s.length()-1);
        int n = str.length();
        int m = s.length();

        int[] lps = buildLps(s);

        int i=0;
        int j=0;

        while(i<n){
            if(str.charAt(i)==s.charAt(j)){
                i++;
                j++;

                if(j==m){
                    return true;
                }
            }
            else if(j>0){
                j=lps[j-1];
            }
            else{
                i++;
            }
        }
        return false;
    }
}
// @lc code=end

