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

    public static ListNode removeDuplicates(ListNode head) {
        if( head == null || head.next == null ) return head;
        
        ListNode dummy = new ListNode(-1);
        ListNode itr = dummy;
        ListNode curr = head;
        itr.next = curr;//Potential unique element
        curr = curr.next;
        
        while( curr != null ){
            boolean isDuplicate = false;
            
            while( curr != null && itr.next.val == curr.val ){
                isDuplicate = true;
                curr = curr.next;
            }
            
            if( isDuplicate ){
                //Iska matlab next number potential non duplicate hai
                itr.next = curr;
            }else{
                // For sure non duplicate element hai
                itr = itr.next;
            }
            curr = curr== null ? curr : curr.next;
        }

        
        return dummy.next;
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
        ListNode head = makeList(scn.nextInt());

        ListNode ans = removeDuplicates(head);
        printList(ans);
    }

}
