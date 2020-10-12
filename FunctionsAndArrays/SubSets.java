package FunctionsAndArrays;

import java.util.*;

public class SubSets{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    
    int n = scn.nextInt();
    int[] a = new int[n];
    
    for(int i = 0 ; i < n ; i++){
        a[i] = scn.nextInt();    
    }
    
    int length = (int)Math.pow(2, a.length);
    
    for(int i = 0 ;i < length ; i++){
        String sb = "";
        int temp =i;
        
        for(int j = a.length - 1 ; j >= 0 ; j--){
            int rem = temp % 2;
            temp = temp/2; 
            
            if ( rem == 0){
                sb = "-\t" + sb ;
            }
            else{
                sb =  a[j] +"\t" + sb;
            }
        }
        System.out.println(sb);
    }
    scn.close();
 }

}
