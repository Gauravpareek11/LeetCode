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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode>q1=new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty()){
            int size=q1.size();
            List<Integer>temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode a=q1.poll();
                temp.add(a.val);
                if(a.left!=null) q1.add(a.left);
                if(a.right!=null) q1.add(a.right);
            }
            ans.add(temp);
        }
        return ans;
    }
}