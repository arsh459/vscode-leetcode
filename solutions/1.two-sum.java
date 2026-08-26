/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (57.95%)
 * Likes:    69490
 * Dislikes: 2592
 * Total Accepted:    22.9M
 * Total Submissions: 39.6M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * You are given an array of integers nums and an integer target, return
 * indices of the two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * Only one valid answer exists.
 * 
 * 
 * 
 * Follow-up: Can you come up with an algorithm that is less than O(n^2) time
 * complexity?
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Brute force - O(n^2) - Here pointer solution will not work as we have to use two arrays
        // one to maintain original indexes and one to maintain element values in sorted order and we have
        // to write custom sort function
        // int n = nums.length;
        // int[] res= new int[2];
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(nums[i]+nums[j]==target){
        //             res[0]=i;
        //             res[1]=j;
        //             break;
        //         }
        //     }
        // }
        // return res;

        // Hashmap - O(n)
        int[] res= new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(target-nums[i])){
                res[1]=i;
                res[0]=hm.get(target-nums[i]);
                break;
            }else{
                hm.put(nums[i],i);
            }
        } 
        return res;
        
    
    }
}
// @lc code=end

