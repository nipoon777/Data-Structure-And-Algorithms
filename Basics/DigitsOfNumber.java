import java.util.*;

public class DigitsOfNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int tmp = n;
        int pow = 1;
        while( tmp >= 10)
        {
            tmp /= 10;
            pow *= 10;
            
        }


        while(pow != 0)
        {
            System.out.println(n / pow);
            n = n % pow;
            pow = pow / 10;
        }


    }    
}
