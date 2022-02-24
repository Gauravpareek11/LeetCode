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
    public ListNode sortList(ListNode head) {
        if(head==null){
            return null;
        }
        return mergesort(head);
    }
    ListNode mergesort(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode mid=middle(head);
        ListNode nextofmid=mid.next;
        mid.next=null;
       ListNode a = mergesort(head);
        ListNode b=mergesort(nextofmid);
        return merge(a,b);
    }
    ListNode merge(ListNode a,ListNode b){
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        ListNode t=null;
        if(a.val<=b.val){
            if(t==null){
                t=a;
            }
            t.next=merge(a.next,b);
        }
        else{
            if(t==null){
                t=b;
            }
            t.next=merge(a,b.next);
        }
        return t;
    }
    ListNode middle(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}