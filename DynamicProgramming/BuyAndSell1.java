package DynamicProgramming;

import java.util.*;

public class BuyAndSell1 {

    public static void main(String[] args)  {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int ndays = scn.nextInt();
        
        int[] sharePrice = new int[ndays];
        
        for(int day = 0 ; day < sharePrice.length ; day++){
            sharePrice[day] = scn.nextInt();
        }
        
        int lsf = Integer.MAX_VALUE;
        int pt = 0;
        int overallP = 0;
        
        for(int day = 0 ; day < sharePrice.length ; day++){
            if(sharePrice[day] < lsf){
                lsf = sharePrice[day];
            }
            
            pt = sharePrice[day] - lsf;
            
            if(pt > overallP){
                overallP = pt;
            }
        }
        
        System.out.println(overallP);
        scn.close();
    }

}
