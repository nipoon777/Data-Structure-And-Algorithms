package DynamicProgramming;
import java.util.*;

public class BuyAndSell2 {

    public static void main(String[] args)  {
        Scanner scn = new Scanner(System.in);
        
        int ndays = scn.nextInt();
        
        int[] sharePrice = new int[ndays];
        
        for(int day = 0 ; day < sharePrice.length ; day++){
            sharePrice[day] = scn.nextInt();
        }
        
        scn.close();
        
        int leastSF = sharePrice[0];
        int maxPST = 0;
        int[] dpS = new int[sharePrice.length];
        dpS[0] = 0;
        for(int day = 1 ; day < sharePrice.length ; day++){
            if(leastSF > sharePrice[day]){
                leastSF = sharePrice[day];
            }
            maxPST = sharePrice[day] - leastSF;
            
            if(dpS[day - 1] < maxPST){
                dpS[day] = maxPST;
            }else{
                dpS[day] = dpS[day - 1];
            }
        }
        
        int maxSF = sharePrice[sharePrice.length - 1];
        int minBST = 0;
        int[] dpB = new int[sharePrice.length];
        dpB[dpB.length - 1] = 0;
        
        for(int day = dpB.length - 2 ; day >= 0 ; day--){
            if(maxSF < sharePrice[day]){
                maxSF = sharePrice[day];
            }
            minBST = maxSF - sharePrice[day];
            if(dpB[day + 1] < minBST){
                dpB[day] = minBST;
            }else{
                dpB[day] = dpB[day + 1];
            }
            
        }
        
        int op = 0;
        
        for(int i = 0 ; i < dpS.length ; i++){
            if(op < dpS[i] + dpB[i]){
                op = dpS[i] + dpB[i];
            }
        }
        
        System.out.println(op);
    }



}