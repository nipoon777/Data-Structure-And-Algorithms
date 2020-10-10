package DimensionArrays;

import java.util.*;

public class SaddlePoint {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[][] a = new int[n][n];

        for(int i = 0 ; i < a.length ; i++){
            for(int j = 0 ; j < a[0].length ; j++){
                a[i][j] = scn.nextInt();
            }
        }
        scn.close();

        for(int i = 0 ; i < a.length ; i++)
        {
            int svr = 0;
            for(int j = 0 ; j < a.length ; j++){
                if(a[i][j] < a[i][svr]){
                    svr = j;
                }
            }
            boolean flag = true;

            for(int k = 0 ; k < a.length ; k++){
                if(a[k][svr] > a[i][svr]){
                    flag = false;
                    break;
                }
            }

            if(flag == true){
                System.out.println(i);
                System.out.println(svr);
                return;
            }
        }

        System.out.println("Invalid input");
        
    }    
}
