package GenericTree;

import java.util.*;
import java.io.*;


public class IteratorAndIterable {
    
    public static class GenericTree implements Iterable<Integer>{
        Node root;
        
        GenericTree (Node root){
            this.root = root;
        }
        public Iterator<Integer> iterator(){
            Iterator<Integer> obj = new GTPreOrderIterator(root);
            return obj;
        }
    }
    
    public static class GTPreOrderIterator implements Iterator<Integer>{
        
        Integer nval;
        
        Stack <Pair> st;
        public GTPreOrderIterator(Node root){
            st = new Stack<>();
            st.push(new Pair(root, -1));
            next();
        }
        
        
        public boolean hasNext(){
            if(nval == null){
                return false;
            }
            else{
                return true;
            }
            
        }
        
        public Integer next(){
            Integer curr = nval;
            nval = null;
            //Moves nval to next position,if not possible than it sets it to null value;
            while(!st.isEmpty()){
                Pair top = st.peek();
                if(top.state == -1){
                    nval = top.node.data;
                    top.state++;
                    break;
                }else if(top.state == top.node.children.size()){
                    st.pop();
                }else{
                    Pair cp = new Pair(top.node.children.get(top.state),-1);
                    st.push(cp);
                    top.state++;
                }
            }
            
            return curr;
        }
    }
    
    public static class Pair{
        Node node;
        int state;
        public Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    
    public static class Node{
        int data;
        ArrayList < Node > children = new ArrayList<>();
    }
    
    public static void display(Node node){
        StringBuilder sb = new StringBuilder();
        sb.append(node.data + "->");
        
        for(Node child : node.children){
            sb.append(child.data +",");
        }
        System.out.println(sb.toString() + ".");
        
        for(Node child : node.children){
            display(child);
        }
        
    }
    
    public static Node construct(int[] arr){
        Stack < Node > st = new Stack<>();
        Node root = null;
        
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == -1){
                st.pop();
            }
            else{
                Node temp = new Node();
                temp.data = arr[i];
                if(st.isEmpty()){
                    root = temp;
                }else{
                    st.peek().children.add(temp);
                }
                st.push(temp);
            } 
                
        }
        return root;
    }
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        
        String[] values = br.readLine().split(" ");
        
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = Integer.parseInt(values[i]);
        }
        
        Node root = construct(arr);
        //display(root);
        GenericTree gt = new GenericTree(root);
        //Syntactic sugar to make the process simplea and easier to understand
        for(int gti : gt){
            System.out.println(gti);
        }
        
        // Iterator gti = gt.iterator();
        
        // while(gti.hasNext()){
        //     System.out.println(gti.next());
        // }
        

    }
}
