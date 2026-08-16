package sorting;

public class MergeSort {

    public static void conquerIt(int[] nums, int i,int mid, int j){
        int[] merged = new int[j-i+1];
        int a=i;
        int b=mid+1;
        int x=0;
        while(a<=mid && b<=j){
            if(nums[a]<nums[b]){
                merged[x]=nums[a];
                a++;
            }else{
                merged[x]=nums[b];
                b++;
            }
            x++;
        }
        while(b<=j){
            merged[x]=nums[b];
            b++;
            x++;
        }
        while(a<=mid){
            merged[x]=nums[a];
            a++;
            x++;
        }

        x=0;
        while(x<merged.length){
            nums[i+x]=merged[x];
            x++;
        }
    }

    public static void divideIt(int[] nums, int i, int j){
        if(i>=j){
            return;
        }

        // int mid = (i+j)/2; 
        int mid= i + ((j-i)/2); // this is used so that i+j does not exceed INTEGER.MAX_VALUE

        divideIt(nums,i, mid);
        divideIt(nums,mid+1,j);    
        conquerIt(nums,i,mid,j);
    }

    public static void main(String[] args){
        int[] nums={5,1,2,3,4};
        divideIt(nums, 0, nums.length-1);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
    
}
