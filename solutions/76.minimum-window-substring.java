/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (48.37%)
 * Likes:    20631
 * Dislikes: 864
 * Total Accepted:    2.3M
 * Total Submissions: 4.8M
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given two strings s and t of lengths m and n respectively, return the
 * minimum window substring of s such that every character in t (including
 * duplicates) is included in the window. If there is no such substring, return
 * the empty string "".
 * 
 * The testcases will be generated such that the answer is unique.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
 * from string t.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 10^5
 * s and t consist of uppercase and lowercase English letters.
 * 
 * 
 * 
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 * 
 */

// @lc code=start
class Solution {
    public boolean isStringContainsAllT(String t, String s){
        HashMap<Character, Integer> hs = new HashMap<>();
        for(int i=0;i<s.length();i++){
            int count = hs.getOrDefault(s.charAt(i), 0);
            hs.put(s.charAt(i), count+1);
        }
        for(int i=0;i<t.length();i++){
            if(!hs.containsKey(t.charAt(i)) || hs.get(t.charAt(i))<=0){
                return false;
            }
            hs.put(t.charAt(i), hs.get(t.charAt(i))-1);
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(m>n){
            return "";
        }

        String minString = "";
        int min=Integer.MAX_VALUE;
        String str = s.substring(0,m-1);
        
        int i=0;
        for(int j=m-1;j<n;j++){
            str= str + s.charAt(j);
            while(isStringContainsAllT(t, str)){
                if(min>(j+1-i)){
                    min= j+1-i;
                    minString=str;
                }
                i++;
                str=str.substring(1);
            }
        }
        return minString;
    }
}
// @lc code=end

