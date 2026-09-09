/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (66.53%)
 * Likes:    23242
 * Dislikes: 841
 * Total Accepted:    6M
 * Total Submissions: 9M
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array nums of size n, return the majority element.
 * 
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * 
 * 
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 * Constraints:
 * 
 * 
 * n == nums.length
 * 1 <= n <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 * The input is generated such that a majority element will exist in the
 * array.
 * 
 * 
 * 
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = -1;
        int count =0;

        for(int i=0;i<nums.length;i++){
            if(count==0){
                candidate = i;
                count++;
                continue;
            }

            if(nums[candidate]==nums[i]){
                count++;
            }else{
                count--;
            }
        }


        // in question it is written majority will always exist,
        // otherwise we would have verified
        return nums[candidate];
    }
}
// @lc code=end

