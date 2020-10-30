package DynamicProgramming;


import java.util.*;

public class ClimbStairs {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int countPaths = countPathM(n, new int[n + 1]);
        
        int tbcount = countPathTb(n);
        
        if( tbcount == countPaths){
            System.out.println(tbcount);
        }
        
        scn.close();
        
    }
    
    public static int countPathM(int n , int[] qb){
        
        if(n == 0){
            return 1;
        }
        
        if( n < 0 ){
            return 0;
        }
        
        if(qb[n] > 0){
            return qb[n];
        }
        
        int nm1 = countPathM( n - 1, qb);
        int nm2 = countPathM( n - 2, qb);
        int nm3 = countPathM( n - 3, qb);
        
        int np = nm1 + nm2 + nm3;
        
        qb[n] = np;
        
        return np;
    }
    
    public static int countPathTb(int n){
        
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        
        for(int i = 1 ; i < dp.length ; i++){
            
            if(i == 1){
                dp[i] = dp[i - 1];
            }
            else if( i == 2){
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            else{
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        
        
        return dp[n];
    }

}
