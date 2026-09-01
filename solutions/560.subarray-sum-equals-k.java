/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (48.08%)
 * Likes:    25717
 * Dislikes: 865
 * Total Accepted:    2.7M
 * Total Submissions: 5.6M
 * Testcase Example:  '[1,1,1]\n2'
 *
 * Given an array of integers nums and an integer k, return the total number of
 * subarrays whose sum equals to k.
 * 
 * A subarray is a contiguous non-empty sequence of elements within an
 * array.
 * 
 * 
 * Example 1:
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 2 * 10^4
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 * 
 * 
 */

// @lc code=start
class Solution {

    // prefix sum, sum[i,j] = sum[j] -sum[i-1];
    // k = sum[j] - sum[i-1];
    // sum[i-1] = sum[j] - k 

    public int subarraySum(int[] nums, int k) {
        if(nums.length==1){
            if(nums[0]==k){
                return 1;
            }
            return 0;
        }
        HashMap<Integer, Integer> hm= new HashMap<>();
        hm.put(0,1);
        int count=0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            if(hm.containsKey(sum-k)){
                count=count+hm.get(sum-k);
            }
            hm.put(sum, hm.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
// @lc code=end

