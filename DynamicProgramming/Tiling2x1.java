package DynamicProgramming;
import java.util.*;

public class Tiling2x1 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3 ; i < dp.length ; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        scn.close();
        System.out.println(dp[n]);

    }
}