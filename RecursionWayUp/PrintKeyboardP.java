package RecursionWayUp;

import java.util.*;


public class PrintKeyboardP {
    public static void main(String[] args){
        
        Scanner scn = new Scanner(System.in);
        
        String ques = scn.next();
        printKPC(ques, "");
        
        scn.close();

    }
    
    static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static void printKPC(String ques, String ans) {
        
        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }
         

        
        char code = ques.charAt(0);
        String roq = ques.substring(1);
        
        String codeString = codes[code - '0'];
        
        for(int i = 0 ; i < codeString.length() ; i++){
            printKPC(roq, ans + codeString.charAt(i)); 
        }
        
    }
    
}
