package FunctionsAndArrays;


import java.util.*;

public class CeilAndFloor{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    
    int n = scn.nextInt();
    
    int[] a = new int[n];
    
    for(int i  = 0 ;  i < n ; i++ ){
        a[i] = scn.nextInt();
    }
    
    int d = scn.nextInt();
    
    int lo = 0;
    int hi = a.length - 1;
    int ceil = 0;
    int floor = 0;
    
    
    while(lo <= hi){
        
        int mid = ( lo + hi ) / 2;
        
        if(a[mid] < d){
            lo = mid + 1;
            floor = a[mid];        
        }else if (a[mid] > d){
            hi = mid - 1;
            ceil = a[mid];
        }else{
            floor = a[mid];
            ceil = a[mid];
        }
    }
    
    System.out.println(ceil);
    System.out.println(floor);
    scn.close();
    
 }

}