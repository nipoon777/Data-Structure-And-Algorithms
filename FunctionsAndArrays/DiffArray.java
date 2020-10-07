package FunctionsAndArrays;
import java.io.*;
import java.util.*;

public class DiffArray{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    
    int n1 = scn.nextInt();
    
    int[] arr1 = new int[n1];
    
    for(int i = 0 ; i < n1 ; i++){
        arr1[i] = scn.nextInt();
    }
    
    int n2 = scn.nextInt();
    
    int[] arr2 = new int[n2];
    
    for(int i = 0 ; i < n2 ; i++){
        arr2[i] = scn.nextInt();
    }
    
    int[] darr = new int[n2];
    int c = 0;
    int i = arr1.length - 1;
    int j = arr2.length - 1;
    int k = darr.length - 1;
    while( k >= 0){
        
        int d = 0;
        int val2 = ( i >= 0 ? arr1[i] : 0);
        if(arr2[j] + c >= val2){
            d =  arr2[j] + c - val2;
            c = 0;
        }
        else{
            d = arr2[j] + c + 10 - val2;
            c = -1;
        }
        darr[k] = d;
        
        i--;
        j--;
        k--;
    }
    
    int idx = 0;
    
    while( idx < darr.length){
        if(darr[idx] == 0){
            idx++;
        }else{
            break;
        }
    }
    
    while(idx < darr.length){
        System.out.println(darr[idx++]);
    }
    
    
 }

}
