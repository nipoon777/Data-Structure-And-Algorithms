package DynamicProgramming;
import java.util.*;

public class TilesMx1 {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[] dp = new int[n + 1];
        
        for(int i = 1 ; i < dp.length ; i++){
            if(i < m){
                dp[i] = 1;
            }else if(i == m){
                dp[i] = 2;
            }else{
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }
        scn.close();
        System.out.println(dp[n]);
    }
}