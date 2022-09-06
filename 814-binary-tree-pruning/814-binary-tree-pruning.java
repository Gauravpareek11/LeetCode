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
    public TreeNode pruneTree(TreeNode root) {
        if(root==null) return null;
        solve(root);
        if(root.left==null && root.right==null && root.val==0) return null;
        return root;
    }
    int solve(TreeNode root){
        if(root==null) return 0;
        
        int l=0;
        int r=0;
        if(root.left!=null && root.left.val==1) l=1+solve(root.left);
        else l=solve(root.left);
        
        if(root.right!=null && root.right.val==1) r=1+solve(root.right);
        else r=solve(root.right);
        
        if(l==0) root.left=null;
        if(r==0) root.right=null;
        return Math.max(l,r);
    }
}