package Patterns;
import java.util.*;

public class Pattern3  {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        for( int i = 0 ; i < n ; i++ ){
            int j;
            for(j = 0 ; j < n; j++){
                if(j < n - i -1)
                {
                    System.out.print("\t");
                  
                }
                else{
                    System.out.print("*\t");
                }
              
            }
            System.out.println();
        }

    }
}