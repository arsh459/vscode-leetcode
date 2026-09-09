/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 *
 * https://leetcode.com/problems/insert-interval/description/
 *
 * algorithms
 * Medium (45.95%)
 * Likes:    12099
 * Dislikes: 931
 * Total Accepted:    1.9M
 * Total Submissions: 4.2M
 * Testcase Example:  '[[1,3],[6,9]]\n[2,5]'
 *
 * You are given an array of non-overlapping intervals intervals where
 * intervals[i] = [starti, endi] represent the start and the end of the i^th
 * interval and intervals is sorted in ascending order by starti. You are also
 * given an interval newInterval = [start, end] that represents the start and
 * end of another interval.
 * 
 * Two intervals are considered overlapping if they share at least one point.
 * 
 * Insert newInterval into intervals such that intervals is still sorted in
 * ascending order by starti and intervals still does not have any overlapping
 * intervals (merge overlapping intervals if necessary).
 * 
 * Return intervals after the insertion.
 * 
 * Note that you don't need to modify intervals in-place. You can make a new
 * array and return it.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with
 * [3,5],[6,7],[8,10].
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^5
 * intervals is sorted by starti in ascending order.
 * newInterval.length == 2
 * 0 <= start <= end <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int nStart = newInterval[0];
        int nEnd = newInterval[1];
        int n = intervals.length;

        List<List<Integer>> li= new ArrayList<>();
        int sI =-1;

        // left merge
        for(int i=0;i<n;i++){
            int s = intervals[i][0];
            int e = intervals[i][1];
            if(sI==-1 && nStart<=e){
                sI = i;
                break;
            }
            List<Integer> l = new ArrayList<>();
            l.add(s);
            l.add(e);
            li.add(l);
        }

        // middle merge
        if(sI==-1){
            List<Integer> l = new ArrayList<>();
            l.add(nStart);
            l.add(nEnd);
            li.add(l);
        }

        else{
            List<Integer> l = new ArrayList<>();
            l.add(Math.min(nStart,intervals[sI][0]));            

            int j=sI;
            while(j<n){
                System.out.println(j);
                System.out.println(nEnd);

                int s = intervals[j][0];
                int e = intervals[j][1];

                if(nEnd<s){
                    l.add(nEnd);
                    break;
                }
                else if(nEnd<=e){
                    l.add(Math.max(nEnd, e));
                    j++;
                    break;
                }
                j++;
            }

            if(j==n){
                l.add(nEnd);
            }
            li.add(l);

            
            for(int k=j;k<n;k++){
                int s = intervals[k][0];
                int e = intervals[k][1];
                List<Integer> lm = new ArrayList<>();
                lm.add(s);
                lm.add(e);
                li.add(lm);
            }
        }
        int[][] answer = new int[li.size()][2];
        for(int i=0;i<li.size();i++){
            answer[i][0]= li.get(i).get(0);
            answer[i][1]= li.get(i).get(1);
        }
        return answer;
    }
}
// @lc code=end

