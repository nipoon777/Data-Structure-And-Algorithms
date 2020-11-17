package DynamicProgramming;
import java.util.*;

public class PaintHouse {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int nhs = scn.nextInt();
        
        int[][] pcost = new int[nhs][3];
        
        for(int i = 0 ; i < pcost.length ; i++){
            for(int j = 0 ; j < pcost[0].length ; j++){
                pcost[i][j] = scn.nextInt();
            }
        }
        scn.close();
        long[][] dp = new long[nhs][3];
        
        dp[0][0] = pcost[0][0];
        dp[0][1] = pcost[0][1];
        dp[0][2] = pcost[0][2];
        
        for(int i = 1 ; i < dp.length ; i++)
        {
            dp[i][0] = pcost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = pcost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = pcost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        long ans = Math.min(dp[dp.length - 1][0], Math.min(dp[dp.length - 1][1], dp[dp.length - 1][2]));
        System.out.println(ans);
        
    }
}