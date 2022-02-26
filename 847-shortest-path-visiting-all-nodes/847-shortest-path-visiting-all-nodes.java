// class Solution {
//     public int shortestPathLength(int[][] graph) {
//         ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
//         for(int i=0;i<graph.length;i++){
//             adj.add(new ArrayList<Integer>());
//         }
//         for(int i=0;i<graph.length;i++){
//             for(int j=0;j<graph[i].length;j++){
//                 adj.get(i).add(graph[i][j]);
//             }
//         }
//         int n_1=graph.length-1;
//         int ans=Integer.MAX_VALUE;
//         for(int i=0;i<graph.length;i++){
//             boolean[] visited=new boolean[graph.length];
//             int c=dfs(i,visited,adj,0,n_1);
//             if(c==n_1) return c;
//             ans=Math.min(ans,2*(n_1)-c);
//         }
//         return ans;
//     }
//     int dfs(int node,boolean[] visited,ArrayList<ArrayList<Integer>>adj,int depth,int n_1){
//         visited[node]=true;
//         int maxdepth=depth;
//         for(int i:adj.get(node)){
//             if(!visited[i]) maxdepth=Math.max(maxdepth,dfs(i,visited,adj,depth+1,n_1));
//             if(maxdepth==n_1) return maxdepth;
//         }
//         visited[node]=false;
//         return maxdepth;
//     }
// }
class Solution {
    public int shortestPathLength(int[][] graph) {
        if (graph.length == 1) {
            return 0;
        }
        
        int n = graph.length;
        int endingMask = (1 << n) - 1;
        boolean[][] seen = new boolean[n][endingMask];
        ArrayList<int[]> queue = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            queue.add(new int[] {i, 1 << i});
            seen[i][1 << i] = true;
        }
        
        int steps = 0;
        while (!queue.isEmpty()) {
            ArrayList<int[]> nextQueue = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                int[] currentPair = queue.get(i);
                int node = currentPair[0];
                int mask = currentPair[1];
                for (int neighbor : graph[node]) {
                    int nextMask = mask | (1 << neighbor);
                    if (nextMask == endingMask) {
                        return 1 + steps;
                    }
                    
                    if (!seen[neighbor][nextMask]) {
                        seen[neighbor][nextMask] = true;
                        nextQueue.add(new int[] {neighbor, nextMask});
                    }
                }
            }
            steps++;
            queue = nextQueue;
        }
        
        return -1;
    }
}