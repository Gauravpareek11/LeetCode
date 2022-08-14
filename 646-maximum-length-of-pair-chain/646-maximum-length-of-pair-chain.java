class Solution {
    public int findLongestChain(int[][] pairs) {
        
        Arrays.sort(pairs,(a,b)->Integer.compare(a[0],b[0]));
        int[][] dp=new int[pairs.length][pairs.length+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return solve(0,pairs,-1,dp);
    }
    int solve(int i,int[][] pairs,int prev,int[][] dp){
        if(i==pairs.length) return 0;
        
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int not_pick=solve(i+1,pairs,prev,dp);
        int pick=0;
        if(prev==-1||pairs[prev][1]<pairs[i][0]) pick=1+solve(i+1,pairs,i,dp);
        
        return dp[i][prev+1]=Math.max(pick,not_pick);
    }
}