/*
 * @lc app=leetcode id=187 lang=java
 *
 * [187] Repeated DNA Sequences
 *
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 *
 * algorithms
 * Medium (53.99%)
 * Likes:    3681
 * Dislikes: 576
 * Total Accepted:    563.8K
 * Total Submissions: 1M
 * Testcase Example:  '"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"'
 *
 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A',
 * 'C', 'G', and 'T'.
 * 
 * 
 * For example, "ACGAATTCCG" is a DNA sequence.
 * 
 * 
 * When studying DNA, it is useful to identify repeated sequences within the
 * DNA.
 * 
 * Given a string s that represents a DNA sequence, return all the
 * 10-letter-long sequences (substrings) that occur more than once in a DNA
 * molecule. You may return the answer in any order.
 * 
 * 
 * Example 1:
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC","CCCCCAAAAA"]
 * Example 2:
 * Input: s = "AAAAAAAAAAAAA"
 * Output: ["AAAAAAAAAA"]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s[i] is either 'A', 'C', 'G', or 'T'.
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> li = new ArrayList<>();
        if(s.length()<=10){
            return li;
        }

        String str = s.substring(0,10);
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put(str, 1);
        for(int i=10;i<s.length();i++){
            str = str.substring(1,10) + s.charAt(i); 
            if(hm.containsKey(str) && hm.get(str)==1){
                li.add(str);
                hm.put(str,2);
            }else{
                hm.put(str, hm.getOrDefault(str, 0)+1);
            }
        }
        return li;
    }
}
// @lc code=end

