/*
 * @lc app=leetcode id=448 lang=java
 *
 * [448] Find All Numbers Disappeared in an Array
 *
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 *
 * algorithms
 * Easy (64.60%)
 * Likes:    10582
 * Dislikes: 561
 * Total Accepted:    1.5M
 * Total Submissions: 2.3M
 * Testcase Example:  '[4,3,2,7,8,2,3,1]'
 *
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear
 * in nums.
 * 
 * 
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * Example 2:
 * Input: nums = [1,1]
 * Output: [2]
 * 
 * 
 * Constraints:
 * 
 * 
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i] <= n
 * 
 * 
 * 
 * Follow up: Could you do it without extra space and in O(n) runtime? You may
 * assume the returned list does not count as extra space.
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //  1. It can be done using a simple hashset, but it will take a S(n), so we will use 
        // array index itself as hash. It is often called cyclic sort.

        List<Integer> li = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int currValue = Math.abs(nums[i]);
            int valueIndex =  currValue - 1;
            nums[valueIndex] = -1 * Math.abs(nums[valueIndex]);
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                li.add(i+1);
            }
        }

        return li;

        
    }
}
// @lc code=end

