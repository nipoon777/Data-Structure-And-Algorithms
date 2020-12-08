package DynamicProgramming;

import java.util.*;

public class BuyAndSellInfinite {

    public static void main(String[] args)  {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int ndays = scn.nextInt();
        
        int[] sharePrice = new int[ndays];
        
        for(int day = 0 ; day < sharePrice.length ; day++){
            sharePrice[day] = scn.nextInt();
        }
        
        scn.close();
        
        int buyP = sharePrice[0];
        int sellP = sharePrice[0];
        int pcollect = 0;
        
        for(int day = 1 ; day < sharePrice.length ; day++){
            
            if(sharePrice[day] >= sharePrice[day - 1]){
                sellP = sharePrice[day];
            }
            else{
                pcollect += sellP - buyP;
                buyP = sellP = sharePrice[day];
            }
        }
        
        pcollect += sellP - buyP;
        
        System.out.println(pcollect);
    }

}