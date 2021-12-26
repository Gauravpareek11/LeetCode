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
    TreeNode node;
    public TreeNode bstFromPreorder(int[] preorder) {
        for(int i=0;i<preorder.length;i++){
            createNode(preorder[i]);
        }
        return node;
    }
    void createNode(int data){
        node=create(node,data);
    }
    TreeNode create(TreeNode node,int data){
        if(node==null){
            node=new TreeNode(data);
            return node;
        }
        if(node.val<data){
            node.right=create(node.right,data);
        }
        if(node.val>data) node.left=create(node.left,data);
        return node;
    }
}