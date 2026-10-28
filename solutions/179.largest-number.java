/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 *
 * https://leetcode.com/problems/largest-number/description/
 *
 * algorithms
 * Medium (44.01%)
 * Likes:    9624
 * Dislikes: 813
 * Total Accepted:    892.9K
 * Total Submissions: 2M
 * Testcase Example:  '[10,2]'
 *
 * Given a list of non-negative integers nums, arrange them such that they form
 * the largest number and return it.
 * 
 * Since the result may be very large, so you need to return a string instead
 * of an integer.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [10,2]
 * Output: "210"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));
        String str = "";
        for(int i=0;i<arr.length;i++){
            if(str.length()==0 && Integer.valueOf(arr[i])==0){
                continue;
            }
            str = str +  arr[i];
        }

        if(str.length()==0){
            str="0";
        }

        return str;
    }
}
// @lc code=end

