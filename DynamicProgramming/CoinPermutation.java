package DynamicProgramming;

import java.util.*;

public class CoinPermutation {

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int[] coins = new int[n];
        
        for(int i = 0 ; i < coins.length ; i++){
            coins[i] = scn.nextInt();
        }
        
        int den = scn.nextInt();
        
        int perm = getPermutation(coins,den);
        
        System.out.println(perm);
        scn.close();
    }
    
    public static int getPermutation(int[] coins, int den){
        int[] dp = new int[den + 1];
        
        dp[0] = 1;
        
        for(int amt = 1 ; amt <= den ; amt++){
            for(int coin : coins){
                if( coin <= amt ){
                    int ramt = amt - coin;
                    dp[amt] += dp[ramt];
                    
                }
            }
        }
        
        return dp[den];
    }
}
