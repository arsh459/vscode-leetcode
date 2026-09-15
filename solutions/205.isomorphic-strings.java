/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 *
 * https://leetcode.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (49.06%)
 * Likes:    10826
 * Dislikes: 2302
 * Total Accepted:    2.3M
 * Total Submissions: 4.8M
 * Testcase Example:  '"egg"\n"add"'
 *
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings s and t are isomorphic if the characters in s can be replaced to
 * get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character, but a character may map to itself.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "egg", t = "add"
 * 
 * Output: true
 * 
 * Explanation:
 * 
 * The strings s and t can be made identical by:
 * 
 * 
 * Mapping 'e' to 'a'.
 * Mapping 'g' to 'd'.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "f11", t = "b23"
 * 
 * Output: false
 * 
 * Explanation:
 * 
 * The strings s and t can not be made identical as '1' needs to be mapped to
 * both '2' and '3'.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "paper", t = "title"
 * 
 * Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 5 * 10^4
 * t.length == s.length
 * s and t consist of any valid ascii character.
 * 
 * 
 */

// @lc code=start
class Solution {

    // this works on the concept of rolling hash
    // here can not map
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hm = new HashMap<>();
        HashMap<Character, Character> rhm = new HashMap<>();
        String str="";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            char cht = t.charAt(i);

            if(hm.containsKey(ch)){
                if(hm.get(ch) != cht){
                    return false;
                }
            }else{
                if(rhm.containsKey(cht)){
                    return false;
                }
                hm.put(ch, cht);
                rhm.put(cht, ch);
            }
            str=str+ hm.get(ch);
        }

        if(str.equals(t)){
            return true;
        }
        return false;
    }
}
// @lc code=end

