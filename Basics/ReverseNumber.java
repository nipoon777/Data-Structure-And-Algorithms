package Basics;
import java.util.*;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        while(n != 0){
            int digit = n % 10;
            n = n / 10;

            System.out.println(digit);
        }
        scn.close();
    }    
}
