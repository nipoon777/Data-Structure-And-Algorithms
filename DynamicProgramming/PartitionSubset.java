package DynamicProgramming;
import java.util.*;

public class PartitionSubset {

   public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int people = scn.nextInt();
        int teams = scn.nextInt();
        scn.close();
        if(teams == 0 || people < teams || people == 0){
            System.out.println(0);
            return;
        }
        
        long[][] dp = new long[teams + 1][people + 1]; 
        
        
        for(int t = 1 ; t < dp.length ; t++){
            for(int p = 1 ; p < dp[0].length ; p++){
                if(p < t){
                    dp[t][p] = 0;
                }else if(p == t){
                    dp[t][p] = 1;
                }else{
                    dp[t][p] = dp[t-1][p - 1] + t * dp[t][p - 1];
                }
            }
        }
        
        System.out.println(dp[teams][people]);
        
        
       
   }
   
}
      