/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 *
 * algorithms
 * Medium (52.77%)
 * Likes:    14734
 * Dislikes: 549
 * Total Accepted:    2.1M
 * Total Submissions: 4M
 * Testcase Example:  '7\n[2,3,1,2,4,3]'
 *
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal
 * to target. If there is no such subarray, return 0 instead.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem
 * constraint.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^4
 * 
 * 
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution of which the time complexity is O(n log(n)).
 */

// @lc code=start
class Solution {
    // Brute force
    // public boolean isSumTarget(int i,int j, int[] nums, int target){
    //     int sum=0;
    //     for(int k=i;k<=j;k++){
    //         sum+=nums[k];
    //     }
    //     return sum>=target;
    // }

    // public int minSubArrayLen(int target, int[] nums) {
    //     int n = nums.length;
    //     int min = Integer.MAX_VALUE;
    //     for(int i=0;i<n;i++){
    //         for(int j=i;j<n;j++){
    //             if(isSumTarget(i,j,nums,target)){
    //                 if((j+1-i)<min){
    //                     min=j+1-i;
    //                 }
    //             }
    //         }
    //     }
    //     if(min==Integer.MAX_VALUE){
    //         return 0;
    //     }
    //     return min;
    // }


    // O(n) - Using Sliding Window
    public int minSubArrayLen(int target, int[] nums) {
        int left =0;
        int min=Integer.MAX_VALUE;

        int currSum=0;
        for(int right =0;right<nums.length;right++){
            currSum+=nums[right];
            while(currSum>=target){
                min = Math.min(min, right+1-left);
                currSum-=nums[left];
                left++;
            }
        }
        if(min==Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }
}
// @lc code=end

