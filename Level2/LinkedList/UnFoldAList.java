package Level2.LinkedList;

import java.util.*;

class UnFoldAList {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null ) return head;
        
        ListNode curr = head;
        ListNode prev = null;
        ListNode fwd = null;
        
        while( curr != null ){
            fwd = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = fwd;
        }
        
        return prev;
    }

    public static void unfold(ListNode head) {
        if(head == null || head.next == null ) return;
          
          
          
        ListNode c1 = head;
        ListNode f1 = null;
        
        ListNode c2 = head.next;
        ListNode f2 = null;
        
        ListNode revHead = c2;
        
        
        while( c2 != null && c2.next != null){
            f1 = c1.next.next;
            f2 = c2.next.next;
            
            c1.next = f1;
            c2.next = f2;
            
            c1 = f1;
            c2 = f2;
        }
        
        ListNode newHead = reverse(revHead);
        
        c1.next = newHead;

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
        unfold(head);
        printList(head);
        scn.close();
    }
}
