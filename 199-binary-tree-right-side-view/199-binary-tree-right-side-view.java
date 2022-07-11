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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>l1=new ArrayList<Integer>();
        int h=height(root);
        for(int i=0;i<h;i++){
            l1.add(null);
        }
        rightview(root,l1,0);
        return l1;
    }
    void rightview(TreeNode root,List<Integer>l1,int level){
        if(root==null) return;
        l1.set(level,root.val);
        rightview(root.left,l1,level+1);
        rightview(root.right,l1,level+1);
    }
    int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=height(root.left);
        int r=height(root.right);
        return Math.max(l,r)+1;
    }
}