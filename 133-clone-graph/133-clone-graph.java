/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // int val=node.val;
        if(node==null) return null;
        List<Node>Visited=new ArrayList<>();
        Visited.add(node);
        Queue<Node>q1=new LinkedList<>();
        HashMap<Node,Node>m1=new HashMap<>();
        q1.add(node);
        Node ans=new Node(node.val);
        m1.put(node,ans);
        while(!q1.isEmpty()){
            Node p=q1.poll();
            // List<Node>temp=new ArrayList<>();
            for(Node i:p.neighbors){
                if(!Visited.contains(i)){
                    Visited.add(i);
                    m1.put(i,new Node(i.val));
                    q1.add(i);
                }
                m1.get(p).neighbors.add(m1.get(i));
            }
            // System.out.println(p.neighbors);
        }
        // System.out.println(ans.neighbors);
        return ans;
    }
}