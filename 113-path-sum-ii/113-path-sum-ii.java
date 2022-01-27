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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>l1=new ArrayList<>();
        solve(root,targetSum,ans,l1);
        return ans;
    }
    void solve(TreeNode root,int targetSum,List<List<Integer>>ans,List<Integer>l1){
        if(root==null) return;
        if(root.left==null && root.right==null && targetSum==root.val){
            l1.add(root.val);
            ans.add(new ArrayList<>(l1));
            l1.remove(l1.size()-1);
            return;
        }
        l1.add(root.val);
        solve(root.left,targetSum-root.val,ans,l1);
        solve(root.right,targetSum-root.val,ans,l1);
        l1.remove(l1.size()-1);
    }
}