/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 *
 * https://leetcode.com/problems/basic-calculator-ii/description/
 *
 * algorithms
 * Medium (47.17%)
 * Likes:    6660
 * Dislikes: 961
 * Total Accepted:    983K
 * Total Submissions: 2.1M
 * Testcase Example:  '"3+2*2"'
 *
 * Given a string s which represents an expression, evaluate this expression
 * and return its value. 
 * 
 * The integer division should truncate toward zero.
 * 
 * You may assume that the given expression is always valid. All intermediate
 * results will be in the range of [-2^31, 2^31 - 1].
 * 
 * Note: You are not allowed to use any built-in function which evaluates
 * strings as mathematical expressions, such as eval().
 * 
 * 
 * Example 1:
 * Input: s = "3+2*2"
 * Output: 7
 * Example 2:
 * Input: s = " 3/2 "
 * Output: 1
 * Example 3:
 * Input: s = " 3+5 / 2 "
 * Output: 5
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 3 * 10^5
 * s consists of integers and operators ('+', '-', '*', '/') separated by some
 * number of spaces.
 * s represents a valid expression.
 * All the integers in the expression are non-negative integers in the range
 * [0, 2^31 - 1].
 * The answer is guaranteed to fit in a 32-bit integer.
 * 
 * 
 */

// @lc code=start
class Solution {
    // we have to follow the concept of BOD MAS
    public int calculate(String s) {
        String str = "";
        int n = s.length();
        
        // remove spaces
        for(int i=0;i<n;i++){
            if(s.charAt(i)==' '){
                continue;
            }
            str = str + s.charAt(i);
        }
        s = str;
        n = s.length();
        str = ""; 

        // now let;s divide
        for(int i=0;i<n;i++){
            str = str + s.charAt(i);
            if(s.charAt(i)=='/'){
                // find the numbers index around it

                int k = i-1;



                // left number index
                while(k>0){
                    if(s.charAt(k)=='*' || s.charAt(k)=='+' || s.cha ){}
                    k--;
                }

                // right number index
                while(){}
            }
        }


    }
}
// @lc code=end

