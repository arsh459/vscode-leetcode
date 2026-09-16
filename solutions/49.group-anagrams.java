/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (73.28%)
 * Likes:    22572
 * Dislikes: 777
 * Total Accepted:    5.2M
 * Total Submissions: 7.1M
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * 
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * Explanation:
 * 
 * 
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form
 * each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged
 * to form each other.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: strs = [""]
 * 
 * Output: [[""]]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: strs = ["a"]
 * 
 * Output: [["a"]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    // base approach is comparing all the combinations it will take O(n^2 * k)
    // Second approach is we make a hashMap of with key as sorted string O(n * klogk) - k length of longest string
    // Third is we make some unique signature using string as store it as key (n * k) - it will 
    
    // By sorting
    // public List<List<String>> groupAnagrams(String[] s) {
    //     List<List<String>> li = new ArrayList<>();
    //     HashMap<String, Integer> hm = new HashMap<>();
    //     for(int i=0;i<s.length;i++){
    //         char[] chars = s[i].toCharArray();
    //         Arrays.sort(chars);
    //         String str = new String(chars);
    //         if(!hm.containsKey(str)){
    //             hm.put(str,li.size());
    //             li.add(new ArrayList<>(Arrays.asList(s[i])));
    //         }else{
    //             li.get(hm.get(str)).add(s[i]);
    //         }
    //     }
    //     return li;
    // }

    // by unique signature

    // we will make a signature like it all anagrams have same character count
    public String getSignature(String s){
        int[] count = new int[26];
        for(char ch : s.toCharArray()){
            count[ch-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++){
            if(count[i]!=0){
                sb.append((char) ('a' + i)).append(count[i]);
            }
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] s) {
        List<List<String>> li = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0;i<s.length;i++){
            String uSignature = getSignature(s[i]);
            if(!hm.containsKey(uSignature)){
                hm.put(uSignature,li.size());
                li.add(new ArrayList<>(Arrays.asList(s[i])));
            }else{
                li.get(hm.get(uSignature)).add(s[i]);
            }
        }
        return li;
    }


}
// @lc code=end

