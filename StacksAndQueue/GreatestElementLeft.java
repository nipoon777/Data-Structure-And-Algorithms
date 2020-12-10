package StacksAndQueue;

import java.io.*;
import java.util.*;

public class GreatestElementLeft{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] span = solve(a);
    display(span);
 }

 public static int[] solve(int[] arr){
     int[] gel = new int[arr.length];
     Stack<Integer> st = new Stack<>();
     
     gel[0] = arr[0];
     st.push(0);
     
     for(int i = 1 ; i < gel.length ; i++){
         while(!st.isEmpty() && arr[i] > arr[st.peek()]){
             st.pop();
         }
         if(st.isEmpty()){
             gel[i] = -1;
         }else{
             gel[i] = arr[st.peek()]; 
         }
         st.push(i);
     }
     return gel;
 }

}