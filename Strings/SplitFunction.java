package Strings;

import java.util.*;

public class SplitFunction {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        String [] res = s.split(",");
        for(int i = 0 ;i < res.length ; i++){
            System.out.println(res[i]);
        }
        scn.close();
    }    
}
