/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (38.66%)
 * Likes:    33169
 * Dislikes: 2035
 * Total Accepted:    5.1M
 * Total Submissions: 13.2M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, return the longest palindromic substring in s.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "cbbd"
 * Output: "bb"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 * 
 * 
 */

// @lc code=start
class Solution {

    // it will take O(N^2)
    // public static boolean isValid(String s){
    //     int n = s.length();
    //     for(int i=0;i<n/2;i++){
    //         if(s.charAt(i) != s.charAt(n-i-1)){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // public String longestPalindrome(String s) {
    //     int n = s.length();
    //     String maxString = "";

    //     for(int i=0;i<n;i++){
    //         for(int j=i+1;j<=n;j++){
    //             String sub = s.substring(i,j);
    //             if(isValid(sub)){
    //                 if(sub.length() > maxString.length()){
    //                    maxString =  sub;
    //                 }
    //             }
    //         }
    //     }

    //     return maxString;
    // }


    // let's find a solution which will take O(n) - We can use 
    // eac - expand around center, so there are like 2n-1 centers in 
    // a string as palidrome can be odd or even


    public String longestPalindrome(String s) {
        int n = s.length();
        String maxString = "";

        for(int i=0;i<2*n;i++){
            int actI = i/2;
            int left = actI-1;
            int right = actI + 1;

            if(i%2!=0){
                left = actI;
                right = actI + 1;
            }
            

            while(left>=0 && right<n && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }

            if(right-left-1 > maxString.length()){
                maxString = s.substring(left+1, right);
            }
        }

        return maxString;
    }

}
// @lc code=end

