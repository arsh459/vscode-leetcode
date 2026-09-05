/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (49.59%)
 * Likes:    23705
 * Dislikes: 661
 * Total Accepted:    3.6M
 * Total Submissions: 7.2M
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in non-decreasing order, find the
 * starting and ending position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums is a non-decreasing array.
 * -10^9 <= target <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {

    // O(n) approach
    public static void searchInIJIteration(int[] nums, int target, int[] res){
        int i=0;
        int j= nums.length-1;
        while(i<=j){
            int mid = i+((j-i)/2);
            if(target==nums[mid]){
                res[0]=0;
                res[1]=nums.length-1;
                for(int k=mid;k<nums.length;k++){
                    if(nums[k]!=target){
                        res[1]=k-1;
                        break;
                    }
                }
                for(int k=mid;k>=0;k--){
                    if(nums[k]!=target){
                        res[0]=k+1;
                        break;
                    }
                }
                break;
            }
            if(target>nums[mid]){
                i=mid+1;
            }
            if(target<nums[mid]){
                j=mid-1;
            }
        }
    }  

    // O(logn)
    public static int searchInIJIterationLast(int[] nums, int target){
        int i=0;
        int j= nums.length-1;
        int last = -1;
        while(i<=j){
            int mid = i+((j-i)/2);
            if(target==nums[mid]){
                last=mid;
                i=mid+1;
            }
            if(target>nums[mid]){
                i=mid+1;
            }
            if(target<nums[mid]){
                j=mid-1;
            }
        }
        return last;
    } 

    public static int searchInIJIterationFirst(int[] nums, int target){
        int i=0;
        int j= nums.length-1;
        int first = -1;
        while(i<=j){
            int mid = i+((j-i)/2);
            if(target==nums[mid]){
                first=mid;
                j=mid-1;
            }
            if(target>nums[mid]){
                i=mid+1;
            }
            if(target<nums[mid]){
                j=mid-1;
            }
        }
        return first;
    } 

    

    public int[] searchRange(int[] nums, int target) {
        int[] res= new int[2];
        res[0]=-1;
        res[1]=-1;
        // searchInIJIteration(nums, target, res); // this will take logn+n - means O(n)
        // which is not better than normal array search 

        // We will use two binary searches first, last
        res[0]= searchInIJIterationFirst(nums, target);
        res[1]= searchInIJIterationLast(nums, target);

        return res;
    }
}
// @lc code=end

