class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        boolean[] vis=new boolean[n];
        for(int i=0;i<connections.length;i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        // List<Integer>ans=new ArrayList<>();
        int ans=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,adj,vis);
                ans++;
            }
            // if(!vis[i] && m1.get(i)==null) ans++;
        }
        return ans-1;
    }
    void dfs(int node,List<List<Integer>>adj,boolean[] vis){
        // ans.add(node);
        vis[node]=true;
        // if(m1.get(node)==null) return;
        for(int i:adj.get(node)){
            if(!vis[i]) dfs(i,adj,vis);
        }
    }
}