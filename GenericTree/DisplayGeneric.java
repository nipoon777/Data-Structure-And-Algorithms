package GenericTree;
import java.util.*;



public class DisplayGeneric {
    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static void main(String[] args) {
        Node root = null;
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, -1, -1, 40, 90, -1, 100, -1, -1, -1};
        Stack<Node> st = new Stack<>();

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
        display(root);
    
    }
    //d(10) -> I need to print children of 10 and have faith that the children can print 
    // its own family i.e d(10) -> s(10), d(20),d(30), d(40).
    public static void display(Node root){
        String str = root.data + "-> ";
        for(Node child : root.children){
            str += child.data + ",";
        }
        str += ".";
        System.out.println(str);
        for(Node child : root.children){
            display(child);
        }
    }
}
    
    
    

