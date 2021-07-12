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
    public static ListNode getTail(ListNode head){
        if( head == null || head.next == null ) return head;
        
        ListNode curr = head;
        while( curr.next != null ){
            curr = curr.next;
        }
        return curr;
        
    }

    public static ListNode segregateOnLastIndex(ListNode head) {
        if( head == null || head.next == null ) return head;
        
        ListNode tail = getTail(head);
        
        ListNode pivot = tail;
        
        ListNode dummySmaller = new ListNode(-1);
        ListNode dummyLarger = new ListNode(-1);
        
        ListNode prevS = dummySmaller, prevL = dummyLarger;
        
        ListNode curr = head;
        while( curr != null ){
            if( curr.val <= pivot.val ){
                prevS.next = curr;
                prevS = prevS.next;
            }else{
                prevL.next = curr;
                prevL = prevL.next;
            }
            curr = curr.next;
        }
        prevL.next = null;
        prevS.next = dummyLarger.next;
        
        return pivot;
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
        h1 = segregateOnLastIndex(h1);
        printList(h1);
    }
}