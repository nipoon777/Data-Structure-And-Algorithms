package Level2.LinkedList;

import java.util.*;

class PalindromeLinkedList {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    static ListNode pointer;
    public static boolean isPalindromeHelper(ListNode node){
        if( node == null ){
            return true;
        }
        
        boolean rres = isPalindromeHelper(node.next);
        if(rres){
            if(node.val == pointer.val ){
                pointer = pointer.next;
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    public static boolean isPalindrome(ListNode head) {
        pointer = head;
        return isPalindromeHelper(head);
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

        System.out.println(isPalindrome(dummy.next));
        scn.close();
    }
}
