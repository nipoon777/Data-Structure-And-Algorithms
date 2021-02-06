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

        for(int gap = 0 ; gap < a.length ; gap++){
            //j Sabse pehle pohachta hai destination iss liye J ke liye inner loop likha
            for(int i = 0 , j = gap ; j < a.length ; j++,i++){
                System.out.println(a[i][j]);
            }
        }
        scn.close();
    }    
}
