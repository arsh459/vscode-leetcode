/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 *
 * https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 *
 * algorithms
 * Medium (58.32%)
 * Likes:    13426
 * Dislikes: 239
 * Total Accepted:    1.5M
 * Total Submissions: 2.6M
 * Testcase Example:  '[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]\n' +
  '5'
 *
 * Write an efficient algorithm that searches for a value target in an m x n
 * integer matrix matrix. This matrix has the following properties:
 * 
 * 
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix =
 * [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
 * target = 5
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix =
 * [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
 * target = 20
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -10^9 <= matrix[i][j] <= 10^9
 * All the integers in each row are sorted in ascending order.
 * All the integers in each column are sorted in ascending order.
 * -10^9 <= target <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean binarySearch(int[] nums, int target){
        int i=0;
        int j= nums.length - 1;
        while(i<=j){
            int mid = i+ (j-i)/2;

            if(nums[mid]==target){
                return true;
            }

            if(nums[mid]>target){
                j = mid-1;
            }else{
                i=mid+1;
            }
        }

        return false;
    }

    public boolean searchMatrixNlogN(int[][] matrix, int target){
        for(int i=0;i<matrix.length;i++){
            if(binarySearch(matrix[i], target)){
                return true;
            }
        }
        return false;

    }

    public boolean searchMatrix(int[][] a, int target) {
        // staircase method

        // we will start from top-right
        int row = 0;
        int col = a[0].length - 1;

        while(col>=0 && row<a.length){
            if(a[row][col] < target){
                row++;
            }else if(a[row][col] == target){
                return true;
            }else{
                col--;
            }
        }

        return false;
    }
}
// @lc code=end

