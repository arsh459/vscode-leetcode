/*
 * @lc app=leetcode id=454 lang=java
 *
 * [454] 4Sum II
 *
 * https://leetcode.com/problems/4sum-ii/description/
 *
 * algorithms
 * Medium (58.19%)
 * Likes:    5118
 * Dislikes: 151
 * Total Accepted:    401.9K
 * Total Submissions: 690.7K
 * Testcase Example:  '[1,2]\n[-2,-1]\n[-1,2]\n[0,2]'
 *
 * Given four integer arrays nums1, nums2, nums3, and nums4 all of length n,
 * return the number of tuples (i, j, k, l) such that:
 * 
 * 
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * Output: 2
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) +
 * (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) +
 * (-1) + 0 = 0
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == nums1.length
 * n == nums2.length
 * n == nums3.length
 * n == nums4.length
 * 1 <= n <= 200
 * -2^28 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2^28
 * 
 * 
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int n = nums1.length;
        int count =0;

        // brute force - O(N^4)
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         for(int k=0;k<n;k++){
        //             for(int l=0;l<n;l++){
        //                 if(nums1[i]+nums2[j]+nums3[k]+nums4[l]==0){
        //                     count++;
        //                 }
        //             }
        //         }
        //     }
        // }

        // Using Hashmap for 1 loop - O(N^3)
        // HashMap<Integer, Integer> hm = new HashMap<>();
        // for(int i=0;i<n; i++ ){
        //     hm.put(nums4[i], hm.getOrDefault(nums4[i],0)+1);
        // }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         for(int k=0;k<n;k++){
        //             int sum = nums1[i]+nums2[j]+nums3[k];
        //             if(hm.containsKey(-1*sum)){
        //                 count= count + hm.get(-1*sum);
        //             }
        //         }
        //     }
        // }

        // using HashMap - removing one more loop - O(N^2)
        // We will store the possible sum of 3rd and forth arrays
        // in N^2 time

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sum = nums3[i] + nums4[j];
                hm.put(sum, hm.getOrDefault(sum,0)+1);
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sum = nums1[i] + nums2[j];
                if(hm.containsKey(-1*sum)){
                    count = count + hm.get(-1*sum);
                }
            }
        }

        return count;
    }
}
// @lc code=end

