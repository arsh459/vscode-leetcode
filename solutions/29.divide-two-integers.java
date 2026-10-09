/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 *
 * https://leetcode.com/problems/divide-two-integers/description/
 *
 * algorithms
 * Medium (20.32%)
 * Likes:    6282
 * Dislikes: 15311
 * Total Accepted:    1.3M
 * Total Submissions: 6.2M
 * Testcase Example:  '10\n3'
 *
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division, and mod operator.
 * 
 * The integer division should truncate toward zero, which means losing its
 * fractional part. For example, 8.345 would be truncated to 8, and -2.7335
 * would be truncated to -2.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * Note: Assume we are dealing with an environment that could only store
 * integers within the 32-bit signed integer range: [−2^31, 2^31 − 1]. For this
 * problem, if the quotient is strictly greater than 2^31 - 1, then return 2^31
 * - 1, and if the quotient is strictly less than -2^31, then return -2^31.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = 3.33333.. which is truncated to 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * -2^31 <= dividend, divisor <= 2^31 - 1
 * divisor != 0
 * 
 * 
 */

// @lc code=start
class Solution {
    public int divide(int a /** Dividend */, int b /** Divisor */) {

        // -2^31 <= dividend, divisor <= 2^31 - 1
        // we will use bitwise operations, so we will basically remove the divisor*2^x 
        // dividend
        if(a == 0){
            return 0;
        }
        if(a = Integer.MIN_VALUE && b == -1){
            return Integer.MAX_VALUE;
        }

        boolean isPositive = false;
        if((a>0 && b>0) || (a<0 && b<0)){
            isPositive = true;
        }
        
        a = Math.abs(a);
        b = Math.abs(b);
        int sum = 0;

        int maxB=b;

        while(maxB<b){
            maxB =  
        }

    }
}
// @lc code=end

