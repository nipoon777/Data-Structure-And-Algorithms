package StacksAndQueue;

import java.io.*;
import java.util.*;

public class SlidingWindowMax{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    int[] nge = new int[arr.length];
    
    Stack<Integer> st = new Stack<>();
    
    nge[arr.length - 1] = arr.length;
    st.push(arr.length - 1);
    for(int i = arr.length - 2 ; i >= 0 ; i--){
        
        while(!st.isEmpty() && arr[i] >= arr[st.peek()]){
            st.pop();
        }
        if(st.isEmpty()){
            nge[i] = arr.length;
        }else{
            nge[i] = st.peek();
        }
        
        st.push(i);
    }
    for(int i = 0 ; i <= arr.length - k ; i++){
        int j = i;
        while(nge[j] < i + k){
            j = nge[j];
        }
        System.out.println(arr[j]);
    }
 }
}