package recursion;

public class NumberWays {
    public static int callGuests(int n){
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        return callGuests(n-1) + (n-1)*callGuests(n-2);
    }

    

    public static void main(String args[]){
        int n=2;
        System.out.println(callGuests(n)); 
    }
}
