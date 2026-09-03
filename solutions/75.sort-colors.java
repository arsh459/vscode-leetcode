/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 *
 * https://leetcode.com/problems/sort-colors/description/
 *
 * algorithms
 * Medium (70.20%)
 * Likes:    22078
 * Dislikes: 780
 * Total Accepted:    4.1M
 * Total Submissions: 5.8M
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * You are given an array nums with n objects colored red, white, or blue, sort
 * them in-place so that objects of the same color are adjacent, with the
 * colors in the order red, white, and blue.
 * 
 * We will use the integers 0, 1, and 2 to represent the color red, white, and
 * blue, respectively.
 * 
 * You must solve this problem without using the library's sort function.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,0,2,1,1,0]
 * 
 * Output: [0,0,1,1,2,2]
 * 
 * Explanation:
 * 
 * The array has two 0s, two 1s, and two 2s. Sorting them in-place places all
 * 0s first, then all 1s, then all 2s.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,0,1]
 * 
 * Output: [0,1,2]
 * 
 * Explanation:
 * 
 * The array has one each of 0, 1, and 2, arranged in-place in the order 0, 1,
 * 2.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 * 
 * 
 * 
 * Follow up: Could you come up with a one-pass algorithm using only constant
 * extra space?
 * 
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        // we can do it with dutch national flag algorithm
        // The Dutch National Flag (DNF) algorithm is a three-way
        //  partitioning technique proposed by Edsger Dijkstra. 
        // It sorts an array containing three distinct values 
        // (traditionally represented as 0s, 1s, and 2s) in O(n) time 
        // and O(1) space using a single pass.
        int n =nums.length;
        int zeroIndex=0;
        int twoIndex=nums.length-1;
        int i=0;

        while(i<=twoIndex){
            if(nums[i]==0){
                nums[i]= 1; // as only 1 can be there on left as all other are
                // shifted
                nums[zeroIndex] = 0;
                zeroIndex++;
                i++;
            }
            else if(nums[i]==2){
                int temp = nums[twoIndex];
                nums[twoIndex] = 2;
                nums[i]= temp;
                twoIndex--;
            }
            else{
                i++;
            }
        }
    }
}
// @lc code=end

