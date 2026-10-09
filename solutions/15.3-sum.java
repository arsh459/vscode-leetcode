/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (39.63%)
 * Likes:    36085
 * Dislikes: 3308
 * Total Accepted:    6.3M
 * Total Submissions: 16M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation: 
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not
 * matter.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 3 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] a) {
        // We need to find triplets, whose sum is equal to 0
        // 1. first solution is i just have a loop over the array and check for this

        // brute force
        // List<List<Integer>> a = new ArrayList<>();
        // HashSet<List<Integer>> hs = new HashSet<>();

        // int n = nums.length;
        // for(int i=0;i<n-2;i++){
        //     for(int j=i+1;j<n-1;j++){
        //         for(int k=j+1;k<n;k++){
        //             if(nums[i]+nums[j]+nums[k]==0){
        //                 List<Integer> li = new ArrayList<>();
        //                 li.add(nums[i]);
        //                 li.add(nums[j]);
        //                 li.add(nums[k]);
        //                 Collections.sort(li);
        //                 if(hs.contains(li)){
        //                     continue;
        //                 }else{
        //                     hs.add(li);
        //                     a.add(li);
        //                 }
        //             } 
        //         }
        //     }
        // }

        // return a;


        // Now removing the third loop using HashSet
        // List<List<Integer>> a = new ArrayList<>();
        // HashSet<List<Integer>> hs = new HashSet<>();

        // int n = nums.length;
        // for(int i=0;i<n-1;i++){
        //     HashSet<Integer> hsi= new HashSet<>();
        //     for(int j=i+1;j<n;j++){
        //         int k = -1*(nums[i]+nums[j]);
        //         if(hsi.contains(k)){
        //             List<Integer> li = new ArrayList<>();
        //             li.add(nums[i]);
        //             li.add(nums[j]);
        //             li.add(k);
        //             Collections.sort(li);
        //             if(hs.contains(li)){
        //                 continue;
        //             }else{
        //                 hs.add(li);
        //                 a.add(li);
        //             }
        //         }
        //         hsi.add(nums[j]);
        //     }
        // }
        // return a;


        // Now even removing the extra hashset's required
        // This is what interviewer wants everytime

        // first sort the array
        Arrays.sort(a);
        
        List<List<Integer>> ans = new ArrayList<>();
        int i=0; 
        int n = a.length;      
        while(i < n){
            int num = a[i];
            int target = -1 * a[i];

            int j = i+1;
            int k = n-1;
            
            while(j<k){
                if(a[j]+a[k] > target){
                    k--;
                    while(k>=0 && a[k]==a[k+1]){
                        k--;
                    }
                }
                else if(a[j]+a[k] == target){
                    List<Integer> li = new ArrayList<>(Arrays.asList(a[i],a[j],a[k]));
                    ans.add(li);
                    j++;
                    k--;
                    while(k>=0 && a[k]==a[k+1]){
                        k--;
                    }
                    while(j<n && a[j-1]==a[j]){
                        j++;
                    }                   
                }
                else if(a[j]+a[k] < target){
                    j++;
                    while(j<n && a[j-1]==a[j]){
                        j++;
                    }     
                }
            } 


            i++;
            while(i<n && a[i-1]==a[i]){
                i++;
            } 
        }
        return ans;
    }
}
// @lc code=end

