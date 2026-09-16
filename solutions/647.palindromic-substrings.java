/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 *
 * https://leetcode.com/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (73.23%)
 * Likes:    11707
 * Dislikes: 258
 * Total Accepted:    1.3M
 * Total Submissions: 1.7M
 * Testcase Example:  '"abc"'
 *
 * Given a string s, return the number of palindromic substrings in it.
 * 
 * A string is a palindrome when it reads the same backward as forward.
 * 
 * A substring is a contiguous sequence of characters within the string.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count =s.length(); // As all single character are palindromes

        for(int i=0;i<2*n;i++){
            int actI = i/2;
            int left = actI-1;
            int right = actI + 1;

            if(i%2!=0){
                left = actI;
                right = actI + 1;
            }
            

            while(left>=0 && right<n && s.charAt(left) == s.charAt(right)){
                count++;
                left--;
                right++;
            }
        }

        return count; 
    }
}
// @lc code=end

