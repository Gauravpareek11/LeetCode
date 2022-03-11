/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;
        int len=0;
        ListNode ptr=head;
        while(ptr!=null){
            ptr=ptr.next;
            len++;
        }
        k=k%len;
        if(k==0) return head;
        ListNode prev=null;
        ptr=head;
        for(int i=0;i<len-k;i++){
            prev=ptr;
            ptr=ptr.next;
        }
        ListNode n=ptr;
        ptr=head;
        while(ptr.next!=null){
            ptr=ptr.next;
        }
        ptr.next=head;
        head=n;
        prev.next=null;
        return head;
    }
}