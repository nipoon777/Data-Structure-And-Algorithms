import java.io.*;
import java.util.*;

public class Main {

    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        // write your code here
        //Row Check
        for(int c = 0; c < chess[0].length ; c++ ){
            if( chess[row][c] != 0 ){
                return false;
            }
        }
        //Col Check
        for(int r = 0 ; r < chess.length ; r++ ){
            if( chess[r][col] != 0){
                return false;
            }
        }
        //Left Diagnonal UP
        for(int r = row - 1, c = col - 1 ; r >= 0 && c >= 0 ; r--, c-- ){
            if( chess[r][c] != 0 ){
                return false;
            }
        }
        
        //Left Diagonal Down
        for(int r = row + 1, c = col + 1 ; r < chess.length && c < chess[0].length ; r++, c++ ){
            if( chess[r][c] != 0 ){
                return false;
            }
        }
        //Right Diagonal Up
        for(int r = row - 1, c = col + 1 ; r >= 0 && c < chess[0].length ; r--, c++ ){
            if( chess[r][c] != 0 ){
                return false;
            }
        }
        //Right Diagonal Down
        for(int r = row + 1, c = col - 1 ; r < chess.length && c >= 0 ; r++, c-- ){
            if( chess[r][c] != 0 ){
                return false;
            }
        }
        
        return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        
        if( qpsf == tq ){
            for(int[] row : chess){
                for(int val : row){
                    System.out.print(val > 0? "q"+val + "	" : "-	");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for(int r = 0 ; r < chess.length ; r++ ){
            for(int c = 0 ; c < chess[0].length ; c++ ){
                if(chess[r][c] == 0 && IsQueenSafe(chess, r, c) ){
                    chess[r][c] = qpsf + 1;
                    nqueens(qpsf+ 1, tq, chess);
                    chess[r][c] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}