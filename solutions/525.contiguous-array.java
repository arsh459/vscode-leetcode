/*
 * @lc app=leetcode id=525 lang=java
 *
 * [525] Contiguous Array
 *
 * https://leetcode.com/problems/contiguous-array/description/
 *
 * algorithms
 * Medium (52.23%)
 * Likes:    9030
 * Dislikes: 456
 * Total Accepted:    733.5K
 * Total Submissions: 1.4M
 * Testcase Example:  '[0,1]'
 *
 * Given a binary array nums, return the maximum length of a contiguous
 * subarray with an equal number of 0 and 1.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number
 * of 0 and 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal
 * number of 0 and 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [0,1,1,1,1,1,0,0,0]
 *               [-1,0,1,2,3,4,3,2,1]
 *               []       
 * Output: 6
 * Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal
 * number of 0 and 1.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * nums[i] is either 0 or 1.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findMaxLength(int[] nums) {
        // we can use the concept of prefix sum here
        // we will add -1 for 0
        // and we will add 1 for 1,
        // wherever sum at two indices is same it means there is same number of
        // 0,1 in between

        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum=0;
        hm.put(sum,-1);
        int max= Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                sum--;
            }else{
                sum++;
            }
            if(hm.containsKey(sum)){
                int minIndex = hm.get(sum);
                max=Math.max(max,i-minIndex);
            }else{
                hm.put(sum, i);
            }
        }

        if(max==Integer.MIN_VALUE){
            return 0;
        }

        return max;
        
    }
}
// @lc code=end

