package DynamicProgramming;

import java.util.*;

public class KnapsackUn {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] cost = new int[n];
        int[] weight = new int[n];
        
        for(int i = 0 ; i < cost.length ; i++){
            cost[i] = scn.nextInt();
        }
        
        for(int i = 0 ; i < weight.length ; i++){
            weight[i] = scn.nextInt();
        }
        
        int capacity = scn.nextInt();
        
        int max = getKnapsack(cost, weight, capacity);
        
        System.out.println(max);
        scn.close();
    }
    
    
    public static int getKnapsack(int[] cost, int[] weight, int capacity){
        int[] dp = new int[capacity + 1];
        
        for(int dcap = 1 ; dcap < dp.length ; dcap++){
            int max = 0;
            for(int wtar = 0 ; wtar < weight.length ; wtar++){
                if(dcap >= weight[wtar]){
                    int rcap = dcap - weight[wtar];
                    int ramt = dp[rcap];
                    
                    if( max < ramt + cost[wtar]){
                        max = ramt + cost[wtar];
                    }
                }
            }
            dp[dcap] = max;
        }
        
        return dp[capacity]; 
    }
}


