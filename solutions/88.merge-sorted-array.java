/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 *
 * https://leetcode.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (55.58%)
 * Likes:    19440
 * Dislikes: 2679
 * Total Accepted:    6.1M
 * Total Submissions: 10.9M
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
 * order, and two integers m and n, representing the number of elements in
 * nums1 and nums2 respectively.
 * 
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * 
 * The final sorted array should not be returned by the function, but instead
 * be stored inside the array nums1. To accommodate this, nums1 has a length of
 * m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a
 * length of n.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming
 * from nums1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there
 * to ensure the merge result can fit in nums1.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -10^9 <= nums1[i], nums2[j] <= 10^9
 * 
 * 
 * 
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 * 
 */

// @lc code=start
class Solution {

    // insert in an array
    public void insert(int[] nums1, int i, int val){
        for(int j=nums1.length-1;j>i;j--){
            nums1[j]=nums1[j-1];
        }
        nums1[i]=val;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // Ways to do this 
        // 1. Can have a third array and do insertion there it will take O(m+n) and S(m+n)
        // 2. We can have it in nums1 array and do the insertion it can have O(m*n) as i have to perform 
        // insertion for every element of 2nd array(m) and insertion takes n operations so O(m*n) space 
        // complexity will be O(1).
        // 3. I have to find a way to do inplace insertion so that it O(m+n) and S(1). There is
        // a way with two pointers where we are

        int i=0;
        int j=0;

        while(i<m+n && j<n){
            if(nums1[i]>=nums2[j]){
                insert(nums1, i, nums2[j]);
                j++;
                i++;
            }else{
                i++;
            }
        }

        while(j!=n){
            nums1[m+j]=nums2[j];
            j++;
        }
    }
}
// @lc code=end

