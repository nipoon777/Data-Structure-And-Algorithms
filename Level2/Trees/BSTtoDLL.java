import java.util.*;

public class Main {
  public static Scanner scn = new Scanner(System.in);

  public static class Node {
    int val = 0;
    Node left = null;
    Node right = null;

    Node(int val) {
      this.val = val;
    }
  }

  public static Node bToDLL(Node root) {
      
      Stack <Node> st = new Stack<>();
      Node dummy = new Node(-1);
      Node prev = dummy;
    
      getAllLeftNodes(root, st);
      
      while( st.size() > 0 ){
          Node curr = st.pop();
          
          prev.right = curr;
          curr.left = prev;
          prev = curr;
          
          getAllLeftNodes(curr.right, st);
      }
      Node head = dummy.right;
      dummy.right = null;
      head.left = null;
      
      prev.right = head;
      head.left = prev;
      
      
      
    return head;
  }
  
  public static void getAllLeftNodes(Node curr, Stack<Node> st){
        while( curr != null ){
            st.push(curr);
            curr = curr.left;
        }  
  }
  
  

  // input_section=================================================

  public static void display(Node node) {
    Node head = node;
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.right;
      if (node == head)
        break;
    }

  }

  public static Node constructFromInOrder_(int[] in, int si, int ei) {
    if (si > ei)
      return null;

    int mid = (si + ei) / 2;
    Node node = new Node(in[mid]);

    node.left = constructFromInOrder_(in, si, mid - 1);
    node.right = constructFromInOrder_(in, mid + 1, ei);

    return node;
  }

  public static Node constructFromInOrder(int[] inOrder) {
    int n = inOrder.length;
    return constructFromInOrder_(inOrder, 0, n - 1);
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] in = new int[n];
    for (int i = 0; i < n; i++)
      in[i] = scn.nextInt();

    Node root = constructFromInOrder(in);
    root = bToDLL(root);
    display(root);
  }

  public static void main(String[] args) {
    solve();
  }
}