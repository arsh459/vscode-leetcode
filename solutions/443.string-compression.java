/*
 * @lc app=leetcode id=443 lang=java
 *
 * [443] String Compression
 *
 * https://leetcode.com/problems/string-compression/description/
 *
 * algorithms
 * Medium (60.77%)
 * Likes:    6405
 * Dislikes: 8993
 * Total Accepted:    1.2M
 * Total Submissions: 1.9M
 * Testcase Example:  '["a","a","b","b","c","c","c"]'
 *
 * Given an array of characters chars, compress it using the following
 * algorithm:
 * 
 * Begin with an empty string s. For each group of consecutive repeating
 * characters in chars:
 * 
 * 
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * 
 * 
 * The compressed string s should not be returned separately, but instead, be
 * stored in the input character array chars. Note that group lengths that are
 * 10 or longer will be split into multiple characters in chars.
 * 
 * After you are done modifying the input array, return the new length of the
 * array.
 * 
 * You must write an algorithm that uses only constant extra space.
 * 
 * Note: The characters in the array beyond the returned length do not matter
 * and should be ignored.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: chars = ["a","a","b","b","c","c","c"]
 * Output: 6
 * Explanation: The groups are "aa", "bb", and "ccc". This compresses to
 * "a2b2c3".
 * After modifying the input array in-place, the first 6 characters of chars
 * should be ["a","2","b","2","c","3"].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: chars = ["a"]
 * Output: 1
 * Explanation: The only group is "a", which remains uncompressed since it is a
 * single character.
 * After modifying the input array in-place, the first character of chars
 * should be ["a"].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * Output: 4
 * Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to
 * "ab12".
 * After modifying the input array in-place, the first 4 characters of chars
 * should be ["a","b","1","2"].
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= chars.length <= 2000
 * chars[i] is a lowercase English letter, uppercase English letter, digit, or
 * symbol.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {

        if(chars.length<=1){
            return chars.length;
        }


        String str = "";



        int count = 1;
        for(int i=1;i<chars.length;i++){
            if(chars[i]==chars[i-1]){
                count++;
                if(i==chars.length-1){
                    str=str+chars[i]+count;
                }
                continue;
            }
            
            str=str+chars[i-1];
            if(count>1){
                str=str+count;
            }

            if(i==chars.length-1){
                str=str+chars[i];
            }
            count=1;
        }

        for(int i=0;i<str.length();i++){
            chars[i]=str.charAt(i);
        }

        return str.length();
    }
}
// @lc code=end

