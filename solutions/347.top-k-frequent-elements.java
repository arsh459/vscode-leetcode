/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (67.32%)
 * Likes:    19905
 * Dislikes: 858
 * Total Accepted:    3.9M
 * Total Submissions: 5.8M
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2
 * 
 * Output: [1,2]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1], k = 1
 * 
 * Output: [1]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
 * 
 * Output: [1,2]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 * 
 * 
 * 
 * Follow up: Your algorithm's time complexity must be better than O(n log n),
 * where n is the array's size.
 * 
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // this can be done using HashMap + bucket sort

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }

        // Now i need to make buckets in this
        // basically storing values by element map
        List<Integer>[] buckets = new List[nums.length];
        for(int i=0;i<nums.length;i++){
            buckets[i]= new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entrySet:hm.entrySet()){
            int value = entrySet.getValue();
            int key = entrySet.getKey();
            buckets[value-1].add(key);
        }

        int l=0;
        int[] a = new int[k];
        for(int i=nums.length-1;i>=0;i--){
            if(l==k){
                break;
            }

            for(int j=0;j<buckets[i].size();j++){
                if(l==k){
                    break;
                }
                a[l]=buckets[i].get(j);
                l++;
            }
        }

        return a;
    }
}
// @lc code=end

