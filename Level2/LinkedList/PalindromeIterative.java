package Level2.LinkedList;

import java.util.*;

class PalindromeIterative {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode middle(ListNode head){
        if(head == null || head.next == null ) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null ) return head;
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode fwd = null;
        
        while ( curr != null ){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        
        return prev;
    }

    public static boolean isPalindrome(ListNode head) {
        
        if( head == null || head.next == null ) return true;
        
        ListNode midNode = middle(head);
        
        ListNode newHead = midNode.next;
        
        newHead = reverse(newHead);
        
        boolean res = true;
        
        ListNode ptr1 = head;
        
        ListNode ptr2 = newHead;
        
        
        
        while( ptr2 != null ){
            if(ptr1.val != ptr2.val){
                res = false;
                break;
            }else{
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
        }
        
        
        newHead = reverse(newHead);
        midNode.next = newHead;
        
        return res;
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
        scn.close();
        System.out.println(isPalindrome(dummy.next));
    }
}
