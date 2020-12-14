package StacksAndQueue;

import java.io.*;
import java.util.*;

public class PreFixEval {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        Stack<Integer> values = new Stack<>();
        Stack<String> inFix = new Stack<>();
        Stack<String> postFix = new Stack<>();
        for(int i = exp.length() - 1 ; i >= 0 ; i--){
            char ch = exp.charAt(i);

            if( Character.isDigit(ch)){
                values.push(ch - '0');
                inFix.push(ch + "");
                postFix.push(ch + "");
            }else if(ch == '+' || 
                     ch == '-' ||
                     ch == '*' ||
                     ch == '/'){
                
                int val1 = values.pop();
                int val2 = values.pop();
                int opr = operation(val1, val2, ch);
                values.push(opr);

                String ival1 = inFix.pop();
                String ival2 = inFix.pop();
                String ival = "(" + ival1 + ch + ival2 +")";
                inFix.push(ival);

                String pval1 = postFix.pop();
                String pval2 = postFix.pop();
                String pval = pval1 + pval2 + ch;
                postFix.push(pval);
            }
        }
        System.out.println(values.peek());
        System.out.println(inFix.peek());
        System.out.println(postFix.peek());

    }
    public static int operation(int val1, int val2, char ch){
        if(ch == '+'){
            return val1 + val2;
        }else if(ch == '-'){
            return val1 - val2;
        }else if(ch == '*'){
            return val1 * val2;
        }else{
            return val1 / val2;
        }
    }
}
