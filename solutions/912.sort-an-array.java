/*
 * @lc app=leetcode id=912 lang=java
 *
 * [912] Sort an Array
 *
 * https://leetcode.com/problems/sort-an-array/description/
 *
 * algorithms
 * Medium (55.51%)
 * Likes:    7424
 * Dislikes: 859
 * Total Accepted:    1.2M
 * Total Submissions: 2.2M
 * Testcase Example:  '[5,2,3,1]'
 *
 * Given an array of integers nums, sort the array in ascending order and
 * return it.
 * 
 * You must solve the problem without using any built-in functions in
 * O(nlog(n)) time complexity and with the smallest space complexity
 * possible.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Explanation: After sorting the array, the positions of some numbers are not
 * changed (for example, 2 and 3), while the positions of other numbers are
 * changed (for example, 1 and 5).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * Explanation: Note that the values of nums are not necessarily unique.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 5 * 10^4
 * -5 * 10^4 <= nums[i] <= 5 * 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] a) {
        // bubble sort
        // for(int i=0;i<a.length;i++){
        //     for(int j=1;j<a.length-i;j++){
        //         if(a[j-1]>a[j]){
        //             int temp = a[j-1];
        //             a[j-1] = a[j];
        //             a[j] = temp;
        //         }
        //     }
        // }



        // selection sort
        // for(int i=0;i<a.length-1;i++){
        //     int minIndex = i;
        //     for(int j=i+1;j<a.length;j++){
        //         if(a[j]<a[minIndex]){
        //             minIndex=j;
        //         }
        //     }
        //     if(minIndex != i){
        //         int temp = a[minIndex];
        //         a[minIndex] = a[i];
        //         a[i] = temp;
        //     }
        // }

        // insertion sort
        // here we make two portions of array, one is sorted and other is unsorted.
        // we take one key from unsorted portion and insert it at correct position in sorted part
        // for(int i=1;i<a.length;i++){
        //     int key = a[i];
        //     int j=i-1;
        //     while(j>=0 && a[j]>key){
        //         a[j+1]=a[j];
        //         j--;
        //     }
        //     a[j+1]=key;
        // }

        // merge sort
        // mergeSortIt(0, a.length-1,a);

        // quick sort



        // heap




        return a;

    }

    public static void mergeSortedArrays(int i, int k ,int j, int[] a){
        // how to do it in-place
        int n = k - i + 1;
        int m = j - k;

        int[] arr = new int[m+n];
        int l = 0;

        int x=0;
        int y=0;
        while(x<n && y<m){
            if(a[i+x] <= a[k+1+y]){
                arr[l] = a[i+x];
                x++;
            }else{
                arr[l] = a[k+1+y];
                y++;
            }
            l++;
        }

        while(x<n){
            arr[l]=a[x+i];
            l++;
            x++;
        }

        while(y<m){
            arr[l]=a[k+1+y];
            l++;
            y++;
        }


        l=0;
        while(l<m+n){
            a[i+l] = arr[l];
            l++;
        }
    }

    public void mergeSortIt(int i, int j, int[] a){
        if(i>=j){
            return;
        }
        int mid = i + (j-i)/2;
        mergeSortIt(i, mid, a);
        mergeSortIt(mid+1, j, a);
        mergeSortedArrays(i,mid, j, a);
    }
}
// @lc code=end

