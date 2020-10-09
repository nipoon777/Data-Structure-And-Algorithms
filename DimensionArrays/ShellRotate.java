package DimensionArrays;

import java.util.*;

public class ShellRotate {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] a = new int[n][m];

        for(int i = 0 ; i < a.length ; i++){
            for(int j = 0; j < a[0].length ; j++){
                a[i][j] = scn.nextInt();
            }
        }
        int s = scn.nextInt();
        int r = scn.nextInt();

        int[] oneD = shellToOneD(a,s);

        rotate(oneD, r);

        oneDtoShell(a, oneD, s);

        display(a);
        scn.close();
    } 

    public static int[] shellToOneD(int[][] a, int s){
        int minr = s - 1;
        int minc = s - 1;
        int maxr = a.length  -  s;
        int maxc = a[0].length - s;
        int n = 2 * ( maxc - minc + maxr - minr);
        int[] oneD = new int[n];

        int idx = 0;

        
            for(int i = minr, j = minc ; i <= maxr ; i++){
                oneD[idx++] = a[i][j];
            }

            for(int i = maxr, j = minc + 1; j <= maxc ; j++){
                oneD[idx++] = a[i][j];
            }
            
            for(int i = maxr - 1 , j = maxc ; i >= minr ; i--){
                oneD[idx++] = a[i][j];
            }
            for(int i = minr, j = maxc - 1 ; j >= minc + 1 ; j--){
                oneD[idx++] = a[i][j];
            }

        return oneD;

    }    

    public static void reverse(int[] oneD, int li, int ri) {
        while(li < ri){
            int temp = oneD[li];
            oneD[li] = oneD[ri];
            oneD[ri] = temp;
            li++;
            ri--;
        }   
    }

    public static void rotate(int[] oneD, int r) {

        r = r % oneD.length;

        if( r < 0){
            r = r + oneD.length;
        }
        
        reverse(oneD, 0 , oneD.length - r -1);
        reverse(oneD, oneD.length - r, oneD.length - 1);
        reverse(oneD, 0 , oneD.length -1);
        
        
    }

    public static void oneDtoShell(int[][] a, int [] oneD, int s){
        int minr = s - 1;
        int minc = s - 1;
        int maxr = a.length  -  s;
        int maxc = a[0].length - s;

        int idx = 0;

        while(idx < oneD.length){
            for(int i = minr, j = minc ; i <= maxr ; i++){
                a[i][j] = oneD[idx];
                idx++;
            }

            for(int i = maxr, j = minc + 1; j <= maxc ; j++){
                a[i][j] = oneD[idx];
                idx++;
            }
            for(int i = maxr - 1, j = maxc ; i >= minr ; i--){
                a[i][j] = oneD[idx];
                idx++;
            }
            
            for(int i = minr, j = maxc -1 ; j >= minc + 1 ; j--){
                a[i][j] = oneD[idx];
                idx++;
            }
        }
        
    }

    public static void display(int[][] a){
        for(int i = 0 ; i < a.length ; i++){
            for(int j = 0 ; j < a[0].length ; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();

        }
    }
    
    
}
