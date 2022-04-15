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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // TreeNode temp=null;
        // if(root.val<low) {
        //     while(root!=null && root.val<low){
        //         root=root.right;
        //     }
        //     // if(root==null) return null;
        //     temp=(root!=null?root:null);
        //     solve(temp,low,high);
        //     return temp;
        // }
        // else if(root.val>high){
        //     while(root!=null && root.val>high){
        //         root=root.left;
        //     }
        //     // if(root==null) return null;
        //     temp=(root!=null?root:null);
        //     solve(temp,low,high);
        //     return temp;
        // }
        // solve(root,low,high);
        if (root == null) return root;
        if (root.val > high) return trimBST(root.left, low, high);
        if (root.val < low) return trimBST(root.right, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
    // void solve(TreeNode root,int low,int high){
    //     if(root==null) return;
    //     if(root.left!=null && root.left.val<=low){
    //         if(root.left.val==low){
    //             if(root.left.left!=null) root.left.left=null;
    //         }
    //         else if(root.left.right!=null && root.left.right.val>=low && root.left.right.val<=high){
    //             root.left=root.left.right;
    //         }
    //         else root.left=null;
    //     }
    //     if(root.right!=null && root.right.val>=high){
    //         if(root.right.val==high){
    //              if(root.right.right!=null) root.right.right=null;
    //         }
    //         else if( root.right.left!=null && root.right.left.val<=high && root.right.left.val>=low){
    //             root.right=root.right.left;
    //         }
    //         else root.right=null;
    //     }
    //     solve(root.left,low,high);
    //     solve(root.right,low,high);
    // }
}