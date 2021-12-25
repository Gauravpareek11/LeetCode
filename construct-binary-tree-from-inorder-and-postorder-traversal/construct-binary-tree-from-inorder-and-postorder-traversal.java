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
    static int postindex=0;
    static HashMap<Integer,Integer>m1=new HashMap<Integer,Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postindex=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            m1.put(inorder[i],i);
        }
        return solve(inorder,postorder,0,inorder.length-1);
    }
    TreeNode solve(int[] inorder,int[] postorder,int start,int end){
        if(start>end) return null;
        if(start==end){
            TreeNode t=new TreeNode(postorder[postindex--]);
            return t;
        }
        int index=m1.get(postorder[postindex]);
        TreeNode t=new TreeNode(postorder[postindex--]);
        t.right=solve(inorder,postorder,index+1,end);
        t.left=solve(inorder,postorder,start,index-1);
        return t;
    }
}