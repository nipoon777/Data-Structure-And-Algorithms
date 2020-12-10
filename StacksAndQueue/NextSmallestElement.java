package StacksAndQueue;
import java.util.*;

public class NextSmallestElement {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scn.nextInt();
        }
        scn.close();
        getNextSmallest(arr);
    }
    public static void getNextSmallest(int[] arr){

        int[] nse = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        st.push(0);

        for(int i = 1 ; i < arr.length ; i++){
            while(st.isEmpty() && arr[i] < arr[st.peek()]){
                int pos = st.peek();
                nse[pos] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        while(st.isEmpty()){
            nse[st.peek()] = -1;
            st.pop();
        }

        for(int i : nse){
            System.out.print(i + "\t");
        }
    }
    
}
