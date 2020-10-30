package DynamicProgramming;

import java.util.*;

public class FibonacciDp{
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int fibn = fibMemoization(n, new int[n + 1]);
        
        System.out.println(fibn);
        scn.close();
     }
     
    public static int fibMemoization(int n, int[] qb){
        if( n == 0 || n == 1){
            return n;
        }
        
        if(qb[n] != 0){
            return qb[n];
        }
        
        int fibnm1 = fibMemoization( n - 1, qb);
        int fibnm2 = fibMemoization( n - 2, qb);
        
        int fib = fibnm1 + fibnm2;
        
        qb[n] = fib;
        
        return fib;
    }

}
