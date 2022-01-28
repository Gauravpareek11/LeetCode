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
    int sum=0;
    public int deepestLeavesSum(TreeNode root) {
        sum=0;
        solve(root,height(root));
        return sum;
    }
    int height(TreeNode root){
        if(root==null) return 0;
        int l=height(root.left);
        int r=height(root.right);
        return Math.max(l,r)+1;
    }
    void solve(TreeNode root,int level){
        if(root==null) return;
        if(level==1){
            sum+=root.val;
            return;
        }
        solve(root.left,level-1);
        solve(root.right,level-1);
    }
}