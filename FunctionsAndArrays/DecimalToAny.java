package FunctionsAndArrays;

import java.util.*;

public class DecimalToAny {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();

        int res = getDecimalToAny(n, b);

        System.out.println(res);
    }
    
    public static int getDecimalToAny(int n , int b) {

        int res = 0;
        int pow = 1;

        while( n != 0){
            int digit = n % b ;
            n = n / b;
            res += digit * pow;
            pow *= 10;
        }
        return res;
        
    }
}
