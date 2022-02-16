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
    public ListNode swapPairs(ListNode head) {
        ListNode ptr=head;
        ListNode prev=null;
        while(ptr!=null && ptr.next!=null){
            if(ptr==head){
                ListNode temp=ptr.next;
                ptr.next=temp.next;
                temp.next=ptr;
                head=temp;
                prev=ptr;
            }
            else{
                ListNode temp=ptr.next;
                ptr.next=temp.next;
                temp.next=ptr;
                prev.next=temp;
                prev=ptr;
            }
            ptr=ptr.next;
        }
        return head;
    }
}