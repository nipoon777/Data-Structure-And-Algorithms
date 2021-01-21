package Heap;

import java.util.*;

public class Basics {

    public static void main(String[] args) {
        PriorityQueue <Integer> pq = new PriorityQueue <>(Collections.reverseOrder());
        
        int[] ranks = {10,88,124,56,78,45,99,101,54,9,54};
        
        for(int val : ranks){
            pq.add(val);
        }
        
        while( !pq.isEmpty() ){
            System.out.println(pq.peek() );
            pq.remove();
        }

    }
}
