package IntroRecursion;

import java.util.*;

public class PrintDecreasing {
    public static void main(String[] args)  {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        printDecreasing(n);
        scn.close();
    }

    public static void printDecreasing(int n){
        
        if(n == 0){
            return;
        }
        System.out.println(n);
        printDecreasing(n-1);
        
    }
}
