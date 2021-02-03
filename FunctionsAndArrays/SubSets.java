package FunctionsAndArrays;

import java.util.*;

public class SubSets{

    public static void subSet(int[] arr){
        //Total number of elements kitna hai subset/subsequence mai ye isse pata chalega
        
        int size = (int) Math.pow(2, arr.length);
        
        for(int i = 0 ; i < size ; i++){
            //Har ek "i" ke value ka uska binary representation samajna padega
            //Kyuki "i" ko hum element represent karne ke liye use kar rahe hai toh usse baki jagaha use nahi kar sakte
            int temp = i;
            // Reverse mai Loop iss liye laaga rahe hai kyuki hame remainder last digit se milta hai
            String subset = "";
            for(int j = arr.length - 1; j >= 0; j--){
                if( temp % 2 == 0){// Kyuki remainder denote karta hai ki kya digit ayega ki nahi ayega
                    subset = "-\t" + subset;
                }else{
                    subset = arr[j] +"\t" + subset;
                    
                }
                temp = temp/2;// temp ko chnage karna hoga taki uski next binary digit mile
            }
            System.out.println(subset);
        }
        
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scn.nextInt();
        }
        scn.close();
        
        subSet(arr);
    }
}
