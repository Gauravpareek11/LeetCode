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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null;
        ListNode ptr=null;
        ListNode ptr1=l1;
        ListNode ptr2=l2;
        int sum=0;
        int rem=0;
        while(ptr1!=null && ptr2!=null){
            sum=(ptr1.val+ptr2.val+rem)%10;
            rem=(ptr1.val+ptr2.val+rem)/10;
            if(head==null){
                head=new ListNode(sum);
                ptr=head;
            }
            else{
                ptr.next=new ListNode(sum);
                ptr=ptr.next;
            }
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        while(ptr1!=null){
            sum=(ptr1.val+rem)%10;
            rem=(ptr1.val+rem)/10;
            ptr.next=new ListNode(sum);
            ptr=ptr.next;
            ptr1=ptr1.next;
        }
        while(ptr2!=null){
            sum=(ptr2.val+rem)%10;
            rem=(ptr2.val+rem)/10;
            ptr.next=new ListNode(sum);
            ptr=ptr.next;
            ptr2=ptr2.next;
        }
        if(rem!=0){
            ptr.next=new ListNode(rem);
        }
        return head;
    }
}