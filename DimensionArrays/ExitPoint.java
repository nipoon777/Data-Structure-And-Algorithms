package DimensionArrays;

import java.util.Scanner;

public class ExitPoint {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] a = new int[r][c];

        for(int i = 0 ; i < a.length ; i++ ){
            for(int j = 0 ; j < a[0].length ; j++){
                a[i][j] = scn.nextInt();
            }
        }

        int i = 0;
        int j = 0;
        int dir = 0;

        while(true){
            dir = ( dir + a[i][j] ) % 4;
            if(dir == 0){
                j++;
            }
            if(dir == 1){
                i++;
            }
            if(dir == 2){
                j--;
            }
            if(dir == 3){
                i--;
            }

            if(i < 0){
                i++;
                break;
            }
            if(j < 0){
                j++;
                break;
            }

            if(i > a.length - 1){
                i--;
                break;
            }

            if(j > a.length - 1){
                j--;
                break;
            }


        }

        System.out.println(i);
        System.out.println(j);
        scn.close();
    }    
}
