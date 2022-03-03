class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        List<List<Integer>>ans=new ArrayList<>();
        ArrayList<Integer>l1=new ArrayList<>();
        solve(0,adj,ans,l1);
        return ans;
    }
    void solve(int i,ArrayList<ArrayList<Integer>>adj,List<List<Integer>>ans,List<Integer>l1){
        l1.add(i);
        if(i==adj.size()-1){
            ans.add(new ArrayList<Integer>(l1));
        }
        for(int node:adj.get(i)){
            solve(node,adj,ans,l1);
            l1.remove(l1.size()-1);
        }
    }
}