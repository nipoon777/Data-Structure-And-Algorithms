package DimensionArrays;
import java.util.*;

public class DiagonalTraversal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[][] a = new int[n][n];

        for(int i = 0 ; i < a.length ; i++){
            for(int j = 0 ; j < a[0].length ; j++){
                a[i][j] = scn.nextInt();
            }
        }

        for(int g = 0 ; g < a.length ; g++){
            for(int i = 0 , j = g ; j < a.length ; j++,i++){
                System.out.println(a[i][j]);
            }
        }
        scn.close();
    }    
}
