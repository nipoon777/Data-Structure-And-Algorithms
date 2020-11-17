package DynamicProgramming;
import java.util.*;

public class PaintHouse2 {

    public static void main(String[] args)  {
        Scanner scn = new Scanner(System.in);
        
        int nhs = scn.nextInt();
        int ncs = scn.nextInt();
        
        int[][] pcost = new int[nhs][ncs];
        
        for(int r = 0 ; r < pcost.length ; r++){
            for(int c = 0 ; c < pcost[0].length ; c++){
                pcost[r][c] = scn.nextInt();
            }
        }
        scn.close();
        int[][] dp = new int[pcost.length][pcost[0].length];
        
        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;
        
        for(int j = 0 ; j < pcost[0].length ; j++ ){
            dp[0][j] = pcost[0][j];
            
            if(dp[0][j] <= least){
                sleast = least;
                least = dp[0][j];
            }
            else if(dp[0][j] <= sleast){
                sleast = dp[0][j];
            }
        }
        
        for(int i = 1 ; i < pcost.length ; i++){
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;
            for(int j = 0 ; j < pcost[0].length ; j++){
                if(dp[i - 1][j] != least){
                    dp[i][j] = pcost[i][j] + least;
                }else {
                    dp[i][j] = pcost[i][j] + sleast;
                }
                if(dp[i][j] <= nleast){
                    nsleast = nleast;
                    nleast = dp[i][j];
                }
                else if(dp[i][j] <= nsleast){
                    nsleast = dp[i][j];
                }
            }
            least = nleast;
            sleast = nsleast;
        }
        
        System.out.println(least);

    }
}