package RecursionWayUp;
import java.util.*;


public class TextEncoding {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        String ques = scn.next();
        
        printEncodings(ques, "");
        
        scn.close();

    }

    public static void printEncodings(String ques, String ans) {
        
        if(ques.length() == 0){
            System.out.println(ans);
        }
        
        else if(ques.length() == 1){
            char ch = ques.charAt(0);
            
            if(ch == 0){
                return;
            }
            
            int code = ch - '0';
            char val = (char)(code + 'a' -1);
            ans = ans + val;
            System.out.println(ans);

        }
        
        else{
            char ch = ques.charAt(0);
            String roq = ques.substring(1);
            
            if(ch == 0){
                return;
            }
            else{
                int chv = ch - '0';
                char code = (char)(chv + 'a' - 1);
                
                printEncodings(roq, ans + code);
            }
            
            int ch12 = Integer.parseInt(ques.substring(0,2));
            String roq12 = ques.substring(2);
            
            if(ch12 <= 26 ){
                char val = (char)(ch12 + 'a' - 1);
                printEncodings(roq12, ans + val);
            }
        }
        
    }
    
}
