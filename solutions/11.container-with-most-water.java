/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 *
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (60.58%)
 * Likes:    34740
 * Dislikes: 2233
 * Total Accepted:    5.7M
 * Total Submissions: 9.4M
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * You are given an integer array height of length n. There are n vertical
 * lines drawn such that the two endpoints of the i^th line are (i, 0) and (i,
 * height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array
 * [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the
 * container can contain is 49.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: height = [1,1]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        // Brute force
        // int maxArea= Integer.MIN_VALUE;
        // int n = height.length;
        // for(int i=0;i<n-1;i++){
        //     for(int j=i+1;j<n;j++){
        //         int area = Math.min(height[i],height[j]) * (j-i);
        //         if(area>maxArea){
        //             maxArea = area;
        //         }
        //     }
        // }
        // return maxArea;

        // 2 pointer approach
        // We will start from both the ends and calculated its water and 
        // suppose if left<right then increment left, other wise right


        int max=Integer.MIN_VALUE;
        int i=0;
        int j=height.length-1;
        while(i<j){
            int area = Math.min(height[i],height[j]) * (j-i);
            max = Math.max(area, max);
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
}
// @lc code=end

