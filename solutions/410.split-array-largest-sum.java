/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 *
 * https://leetcode.com/problems/split-array-largest-sum/description/
 *
 * algorithms
 * Hard (61.67%)
 * Likes:    11788
 * Dislikes: 279
 * Total Accepted:    747.1K
 * Total Submissions: 1.2M
 * Testcase Example:  '[7,2,5,10,8]\n2'
 *
 * Given an integer array nums and an integer k, split nums into k non-empty
 * subarrays such that the largest sum of any subarray is minimized.
 * 
 * Return the minimized largest sum of the split.
 * 
 * A subarray is a contiguous part of the array.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [7,2,5,10,8], k = 2
 * Output: 18
 * Explanation: There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8], where the largest sum
 * among the two subarrays is only 18.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,3,4,5], k = 2
 * Output: 9
 * Explanation: There are four ways to split nums into two subarrays.
 * The best way is to split it into [1,2,3] and [4,5], where the largest sum
 * among the two subarrays is only 9.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 10^6
 * 1 <= k <= min(50, nums.length)
 * 
 * 
 */

// @lc code=start
class Solution {

    public boolean isArraySubarrayCountGreaterThank(int[] nums, int k, int sum){
        int subArrayCount = 1;
        int currSum = 0;
        for(int num : nums){
            if(num > sum){
                return true;
            }
            if((currSum + num) > sum){
                subArrayCount++;
                currSum = 0;
            }
            currSum += num;
        }
        if(subArrayCount > k){
            return true;
        }
        return false;
    }



    public int splitArray(int[] nums, int k) {
        // I have to divide the array into subarray such that largest sum is minimized
        // I have to find minimum sum for which i can divide the array into k subarrays. 
        // if not increase the sum and try again.
    
        // now what are the limits to start this
        //  nums[0] < sum < Integer.MAX_VALUE;
        int start = nums[0];
        int end = Integer.MAX_VALUE;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(isArraySubarrayCountGreaterThank(nums, k, mid)){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start;
    }
}
// @lc code=end

