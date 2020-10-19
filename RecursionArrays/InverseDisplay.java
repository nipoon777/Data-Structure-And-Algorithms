package RecursionArrays;

import java.util.*;


public class InverseDisplay {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scn.nextInt();
        }
        displayArrReverse(arr, arr.length - 1);
        scn.close();
    }

    public static void displayArrReverse(int[] arr, int idx) {
        if(idx < 0){
            return;
        }
        System.out.println(arr[idx]);
        displayArrReverse(arr, idx - 1);

    }
    
}
