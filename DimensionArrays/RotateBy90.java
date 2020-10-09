package DimensionArrays;

import java.util.*;


public class RotateBy90 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[][] a = new int[n][n];

        for(int i = 0 ;i < a.length ; i++){
            for(int j = 0 ; j < a[0].length ; j++){
                a[i][j] = scn.nextInt();
            }
        }


        for(int i = 0 ;i < a.length ; i++){
            for(int j = i ; j < a[0].length ; j++){
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }


        for(int i = 0 ; i < a.length ; i++){
            int li = 0;
            int ri = a[0].length - 1;

            while( li <= ri ){
                int temp = a[i][ri];
                a[i][ri] = a[i][li];
                a[i][li] = temp;
                li++;
                ri--;
            }
        }
        display(a);
        scn.close();
    } 
    
    public static void display(int[][] a){
        for(int i = 0 ;i < a.length ; i++){
            for(int j = 0 ; j < a[0].length ; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
