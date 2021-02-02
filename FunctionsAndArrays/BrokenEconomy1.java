package FunctionsAndArrays;

import java.util.*;

public class BrokenEconomy1 {

    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scn.nextInt();
        }
        int ele = scn.nextInt();
        scn.close();
        brokenEconomy(arr, ele);
    }
    
    public static void brokenEconomy(int[] arr, int ele){
        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;
        
        for(int val : arr){
            if( val < ele ){
                if( val > floor){
                    floor = val;
                }
            }else if ( val > ele ){
                if( val < ceil ){
                    ceil = val;
                }
            }else{
                floor = ceil = val;
                break;
            }
        }
        System.out.println(ceil + "\n" + floor);
        
    }

}