package Heap;

import java.io.*;
import java.util.*;

public class PriorityQueueImpl {

    public static class PriorityQueue {
        ArrayList < Integer > data;

        public PriorityQueue() {
            data = new ArrayList < > ();
        }

        public void add(int val) {
            data.add(val);
            upheapify(data.size() - 1);
        }
        
        public void swap (int parentIndex, int childIndex){
            int pval = data.get(parentIndex);
            int cval = data.get(childIndex);
            data.set(parentIndex, cval);
            data.set(childIndex, pval);
        }
        
        private void upheapify (int childIndex){
            if( childIndex == 0 ){
                return;
            }
            int parentIndex = (childIndex - 1) / 2;
            if( data.get(parentIndex) > data.get(childIndex)){
                swap(parentIndex, childIndex);
                upheapify(parentIndex);
            }
        }
        
        public void downheapify(int parentIndex){
            int mini = parentIndex;
            int leftChild = 2 * parentIndex + 1;
            
            if( leftChild < data.size() && data.get(leftChild) < data.get(mini)){
                mini = leftChild;
            } 
            
            int rightChild = 2 * parentIndex + 2;
            
            if (rightChild < data.size() && data.get(rightChild) < data.get(mini)){
                mini = rightChild;
            }
            
            if( mini != parentIndex ){
                swap( parentIndex, mini);
                downheapify(mini);
            }
        }

        public int remove() {
            if( this.size() == 0){
                System.out.println("Underflow");
                return -1;
            }else{
                swap(0, data.size() - 1);
                int val = data.remove(data.size() - 1);
                downheapify(0);
                return val;
            }
        }

        public int peek() {
            if( this.size() == 0){
                System.out.println("Underflow");
                return -1;
            }else{
                return data.get(0);
            }
        }

        public int size() {
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}
