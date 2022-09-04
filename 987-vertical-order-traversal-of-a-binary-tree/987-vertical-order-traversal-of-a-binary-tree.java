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
class pair{
    int val;
    int row;
    int col;
    pair(int val,int row,int col){
        this.val=val;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,List<Integer>>m1=new TreeMap<>();
        List<pair>l1=new ArrayList<>();
        preorder(root,0,0,l1);
        Collections.sort(l1,(a,b)->Integer.compare(a.val,b.val));
        Collections.sort(l1,(a,b)->Integer.compare(a.row,b.row));
        for(pair i:l1){
            if(m1.containsKey(i.col)){
                m1.get(i.col).add(i.val);
            }
            else{
                List<Integer>l2=new ArrayList<Integer>();
                l2.add(i.val);
                m1.put(i.col,l2);
            }
        }
        List<List<Integer>>ans=new ArrayList<List<Integer>>();
        for(Map.Entry<Integer,List<Integer>>in:m1.entrySet()){
            ans.add(in.getValue());
        }
        return ans;
    }
    void preorder(TreeNode root,int row,int col,List<pair>l1){
        if(root==null) return;
        // if(m1.containsKey(col)){
        //     m1.get(col).add(root.val);
        //     // List<Integer>l1=new ArrayList<>(m1.get(col));
        //     // l1.add(root.val);
        //     // Collections.sort(l1);
        //     // System.out.println(l1);
        //     // m1.put(col,l1);
        // }
        // else{
        //     List<Integer>l1=new ArrayList<Integer>();
        //     l1.add(root.val);
        //     m1.put(col,l1);
        // }
        l1.add(new pair(root.val,row,col));
        preorder(root.left,row+1,col-1,l1);
        preorder(root.right,row+1,col+1,l1);
    }
}