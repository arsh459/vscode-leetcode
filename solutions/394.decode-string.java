/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 *
 * https://leetcode.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (63.38%)
 * Likes:    14293
 * Dislikes: 721
 * Total Accepted:    1.3M
 * Total Submissions: 2.1M
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; there are no extra
 * white spaces, square brackets are well-formed, etc. Furthermore, you may
 * assume that the original data does not contain any digits and that digits
 * are only for those repeat numbers, k. For example, there will not be input
 * like 3a or 2[4].
 * 
 * The test cases are generated so that the length of the output will never
 * exceed 10^5.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets
 * '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 * 
 * 
 */

// @lc code=start
class Solution {
    // public String decodeString(String s) {
    //     Stack<Character> st = new Stack<>();
    //     String str="";
    //     for(int i=0;i<s.length();i++){
    //         char ch = s.charAt(i);
    //         if(ch!=']'){
    //             st.push(ch);
    //             continue;
    //         }
    //
    //         String temp = "";
    //         while(st.peek()!='['){
    //             temp = st.pop() + temp;
    //         }
    //         st.pop();
    //
    //         String num = "";
    //         while(!st.isEmpty() && Character.isDigit(st.peek())){
    //             num = st.pop() + num;
    //         }
    //
    //         int r = Integer.valueOf(num);
    //
    //         for(int j=r;j>0;j--){
    //             for(int k=0;k<temp.length();k++){
    //                 st.push(temp.charAt(k));
    //             }
    //         }
    //     }
    //
    //
    //     while(!st.isEmpty()){
    //         str = st.pop() + str;
    //     }
    //
    //     return str;
    // }

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<int[]> st = new ArrayDeque<>();
        int k = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                k = k*10 + (ch-'0');
            }
            else if(ch=='['){
                st.push(new int[]{sb.length(), k});
                k = 0;
            }
            else if(ch==']'){
                int[] top = st.pop();
                int start = top[0];
                int end = sb.length();
                for(int j=1;j<top[1];j++){
                    sb.append(sb, start, end);
                }
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
// @lc code=end

