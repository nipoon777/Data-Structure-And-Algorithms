package FunctionsAndArrays;
import java.io.*;
import java.util.*;

public class FirstAndLastBF {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner( System.in );
        
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0; i < arr.length ; i++ ){
            arr[i] = scn.nextInt();
        }
        int ele = scn.nextInt();
        // firstAndLastIndex(arr, ele);
        System.out.println(firstIndex(arr, ele));
        System.out.println(lastIndex(arr, ele));
    }
    
    public static int firstIndex(int[] arr, int ele){
        int fi = -1;
        int lo = 0;
        int hi = arr.length - 1;
        
        while ( lo <= hi){
            int mid = (lo  + hi ) / 2;
            
            if(ele == arr[mid]){
                fi = mid;
                hi = mid - 1;
            }else if ( ele > arr[mid]){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return fi;
    }
    public static int lastIndex(int[] arr, int ele){
        int li = -1;
        int lo = 0;
        int hi = arr.length - 1;
        
        while ( lo <= hi){
            int mid = (lo  + hi ) / 2;
            
            if(ele == arr[mid]){
                li = mid;
                lo = mid + 1;
            }else if ( ele > arr[mid]){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return li;
    }
    
    
    public static void firstAndLastIndex(int[] arr, int ele){
        int firstIndex = -1;
        int lastIndex = -1;
        
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == ele){
                if(firstIndex == -1){
                    firstIndex = i;
                }
                lastIndex = i;
            }
        }
        System.out.println(firstIndex + "\n" + lastIndex);
    }

}