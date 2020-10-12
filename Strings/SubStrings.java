package Strings;
import java.util.*;


public class SubStrings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String s = scn.nextLine();

        for(int i = 0 ;i < s.length() ; i++){
            for(int j = i + 1 ; j <= s.length();j++){
                System.out.println(s.substring(i,j));
            }
        }
        scn.close();
    }    
}
