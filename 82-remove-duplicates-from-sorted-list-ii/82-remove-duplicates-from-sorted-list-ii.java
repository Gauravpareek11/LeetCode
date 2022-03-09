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
    public ListNode deleteDuplicates(ListNode head) {
       ListNode ptr=head;
        TreeMap<Integer,Integer>m1=new TreeMap<Integer,Integer>();
        while(ptr!=null){
            if(m1.containsKey(ptr.val)){
                m1.put(ptr.val,m1.get(ptr.val)+1);
            }
            else{
                m1.put(ptr.val,1);
            }
            ptr=ptr.next;
        }
        ListNode newHead=null;
        ListNode temp=null;
        for(Map.Entry<Integer,Integer>in:m1.entrySet()){
            if(in.getValue()<2){
                if(newHead==null){
                    temp=new ListNode(in.getKey());
                    newHead=temp;
                }
                else{
                    temp.next=new ListNode(in.getKey());
                    temp=temp.next;
                }
            }
        }
        return newHead;
    }
}