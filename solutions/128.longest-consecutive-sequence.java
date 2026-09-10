/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Medium (47.23%)
 * Likes:    23367
 * Dislikes: 1257
 * Total Accepted:    3.6M
 * Total Submissions: 7.7M
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * Given an unsorted array of integers nums, return the length of the longest
 * consecutive elements sequence.
 * 
 * You must write an algorithm that runs in O(n) time.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,0,1,2]
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {

    // this solution is using sort, we have to find a way without using sort
    // public int longestConsecutive(int[] nums) {
    //     int n = nums.length;
    //     if(n==0 || n==1){
    //         return n;
    //     }

    //     Arrays.sort(nums);
    //     int maxCount = 1;
    //     List<Integer> li = new ArrayList<>();
    //     li.add(nums[0]);
    //     for(int i=1;i<n;i++){
    //         int curr = nums[i];
    //         int prev = li.get(li.size()-1);

    //         if(curr-prev==1){
    //             li.add(curr);
    //             maxCount = Math.max(maxCount, li.size());
    //         }else if(curr==prev){
    //             continue;
    //         }else{
    //             li= new ArrayList<>();
    //             li.add(curr);
    //         }

    //     }
    //     return maxCount;
    // }


    // one solution is we can use HashSet
    // we save all the number in the Hashset 

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0 || n==1){
            return n;
        }
        HashSet<Integer> hs = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        int maxCount=0;
        Iterator<Integer> it = hs.iterator();
        while(it.hasNext()){
            int i = it.next();
            int count=1;
            // means it is the start
            if(!hs.contains(i-1)){
                int x = i+1;
                while(hs.contains(x)){
                    x++;
                    count++;
                }
                maxCount=Math.max(maxCount, count);
            }
        }

        return maxCount;
    }



}
// @lc code=end

