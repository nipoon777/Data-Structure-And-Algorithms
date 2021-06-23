import java.io.*;
import java.util.*;

public class Main {

    public static boolean IsKnightSafe(boolean[][] chess, int i, int j) {
        // 1 check
        int r = i - 2;
        int c = j + 1;
        if( r >= 0 && c < chess[0].length && chess[r][c]){
            return false;
        }
        // 2 check
        r = i - 2;
        c = j - 1;
        if( r >= 0 && c >= 0 && chess[r][c] ){
            return false;
        }
        // 3 check
        r = i - 1;
        c = j + 2;
        if( r >= 0 && c < chess[0].length && chess[r][c]){
            return false;
        }
        //4 check
        r = i - 1;
        c = j - 2;
        if( r >= 0 && c >= 0 && chess[r][c] ){
            return false;
        }
        return true;
        
    }

    public static void nknights(int kpsf, int tk, boolean[][] chess, int lcno) {
        if( kpsf == tk ){
            for(boolean[] row : chess){
                for(boolean val : row){
                    System.out.print(val ? "k\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        for(int i = lcno + 1 ; i < tk * tk ; i++ ){
            int row = i / tk;
            int col = i % tk;
            if( IsKnightSafe(chess, row, col) ){
                chess[row][col] = true;
                nknights(kpsf + 1, tk, chess, i);
                chess[row][col] = false;
            }
            
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        nknights(0, n, chess, -1);
    }
}