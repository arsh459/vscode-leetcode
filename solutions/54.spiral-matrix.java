/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (57.81%)
 * Likes:    17846
 * Dislikes: 1600
 * Total Accepted:    2.6M
 * Total Submissions: 4.5M
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<Integer> li= new ArrayList<>();

        int iStart=0;
        int iEnd = n-1;

        int jStart=0;
        int jEnd = m-1;


        while(iStart<=iEnd && jStart<=jEnd){
            for(int j=jStart;j<=jEnd;j++){
                li.add(matrix[iStart][j]);
            }
            iStart++;

            for(int i=iStart;i<=iEnd;i++){
                li.add(matrix[i][jEnd]);
            }
            jEnd--;

            if(iStart<=iEnd){
                for(int j=jEnd;j>=jStart;j--){
                    li.add(matrix[iEnd][j]);
                }
                iEnd--;
            }
            
            if(jStart<=jEnd){
                for(int i=iEnd;i>=iStart;i--){
                    li.add(matrix[i][jStart]);
                }
                jStart++;
            }
            
        }

        return li;


    }
}
// @lc code=end

