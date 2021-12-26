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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        ArrayList<Integer>l1=new ArrayList<>();
        inorder(root,l1);
        l1.add(val);
        Collections.sort(l1);
        return create(l1,0,l1.size()-1);
    }
    void inorder(TreeNode root,ArrayList<Integer>l1){
        if(root==null) return;
        inorder(root.left,l1);
        l1.add(root.val);
        inorder(root.right,l1);
    }
    TreeNode create(ArrayList<Integer>l1,int i,int n){
        if(i>n) return null;
        int mid=i+(n-i)/2;
        TreeNode node=new TreeNode(l1.get(mid));
        node.left=create(l1,i,mid-1);
        node.right=create(l1,mid+1,n);
        return node;
    }
}