package StacksAndQueue;
import java.io.*;
import java.util.*;

public class MergeOver {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[n][2];
        
        for(int i = 0 ; i < arr.length ; i++){
            String line = br.readLine();
            arr[i][0] = Integer.parseInt(line.split(" ")[0]);
            arr[i][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Pair[] pairs = new Pair[arr.length];
        
        for(int i = 0 ; i < arr.length ; i++){
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        
        Arrays.sort(pairs);
        
        Stack<Pair> st = new Stack<>();
        
        st.push(pairs[0]);
        
        for(int i = 1 ; i < pairs.length ; i++){
            Pair top = st.peek();
            
            if(pairs[i].st > top.et){
                st.push(pairs[i]);
            }else{
                top.et = Math.max(pairs[i].et, top.et);
            }
        }
        Stack<Pair> res = new Stack<>();
        
        while(!st.isEmpty()){
            res.push(st.pop());
        }
        while(!res.isEmpty()){
            Pair result = res.pop();
            
            System.out.println(result.st + " " + result.et);
        }
        
    }
    
    public static class Pair implements Comparable<Pair> {
        int st;
        int et;
        
        Pair(int st, int et){
            this.st = st;
            this.et = et;
        }
        
        public int compareTo(Pair other){
            if(this.st != other.st){
                return this.st - other.st;
            }
            else{
                return this.et - other.et;
            }
        }
        
    }

}