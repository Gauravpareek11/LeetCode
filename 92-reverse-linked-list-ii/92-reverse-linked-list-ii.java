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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode start=head;
        ListNode end=head;
        ListNode prev=null;
        for(int i=0;i<left-1;i++){
            prev=start;
            start=start.next;
        }
        for(int i=0;i<right-1;i++){
            end=end.next;
        }
        if(prev==null) return reverse(head,start,end,prev);
        prev.next=reverse(head,start,end,prev);
        return head;
    }
   ListNode reverse(ListNode head,ListNode start,ListNode end,ListNode prev){
        if(head==null) return null;
        ListNode ptr=start;
        ListNode prev1=prev;
        ListNode next=null;
        while(ptr!=end){
            next=ptr.next;
            ptr.next=prev1;
            prev1=ptr;
            ptr=next;
        }
        next=ptr.next;
        ptr.next=prev1;
        prev1=ptr;
        start.next=next;
        return prev1;
    }
}