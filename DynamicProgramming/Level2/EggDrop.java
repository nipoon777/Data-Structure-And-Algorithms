import java.io.*;
import java.util.*;

public class Main {

	public static int eggDrop(int k, int n){
		int[][] dp = new int[k + 1][n + 1];
        
        for(int e = 1; e <= k ; e++ ){
            for(int f = 1 ; f <= n ; f++ ){
                if( e == 1 ){
                    dp[e][f] = f;
                }else if( f == 1 ){
                    dp[e][f] = 1;
                }else{
                    int min = Integer.MAX_VALUE;
                    for(int mf = f - 1, pf = 0 ; mf >= 0 ; mf--, pf++ ){
                        int val1 = dp[e - 1][pf];// Egg Breaks
                        int val2 = dp[e][mf];// Egg Survives;
                        int val = Math.max(val1, val2);
                        min = Math.min(min, val);
                    }
                    dp[e][f] = min + 1;
                }
            }
        }
        return dp[k][n];

	} 

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//n -> number of eggs and k -> number of floors
		int n = scn.nextInt();
		int k = scn.nextInt();
		System.out.println(eggDrop(n,k));
	}
	
}