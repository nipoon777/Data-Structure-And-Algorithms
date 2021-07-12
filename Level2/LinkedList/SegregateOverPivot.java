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
  public static ListNode getPivot(ListNode head, int idx){
      ListNode curr = head;
      while( idx > 1 ){
          curr = curr.next;
          idx--;
      }
      return curr;
      
  }
  public static ListNode segregate(ListNode head, int pivotIdx) {
    if( head == null || head.next == null )return head;
    
    ListNode pivot = getPivot(head,pivotIdx);
    
    ListNode dummyPivot = new ListNode(-1);
    ListNode dummySmaller = new ListNode(-1);
    ListNode dummyLarger = new ListNode(-1);
    
    ListNode prevS = dummySmaller, prevL = dummyLarger, prevP = dummyPivot, curr = head;
    
    while( curr != null ){
        if( curr.val > pivot.val ){
            prevL.next = curr;
            prevL = prevL.next;
        }else if( curr.val < pivot.val){
            prevS.next = curr;
            prevS = prevS.next;
        }else{
            prevP.next = curr;
            prevP = prevP.next;
        }
        curr = curr.next;
    }
    prevL.next = null;
    prevS.next = dummyPivot.next;
    prevP.next = dummyLarger.next;
    
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