/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer>l1=new ArrayList<Integer>();
        solve(root,l1);
        TreeNode head=null;
        TreeNode ptr=head;
        // System.out.println(l1);
        for(int i:l1){
            if(head==null){
                head=new TreeNode(i);
                ptr=head;
            }
            else{
                ptr.right=new TreeNode(i);
                ptr=ptr.right;
            }
        }
        return head;
    }
    void solve(TreeNode root,ArrayList<Integer>l1){
        if(root==null) return;
        solve(root.left,l1);
        l1.add(root.val);
        solve(root.right,l1);
    }
}