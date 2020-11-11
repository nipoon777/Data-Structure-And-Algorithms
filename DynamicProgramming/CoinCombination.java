package DynamicProgramming;


import java.util.*;

public class CoinCombination {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int[] coins = new int[n];
        
        for(int i = 0 ; i < coins.length ; i++){
            coins[i] = scn.nextInt();
        }
        
        int den = scn.nextInt();
        
        int combination = coinComb(coins, den);
        
        System.out.println(combination);

        scn.close();

    }
    
    
    
    public static int coinComb(int[] coins, int den){
        
        int[] dp = new int[den + 1];
        
        dp[0] = 1;
        
        for(int i = 0 ; i < coins.length ; i++){
            for(int j = coins[i] ; j < dp.length ; j++){
                dp[j] += dp[j - coins[i]];
            }
        }
        
        return dp[dp.length - 1];
    }
}
