/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (52.74%)
 * Likes:    25046
 * Dislikes: 920
 * Total Accepted:    4.3M
 * Total Submissions: 8.2M
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all
 * overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into
 * [1,6].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: intervals = [[4,7],[1,4]]
 * Output: [[1,7]]
 * Explanation: Intervals [1,4] and [4,7] are considered overlapping.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {

    // O(n^2) approach 
    // public int[][] merge(int[][] intervals) {
    //     int n = intervals.length;
    //     boolean[] m = new boolean[n];

    //     int i=0;
    //     while(i<n){
    //         if(m[i]){
    //             i++;
    //             continue;
    //         }
    //         int s = intervals[i][0];
    //         int e = intervals[i][1];

    //         for(int j=i+1;j<n;j++){
    //             if(m[j]){
    //                 continue;
    //             }
    //             int sj = intervals[j][0];
    //             int ej = intervals[j][1];

    //             if(ej<s || sj>e){
    //                 continue;
    //             }else{
    //                 s = Math.min(s,sj);
    //                 e = Math.max(ej, e);
    //                 m[j]=true;
    //             }
    //         }

    //         if(intervals[i][0] == s && intervals[i][1] == e ){
    //             i++;
    //         }else{
    //             intervals[i][0]=s;
    //             intervals[i][1]=e;
    //         }
    //     }

    //     int answerLength = 0;
    //     for(int j=0;j<m.length;j++){
    //         if(!m[j]){
    //             answerLength++;
    //         }
    //     }
    //     int[][] answer = new int[answerLength][2];

    //     int j=0;
    //     int k =0;
    //     while(j<n){
    //         if(m[j]){
    //             j++;
    //             continue;
    //         }

    //         answer[k][0] = intervals[j][0];
    //         answer[k][1] = intervals[j][1];

    //         k++;
    //         j++;
    //     }

    //     return answer;
    // }


    // O(n*logn) - let's sort the array with start of interval 
    // now we need to merge adjacent only
    public int[][] merge(int[][] a) {
        Arrays.sort(a, (b, c) -> Integer.compare(b[0], c[0]));
        int n = a.length;
        boolean[] m = new boolean[n];

        int i=1;
        while(i<n){
            int s = a[i][0];
            int e = a[i][1];

            int ls = a[i-1][0];
            int le = a[i-1][1];


            if(le>=s){
                a[i][0] = ls;
                a[i][1] = Math.max(le,e);
                m[i-1]=true;
            }
            i++;
        }



        int answerLength = 0;
        for(int j=0;j<m.length;j++){
            if(!m[j]){
                answerLength++;
            }
        }
        int[][] answer = new int[answerLength][2];

        int j=0;
        int k =0;
        while(j<n){
            if(m[j]){
                j++;
                continue;
            }

            answer[k][0] = a[j][0];
            answer[k][1] = a[j][1];

            k++;
            j++;
        }

        return answer;
    }
}
// @lc code=end

