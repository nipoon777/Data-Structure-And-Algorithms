package Patterns;

import java.util.*;

public class Pattern16{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int sp = 2 * n - 3;
    int st = 1;
    for(int i = 1 ; i <= n ; i++){
        int k = 1;
        for(int j = 1 ; j <= st ; j++){
            System.out.print(k + "\t");
            k++;
            }
        for(int j = 1 ; j <= sp ; j++){
            System.out.print("\t");
        }
        if(st == n ){
            k--;
            st--;
        }
        for(int j = 1 ; j <= st ; j++){
            k--;
            System.out.print(k + "\t");
            
        }
        
        sp -= 2;
        st++;
        System.out.println();
        }
        scn.close();
    }
    
}
