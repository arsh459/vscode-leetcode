package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sudoku {
    static int n=9;
    static char[] chars= {'1','2','3','4','5','6','7','8','9'};

    public static void printBoard(char[][] board){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public static List<Character> charactersLeft(int i , int j, char[][] board){
        List<Character> li = new ArrayList<>(Arrays.asList(
            '1', '2', '3', '4', '5', '6', '7', '8', '9'
        ));

        // horizontal checking
        for(int k=0;k<n;k++){
            if(board[i][k]=='.'){
                continue;
            }
            li.remove(Character.valueOf(board[i][k]));
        }

        // vertical checking
        for(int k=0;k<n;k++){
            if(board[k][j]=='.'){
                continue;
            }
            li.remove(Character.valueOf(board[k][j]));
        }

        // cross 3x3 matrix checking
        int startI= (i/3) * 3;
        int startJ=(j/3) * 3;
        for(int k=startI;k<startI+3;k++){
            for(int l=startJ;l<startJ+3;l++){
                if(board[k][l]=='.'){
                    continue;
                }
                li.remove(Character.valueOf(board[k][l]));
             }
        }
        System.out.println(i+" "+j+" "+li);
        return li;
    }

    public static boolean isBoardFull(char[][] board){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    return false;
                }
            }
        }
        return true;
    }

    public static void solveSudoku(int i , int j, char[][] board) {
        if(i==n){
            printBoard(board);
            return;
        }

        int nRow=0;
        int nCol=0;
        if(j==n-1){
            nRow=i+1;
            nCol=0;
        }else{
            nRow=i;
            nCol=j+1;
        }

        if(board[i][j]!='.'){
            solveSudoku(nRow, nCol, board);
            return;
        }

        List<Character> li = charactersLeft(i,j,board);
        if(li.size()==0){
            return;
        }
        
        for(int k = 0;k<li.size();k++){
            if(isBoardFull(board)){
                return;
            }
            board[i][j]=li.get(k);
            solveSudoku(nRow, nCol, board);
            if(isBoardFull(board)){
                return;
            }
            board[i][j]='.';
        }
    }

    public static void main(String[] args){
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(0,0,board);
    }
    
}
