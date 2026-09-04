/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 *
 * https://leetcode.com/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (52.16%)
 * Likes:    19152
 * Dislikes: 908
 * Total Accepted:    5.1M
 * Total Submissions: 9.8M
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums contains distinct values sorted in ascending order.
 * -10^4 <= target <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {

    public static int searchInIJIteration(int[] nums, int target){
        int i=0;
        int j= nums.length-1;
        while(i<=j){
            int mid = i+((j-i)/2);
            if(target==nums[mid]){
                return mid;
            }
            if(target>nums[mid]){
                i=mid+1;
            }
            if(target<nums[mid]){
                j=mid-1;
            }
        }
        return i;
    }   

    public int searchInsert(int[] nums, int target) {
        return searchInIJIteration(nums,target);
    }
}
// @lc code=end

