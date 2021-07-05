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
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if( l1 == null || l2 == null ){
            return l1!= null ? l1 : l2;
        }
        
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;
        while(carry != 0 || temp1 != null || temp2 != null ){
            int val1 = temp1 != null ? temp1.val : 0;
            int val2 = temp2 != null ? temp2.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode newNode = new ListNode(sum );
            
            temp.next = newNode;
            temp = temp.next;
            temp1 = temp1 == null ? temp1 : temp1.next;
            temp2 = temp2 == null ? temp2 : temp2.next;
        }
        ListNode res = dummy;
        res = res.next;
        dummy.next = null;
        
        l1 = reverse(l1);
        l2 = reverse(l2);
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

        ListNode ans = addTwoNumbers(head1, head2);
        printList(ans);
    }

}