import java.util.*;

public class InverseNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int p = 1;
        int s = 0;

        while( n != 0){
            int digit = n % 10;
            n = n / 10;
            s += p * Math.pow(10,digit -1);
            p++;
        }
        System.out.println(s);
    }    
}
