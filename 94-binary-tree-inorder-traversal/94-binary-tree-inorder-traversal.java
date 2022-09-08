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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode>s1=new Stack<>();
        ArrayList<Integer>l1=new ArrayList<>();
        if(root==null) return l1;
        s1.add(root);
        while(!s1.isEmpty()){
            while(root.left!=null){
                s1.add(root.left);
                root=root.left;
            }
            while(s1.size()>=1 && s1.peek().right==null){
                l1.add(s1.peek().val);
                s1.pop();
            }
            if(s1.size()>=1){
                l1.add(s1.peek().val);
                root=s1.pop().right;
                s1.add(root);
            }
        }
        return l1;
    }
}