package BinaryTree;

import java.util.*;
import java.io.*;

public class Revision {
    
    public static class Node{
        int data;
        Node left;
        Node right;
        
        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    
    public static class Pair{
        Node node;
        int state;
        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    
    public static Node construct(Integer[] arr){
        Node root = new Node(arr[0], null, null);
        
        Stack < Pair > st = new Stack <>();
        Pair rtp = new Pair(root, 1);
        st.push(rtp);
        int idx = 0;
        while( !st.isEmpty() ){
            Pair top = st.peek();
            
            
            if(top.state == 1){
                idx++;
                if(arr[idx] != null){
                    
                    Node ln = new Node(arr[idx], null , null);
                    top.node.left = ln;
                    Pair lp = new Pair(ln, 1);
                    st.push(lp);
                    
                }else{
                    top.node.left = null;
                }
                top.state++;
                
                
            }else if( top.state == 2){
                idx++;
                if(arr[idx] != null){
                    
                    Node rn = new Node(arr[idx], null , null);
                    top.node.right = rn;
                    Pair rp = new Pair(rn, 1);
                    st.push(rp);
                    
                }else{
                    top.node.right = null;
                }
                top.state++;
                
            }else{
                st.pop();
            }
        }
        return root;
    }
    
    public static void display(Node node){
        if(node == null){
            return;
        }
        String str = "";
        
        str += node.left != null ? node.left.data + "" : ".";
        
        str += " <- " + node.data + " -> ";
        
        str += node.right != null ? node.right.data + "" : ".";
        
        System.out.println(str);
        display(node.left);
        display(node.right);
        
    }
    
    public static int sum (Node node){
        if(node == null){
            return 0;
        }
        
        int ls = sum(node.left);
        int rs = sum(node.right);
        
        int ts = ls + rs + node.data;
        
        return ts;
        
    }
    
    public static int size (Node node){
        if( node == null ){
            return 0;
        }
        
        int lz = size(node.left);
        int rz = size(node.right);
        
        int tz = lz + rz + 1;
        
        return tz;
    }
    
    public static int maximum (Node node){
        
        if(node == null){
            return Integer.MIN_VALUE;
        }
        
        int lmax = maximum( node.left );
        int rmax = maximum( node.right );
        
        int max = Math.max(node.data, Math.max(lmax, rmax));
        return max;
        
    }
    
    public static int height (Node node){
        if(node == null){
            return -1;
        }
        
        int lh = height ( node.left );
        int rh = height ( node.right );
        
        int ht = Math.max( lh, rh ) + 1;
        
        return ht;
    }
    
    public static void iterativeTraversal(Node node){
        StringBuilder pre = new StringBuilder();
        StringBuilder in = new StringBuilder();
        StringBuilder post = new StringBuilder();
        
        Pair rtp = new Pair(node, 1);
        
        Stack < Pair > st = new Stack <>();
        st.push(rtp);
        
        while( !st.isEmpty() ){
            Pair top = st.peek();
            
            if(top.state == 1){
                pre.append(top.node.data + " ");
                top.state++;

                if(top.node.left != null){
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                }
                
            }else if (top.state == 2){
                in.append(top.node.data + " ");
                top.state++;
                
                if(top.node.right != null){
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                }
            }else{
                post.append(top.node.data +  " ");
                st.pop();
            }
        }
        
        System.out.println("PreOrder ->" + pre.toString() );
        System.out.println("InOrder ->" + in.toString() );
        System.out.println("PostOrder ->" + post.toString() );
    }
    
    public static void levelOrderTraversal(Node node){
        Queue < Node > mq = new ArrayDeque<>();
        mq.add(node);
        System.out.println("Level Order -> ");
        while( !mq.isEmpty() ){
            int count = mq.size();
            
            for(int i = 0 ; i < count ; i++){
                node = mq.remove();
                System.out.print(node.data + " ");
                if(node.left != null){
                    mq.add(node.left);
                }
                if(node.right != null){
                    mq.add(node.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Integer[] arr = new Integer[n];
        
        String[] values = br.readLine().split(" ");
        
        for(int i = 0 ; i < arr.length ; i++){
            if(values[i].equals("n")){
                arr[i] = null;
            }else{
                arr[i] = Integer.parseInt(values[i]);
            }
        }
        
        Node root = construct(arr);
        // display(root);
        // System.out.println( "Sum is " + sum(root) );
        // System.out.println( "Size is " + size(root) );
        // System.out.println( "Maximum is " + maximum(root) );
        // System.out.println( "Height is " + height(root) );
        
        //iterativeTraversal(root) ;
        levelOrderTraversal(root);

    }
}