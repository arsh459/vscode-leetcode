/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (45.57%)
 * Likes:    30798
 * Dislikes: 1845
 * Total Accepted:    4.9M
 * Total Submissions: 10.8M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * There is an integer array nums sorted in ascending order (with distinct
 * values).
 * 
 * Prior to being passed to your function, nums is possibly left rotated at an
 * unknown index k (1 <= k < nums.length) such that the resulting array is
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices
 * and become [4,5,6,7,0,1,2].
 * 
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -10^4 <= target <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public static int findPivot(int[] nums){
        int i=0;
        int j=nums.length-1;

        

        while(i<=j){
            if(nums[j]>nums[i]){
                return i;
            }
            int mid = i+ (j-i)/2;
            if(nums[mid]>nums[j]){
                i=mid+1;
            }else{
                j=mid;
            }
        }

        return i;
    }

    public int binarySearch(int i, int j, int[] nums, int target){
        while(i<=j){
            int mid=i + (j-i)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                j=mid-1;
            }
            if(nums[mid]<target){
                i=mid+1;
            }
        }

        return -1;
    }




    public int search(int[] nums, int target) {


        // There are two ways
        // 1. we will first find the index where the array is rotated, so we have to find
        // the smallest element in array and then we will do binary search around that element left subArray and rightsubarray

        int pivot = findPivot(nums);
        int leftIndex = binarySearch(pivot,nums.length-1, nums, target);
        int rightIndex = binarySearch(0,pivot-1, nums, target);
        
        if(rightIndex!=-1){
            return rightIndex;
        }
        if(leftIndex!=-1){
            return leftIndex;
        }
        return -1;
    }
}
// @lc code=end

