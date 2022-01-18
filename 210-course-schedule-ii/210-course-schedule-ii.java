class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }
        Queue<Integer>q1=new LinkedList<>();
        int count=0;
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                count++;
                q1.add(i);
            }
        }
        ArrayList<Integer>l1=new ArrayList<Integer>();
        while(!q1.isEmpty()){
            int k=q1.poll();
            l1.add(k);
            for(int i:adj.get(k)){
                indegree[i]--;
                if(indegree[i]==0) q1.add(i);
            }
        }
        int[] ans=new int[n];
        if(l1.size()<n) return new int[0];
        for(int i=0;i<n;i++){
            ans[n-i-1]=l1.get(i);
        }
        return ans;
    }
}