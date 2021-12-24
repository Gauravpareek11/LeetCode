/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode>parent=new HashMap<>();
        getParent(root,parent);
        Queue<TreeNode>q1=new LinkedList<>();
        Map<TreeNode,Boolean>visited=new HashMap<>();
        q1.add(target);
        visited.put(target,true);
        int dist=0;
        while(!q1.isEmpty()){
            int size=q1.size();
            if(dist==k) break;
            dist++;
            for(int i=0;i<size;i++){
                TreeNode cur=q1.poll();
                if(cur.left!=null && !visited.containsKey(cur.left)){
                    q1.add(cur.left);
                    visited.put(cur.left,true);
                }
                if(cur.right!=null && !visited.containsKey(cur.right)){
                    q1.add(cur.right);
                    visited.put(cur.right,true);
                }
                if(parent.containsKey(cur) && !visited.containsKey(parent.get(cur))){
                    q1.add(parent.get(cur));
                    visited.put(parent.get(cur),true);
                }
            }
        }
        List<Integer>ans=new ArrayList<Integer>();
        while(!q1.isEmpty()){
            ans.add(q1.peek().val);
            q1.poll();
        }
        return ans;
    }
    void getParent(TreeNode root,Map<TreeNode,TreeNode>parent){
        Queue<TreeNode>q1=new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty()){
            TreeNode curr=q1.poll();
            if(curr.left!=null){
                parent.put(curr.left,curr);
                q1.add(curr.left);
            }
            if(curr.right!=null){
                parent.put(curr.right,curr);
                q1.add(curr.right);            
            }
        }
    }
}