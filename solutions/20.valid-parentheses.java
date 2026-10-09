/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (44.91%)
 * Likes:    28521
 * Dislikes: 2036
 * Total Accepted:    8.2M
 * Total Submissions: 18.2M
 * Testcase Example:  '"()"'
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "()"
 * 
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "()[]{}"
 * 
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "(]"
 * 
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "([])"
 * 
 * Output: true
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: s = "([)]"
 * 
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        int n =s.length();
        Stack<Character> st = new Stack<>();

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch== '{' || ch == '[' || ch == '('){
                st.push(ch);
                continue;
            }

            if(st.isEmpty()){
                return false;
            }

            if(!st.isEmpty()){
                char peek = st.peek();

                if((peek=='{' && ch !='}') || (peek=='[' && ch !=']') || (peek=='(' && ch !=')')){
                    return false;
                }

                st.pop();
            }
        }
        

        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}
// @lc code=end

