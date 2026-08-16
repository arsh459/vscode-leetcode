package sorting;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class QuickSort {
    // pivot and partition
    public static int partIt(int nums[], int i, int j){
        int pivot = nums[j];
        int k=i-1; // To find pivot index
        int x=i;
        while(x<j){
            if(nums[x]<pivot){
                k++;
                int temp = nums[k];
                nums[k]=nums[x];
                nums[x]=temp;
            }
            x++;
        }

        // making the last position of pivot
        k++;
        int temp = nums[k];
        nums[k]=nums[j];
        nums[j]=temp;


        return k;
    }

    public static void sortIt(int[] nums, int i, int j){
        if(i>j){
            return;
        }
        int pIndex = partIt(nums, i, j);
        sortIt(nums, i, pIndex-1);
        sortIt(nums, pIndex+1, j);
    }

    public static void main(String[] args){
        int[] nums= {3, 2, 4};
        sortIt(nums,0,nums.length-1);

        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]);
        }
    }

}
