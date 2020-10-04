package Basics;
import java.util.*;


public class RotateNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        int digits = (int)Math.floor(Math.log10(n) + 1);

        k = k % digits;
        if( k < 0){
            k = k + digits;
        }
        int div = (int) Math.pow(10, k);
        int mul = (int) Math.pow(10, digits - k);
        
        int rem = n % div;
        n = n / div;
        System.out.println(mul*rem + n);

    }
}
