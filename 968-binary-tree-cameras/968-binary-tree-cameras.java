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
    int ans=0;
    public int minCameraCover(TreeNode root) {
        if(cover(root)==2) ans++;
        return ans;
        // HashSet<TreeNdoe>s1=new Hashset<>();
    }
    int cover(TreeNode root){
        if(root==null) return 0;
        
        int l=cover(root.left);
        int r=cover(root.right);
        
        if(l==2||r==2){
            ans++;
            return 1;
        }
        
        if(l==1||r==1) return 0;
        return 2;
    }
}