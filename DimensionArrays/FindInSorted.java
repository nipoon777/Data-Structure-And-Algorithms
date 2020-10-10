package DimensionArrays;

import java.util.*;

public class FindInSorted {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[][] a = new int[n][n];

        for(int i = 0 ; i < a.length ; i++){
            for(int j = 0 ; j < a[0].length ; j++){
                a[i][j] = scn.nextInt();
            }
        }
        
        int s = scn.nextInt();


        int i = 0;
        int j = a.length - 1;

        while(i < a.length  && j >= 0){
            if(a[i][j] == s){
                System.out.println(i);
                System.out.println(j);
                return;
            }else if (s > a[i][j]){
                i++;
            }else{
                j--;
            }
        }
        System.out.println("Not found");
        scn.close();
    }    
}
