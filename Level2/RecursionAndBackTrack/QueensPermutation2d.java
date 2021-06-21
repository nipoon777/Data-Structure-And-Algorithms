import java.io.*;
import java.util.*;

public class Main {

    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        
        if( row == tq ){
            if(qpsf == tq ){
                System.out.println(asf);
                System.out.println();
            }
            return;
        }
        int nr, nc;
        String sep;
        if( col == tq - 1){
            nr = row + 1;
            nc = 0;
            sep = "\n";
        }else{
            nr = row;
            nc = col + 1;
            sep = "\t";
        }
        for(int queen = 0 ; queen< queens.length ; queen++ ){
            if( queens[queen] == false ){
                queens[queen] = true;
                queensPermutations(qpsf + 1, tq, nr, nc, asf +"q" + (queen + 1) + sep , queens);
                queens[queen] = false;
            }
        }
        queensPermutations(qpsf, tq, nr, nc, asf + "-" +sep, queens);
        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}