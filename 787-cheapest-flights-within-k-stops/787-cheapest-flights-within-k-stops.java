class pair{
    int node;
    int dis;
    int stop;
    pair(int node,int dis,int stop){
        this.node=node;
        this.dis=dis;
        this.stop=stop;
    }
}
class Node{
    int u;
    int wt;
    Node(int u,int wt){
        this.u=u;
        this.wt=wt;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Node>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Node>());
        }
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Node(flights[i][1],flights[i][2]));
        }
        int[] dis=new int[n];
        int[] current=new int[n];
        Arrays.fill(current,Integer.MAX_VALUE);
        Arrays.fill(dis,Integer.MAX_VALUE);
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->Integer.compare(a.dis,b.dis));
        pq.add(new pair(src,0,0));
        while(!pq.isEmpty()){
            pair p=pq.poll();
            if(p.node==dst) return dis[dst];
            // System.out.println(p.node+" "+p.dis+" "+p.stop);
            // System.out.println(Arrays.toString(dis));
            if(p.stop==k+1) continue;
            for(Node m:adj.get(p.node)){
                if(dis[m.u]>p.dis+m.wt){
                    dis[m.u]=p.dis+m.wt;
                    pq.add(new pair(m.u,dis[m.u],p.stop+1));
                }
                else if(p.stop+1<current[m.u]){
                    pq.add(new pair(m.u,p.dis+m.wt,p.stop+1));
                }
                current[m.u]=p.stop+1;
            }
        }
        return (dis[dst]==Integer.MAX_VALUE?-1:dis[dst]);
    }
}