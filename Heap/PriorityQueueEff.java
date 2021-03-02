package Heap;
import java.util.*;


public class PriorityQueueEff {
    public static class PriorityQueue {
        ArrayList < Integer > data;

        public PriorityQueue(int[] arr) {
            data = new ArrayList < > ();
            for(int val : arr){
                data.add(val);
            }
            for(int i = data.size() / 2 - 1 ; i >= 0; i--){
                downheapify(i);
            }
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

    public static void main(String[] args){
        int[] arr = { 5, 9, 19, 25, 56, 85, 17, 24, 85, 1, 2, 30};

        PriorityQueue pq = new PriorityQueue(arr);

        while( pq.size() > 0){
            System.out.print( pq.remove() + " ");
        }
        System.out.println();

    }
    
}
