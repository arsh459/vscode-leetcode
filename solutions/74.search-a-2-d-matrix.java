/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 *
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (54.34%)
 * Likes:    18378
 * Dislikes: 502
 * Total Accepted:    3.2M
 * Total Submissions: 5.8M
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,60]]\n3'
 *
 * You are given an m x n integer matrix matrix with the following two
 * properties:
 * 
 * 
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the
 * previous row.
 * 
 * 
 * Given an integer target, return true if target is in matrix or false
 * otherwise.
 * 
 * You must write a solution in O(log(m * n)) time complexity.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10^4 <= matrix[i][j], target <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] a, int target) {
        // i have to take a target and i have start and end,
        // i just need to find the mid of thing

        int n = a.length;
        int m = a[0].length;

        int i = 0;
        int j = n*m - 1;

        while(i<=j){
            int mid = i + (j-i)/2;
            int midI = mid/m;
            int midJ = mid%m;

            if(a[midI][midJ] == target){
                return true;
            }else if(a[midI][midJ] > target){
                j = mid-1;
            }else{
                i = mid+1;
            }
        }

        return false;
    }
}

// @lc code=end

