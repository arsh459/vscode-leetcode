/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 *
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 *
 * algorithms
 * Medium (63.57%)
 * Likes:    17484
 * Dislikes: 871
 * Total Accepted:    2.8M
 * Total Submissions: 4.4M
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row
 * and column to 0's.
 * 
 * You must do it in place.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best
 * solution.
 * Could you devise a constant space solution?
 * 
 * 
 */

// @lc code=start
class Solution {


    // we will some place to store the flag whether there is that row or column
    // we will use first row and first column as flag for zeros

    // we will first set -1 everywhere a 0 is encountered
    public void setZeroes(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        boolean first_row_has_zero= false;
        boolean first_column_has_zero= false;
        for(int i=0;i<n;i++){
            if(a[i][0]==0){
                first_column_has_zero=true;
            }
        }

        for(int j=0;j<m;j++){
            if(a[0][j]==0){
                first_row_has_zero=true;
            }
        }

        // we are flagging the first row and first col
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(a[i][j]==0){
                    a[0][j]=0;
                    a[i][0]=0;
                }
            }
        }


        // now we set zero in places
        for(int i=1;i<n;i++){
            if(a[i][0]==0){
                for(int j=0;j<m;j++){
                    a[i][j]=0;
                }
            }
        }
        for(int j=1;j<m;j++){
            if(a[0][j]==0){
                for(int i=0;i<n;i++){
                    a[i][j]=0;
                }
            }
        }

        if(first_row_has_zero){
            for(int j=0;j<m;j++){
                a[0][j]=0;
            }
        }

        if(first_column_has_zero){
            for(int i=0;i<n;i++){
                a[i][0]=0;
            }
        }

    }
}
// @lc code=end

