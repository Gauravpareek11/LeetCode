/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        Queue<Node>q1=new LinkedList<>();
        q1.add(root);
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null) return ans;
        while(!q1.isEmpty()){
            int n=q1.size();
            List<Integer>l1=new ArrayList<>();
            for(int i=0;i<n;i++){
                Node p=q1.poll();
                l1.add(p.val);
                for(Node n1:p.children){
                    if(n1!=null) q1.add(n1);
                }
            }
            ans.add(l1);
        }
        return ans;
    }
}