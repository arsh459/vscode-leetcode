/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 *
 * https://leetcode.com/problems/rotate-array/description/
 *
 * algorithms
 * Medium (45.47%)
 * Likes:    21533
 * Dislikes: 2214
 * Total Accepted:    4.3M
 * Total Submissions: 9.4M
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * Given an integer array nums, rotate the array to the right by k steps, where
 * k is non-negative.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation: 
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^5
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * Try to come up with as many solutions as you can. There are at least three
 * different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * 
 * 
 */

// @lc code=start
class Solution {
    public void rotate(int[] a, int k) {
        // 1. way can be use another array and store there  - O(n) and S(n)
        // 2. take last element and insert at start do in while loop until count of elements moved is k - O(n*k) , S(1)
        // 3. reverse the whole array, then reverse back first element and then reverse back n-k elements - O(n) and S(1)

        int n=a.length;
        k = k%n;
        for(int i=0;i<n/2;i++){
            int temp = a[i];
            a[i]=a[n-1-i];
            a[n-1-i]=temp;
        }

        for(int i=0;i<k/2;i++){
            int temp = a[i];
            a[i]=a[k-1-i];
            a[k-1-i]=temp;
        }

        for(int i=0;i<(n-k)/2;i++){
            int temp = a[i+k];
            a[i+k]=a[n-1-i];
            a[n-1-i]=temp;
        }
    }
}
// @lc code=end

