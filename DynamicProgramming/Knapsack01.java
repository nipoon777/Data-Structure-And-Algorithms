package DynamicProgramming;

import java.util.*;

public class Knapsack01{

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] cost = new int[n];
        int[] weight = new int[n];
        
        for(int i = 0; i < cost.length ; i++){
            cost[i] = scn.nextInt();
        }
        for(int i = 0 ; i < weight.length ; i++){
            weight[i] = scn.nextInt();
        }
        
        int capacity = scn.nextInt();
        
        int maxCost = getKnapsack(cost,weight,capacity);
        
        System.out.println(maxCost);
        scn.close();
    }
    
    
    public static int getKnapsack(int[] cost, int[] weight, int capacity){
        
        int[][] dp = new int[weight.length + 1][capacity + 1];
        
        for(int wgt = 1 ; wgt < dp.length ; wgt++){
            for(int cap = 1 ; cap < dp[0].length ; cap++){
                if(cap >= weight[wgt - 1]){
                    int rcap = cap - weight[wgt - 1];
                    if(dp[wgt - 1][rcap] + cost[wgt-1] > dp[wgt - 1][cap] ){
                        dp[wgt][cap] = dp[wgt - 1][rcap] + cost[wgt-1]; 
                    }else{
                        dp[wgt][cap] = dp[wgt - 1][cap];
                    }
                }else{
                    dp[wgt][cap] = dp[wgt - 1][cap];
                }
                
            }
        }
        
        return dp[dp.length - 1][dp[0].length -1];
        
        
    }
}
