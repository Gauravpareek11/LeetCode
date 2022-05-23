class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp=new int[prices.length][2][2];
        for(int[][] a:dp){
            for(int [] b:a){
                Arrays.fill(b,-1);
            }
        }
        return solve(0,1,1,prices,dp);
    }
    int solve(int i,int buy,int cap,int[] prices,int[][][] dp){
        if(cap<0) return 0;
        if(i==prices.length) return 0;
        
        if(dp[i][buy][cap]!=-1) return dp[i][buy][cap];
        
        
        int profit=0;
        
        if(buy==1){
            profit=Math.max(-prices[i]+solve(i+1,0,cap,prices,dp),solve(i+1,1,cap,prices,dp));
        }
        else{
            profit=Math.max(prices[i]+solve(i+1,1,cap-1,prices,dp),solve(i+1,0,cap,prices,dp));
        }
        return dp[i][buy][cap]=profit;
    }
}