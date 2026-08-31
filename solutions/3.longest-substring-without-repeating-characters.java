/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (39.89%)
 * Likes:    45633
 * Dislikes: 2237
 * Total Accepted:    10.2M
 * Total Submissions: 25.6M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string s, find the length of the longest substring without duplicate
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3. Note that "bca" and
 * "cab" are also correct answers.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not
 * a substring.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 10^5
 * s consists of English letters, digits, symbols and spaces.
 * 
 * 
 */

// @lc code=start
class Solution {

    // brute Force
    // public static boolean isValidSubString(String str){
    //     HashSet<Character> hs = new HashSet<>();
    //     for(int i=0;i<str.length();i++){
    //         Character ch = str.charAt(i);
    //         if(hs.contains(Character.valueOf(ch))){
    //             return false;
    //         }
    //         hs.add(Character.valueOf(ch));
    //     }
    //     return true;
    // }

    // public int lengthOfLongestSubstring(String s) {
    //     if(s.length() ==0){
    //         return 0;
    //     }


    //     int max= 1;
    //     int n= s.length();
    //     for(int i=0;i<n;i++){
    //         for(int j=i;j<n;j++){
    //             if(isValidSubString(s.substring(i,j+1))){
    //                 if((j+1-i)>max){
    //                     max = j+1-i;
    //                 }
    //             }
    //         }
    //     }

    //     return max;
    // }


    // O(n)
    public int lengthOfLongestSubstring(String s) {
        if(s.length() ==0){
            return 0;
        }

        HashSet<Character> hs = new HashSet<>();
        int n= s.length();

        int left=0;
        int max= 1;

        for(int right =0;right<n;right++){
            while (hs.contains(s.charAt(right))) {
                hs.remove(s.charAt(left));
                left++;
            }
            hs.add(s.charAt(right));
            max= Math.max(max, right+1-left);
        }
        
        return max;
    }
}
// @lc code=end

