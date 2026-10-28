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
    // we can do one thing like, there are 4 characters,
    // / - Do this first
    // * - Do this
    // +
    // -




    // we have to follow the concept of BOD MAS
    public int calculate(String s) {
        int n = 0;
        char op = '+';
        Stack<Integer> st = new Stack<>();
        int res = 0;
        s+='+';

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch==' '){
                continue;
            }

            if(Character.isDigit(ch)){
                n = n*10 + (ch-'0');
                continue;
            }

            if(op=='+'){
                st.push(n);
            }else if(op=='-'){
                st.push(-1*n);
            }else if(op=='*'){
                st.push(st.pop() * n);
            }else{
                st.push(st.pop() / n);
            }

            op=ch;
            n=0;
        }
        while(!st.isEmpty()){
            res = res + st.pop();
        }

        return res;
    }
}
// @lc code=end

