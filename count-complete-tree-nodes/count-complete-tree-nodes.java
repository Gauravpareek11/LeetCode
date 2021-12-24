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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int l=Leftheight(root);
        int r=Rightheight(root);
        if(l==r) return((2<<(l))-1);
        
        else return 1+countNodes(root.left)+countNodes(root.right);
    }
    int Leftheight(TreeNode root){
        if(root==null) return 0;
        int cnt=0;
        while(root.left!=null){
            root=root.left;
            cnt++;
        }
        return cnt;
    }
    int Rightheight(TreeNode root){
        if(root==null) return 0;
        int cnt=0;
        while(root.right!=null){
            root=root.right;
            cnt++;
        }
        return cnt;
    }
}