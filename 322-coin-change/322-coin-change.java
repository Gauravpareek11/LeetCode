class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        int ans=solve(coins,0,amount,dp);
        return ans>=(int)1e6?-1:ans;
    }
    int solve(int[] coins,int i,int amt,int[][] dp){
        if(i==coins.length-1){
            if(amt==0) return 0;
            if(amt%coins[i]==0) return amt/coins[i];
            return (int)1e6;
        }
        if(dp[i][amt]!=-1) return dp[i][amt];
        int not_pick=solve(coins,i+1,amt,dp);
        int pick=(int)1e6;
        if(amt-coins[i]>=0) pick=1+solve(coins,i,amt-coins[i],dp);
        return dp[i][amt]=Math.min(pick,not_pick);
    }
}