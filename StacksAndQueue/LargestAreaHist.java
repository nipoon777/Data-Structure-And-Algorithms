package StacksAndQueue;

import java.io.*;
import java.util.*;

public class LargestAreaHist{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    
    int[] nsr = new int[a.length];
    
    Stack<Integer> st = new Stack<>();
    
    st.push(0);
    
    for(int i = 1 ; i < nsr.length ; i++){
        while(!st.isEmpty() && a[i] < a[st.peek()]){
            nsr[st.peek()] = i;
            st.pop();
        }
        st.push(i);
    }
    while(!st.isEmpty()){
        nsr[st.peek()] = a.length;
        st.pop();
    }
    
    int[] nsl = new int[a.length];
    nsl[0] = -1;
    st.push(0);
    
    for(int i = 1 ; i < nsl.length ; i++){
        while(!st.isEmpty() && a[i] < a[st.peek()]){
            st.pop();
        }
        if(st.isEmpty()){
            nsl[i] = -1;
        }else{
            nsl[i] = st.peek();
        }
        
        st.push(i);
    }
    
    int maxArea = 0;
    
    for(int i = 0 ;i < a.length ; i++){
        int width = nsr[i] - nsl[i] - 1;
        int area = width * a[i];
        if(area > maxArea){
            maxArea = area;
        }
    }
    
    System.out.println(maxArea);
 }
}
