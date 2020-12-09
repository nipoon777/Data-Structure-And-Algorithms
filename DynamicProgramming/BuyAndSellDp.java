package DynamicProgramming;

import java.util.*;

public class BuyAndSellDp {

    public static void main(String[] args)  {
        Scanner scn = new Scanner(System.in);
        
        int ndays = scn.nextInt();
        int[] sharePrice = new int[ndays];
        
        for(int day = 0 ; day < sharePrice.length ; day++){
            sharePrice[day] = scn.nextInt();
        }
        int trans = scn.nextInt();
        scn.close();

        int[][] dp = new int[trans + 1][sharePrice.length];
        
        for(int tran = 1 ; tran < dp.length ; tran++){
            int max = Integer.MIN_VALUE;
            for(int day = 1 ; day < dp[0].length ; day++){
                if(max < dp[tran - 1][day - 1] - sharePrice[day - 1]){
                    max = dp[tran - 1][day - 1] - sharePrice[day - 1];
                }
                if(max + sharePrice[day] > dp[tran][day -1]){
                    dp[tran][day] = max + sharePrice[day];
                }else{
                    dp[tran][day] = dp[tran][day -1];
                }
                
            }
        }
        
        System.out.println(dp[dp.length -1][dp[0].length -1]);
    }

}
