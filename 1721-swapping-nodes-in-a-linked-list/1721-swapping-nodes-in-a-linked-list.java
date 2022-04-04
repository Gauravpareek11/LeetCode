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
    public ListNode swapNodes(ListNode head, int k) {
        return swapNodes_bf_list(head,k);
    }
  public static ListNode swapNodes_bf_list(ListNode head, int k) {
        ListNode pNode = head;
        List<ListNode> nodeList = new ArrayList<>();
		// store these nodes.
        while (pNode != null) {
            nodeList.add(pNode);
            pNode = pNode.next;
        }

		// swap their values.
        int len = nodeList.size();
        int temp = nodeList.get(k - 1).val;
        nodeList.get(k - 1).val = nodeList.get(len - k).val;
        nodeList.get(len - k).val = temp;

        return head;
    }
}