class Solution {
    static int mod=(int)1e9+7;
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        int[][] a=new int[n][2];
        for(int i=0;i<n;i++){
            a[i]=new int[]{efficiency[i],speed[i]};
        }
        Arrays.sort(a,(x,y)->y[0]-x[0]);
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        long ans=0;
        long sum=0;
        for(int[] e:a){
            pq.add(e[1]);
            sum+=e[1];
            if(pq.size()>k) sum-=pq.poll();
            ans=Math.max(ans,sum*e[0]);
        }
        return (int)(ans%mod);
    }
}