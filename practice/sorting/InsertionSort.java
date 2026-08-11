package sorting;

public class InsertionSort {
    public static void main(String[] args){
        int[] a = {7,8,5,3,2};
        int n = a.length;
        
        for(int i=1;i<n;i++){
            if(a[i]<a[i-1]){
                continue;
            }
            for(int j=i;j>0;j--){
                if(a[j]<a[j-1]){
                    continue;
                }
                int temp = a[j-1];
                a[j-1]=a[j];
                a[j]=temp;
            }
        }

        for(int i =0;i<n;i++){
            System.out.print(a[i]+" ");
        }


    }
}
