package recursion;

public class TowerOfHanoiV1 {
    public static int solveIt(int n){
        if(n==2){
            return 3;
        }
        return solveIt(n-1)+1+solveIt(n-1);
    }

    //print all permutations of a string
    public static void printAllPermutations(String s, String p){
        if(s.length()==0){
            System.out.println(p);
        }
        for(int i=0;i<s.length();i++){
            char currentChar= s.charAt(i);
            String newStr= s.substring(0,i) + s.substring(i+1,s.length());
            printAllPermutations(newStr, p+currentChar);
        }
    }


    public static int n=3;
    public static int m=3;
    public static int count=0;

    // count paths in a maze from 0,0 to n,m it means there are (n-1)*(m-1) blocks
    public static int printPossibleMazePath(int i, int j){
        if(i==n || j==m){
            return 0;
        }
        if(i==n-1 && j==m-1){
            return 1;
        }
        return printPossibleMazePath(i+1,j) + printPossibleMazePath(j+1,i);

    }

    public static void main(String[] args){
        System.out.print(printPossibleMazePath(0,0));
    }
}
