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
    TreeNode prev=null;
    TreeNode first=null;
    TreeNode middle=null;
    TreeNode last=null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        if(last==null) last=middle;
        int temp=first.val;
        first.val=last.val;
        last.val=temp;
    }
    void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev!=null && prev.val>root.val){
            if(first==null){
                first=prev;
                middle=root;
            }
            else last=root;
        }
        prev=root;
        inorder(root.right);
    }
}