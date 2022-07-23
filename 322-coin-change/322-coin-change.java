class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        // for(int[] a:dp){
        //     Arrays.fill(a,-1);
        // }
        // int ans=solve(coins,0,amount,dp);
        for(int i=1;i<=amount;i++){
            if(i%coins[coins.length-1]==0){
                dp[dp.length-1][i]=i/coins[coins.length-1];
            }
            else dp[dp.length-1][i]=(int)1e6;
        }
        dp[dp.length-1][0]=0;
        // return ans>=(int)1e6?-1:ans;
        for(int i=coins.length-2;i>=0;i--){
            for(int j=0;j<=amount;j++){
                int not_pick=dp[i+1][j];
                int pick=(int)1e6;
                if(j-coins[i]>=0) pick=1+dp[i][j-coins[i]];
                dp[i][j]=Math.min(pick,not_pick);
            }
        }
        return dp[0][amount]>=(int)1e6?-1:dp[0][amount];
    }
    // int solve(int[] coins,int i,int amt,int[][] dp){
    //     if(i==coins.length-1){
    //         if(amt==0) return 0;
    //         if(amt%coins[i]==0) return amt/coins[i];
    //         return (int)1e6;
    //     }
    //     if(dp[i][amt]!=-1) return dp[i][amt];
    //     int not_pick=solve(coins,i+1,amt,dp);
    //     int pick=(int)1e6;
    //     if(amt-coins[i]>=0) pick=1+solve(coins,i,amt-coins[i],dp);
    //     return dp[i][amt]=Math.min(pick,not_pick);
    // }
}