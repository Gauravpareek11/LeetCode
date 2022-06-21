class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // int[][][] dp=new int[heights.length][bricks+1][ladders+1];
        // for(int[][] a:dp){
        //     for(int[] b:a){
        //         Arrays.fill(b,-1);
        //     }
        // }
        // return solve(0,heights,bricks,ladders,dp);
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<heights.length-1;i++){
            if(heights[i+1]-heights[i]>0){
                pq.add(heights[i+1]-heights[i]);
                if(pq.size()>ladders){
                    int a=pq.poll();
                    if(bricks<a) return i;
                    bricks-=a;
                }
            }
        }
        return heights.length-1;
    }
    // int solve(int i,int[] a,int br,int ld,int[][][] dp){
    //     // if(br==0 && ld==0) return i;
    //     if(i==a.length-1) return i;
    //     if(dp[i][br][ld]!=-1) return dp[i][br][ld];
    //     if(a[i]>=a[i+1]) return dp[i][br][ld]=solve(i+1,a,br,ld,dp);
    //     else{
    //         int b=i;
    //         int l=i;
    //         if(a[i+1]-a[i]<=br) b=solve(i+1,a,br-(a[i+1]-a[i]),ld,dp);
    //         if(ld>=1) l=solve(i+1,a,br,ld-1,dp);
    //         return dp[i][br][ld]=Math.max(b,l);
    //     }
    // }
}