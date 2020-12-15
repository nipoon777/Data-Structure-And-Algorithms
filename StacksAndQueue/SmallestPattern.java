package StacksAndQueue;

import java.io.*;
import java.util.*;

public class SmallestPattern{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int num = 1;
    Stack<Integer> st = new Stack<>();
    for(int i = 0 ; i < str.length(); i++)
    {   
        char ch = str.charAt(i);
        if(ch == 'd'){
            st.push(num);
            num++;
        }else{
            st.push(num);
            num++;
            
            while(!st.isEmpty()){
                System.out.print(st.pop());
            }
        }
    }
    st.push(num);
    while(!st.isEmpty()){
        System.out.print(st.pop());
    }
 }
}