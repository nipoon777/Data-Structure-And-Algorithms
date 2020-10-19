package RecursionArrays;

import java.util.*;

public class LastIndex {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();
        
        int li = lastIndex(arr, arr.length - 1 , x);
        System.out.println(li);

        scn.close();
    }

    public static int lastIndex(int[] arr, int idx, int x){
        if( idx < 0){
            return -1;
        }
        if( arr[idx] != x){
            return lastIndex(arr, idx - 1, x);
        }         
        return idx;
    }
    
}
