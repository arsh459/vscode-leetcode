package sorting;
public class BubbleSort {
    public static void main(String[] args){
        int[] a = {7,8,5,3,2};
        int n = a.length;
        
        for(int i=0;i<=n-2;i++){
            for(int j=0;j<=n-2-i;j++){
                int temp =a[j+1];
                if(a[j]<a[j+1]){
                    a[j+1]=a[j];
                    a[j]=temp;
                }
            }
        }

        for(int i =0;i<n;i++){
            System.out.print(a[i]+" ");
        }


    }
}
