package DynamicProgramming;


import java.util.*;

public class ClimbStairsV {

    public static void main(String[] args)  {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scn.nextInt();
        }
        
        int steps = climbSteps(n, arr);
        System.out.println(steps);
        scn.close();
    }
    
    
    public static int climbSteps(int n, int[] arr){
        
        int[] dp = new int[n + 1];
        
        dp[n] = 1;
        
        for(int i = n - 1 ; i >= 0 ; i--){
            for(int j = 1 ; j <= arr[i] && i + j <= n ; j++){
                dp[i] += dp[i+j];
            }
        }
        
        return dp[0];
    }

}
