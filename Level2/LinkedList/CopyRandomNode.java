/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if( head == null ) return head;
        
        
        Node curr = head;
        
        HashMap < Node, Node> hmap = new HashMap<>();
        Node dummy =  new Node(-1, null, null);
        Node prev = dummy;
        while( curr != null ){
            Node node = new Node(curr.val, null, null);
            hmap.put(curr, node);
            prev.next = node;
            prev = prev.next;
            curr = curr.next;
        }
        
        Node nHead = dummy.next;
        curr = head;
        while( curr != null ){
            nHead.random = hmap.get(curr.random);
            curr = curr.next;
            nHead = nHead.next;
        }
        return dummy.next;
    }
}