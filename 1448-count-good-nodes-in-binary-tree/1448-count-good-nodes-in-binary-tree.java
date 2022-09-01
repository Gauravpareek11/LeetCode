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
    public int goodNodes(TreeNode root) {
        int[] c=new int[1];
        solve(root,(int)-1e5,c);
        return c[0];
    }
    void solve(TreeNode root,int max,int[] c){
        if(root==null) return;
        if(root.val>=max) c[0]++;
        solve(root.left,Math.max(max,root.val),c);
        solve(root.right,Math.max(max,root.val),c);
    }
}