/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 *
 * https://leetcode.com/problems/product-of-array-except-self/description/
 *
 * algorithms
 * Medium (69.22%)
 * Likes:    26406
 * Dislikes: 1718
 * Total Accepted:    4.9M
 * Total Submissions: 7.1M
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 * 
 * 
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= nums.length <= 10^5
 * -30 <= nums[i] <= 30
 * The input is generated such that answer[i] is guaranteed to fit in a 32-bit
 * integer.
 * 
 * 
 * 
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The
 * output array does not count as extra space for space complexity analysis.)
 * 
 */

// @lc code=start
class Solution {

    // O(n) and S(n)
    // public int[] productExceptSelf(int[] nums) {
    //     int[] prefixArray= new int[nums.length];
    //     int[] suffixArray= new int[nums.length];

    //     prefixArray[0]= nums[0];
    //     for(int i=1;i<nums.length;i++){
    //         prefixArray[i] = nums[i]*prefixArray[i-1];
    //     }

    //     suffixArray[nums.length-1]= nums[nums.length-1];
    //     for(int i=nums.length-2;i>=0;i--){
    //         suffixArray[i] = nums[i]*suffixArray[i+1];
    //     }

    //     int[] answer= new int[nums.length];
    //     for(int i=0;i<nums.length;i++){
    //         if(i==0){
    //             answer[i]=suffixArray[i+1];
    //         }
    //         else if(i==nums.length-1){
    //             answer[i]=prefixArray[i-1];
    //         }
    //         else{
    //             answer[i] = prefixArray[i-1] * suffixArray[i+1];
    //         }
    //     }
    //     return answer;
    // }

    // O(n) and S(1) - We are not making any other arrays
    // just using current one
    public int[] productExceptSelf(int[] nums) {
        int[] answer= new int[nums.length];
  
        // prefix 
        answer[0]= nums[0];
        for(int i=1;i<nums.length;i++){
            answer[i] = nums[i]*answer[i-1];
        }
        // suffix
        for(int i=nums.length-2;i>=0;i--){
            nums[i] = nums[i]*nums[i+1];
        }

        for(int i=nums.length-1;i>=0;i--){
            if(i==0){
                answer[i]=nums[i+1];
            }
            else if(i==nums.length-1){
                answer[i]=answer[i-1];
            }
            else{
                answer[i] = answer[i-1] * nums[i+1];
            }
        }
        return answer;
    }

}
// @lc code=end

