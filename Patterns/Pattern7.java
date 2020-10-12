package Patterns;

import java.util.*;


public class Pattern7 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        for(int i = 0 ; i < n ; i++){
            int j;
            for(j = 0 ; j < i ; j++){
                System.out.print("\t");
            }
            System.out.println("*\t");
        }
        scn.close();
    }    
}
