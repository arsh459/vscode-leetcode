package recursion;

import java.util.ArrayList;

public class Subsets {
    public static void printArrayList(ArrayList<Integer> a){
        for(int i =0;i<a.size();i++){
            System.out.print(a.get(i)+" ");
        }
        System.out.println();
    }
    public static void subset(int n, ArrayList<Integer> a){
        if(n==0){
            printArrayList(a);
            return;
        }
        a.add(n);
        subset(n-1, a);
        
        a.remove(a.size()-1);
        subset(n-1, a);
    }

    
    // subset of n natural numbers
    public static void main(String args[]){
        int n=3;
        ArrayList<Integer> a= new ArrayList<>();
        subset(n, a);
    }   
}
