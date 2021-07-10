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
    
    static ListNode th = null;
    static ListNode tt = null;
    
    public static void addFirst(ListNode node ){
        if( node == null ) return;
        
        if( th == null ){
            th = node;
            tt = node;
        }else{
            node.next = th;
            th = node;
        }
    }
    public static int length(ListNode head ){
        ListNode curr = head;
        int len = 0;
        
        while( curr != null ){
            curr = curr.next;
            len++;
        }
        return len;
    }
    public static ListNode reverseInKGroup(ListNode head, int k) {
        if( head == null || head.next == null || k == 0 ) return head;
        
        int len = length(head);
        ListNode oh = null;
        ListNode ot = null;
        
        ListNode curr = head;
        
        while( len >= k ){
            int tempk = k;
            
            while( tempk > 0 ){
                tempk--;
                ListNode fwd = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = fwd;
            }
            if( oh == null ){
                oh = th;
                ot = tt;
            }else{
                ot.next = th;
                ot = tt;
            }
            len -= k;
            th = null;
            tt = null;
        }
        
        
        ot.next = curr;
        
        
        return oh;
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

        int k = scn.nextInt();
        h1 = reverseInKGroup(h1, k);
        printList(h1);
    }
}