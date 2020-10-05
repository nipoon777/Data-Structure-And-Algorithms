package Patterns;
import java.util.*;

public class Pattern15 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sp = n / 2;
        int st = 1;
        int k = 1;
        for(int i = 1 ; i <= n ; i++){
            
            for(int j = 1 ; j <= sp ; j++){
                System.out.print("\t");
            }
            int l = k;
            for(int j = 1 ; j <= st ; j++){
                System.out.print(l+ "\t");
                if(j <= st /2){
                    l++;
                }else{
                    l--;
                }
            }
            
            if(i <= n / 2)
            {
                k++;
                sp--;
                st += 2;
            }
            else{
                k--;
                sp++;
                st -= 2;
            }
            System.out.println();
        }

    }
}