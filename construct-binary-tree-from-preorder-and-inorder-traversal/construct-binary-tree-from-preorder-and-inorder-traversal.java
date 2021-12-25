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
    int pindex=0;
    HashMap<Integer,Integer>m1=new HashMap<Integer,Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            m1.put(inorder[i],i);
        }
        return solve(preorder,inorder,0,inorder.length-1);
    }
    TreeNode solve(int[] preorder,int[] inorder,int start,int end){
        if(start>end){
            return null;
        }
        if(start==end){
            int x=preorder[pindex++];
            TreeNode t=new TreeNode(x);
            return t;
        }
        int x=preorder[pindex++];
        TreeNode t=new TreeNode(x);
        int inIndex=m1.get(x);
        t.left=solve(preorder,inorder,start,inIndex-1);
        t.right=solve(preorder,inorder,inIndex+1,end);
        return t;
    }
}