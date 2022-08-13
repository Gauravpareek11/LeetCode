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
    public int rob(TreeNode root) {
        HashMap<TreeNode,Integer>m1=new HashMap<>();
        return solve(root,m1);
    }
    int solve(TreeNode root,HashMap<TreeNode,Integer>m1){
        if(root==null) return 0;
        
        if(m1.containsKey(root)) return m1.get(root);
        int not_pick=solve(root.left,m1)+solve(root.right,m1);
        int pick=root.val;
        if(root.left!=null) pick+=solve(root.left.left,m1)+solve(root.left.right,m1);
        if(root.right!=null)pick+=solve(root.right.left,m1)+solve(root.right.right,m1);
        m1.put(root,Math.max(pick,not_pick));
        return Math.max(pick,not_pick);
    }
}