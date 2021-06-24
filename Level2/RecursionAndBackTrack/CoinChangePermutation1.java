import java.io.*;
import java.util.*;

public class Main {

    public static void coinChange(int[] coins, int amtsf, int tamt, String asf, boolean[] used){
       // write your code here
       if (amtsf > tamt ){
           return;
       }
       if( amtsf == tamt ){
           System.out.println(asf+ ".");
           return;
       }
       
       
       for(int coin = 0 ; coin < coins.length ; coin++ ){
           if( used[coin] == false ){
               used[coin] = true;
               coinChange(coins, amtsf + coins[coin], tamt, asf + coins[coin] + "-", used);
               used[coin] = false;
           } 
       }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        boolean[] used = new boolean[coins.length];
        coinChange(coins, 0, amt, "", used);
    }
}