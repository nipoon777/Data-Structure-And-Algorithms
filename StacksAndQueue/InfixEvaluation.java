package StacksAndQueue;

import java.util.*;

public class InfixEvaluation{
  

public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();

        Stack<Integer> oprnds = new Stack<>();
        Stack<Character> optors = new Stack<>();

        scn.close();
        for(int i = 0 ; i < exp.length() ; i++){
            char ch = exp.charAt(i);

            if(ch == '('){
                optors.push(ch);
            }else if(Character.isDigit(ch)){
                oprnds.push(ch - '0');
            }else if(ch == ')'){
                while( optors.peek() != '('){
                    int val2 = oprnds.pop();
                    int val1 = oprnds.pop();
                    char optor = optors.pop();

                    int operation = operation(val1, val2, optor);

                    oprnds.push(operation);
                }
                optors.pop();
            }else if(ch == '+' || ch == '-' || ch == '*' || ch =='/'){
                while(!optors.isEmpty() && optors.peek() != '('
                        && precedence(optors.peek()) >= precedence(ch)){
                        int val2 = oprnds.pop();
                        int val1 = oprnds.pop();
                        char optor = optors.pop();

                        int operation = operation(val1, val2, optor);

                        oprnds.push(operation);
                }
                optors.push(ch);
            }
            
        }
         while(!optors.isEmpty()){
                int val2 = oprnds.pop();
                int val1 = oprnds.pop();
                char optor = optors.pop();

                int operation = operation(val1, val2, optor);

                oprnds.push(operation);
            }
        System.out.println(oprnds.peek());
    }
    public static int operation(int val1, int val2, char optor){
        if(optor == '+'){
            return val1 + val2;
        }else if(optor == '-'){
            return val1 - val2;
        }else if(optor == '*'){
            return val1 * val2;
        }else{
            return val1 / val2;
        }
    }

    public static int precedence(char optor){
        if(optor == '+'){
            return 1;
        }else if(optor == '-'){
            return 1;
        }else if(optor == '*'){
            return 2;
        }else{
            return 2;
        }
    }
}