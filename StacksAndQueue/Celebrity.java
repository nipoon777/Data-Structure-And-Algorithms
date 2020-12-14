package StacksAndQueue;

import java.io.*;
import java.util.*;

public class Celebrity {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < arr.length ; i++){
            st.push(i);
        }
        
        while(st.size() >= 2){
            int i = st.pop();
            int j = st.pop();
            
            if(arr[i][j] == 1){
                //Iska matlab i j ko janta hai toh i is not a celebrity
                st.push(j);
            }
            else{   //Iska Matlab i j ko nahi janta hai toh vo potential celebrity hai
                st.push(i);
            }
        }
        
        int potential = st.pop();
        
        for(int i = 0 ; i < arr.length ; i++){
            if(i != potential){
                if(arr[potential][i] == 1 || arr[i][potential] == 0){
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(potential);
    }

}