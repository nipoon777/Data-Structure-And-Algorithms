package GenericTree;
import java.util.*;
import java.io.*;

public class Multisolver {
    
    public static class Node{
        int data;
        ArrayList <Node> children = new ArrayList<>();
    }
    
    public static Node construct(int[] arr){
        Node root = null;
        
        Stack <Node> st = new Stack<>();
        
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == -1){
                st.pop();
            }else{
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
    
    public static void display(Node node){
        String str = node.data + "->";
        
        for(Node child : node.children){
            str += child.data + ",";
        }
        str += ".";
        System.out.println(str);
        for(Node child : node.children){
            display(child);
        }
    }
    static int size;
    static int max;
    static int min;
    static int height;
    
    public static void multisolver(Node node, int depth){
        size++;
        max = Math.max(max, node.data);
        min = Math.min(min, node.data);
        height = Math.max(height, depth);
        
        for(Node child : node.children){
            multisolver(child, depth + 1);
        }
    }
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        
        for(int i = 0 ; i < values.length ; i++){
            arr[i] = Integer.parseInt(values[i]);
        }
        
        
        
        Node root = construct(arr);
        
        size = 0;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        height = 0;
        
        multisolver(root, 0);
        //display(root);
        System.out.println("Size =" + size);
        System.out.println("MAX =" + max);
        System.out.println("MIN =" + min);
        System.out.println("Height =" + height);

    }
}