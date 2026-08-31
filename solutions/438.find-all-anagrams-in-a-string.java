/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Medium (54.39%)
 * Likes:    13388
 * Dislikes: 383
 * Total Accepted:    1.3M
 * Total Submissions: 2.4M
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * Given two strings s and p, return an array of all the start indices of p's
 * anagrams in s. You may return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length, p.length <= 3 * 10^4
 * s and p consist of lowercase English letters.
 * 
 * 
 */

// @lc code=start
class Solution {

    public static boolean isAnagram(String s, String p){
        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i=0;i<s.length();i++){
            Integer count = hm.getOrDefault(hm.get(Character.valueOf(s.charAt(i))), 0);
            System.out.println(count);
            hm.put(Character.valueOf(s.charAt(i)), count+1);
        }
        System.out.println(s);
        System.out.println(p);
        System.out.println(hm);

        for(int i=0;i<p.length();i++){
            if(!hm.containsKey(Character.valueOf(p.charAt(i)))){
                return false;
            }
            Integer count = hm.get(Character.valueOf(p.charAt(i)));
            if(count-1<=0){
                hm.remove(Character.valueOf(p.charAt(i)));
            }else{
                hm.put(Character.valueOf(p.charAt(i)), count-1);
            }
        }
        if(hm.size()==0){
            return true;
        }
        return false;

    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>(); 
        int pL = p.length();
        int sL = s.length();

        if(pL>sL){
            return res;
        }

        for(int i=0;i<=sL-pL;i++){
            String sub= s.substring(i, i + pL);
            if(isAnagram(sub, p)){
                res.add(i);
            }
        }

        return res;
    }
}
// @lc code=end

