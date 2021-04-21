
package Level2.LinkedList;
import java.util.*;

class FoldAList {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode middle(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while ( fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public static ListNode reverse(ListNode head){
        if (head == null || head.next == null) return head;
        
        ListNode curr = head;
        ListNode fwd = null;
        ListNode prev = null;
        
        while( curr != null ){
            fwd = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = fwd;
            
        }
        
        return prev;
    }
    
    

    public static void fold(ListNode head) {
        if(head == null || head.next == null ) return;
        
        ListNode midNode = middle(head);
        ListNode newHead = midNode.next;
        
        midNode.next = null;
        
        newHead = reverse(newHead);
        
        ListNode c1 = head;
        ListNode f1 = null;
        
        ListNode c2 = newHead;
        ListNode f2 = null;
        
        
        while( c2 != null ){
            f1 = c1.next;
            f2 = c2.next;
            
            c1.next = c2;
            c2.next = f1;
            
            c1 = f1;
            c2 = f2;
        }

    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        fold(head);
        printList(head);
        scn.close();
    }
}