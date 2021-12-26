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
class BSTIterator {
    List<Integer>l1=new ArrayList<Integer>();
    int i=0;
    public BSTIterator(TreeNode root) {
        inorder(root,l1);
    }
    
    public int next() {
        return l1.get(i++);
    }
    
    public boolean hasNext() {
        return i<l1.size();
    }
    private void inorder(TreeNode root,List<Integer>l1){
        if(root==null) return;
        inorder(root.left,l1);
        l1.add(root.val);
        inorder(root.right,l1);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */