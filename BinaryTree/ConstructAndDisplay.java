package BinaryTree;

import java.util.*;

public class ConstructAndDisplay {
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
    
    public static void display(Node node){
        if(node == null){
            return;
        }
        String str = "";
        str += node.left == null ? ".": node.left.data + "";
        str += "<- " + node.data + " ->";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);
        
        display(node.left);
        display(node.right);
        
    }
    public static void main(String[] args) {
        Integer[] arr = {10, 20, 40, null, null, 50, null, 60,null, null, 30, 70, null, null, 80, 90,null, null, null};
        
        Stack < Pair > st = new Stack<>();
        
        Node root = new Node(arr[0], null, null);
        
        Pair rtp = new Pair(root, 1);
        st.push(rtp);
        int idx = 0;
        while(!st.isEmpty()){
            Pair top = st.peek();
            
            if(top.state == 1){
                idx++;
                if(arr[idx] != null){
                    Node ln = new Node(arr[idx], null, null);
                    top.node.left = ln;
                    Pair lp = new Pair(ln,1);
                    st.push(lp);
                }else{
                    top.node.left = null;
                }
                top.state++;
                
            }else if(top.state == 2){
                idx++;
                if(arr[idx] != null){
                    Node rn = new Node(arr[idx], null, null);
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
        display(root);

    }
}
