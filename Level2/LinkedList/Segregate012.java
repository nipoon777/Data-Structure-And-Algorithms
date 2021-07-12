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

    public static ListNode segregate012(ListNode head) {
        if( head == null || head.next == null ) return head;
        ListNode dummy0 = new ListNode(-1);
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        
        ListNode curr = head, prev0 = dummy0, prev1 = dummy1, prev2 = dummy2;
        
        while( curr != null ){
            if( curr.val == 0 ){
                prev0.next = curr;
                prev0 = prev0.next;
                
            }else if( curr.val == 1){
                prev1.next = curr;
                prev1 = prev1.next;
            }else{
                prev2.next = curr;
                prev2 = prev2.next;
            }
            curr = curr.next;
        }
        //Jab sare 2's ho tabhi prev0 null ko point karega 
        prev0.next = prev1 == dummy1 ? dummy2.next : dummy1.next;
        prev1.next = dummy2.next;
        prev2.next = null;
        
        return dummy0.next;
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
        h1 = segregate012(h1);
        printList(h1);
    }
}