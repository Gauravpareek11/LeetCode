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
        ListNode ptr=reverse(head);
        if(n==1){
            ListNode curr=ptr.next;
            ptr=null;
            return reverse(curr);
        }
        ListNode ptr1=ptr;
        int c=0;
        ListNode prev=null;
        while(ptr1!=null){
            c++;
            if(c==n){
                prev.next=ptr1.next;
            }
            prev=ptr1;
            ptr1=ptr1.next;
        }
        return reverse(ptr);
    }
    ListNode reverse(ListNode ptr){
        ListNode next=null;
        ListNode prev=null;
        while(ptr!=null){
            next=ptr.next;
            ptr.next=prev;
            prev=ptr;
            ptr=next;
        }
        return prev;
    }
}