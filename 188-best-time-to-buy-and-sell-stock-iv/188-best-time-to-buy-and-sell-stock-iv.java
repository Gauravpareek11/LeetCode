class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp=new int[prices.length][2][k+1];
        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        return solve(0,1,prices,k,dp);
    }
    int solve(int i,int buy,int[] prices,int k,int[][][] dp){
        if(k==0) return 0;
        if(i==prices.length) return 0;
        
        if(dp[i][buy][k]!=-1) return dp[i][buy][k];
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[i]+solve(i+1,0,prices,k,dp),solve(i+1,1,prices,k,dp));
        }
        else{
            profit=Math.max(prices[i]+solve(i+1,1,prices,k-1,dp),solve(i+1,0,prices,k,dp));
        }
        return dp[i][buy][k]=profit;
    }
}