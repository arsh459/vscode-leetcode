/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (47.29%)
 * Likes:    32552
 * Dislikes: 3598
 * Total Accepted:    4.5M
 * Total Submissions: 9.5M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 * 
 * 
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Brute Force - O(N) approach with first merge them and then get the median
        int i = 0;
        int j = 0;
        int m = nums1.length;
        int n = nums2.length;
        int k=0;
        int[] res = new int[m+n];
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                res[k]=nums1[i];
                i++;
            }else{
                res[k]= nums2[j];
                j++;
            }
            k++;
        }

        while(j<n){
            res[k]=nums2[j];
            j++;
            k++;
        }
        
        while(i<m){
            res[k]=nums1[i];
            i++;
            k++;
        }
        
        if((m+n)%2!=0){
            return res[(m+n)/2];
        }else{
            return (res[(m+n+1)/2] + res[(m+n-1)/2])/2.0; // to make it a double
        }



        // We have to do it in next O(log(m+n)) approach will be able to do using two pointer
        // which are making the range shorter 
        // Now What i need to decide is how to make the range shorter the good approach

        // 
    }
}
// @lc code=end

