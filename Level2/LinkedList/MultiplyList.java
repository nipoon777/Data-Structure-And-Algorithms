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
        if( head == null || head.next == null) return head;
        
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
    public static ListNode multiplyListWithDigit(ListNode l1, int value){
        ListNode dummy = new ListNode(-1);
        int carry = 0;
        ListNode curr = l1, ac = dummy;
        while( carry != 0 || curr != null ){
            int sum = carry + (( curr == null )? 0 : curr.val ) * value;
            
            carry = sum / 10;
            int digit = sum % 10;
            
            ListNode node = new ListNode(digit);
            ac.next = node;
            ac = ac.next;
            curr = (curr == null )? curr : curr.next;
        }
        
        return dummy.next;
        
    }
    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        
        ListNode dummy = new ListNode(-1);
        ListNode ansItr = dummy;
        ListNode l2_itr = l2;
        while( l2_itr != null ){
            ListNode prod = multiplyListWithDigit(l1, l2_itr.val);
            l2_itr = l2_itr.next;
            addTwoLinkedList(prod, ansItr);
            ansItr = ansItr.next;
            
        }
        return reverse(dummy.next);
    }
    public static void addTwoLinkedList( ListNode prod, ListNode ansItr ){
        ListNode c1 = prod;
        ListNode c2 = ansItr;
        
        int carry = 0;
        
        while( c1 != null || carry != 0 ){
            int sum = carry + ( c1 == null ? 0 : c1.val ) + ( c2.next == null ? 0 : c2.next.val);
            
            carry = sum / 10;
            int digit = sum % 10;
            
            if( c2.next == null ) c2.next = new ListNode(digit);
            else c2.next.val = digit;
            
            c1 = ( c1 == null )? c1 : c1.next;
            c2 = c2.next;
        }
        
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

        ListNode ans = multiplyTwoLL(head1, head2);
        printList(ans);
    }

}
