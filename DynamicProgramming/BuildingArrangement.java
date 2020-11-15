package DynamicProgramming;

import java.util.*;

public class BuildingArrangement{

public static void main(String[] args) {
    // write your code here
    Scanner scn = new Scanner(System.in);
    
    int n = scn.nextInt();
    
    long ob = 1;
    long os = 1;
    scn.close();
    
    for(int i = 2 ; i <= n ; i++){
        long nb = os;
        long ns = ob + os;
        
        os = ns;
        ob = nb;
    }
    
    long total = os + ob;
    total *= total;
    
    System.out.println(total);
 }

}
