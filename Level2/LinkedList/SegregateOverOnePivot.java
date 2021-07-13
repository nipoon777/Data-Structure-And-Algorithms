import java.util.*;

class Main {
  public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

  public static ListNode segregate(ListNode head, int pivotIdx) {
      if( head == null || head.next == null ) return head;
      
      ListNode dummySmaller = new ListNode(-1);
      ListNode dummyLarger = new ListNode(-1);
      
      ListNode pivot = null;
      ListNode curr = head, prevS = dummySmaller, prevL = dummyLarger;
      
      
     
      int i = 0;
      
      while( i < pivotIdx ){
          curr = curr.next;
          i++;
      }
      i = 0;
      int data = curr.val;
      
      curr = head;
      
      while( curr != null ){
          if( i == pivotIdx){
              pivot = curr;
          }else if( curr.val <= data){
              prevS.next = curr;
              prevS = prevS.next;
          }else{
              prevL.next = curr;
              prevL = prevL.next;
          }
          i++;
          curr = curr.next;
      }
      
      prevL.next = null;
      prevS.next = pivot;
      pivot.next = dummyLarger.next;
    return dummySmaller.next;
  }

  public static void printList(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
  }

  public static ListNode createList(int n) {
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    while (n-- > 0) {
      prev.next = new ListNode(scn.nextInt());
      prev = prev.next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    int n = scn.nextInt();
    ListNode h1 = createList(n);
    int idx = scn.nextInt();
    h1 = segregate(h1, idx);
    printList(h1);
  }
}