package DynamicProgramming;

import java.util.*;

public class CountBinaryStr{

public static void main(String[] args) {
    // write your code here
    Scanner scn = new Scanner(System.in);
    
    int n = scn.nextInt();
    int o0s = 1;
    int o1s = 1;
    
    for(int i = 2; i <= n ; i++){
        int n0s = o1s;
        int n1s = o0s + o1s;
        
        o0s = n0s;
        o1s = n1s;
    }
    scn.close();
    System.out.println(o0s + o1s);
 }

}