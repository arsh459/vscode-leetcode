package sorting;

public class SelectionSort {
    public static void main(String[] args){
        int[] a = {7,8,5,3,2};
        int n = a.length;
        
        for(int i=0;i<n;i++){
            int max=0;
            for(int j=0;j<n-i;j++){
                if(a[j]<a[max]){
                    max = j;
                }
            }
            int temp = a[n-i-1];
            a[n-i-1]=a[max];
            a[max]=temp;
        }

        for(int i =0;i<n;i++){
            System.out.print(a[i]+" ");
        }


    }
}
