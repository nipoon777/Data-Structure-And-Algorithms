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
        if( head == null || head.next ==  null ) return head;
        
        ListNode curr = head;
        
        while( curr.next != null ){
            curr = curr.next;
        }
        return curr;
    }
    public static ListNode getCyclicNode( ListNode head ){
        if( head == null || head.next == null ) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while( fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
            if( fast == slow ){
                break;
            }
        }
        if( fast != slow ){
            return null;
        }
        fast = head;
        while( fast != slow ){
            fast = fast.next;
            slow = slow.next;
        }
        
        return slow;
    }
    public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
        if( headA == null || headB == null ){
            return null;
        }
        
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
        
        ListNode tail = getTail(headA);
        
        tail.next = headB;
        
        ListNode itrPoint = getCyclicNode( headA );
        
        tail.next= null;
        
        return itrPoint;
        
    }

    // Input_code===================================================

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

        int idx = scn.nextInt();

        ListNode head2 = makeList(scn.nextInt());

        if (idx >= 0) {
            ListNode curr = head1;
            while (idx-- > 0)
                curr = curr.next;

            ListNode prev = head2;
            while (prev.next != null)
                prev = prev.next;

            prev.next = curr;
        }

        ListNode ans = IntersectionNodeInTwoLL(head1, head2);
        System.out.println(ans != null ? ans.val : -1);
    }
}