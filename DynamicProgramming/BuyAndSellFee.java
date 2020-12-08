package DynamicProgramming;

import java.util.*;

public class BuyAndSellFee {

    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int ndays = scn.nextInt();
        
        int[] sharePrice = new int[ndays];
        
        for(int day = 0 ; day < sharePrice.length ; day++){
            sharePrice[day] = scn.nextInt();
        }
        
        int transFee = scn.nextInt();
        
        scn.close();
        
        int oldBuyState = -sharePrice[0];
        int oldSellState = 0;
        
        for(int day = 0 ; day < sharePrice.length ; day++){
            int newBuyState = 0;
            int newSellState = 0;
            
            if((oldSellState - sharePrice[day]) > oldBuyState){
                newBuyState = oldSellState - sharePrice[day];
            }
            else{
                newBuyState = oldBuyState;
            }
            
            if((oldBuyState + sharePrice[day] - transFee) > oldSellState ){
                newSellState = oldBuyState + sharePrice[day] - transFee;
            }
            else{
                newSellState = oldSellState;
            }
            oldBuyState = newBuyState;
            oldSellState = newSellState;
        }
        
        System.out.println(oldSellState);
        
        
    }

}