/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (69.29%)
 * Likes:    19035
 * Dislikes: 981
 * Total Accepted:    3.8M
 * Total Submissions: 5.5M
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * Given an integer array nums and an integer k, return the k^th largest
 * element in the array.
 * 
 * Note that it is the k^th largest element in the sorted order, not the k^th
 * distinct element.
 * 
 * Can you solve it without sorting?
 * 
 * 
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= k <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {

    public int quickSelect(int k, ArrayList<Integer> nums){
        int pivot = nums.get(nums.size()-1);

        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> m = new ArrayList<>();
        ArrayList<Integer> r = new ArrayList<>();
        for(Integer a:nums){
            if(a>pivot){
                l.add(a);
            }else if(a==pivot){
                m.add(a);
            }else{
                r.add(a);
            }
        }
        if(k<=l.size()){
            return quickSelect(k, l);
        }
        if(k>(l.size()+m.size())){
            return quickSelect(k-l.size()-m.size(), r);
        }
        return pivot;
    }



    public int findKthLargest(int[] nums, int k) {
        // it has to done with multiple approaches 

        // 1. with inbuilt sort o(nlogn) and s(1)
        // Arrays.sort(nums);
        // return nums[nums.length-k];

        // 2. Min-Heap or priority queue O(nlogk) 
        // PriorityQueue<Integer> q = new PriorityQueue<>();
        // for(int i=0;i<nums.length;i++){
        //     q.add(nums[i]);
        //     if(q.size()>k){
        //         q.poll();
        //     }
        // }
        // return q.peek();

        // 3. Using Quick Select - in this we will partition the array
        // O(n^2) worst case and o(n) average case
        ArrayList<Integer> a = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            a.add(nums[i]);
        }
        return quickSelect(k, a);
    }
}
// @lc code=end

