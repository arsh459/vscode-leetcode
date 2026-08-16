package recursion;

public class NQueens{
    public static void printArray(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] +" ");
        }
        System.out.println();
    }

    public static int[] calculateSafePositions(int i, int n, int[] occupiedPositions){
        int[] a = new int[n];
        for(int j=0;j<n;j++){
            a[i]=0;
        }

        for(int j=0;j<i;j++){
            int queensPlacedAt = occupiedPositions[j];

            // horizontal case
            a[queensPlacedAt]=-1;

            // down case
            if((queensPlacedAt+(i-j))<n){
                a[queensPlacedAt+(i-j)]=-1;
            }

            // up case
            if((queensPlacedAt-(i-j))>=0){
                a[queensPlacedAt-(i-j)]=-1;
            }
        }
        return a;
    }

    public static void solveNQueens(int i, int n, int[] occupiedPositions){
        // A queen can cut in directions it can go directions
        // so each queen will be placed in separate column and separate rows
        // i want to send positions of previous queens to calculate safe position
        if(i==n){
            printArray(occupiedPositions);
            return;
        }

        // finding and checking safe position
        int[] safePositions= calculateSafePositions(i, n, occupiedPositions);

        // if no safe position end the recursion
        boolean allUnsafe= true;
        for(int j=0;j<safePositions.length;j++){
            if(safePositions[j]==0){
                allUnsafe=false;
            }
        }
        if(allUnsafe){
            return;
        }


        for(int j=0;j<n;j++){
            if(safePositions[j] == -1){
                continue;
            }
            occupiedPositions[i] = j;
            solveNQueens(i+1,n, occupiedPositions);
            occupiedPositions[i]=-1;
        } 
    }

    public static void solveNQueensByArray(){
        int n=10;
        int[] a =new int[n];
        for(int i =0;i<n;i++){
            a[i]=-1;
        }
        solveNQueens(0,n,a);
    }

    //  It can be solved by 2D Array
    public static void main(String[] args){
        solveNQueensByArray();   
        // solveNQueensBy2DArray();
    }
}