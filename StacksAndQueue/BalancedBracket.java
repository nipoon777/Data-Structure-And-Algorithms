package StacksAndQueue;


import java.util.*;

public class BalancedBracket {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        String str = scn.nextLine();
        scn.close();
        
        Stack<Character> st = new Stack<>();
        
        for(int i = 0 ; i < str.length() ; i++){
            
            char ch = str.charAt(i);
            
            if( ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else if( ch == ')'){
                boolean val = handClosing(st, '(');
                if(!val){
                    System.out.println("false");
                    return;
                }
                
            }else if( ch == '}'){
                boolean val = handClosing(st, '{');
                if(!val){
                    System.out.println("false");
                    return;
                }
            }else if( ch == ']'){
                boolean val = handClosing(st, '[');
                if(!val){
                    System.out.println("false");
                    return;
                }
                
            }
        }
        if(st.isEmpty())
        {
            System.out.println("false");
            return;
        }
        System.out.println("true");
        

    }
    public static boolean handClosing(Stack<Character> st, char ch){
        if(st.isEmpty()){
            return false;
        }else if(st.peek() != ch){
            return false;
        }else{
            st.pop();
        }
        return true;
    }

}