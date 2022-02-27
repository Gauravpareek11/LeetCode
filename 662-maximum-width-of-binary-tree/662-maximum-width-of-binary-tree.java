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
    TreeNode node;
    int index;
    pair(TreeNode node,int index){
        this.node=node;
        this.index=index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
    //     HashMap<Integer,List<Integer>>m1=new HashMap<>();
    //     solve(root,m1,0);
    //     int max=0;
    //     for(Map.Entry<Integer,List<Integer>>in:m1.entrySet()){
    //         List<Integer>l2=in.getValue();
    //         while(l2.size()>0 && l2.get(0)==null){
    //             l2.remove(0);
    //         }
    //         while(l2.size()>0 && l2.get(l2.size()-1)==null){
    //             l2.remove(l2.size()-1);
    //         }
    //         max=Math.max(l2.size(),max);
    //     }
    //     return max;
    // }
    // void solve(TreeNode root,HashMap<Integer,List<Integer>>m1,int row){
    //     if(root==null){
    //         if(m1.containsKey(row)){
    //             m1.get(row).add(null);
    //         }
    //         else{
    //             List<Integer>temp=new ArrayList<Integer>();
    //             temp.add(null);
    //             m1.put(row,temp);
    //         }
    //             return;
    //     }
    //     if(m1.containsKey(row)){
    //         m1.get(row).add(root.val);
    //     }
    //     else{
    //         List<Integer>temp=new ArrayList<Integer>();
    //         temp.add(root.val);
    //         m1.put(row,temp);
    //     }
    //     solve(root.left,m1,row+1);
    //     solve(root.right,m1,row+1);
    // }
       Queue<pair>q1=new LinkedList<>();
       if(root==null) return 0;
        q1.add(new pair(root,0));
        int max=0;
        while(!q1.isEmpty()){
            int min=q1.peek().index;    //to maintain indexing
            int last=0,first=0;
            int size=q1.size();
            for(int i=0;i<size;i++){
                int id=q1.peek().index-min;
                TreeNode temp=q1.peek().node;
                // System.out.println(q1);
                q1.poll();
                if(i==0) first=id;
                if(i==size-1) last=id;
                if(temp.left!=null) q1.add(new pair(temp.left,(2*id)+1));
                if(temp.right!=null) q1.add(new pair(temp.right,(2*id)+2));
            }
              max=Math.max(last-first+1,max);
            // System.out.println(first+" "+last);
        }
        return max;
    }
}