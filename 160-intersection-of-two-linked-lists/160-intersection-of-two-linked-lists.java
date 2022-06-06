/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptr=headA;
        ListNode ptr1=headB;
        int sizeA=0;
        int sizeB=0;
        while(ptr!=null){
            sizeA++;
            ptr=ptr.next;
        }
        while(ptr1!=null){
            sizeB++;
            ptr1=ptr1.next;
        }
        if(sizeA>sizeB){
            int s=sizeA-sizeB;
            ptr=headA;
            while(s!=0){
                ptr=ptr.next;
                s--;
            }
            ptr1=headB;
        }
        else{
            int s=sizeB-sizeA;
            ptr1=headB;
            while(s!=0){
                ptr1=ptr1.next;
                s--;
            }
            ptr=headA;
        }
        while(ptr!=ptr1){
            ptr=ptr.next;
            ptr1=ptr1.next;
        }
        return ptr;
    }
}