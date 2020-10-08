package DimensionArrays;
import java.util.*;

public class WaveTraversal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int r1 = scn.nextInt();
        int c1 = scn.nextInt();
        int [][] a = new int[r1][c1];

        for(int i = 0 ;i < a.length ; i++){
            for(int j = 0; j < a[0].length ; j++){
                a[i][j] = scn.nextInt();
            }
        }

        for(int j = 0 ; j < a[0].length ; j++){
            if( j % 2 == 0){
                for(int i = 0 ;i < a.length ; i++){
                    System.out.println(a[i][j]);
                }

            }else{
                for(int i = a.length -1 ; i >= 0 ; i--){
                    System.out.println(a[i][j]);
                }
            }
            
        }

    }    
}
