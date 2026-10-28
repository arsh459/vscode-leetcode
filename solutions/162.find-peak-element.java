/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 *
 * https://leetcode.com/problems/find-peak-element/description/
 *
 * algorithms
 * Medium (47.17%)
 * Likes:    14956
 * Dislikes: 4965
 * Total Accepted:    2.6M
 * Total Submissions: 5.5M
 * Testcase Example:  '[1,2,3,1]'
 *
 * A peak element is an element that is strictly greater than its neighbors.
 * 
 * 
 * 
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is
 * always considered to be strictly greater than a neighbor that is outside the
 * array.
 * 
 * You must write an algorithm that runs in O(log n) time.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index
 * number 2.
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak
 * element is 2, or index number 5 where the peak element is 6.
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 1000
 * -2^31 <= nums[i] <= 2^31 - 1
 * nums[i] != nums[i + 1] for all valid i.
 * 
 * 
 */

// @lc code=start
class Solution {
    // O(N)
    // public int findPeakElement(int[] nums) {
    //     if(nums.length == 1){
    //         return 0;
    //     }
    //     // one way is to just do the thing
    //     for(int i=0;i<nums.length;i++){
    //         if(i==0){
    //             if(nums[0] > nums[1]){
    //                 return 0;
    //             }
    //         }
    //         else if(i==nums.length-1){
    //             if(nums[i] > nums[i-1]){
    //                 return i;
    //             }
    //         }
    //         else{
    //             if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
    //                 return i;
    //             }
    //         }
    //     }
    //     return -1;
    // }


    // O(logn)
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length ==0){
            return 0;
        }
        if(nums.length == 1){
            return 0;
        }
        if(nums[0]>nums[1]){
            return 0;
        }
        if(nums[nums.length-1] > nums[nums.length-2]){
            return nums.length-1;
        }

        // if the array has one peak
        int i=1;
        int j=nums.length - 2; // as we have already looked at the last element case
        while(i<=j){
            int mid = i +((j-i)/2);
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
               return mid;  
            }
            if(nums[mid]>nums[mid-1]){
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }

        // if array has multiple peaks
        // it has the same condition as if no consecutive duplicates exist,
        // we can just find on which slope we are on as per our above example
        // there is only one case in which it will get stuck if mid is at 
        // trough
        // so we have to handle this
        // so we go to any side
        

        return -1;
    }
}
// @lc code=end

