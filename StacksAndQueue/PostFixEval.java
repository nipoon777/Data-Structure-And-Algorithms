package StacksAndQueue;

import java.io.*;
import java.util.*;

public class PostFixEval{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Stack<Integer> values = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> prefix = new Stack<>();
    
    for(int i = 0 ; i < exp.length() ; i++){
        char ch = exp.charAt(i);
        
        if(Character.isDigit(ch)){
            values.push(ch - '0');
            infix.push(ch + "");
            prefix.push(ch + "");
        }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            int postval2 = values.pop();
            int postval1 = values.pop();
            int postval = operation(postval1, postval2, ch);
            
            values.push(postval);
            
            String inval2 = infix.pop();
            String inval1 = infix.pop();
            String inval = '(' + inval1 + ch + inval2 + ')';
            
            infix.push(inval);
            
            String preval2 = prefix.pop();
            String preval1 = prefix.pop();
            String preval = ch + preval1 + preval2;
            
            prefix.push(preval);
        }
    }
    
    System.out.println(values.peek());
    System.out.println(infix.peek());
    System.out.println(prefix.peek());
    
    // code
 }
 public static int operation(int val1, int val2, char ch){
     if(ch == '+'){
         return val1 + val2;
     }else if( ch == '-'){
         return val1 - val2;
     }else if( ch == '*'){
         return val1 * val2;
     }else{
         return val1 / val2;
     }
 }
}