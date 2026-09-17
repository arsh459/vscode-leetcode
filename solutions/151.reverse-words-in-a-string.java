/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 *
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 *
 * algorithms
 * Medium (57.86%)
 * Likes:    10911
 * Dislikes: 5665
 * Total Accepted:    3.3M
 * Total Submissions: 5.6M
 * Testcase Example:  '"the sky is blue"'
 *
 * Given an input string s, reverse the order of the words.
 * 
 * A word is defined as a sequence of non-space characters. The words in s will
 * be separated by at least one space.
 * 
 * Return a string of the words in reverse order concatenated by a single
 * space.
 * 
 * Note that s may contain leading or trailing spaces or multiple spaces
 * between two words. The returned string should only have a single space
 * separating the words. Do not include any extra spaces.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing
 * spaces.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a
 * single space in the reversed string.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s contains English letters (upper-case and lower-case), digits, and spaces '
 * '.
 * There is at least one word in s.
 * 
 * 
 * 
 * Follow-up: If the string data type is mutable in your language, can you
 * solve it in-place with O(1) extra space?
 * 
 */

// @lc code=start
class Solution {

    // Brute force - O(n) in runtime and O(n) in space
    // public String reverseWords(String s) {
    //     int n =s.length();
    //     ArrayList<String> li = new ArrayList<>();
        
    //     int i=0;
    //     while(i<n){
    //         int start=i;
    //         while(i<n && s.charAt(i)!=' '){
    //             i++;
    //         }
    //         if(start!=i){
    //             li.add(s.substring(start,i));
    //         }
    //         i++;
    //     }

    //     s="";
    //     for(int j=li.size()-1;j>=0;j--){
    //         s= s+ li.get(j);
    //         if(j!=0){
    //             s=s+" ";
    //         }
    //     }
    //     return s;
    // }


    public static void reverse(StringBuilder sb, int k, int l){
        int n = l-k;
        for(int i=0;i<n/2;i++){
            char temp = sb.charAt(k+i);
            sb.setCharAt(k+i, sb.charAt(l-i-1));
            sb.setCharAt(l-i-1, temp);
        }
    }


    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = sb.length();

        // we have first reversed the whole string
        reverse(sb,0,n);
        System.out.println(sb);

        // now we will reverse the words, to get original words
        int i=0;
        while(i<n){
            int start=i;
            while(i<n && sb.charAt(i)!=' '){
                i++;
            }
            if(start!=i){
                reverse(sb,start,i);
            }
            i++;
        }


        // Now we will move the words to there respective poistion
        i=0;
        while(i<n){
            
        }

        

        return sb.toString();
    }
}
// @lc code=end

