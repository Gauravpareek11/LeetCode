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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double>ans=new ArrayList<>();
        Queue<TreeNode>q1=new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty()){
            int n=q1.size();
            double sum=0;
            for(int i=0;i<n;i++){
                TreeNode p=q1.poll();
                sum+=p.val;
                if(p.left!=null) q1.add(p.left);
                if(p.right!=null) q1.add(p.right);
            }
            double x=((sum)/(double)n);
            ans.add(x);
        }
        return ans;
    }
}