class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int a[]:times){
            int[] temp=new int[2];
            temp[0]=a[1];
            temp[1]=a[2];
            adj.get(a[0]).add(temp);
        }
        int[] dis=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0]=0;
        dis[k]=0;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        int[] t={k,0};
        pq.add(t);
        while(!pq.isEmpty()){
            int[] a=pq.poll();
            for(int[] x:adj.get(a[0])){
                if(x[1]+a[1]<dis[x[0]]){
                    dis[x[0]]=x[1]+a[1];
                    int[] temp=new int[2];
                    temp[0]=x[0];
                    temp[1]=dis[x[0]];
                    pq.add(temp);
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dis[i]==Integer.MAX_VALUE) return -1;
            max=Math.max(max,dis[i]);
        }
        return max;
    }
}