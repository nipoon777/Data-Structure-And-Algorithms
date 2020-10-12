package FunctionsAndArrays;


import java.util.*;

public class FirstAndLast{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    
    int n = scn.nextInt();
    
    int [] a = new int[n];
    
    for(int i = 0 ; i < n ; i++){
        a[i] = scn.nextInt();    
    }
    
    int d = scn.nextInt();
    
    int lo = 0;
    int hi = a.length - 1;
    
    int fi = -1;
    
    while( lo <= hi){
        int mid = (lo + hi) / 2;
        
        if(d > a[mid]){
            lo = mid + 1;
            
        }else if (d < a[mid]){
            hi = mid - 1;
            
        }else{
            fi = mid;
            hi = mid - 1;
        }
    }
    System.out.println(fi);
    
    int li = -1;
    lo = 0 ;
    hi = a.length - 1;
    
    while( lo <= hi){
        int mid = (lo + hi) / 2;
        
        if(d > a[mid]){
            lo = mid + 1;
            
        }else if (d < a[mid]){
            hi = mid - 1;
            
        }else{
            li = mid;
            lo = mid + 1;
        }
    }
    System.out.println(li);
    scn.close();
    
    
 }

}
