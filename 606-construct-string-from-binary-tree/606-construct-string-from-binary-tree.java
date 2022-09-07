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
    public String tree2str(TreeNode root) {
        StringBuilder sb=new StringBuilder("");
        solve(root,sb);
        return sb.toString();
    }
    void solve(TreeNode root,StringBuilder sb){
        if(root==null) return;
        sb.append(Integer.toString(root.val));
        if(root.left==null && root.right==null) return;
        sb.append("(");
        solve(root.left,sb);
        sb.append(")");
        if(root.right!=null){
            sb.append("(");
            solve(root.right,sb);
            sb.append(")");
        }
    }
}