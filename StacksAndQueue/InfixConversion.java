package StacksAndQueue;

import java.io.*;
import java.util.*;

public class InfixConversion{
  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
    
        Stack<String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<Character> opretor = new Stack<>();
        
        for(int i = 0 ; i < exp.length(); i++){
            char ch = exp.charAt(i);
            
            if(ch == '('){
                opretor.push(ch);
            }else if( (ch >= '0' && ch <= '9') ||
                      (ch >= 'a' && ch <= 'z') ||
                      (ch >= 'A' && ch <= 'Z')){
                prefix.push(ch + "");
                postfix.push(ch + "");
            }else if( ch == ')'){
                while(opretor.peek() != '('){
                    process(prefix, postfix, opretor);
                }
                opretor.pop();
            }else if( ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while(!opretor.isEmpty() &&
                      opretor.peek() != '(' &&
                      precedence(ch) <= precedence(opretor.peek()) ){
                    process(prefix, postfix, opretor);          
                }
                opretor.push(ch);
            }
        }
        
        while(!opretor.isEmpty()){
            process(prefix, postfix, opretor);
        }
        System.out.println(postfix.peek());
        System.out.println(prefix.peek());
        
    }
    
    public static void process(Stack<String> prefix, Stack<String> postfix, 
                               Stack<Character> opretor){
        char opr = opretor.pop();
        //Prefix Calculation
        String preval2 = prefix.pop();
        String preval1 = prefix.pop();
        String preval = opr + preval1 + preval2;
        prefix.push(preval);
        //Postfix Calculation
        String postval2 = postfix.pop();
        String postval1 = postfix.pop();
        String postval = postval1 + postval2 + opr;
        postfix.push(postval);
    }
 
    public static int precedence(char ch){
        if( ch == '+' || ch == '-'){
            return 1;
        }else{
            return 2;
        }
    }
 
 
 
}