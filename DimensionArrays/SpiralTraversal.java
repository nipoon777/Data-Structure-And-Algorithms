package DimensionArrays;

import java.util.*;

public class SpiralTraversal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int r1 = scn.nextInt();
        int c1 = scn.nextInt();

        int[][] a = new int[r1][c1];

        for(int i = 0 ; i < a.length ; i++){
            for(int j = 0 ; j < a[0].length ; j++){
                a[i][j] = scn.nextInt();
            }
        }

        int minr = 0;
        int minc = 0;
        int maxr = a.length - 1;
        int maxc = a[0].length - 1;
        int txn = r1 * c1;
        int count = 0;
        while(count < txn){
            //lw
                for(int i = minr, j = minc ; i <= maxr && count < txn; i++){
                    System.out.println(a[i][j]);
                    count++;
                }
                minc++;
            //bw
                for(int i = maxr, j = minc ; j <= maxc && count < txn; j++){
                    System.out.println(a[i][j]);
                    count++;
                }
                maxr--;

            //rw
                for(int i = maxr, j = maxc ; i >= minr && count < txn; i--){
                    System.out.println(a[i][j]);
                    count++;
                }
                maxc--;

            //tw
                for(int i = minr, j = maxc ; j >= minc && count < txn; j--){
                    System.out.println(a[i][j]);
                    count++;
                }
                minr++;

        }
        scn.close();
    }    
}
