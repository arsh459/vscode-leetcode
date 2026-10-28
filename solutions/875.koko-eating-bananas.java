/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 *
 * https://leetcode.com/problems/koko-eating-bananas/description/
 *
 * algorithms
 * Medium (50.75%)
 * Likes:    14478
 * Dislikes: 953
 * Total Accepted:    1.9M
 * Total Submissions: 3.7M
 * Testcase Example:  '[3,6,7,11]\n8'
 *
 * Koko loves to eat bananas. There are n piles of bananas, the i^th pile has
 * piles[i] bananas. The guards have gone and will come back in h hours.
 * 
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she
 * chooses some pile of bananas and eats k bananas from that pile. If the pile
 * has less than k bananas, she eats all of them instead and will not eat any
 * more bananas during this hour.
 * 
 * Koko likes to eat slowly but still wants to finish eating all the bananas
 * before the guards return.
 * 
 * Return the minimum integer k such that she can eat all the bananas within h
 * hours.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= piles.length <= 10^4
 * piles.length <= h <= 10^9
 * 1 <= piles[i] <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isCapacityEnough(int[] piles, int h, int start){
        int hours = 0;
        for(int pile: piles){
            int div = pile / start;
            hours = hours + div;
            if(pile%start!=0){
                hours++;
            }
        }
        return hours<=h; 
    }

    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Integer.MAX_VALUE;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(isCapacityEnough(piles, h, mid)){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
}
// @lc code=end

