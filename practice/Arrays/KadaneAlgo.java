package Arrays;

public class KadaneAlgo {
    // it says if any point in array subarray sum becomes -ve reset currSum to 0
    // It is type of dynamic programming type of algo
    public static void main(String[] args){
        int[] arr = {3, -4, 5, 4, -1, 7, 8};

        int currSum=0;
        int maxSubArraySum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];
            maxSubArraySum=Math.max(maxSubArraySum, currSum); // we are doing it before as array can be whole -ve
            if(currSum<0){
                currSum=0;
            }
        }
        System.out.print(maxSubArraySum);
    }

        public int majorityElement(int[] nums) {
        int candidate = -1;
        int count =0;

        for(int i=0;i<nums.length;i++){
            if(count==0){
                candidate = i;
                count++;
                continue;
            }

            if(nums[candidate]==nums[i]){
                count++;
            }else{
                count--;
            }
        }


        // in question it is written majority will always exist,
        // otherwise we would have verified
        return nums[candidate];
    }



    // moore law - Majority law - element existing > N/2 - we can do this using n^2(by 2 loops) or HashMap(O(n))
    // next way is moore law
}
