class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length+2][2];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return solve(0,1,prices,dp);
    }
    int solve(int i, int buy,int[] prices,int[][] dp){
        if(i>=prices.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[i]+solve(i+1,0,prices,dp),solve(i+1,1,prices,dp));
        }
        else{
            profit=Math.max(prices[i]+solve(i+2,1,prices,dp),solve(i+1,0,prices,dp));
        }
        return dp[i][buy]=profit;
    }
}