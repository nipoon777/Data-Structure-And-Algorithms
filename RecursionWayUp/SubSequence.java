package RecursionWayUp;

import java.util.*;

public class SubSequence {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String ques = scn.next();
        
        printSS(ques,"");
        scn.close();

    }

    public static void printSS(String ques, String ans) {
        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }
        
        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        
        printSS(roq, ans + ch );
        printSS(roq, ans + "");
        
        
    }
    
}
