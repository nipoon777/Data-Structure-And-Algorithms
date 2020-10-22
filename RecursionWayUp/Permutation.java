package RecursionWayUp;
import java.util.*;


public class Permutation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String ques = scn.next();

        permuatationString(ques, "");

        scn.close();
    }

    public static void permuatationString(String ques, String ans){
        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }

        for(int s = 0 ; s < ques.length(); s++){
            char ch = ques.charAt(s);
            String roq = ques.substring(0,s) + ques.substring(s+1);

            permuatationString(roq, ans + ch);
        }


    }
    
}
