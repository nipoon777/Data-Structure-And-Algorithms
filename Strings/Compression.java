package Strings;

import java.util.*;

public class Compression {

    public static String compression1(String s) {
        String res = s.charAt(0) + "";

        for(int i = 1 ; i < s.length(); i++){
            char prev = s.charAt(i - 1);
            char curr = s.charAt(i);

            if(prev != curr){
                res += s.charAt(i);
            }
        }
        return res;
        
    }

    public static String compression2(String s) {
        String res = s.charAt(0) + "";
        int count = 1;
        for(int i = 1 ; i < s.length() ; i++){
            char prev = s.charAt(i - 1);
            char curr = s.charAt(i);

            if(curr == prev){
                count++;
            }else{
                if(count > 1){
                    res += count;
                    count = 1;
                }
                res += curr;
            }
        }
        if(count > 1){
            res += count;
        }
        return res;
        
    }



    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(compression1(str));
        System.out.println(compression2(str));

        scn.close();
    }    
}
