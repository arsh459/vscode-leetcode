package recursion;

public class Numbers {

    public static void printNumber(int n){
        if(n<0){
            return;
        }
        printNumber(n-1);
        System.out.println(n);

    }

    public static int sumOfNatural(int n){
        if(n<0){
            return 0;
        }
        return n + sumOfNatural(n-1);

    }

    public static int factorial(int n){
        if(n<1){
            return 1;
        }
        return n * factorial(n-1);
    }

    public static void fibonacci(int a, int b, int end){
        if(end == 0){
            return;
        }
        int sum = a+b;
        System.out.println(sum);
        fibonacci(b,sum, end-1);
    }

    // stack height of n, it means how much stack grows
    public static int powerOf(int x, int n){
        if(n==0){
            return 1;
        }
        return x * powerOf(x, n-1);
    }

    // stack height of n, it means how much stack grows it also has n
    public static int powerOfStack(int x, int n){
        if(x==0){
            return 0;
        }
        if(n==1){
            return x;
        }
        if(n==0){
            return 1;
        }
        return x * x * powerOfStack(x, n-2);
    }

    // stack height of n, it means how much stack grows it also has logn
    public static int powerOfStackLogN(int x, int n){
        if(x==0){
            return 0;
        }
        if(n==1){
            return x;
        }
        if(n==0){
            return 1;
        }
        if(n%2==1){
            return x * powerOfStackLogN(x, (n-1)/2) * powerOfStackLogN(x, (n-1)/2);
        }
        return powerOfStackLogN(x, n/2) * powerOfStackLogN(x, n/2);
    }
    

     public static void main(String[] args){
        int n =10;
        int x=2;
        System.out.println(powerOfStackLogN(x,n));  
    }
    
}