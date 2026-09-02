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
}
