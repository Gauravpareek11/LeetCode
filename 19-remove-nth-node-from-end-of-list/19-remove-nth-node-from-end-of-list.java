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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int c=0;
        ListNode ptr=head;
        while(ptr!=null){
            c++;
            ptr=ptr.next;
        }
        int k=c-n;
        c=0;
        ListNode prev=null;
        ptr=head;
        while(c<k && ptr!=null){
            c++;
            prev=ptr;
            ptr=ptr.next;
        }
        if(prev==null){
            head=head.next;
            return head;
        }
        prev.next=ptr.next;
        return head;
    }
}