package RecursionBackTracking;

import java.util.*;

public class NQueens {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[][] chess = new int[n][n];
        
        printNQueens(chess,"",0);
        
        scn.close();
        
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
        if(row == chess.length){
            System.out.println(qsf + ".");
            return;
        }
        
        for(int col = 0 ; col < chess.length ; col++){
            chess[row][col] = 1;
            if(isQueenSafe(chess,row,col)){
                printNQueens(chess,qsf + row + "-" + col +", ", row + 1);
            }
            chess[row][col] = 0;
        }
    }
    
    public static boolean isQueenSafe(int[][] chess, int row, int col){
        
        for(int i = row - 1, j = col ; i >= 0 ; i--){
            if(chess[i][j] == 1){
                return false;
            }
        }
        
        for(int i = row - 1, j = col - 1 ; i >= 0 && j >= 0 ; i--,j--){
            if(chess[i][j] == 1){
                return false;
            }
        }
        
        for(int i = row - 1, j = col + 1 ; i >= 0 && j < chess.length ; i--,j++){
            if(chess[i][j] == 1){
                return false;
            }
        }
        
        return true;
    }
    
}
