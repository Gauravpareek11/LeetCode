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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ptr1=l1;
        ListNode ptr2=l2;
        ListNode head=null;
        ListNode curr=null;
        while(ptr1!=null && ptr2!=null){
            if(ptr1.val<ptr2.val){
                if(head==null){
                    head=ptr1;
                    curr=head;
                }
                else{
                    curr.next=ptr1;
                    curr=curr.next;
                }
                ptr1=ptr1.next;
            }
            else{
                if(head==null){
                    head=ptr2;
                    curr=ptr2;
                }
                else{
                    curr.next=ptr2;
                    curr=curr.next;
                }
                ptr2=ptr2.next;
            }
        }
        while(ptr1!=null){
            if(head==null){
                head=ptr1;
                curr=head;
            }
            else{
             curr.next=ptr1;
            curr=curr.next;   
            }
            ptr1=ptr1.next;
        }
        while(ptr2!=null){
            if(head==null){
                head=ptr2;
                curr=head;
            }
            else{
            curr.next=ptr2;
            curr=curr.next;   
            }
            ptr2=ptr2.next;
        }
        return head;
    }
}