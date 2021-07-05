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
    
    public static ListNode reverse(ListNode head){
        if( head == null || head.next == null ){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        
        while( curr != null ){
            ListNode nbr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nbr;
        }
        return prev;
    }
    public static ListNode subtractTwoNumbers(ListNode h1, ListNode h2) {
        if( h1 == null || h2 == null ){
            return h1 == null ? h2 : h1;
        }
        
        h1 = reverse(h1);
        h2 = reverse(h2);
        ListNode dummy = new ListNode(-1);
        
        ListNode p1 = h1, p2 = h2, p3 = dummy;
        int borrow = 0;
        while( p1 != null || p2 != null ){
            int val1 = (p1 == null) ? 0 : p1.val;
            int val2 = (p2 == null) ? 0 : p2.val;
            
            val1 = val1 - borrow;
            
            int diff = val1 - val2;
            
            if( diff < 0 ){
                diff += 10;
                borrow = 1;
            }else{
                borrow = 0;
            }
            ListNode node = new ListNode(diff);
            
            p3.next = node;
            p3 = p3.next;
            p1 = p1== null ? p1 : p1.next;
            p2 = p2 == null ? p2 : p2.next;
            
        }
        ListNode res = dummy.next;
        dummy.next = null;
        h1 = reverse(h1);
        h2 = reverse(h2);
        res = reverse(res);
        return res;
    }

    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = makeList(scn.nextInt());
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = subtractTwoNumbers(head1, head2);
        printList(ans);
    }

}