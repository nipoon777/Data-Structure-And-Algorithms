package IntroRecursion;
import java.util.*;

public class PrintZigZag {
    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pzz(n);
        scn.close();
    }

    public static void pzz(int n){
        
        if( n == 0){
            return;
        }
        
        // Draw Eulers Diagram to understand this
        
        System.out.print(n + " ");
        pzz(n - 1);// LC
        System.out.print(n + " ");//In Call
        pzz(n - 1);// RC
        System.out.print(n + " ");
        
    }
    
}
