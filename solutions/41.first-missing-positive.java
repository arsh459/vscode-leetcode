/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 *
 * https://leetcode.com/problems/first-missing-positive/description/
 *
 * algorithms
 * Hard (43.68%)
 * Likes:    18683
 * Dislikes: 1989
 * Total Accepted:    1.9M
 * Total Submissions: 4.3M
 * Testcase Example:  '[1,2,0]'
 *
 * Given an unsorted integer array nums. Return the smallest positive integer
 * that is not present in nums.
 * 
 * You must implement an algorithm that runs in O(n) time and uses O(1)
 * auxiliary space.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are all in the array.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Explanation: 1 is in the array but 2 is missing.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * Explanation: The smallest positive integer 1 is missing.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
class Solution {
    // 
    // public int firstMissingPositive(int[] nums) {
    //     HashSet<Integer> hs = new HashSet<>();
    //     for(int i=0;i<nums.length;i++){
    //         hs.add(nums[i]);
    //     }
    //     for(int i=1;i<=Integer.MAX_VALUE;i++){
    //         if(!hs.contains(i)){
    //             return i;
    //         }
    //     }
    //     return 1;
    // }


    // one more thing we can do is iterate over array once and place all +ve number at theire
    // respective value-1 index
    public int firstMissingPositive(int[] nums) {
        int i=0;
        while(i<nums.length){
            if(nums[i]>0){
                int index = nums[i]-1;

                if(index>nums.length-1){
                    i++;
                    continue;
                }


                int temp = nums[index];
                if(nums[i]==nums[index]){
                    i++;
                    continue;
                }
                nums[index] = nums[i];
                nums[i]=temp;
            }else{
                i++;
            }
        }
        int j=0;
        while(j<nums.length){
            if(nums[j]<=0){
                return j+1;
            }
            j++;
        }
        return j;
    }
}
// @lc code=end

