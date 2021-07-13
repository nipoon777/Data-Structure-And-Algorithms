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
    
    
    public static int getSize(ListNode head){
        ListNode curr = head;
        int len = 0;
        while( curr != null ){
            curr = curr.next;
            len++;
        }
        return len;
    }
    public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
        if( headA == null || headB == null ){
            return null;
        }
        
        int size1 = getSize(headA);
        int size2 = getSize(headB);
        
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
        
        if( size1 > size2 ){
            int diff =  size1 - size2;
            
            while( diff > 0 ){
                ptr1 = ptr1.next;
                diff--;
            }
            
        }else{
            int diff = size2 - size1;
            
            while( diff > 0 ){
                ptr2 = ptr2.next;
                diff--;
            }
        }
        while( ptr1 != null && ptr2 != null ){
            if( ptr1 == ptr2 ){
                return ptr1;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return null;
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