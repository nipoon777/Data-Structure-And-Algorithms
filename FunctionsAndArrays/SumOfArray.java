package FunctionsAndArrays;

import java.util.*;

public class SumOfArray{

public static void main(String[] args) throws Exception {
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
    scn.close();
    int[] sarr = new int[ n1 > n2 ? n1 : n2];
    
    int i = arr1.length - 1;
    int j = arr2.length - 1;
    int k = sarr.length - 1;
    
    int c = 0;
    
    while(k >= 0){
        int d = c;
        if(i >= 0){
            d += arr1[i];
        }
        if(j >= 0){
            d += arr2[j];
        }
        c = d / 10;
        d = d % 10;
        sarr[k] = d;
        i--;
        j--;
        k--;
    }
    if ( c > 0){
        System.out.println(c);
    }
    
    for( i = 0 ; i < sarr.length ; i++){
        System.out.println(sarr[i]);
    }
    
 }

}
