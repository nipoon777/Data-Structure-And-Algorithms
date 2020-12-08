package DynamicProgramming;

import java.util.*;

public class BuyAndSellCool {

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        
        int ndays = scn.nextInt();
        
        int[] sharePrice = new int[ndays];
        
        for(int day = 0 ; day < sharePrice.length ; day++){
            sharePrice[day] = scn.nextInt();
        }
        
        int oldBuyState = -sharePrice[0];
        int oldSellState = 0;
        int oldCoolState = 0;
        scn.close();
        
        for(int day = 1 ; day < sharePrice.length ; day++){
            int newBuyState = 0;
            int newSellState = 0;
            int newCoolState = 0;
            
            if(oldCoolState - sharePrice[day] > oldBuyState){
                newBuyState = oldCoolState - sharePrice[day];
            }else{
                newBuyState = oldBuyState;
            }
            
            if(oldBuyState + sharePrice[day] > oldSellState){
                newSellState = oldBuyState + sharePrice[day];
            }else{
                newSellState = oldSellState;
            }
            
            if(oldSellState > oldCoolState){
                newCoolState = oldSellState;
            }else{
                newCoolState = oldCoolState;
            }
            
            oldBuyState = newBuyState;
            oldSellState = newSellState;
            oldCoolState = newCoolState;
        }
        
        System.out.println(oldSellState);
    }

}
