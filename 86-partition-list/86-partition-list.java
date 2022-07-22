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
    public ListNode partition(ListNode head, int x) {
        List<Integer>l1=new ArrayList<Integer>();
        List<Integer>l2=new ArrayList<Integer>();
        ListNode ptr=head;
        ListNode newHead =null;
        ListNode temp=null;
        while(ptr!=null){
            if(ptr.val<x){
                l1.add(ptr.val);
            }
            else{
                l2.add(ptr.val);
            }
            ptr=ptr.next;
        }
        for(int i=0;i<l1.size();i++){
            if(newHead==null){
                temp=new ListNode(l1.get(i));
                newHead=temp;
            }
            else{
                temp.next=new ListNode(l1.get(i));
                temp=temp.next;
            }
        }
        for(int i=0;i<l2.size();i++){
            if(newHead==null){
                temp=new ListNode(l2.get(i));
                newHead=temp;
            }
            else{
                temp.next=new ListNode(l2.get(i));
                temp=temp.next;
            }
        }
        return newHead;
    }
}