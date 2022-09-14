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
    static int ans=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        ans=0;
        HashMap<Integer,Integer>m1=new HashMap<>();
        solve(root,m1);
        return ans;
    }
    void solve(TreeNode root,HashMap<Integer,Integer>m1){
        if(root==null) return;
        m1.put(root.val,m1.getOrDefault(root.val,0)+1);
        if(root.left==null && root.right==null){
            // System.out.println(root.val);
            int c=0;
            for(int i:m1.keySet()){
                // System.out.println(i+" "+m1.get(i));
                if(m1.get(i)%2==1) c++;
            }
            if(c==1 || c==0) ans++;
            m1.put(root.val,m1.get(root.val)-1);
            return;
        }
        solve(root.left,m1);
        solve(root.right,m1);
        m1.put(root.val,m1.get(root.val)-1);
    }
}