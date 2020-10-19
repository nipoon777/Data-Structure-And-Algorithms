package RecursionArrays;
import java.util.*;

public class MaxArray {
    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scn.nextInt();
        }
        int max = maxOfArray(arr, arr.length - 1);
        System.out.println(max);
        scn.close();
    }

    public static int maxOfArray(int[] arr, int idx){
        if(idx < 0){
            return Integer.MIN_VALUE;
        }
        
        int max = maxOfArray(arr, idx - 1);
        if( max < arr[idx]){
            max = arr[idx];
        }
        return max;
    }
    
}
