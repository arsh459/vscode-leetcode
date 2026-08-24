/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (64.29%)
 * Likes:    19788
 * Dislikes: 615
 * Total Accepted:    5.6M
 * Total Submissions: 8.7M
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 * 
 * 
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 
 * 
 * 
 * Follow up: Could you minimize the total number of operations done?
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;  // keeping track of the zero
        int j=0;

        // finding first zero
        while(i<nums.length){
            if(nums[i]==0){
                break;
            }
            i++;
        }

        // starting point
        j = i+1;

        // then iteration
        while(j<nums.length){
            if(nums[j]!=0){
                nums[i]=nums[j];
                nums[j]=0;
                i++;
            }
            j++;
        }
    }
}
// @lc code=end

