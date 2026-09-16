/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (54.27%)
 * Likes:    12045
 * Dislikes: 8666
 * Total Accepted:    6M
 * Total Submissions: 11M
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads the
 * same forward and backward. Alphanumeric characters include letters and
 * numbers.
 * 
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric
 * characters.
 * Since an empty string reads the same forward and backward, it is a
 * palindrome.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 2 * 10^5
 * s consists only of printable ASCII characters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {

        // These can also be used
        // Character.isLetterOrDigit
        // Character.toLowerCase
        String str = "";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>=48 && ch<=57){
                str=str+ch;
            }
            if(ch>=65 && ch<=90){
                str=str+ch;
            }
            if(ch>=97 && ch<=122){
                str=str+ch;
            }
        }

        str = str.toLowerCase();
                System.out.println(str);

        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt((str.length()-1)-i)){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

