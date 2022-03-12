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
        if(head==null) return head;
        Node ptr=head;
        Node next=null;
        while(ptr!=null){
            next=ptr.next;
            ptr.next=new Node(ptr.val);
            ptr.next.next=next;
            ptr=next;
        }
        ptr=head;
        while(ptr!=null){
            if(ptr.random==null) ptr.next.random=null;
            else ptr.next.random=ptr.random.next;
            ptr=ptr.next.next;
        }
        Node newHead=head.next;
        ptr=newHead;
        while(head!=null){
            head.next=head.next.next;
            ptr.next=(ptr.next!=null)?ptr.next.next:ptr.next;
            ptr=ptr.next;
            head=head.next;
        }
        return newHead;
    }
}