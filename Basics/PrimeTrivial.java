import java.util.*;

public class PrimeTrivial {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for(int i = 0 ; i < t ; i++ )
        {
            int n = scn.nextInt();
            int count = 0;
            for(int j = 1 ; j <= n ; j++){
                if( n % j == 0)
                {
                    count++;
                }
            }
            if(count == 2)
            {
                System.out.println("prime");
            }
            else
            {
                System.out.println("not prime");
            }
        }
  
    }    
}
