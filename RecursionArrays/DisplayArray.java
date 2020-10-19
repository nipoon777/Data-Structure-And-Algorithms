package RecursionArrays;

import java.util.*;

public class DisplayArray {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scn.nextInt();
        }
        displayArr(arr, arr.length - 1);
        scn.close();
    }

    public static void displayArr(int[] arr, int idx){
        
        if(idx < 0){
            return;
        }
        displayArr(arr, idx - 1);
        System.out.println(arr[idx]);
        
    }

}
