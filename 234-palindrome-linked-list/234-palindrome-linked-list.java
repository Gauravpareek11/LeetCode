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
    public boolean isPalindrome(ListNode head) {
        int len=0;
        ListNode ptr=head;
        while(ptr!=null){
            ptr=ptr.next;
            len++;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=reverse(slow.next);
        ListNode temp=slow.next;
        ptr=head;
        while(temp!=null){
            if(temp.val!=ptr.val) return false;
            temp=temp.next;
            ptr=ptr.next;
        }
        return true;
    }
    ListNode reverse(ListNode ptr){
        ListNode prev=null;
        ListNode next=null;
        while(ptr!=null){
            next=ptr.next;
            ptr.next=prev;
            prev=ptr;
            ptr=next;
        }
        return prev;
    }
}