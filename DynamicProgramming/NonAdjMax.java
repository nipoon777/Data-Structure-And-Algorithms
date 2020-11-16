package DynamicProgramming;
import java.util.*;

public class NonAdjMax {

    public static void main(String[] args)  {
        Scanner scn = new Scanner(System.in);
        
        int arr_sz = scn.nextInt();
        
        int[] arr = new int[arr_sz];
        
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scn.nextInt();
        }
        
        int inc = arr[0];
        int exc = 0;

        scn.close();
        
        for(int i = 1 ; i < arr.length ; i++){
            int ninc = arr[i] + exc;
            int nexc = Math.max(inc, exc);
            
            inc = ninc;
            exc = nexc;
        }
        
        int ans = Math.max(inc, exc);
        System.out.println(ans);
    }
}