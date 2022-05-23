class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length+1][2];
        // for(int a[]:dp){
        //     Arrays.fill(a,-1);
        // }
        dp[prices.length][0]=dp[prices.length][1]=0;
        for(int i=prices.length-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
              int profit=0;
              if(buy==1){
                    profit=Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
              }
              else{
                profit=Math.max(prices[i]+dp[i+1][1],dp[i+1][0]);
                }
                dp[i][buy]=profit;  
            }
        }
        return dp[0][1];
    }
//     int solve(int i,int buy,int[] prices,int[][] dp){
//         if(i==prices.length) return 0;
        
//         if(dp[i][buy]!=-1) return dp[i][buy];
//         int profit;
//         if(buy==1){
//             profit=Math.max(-prices[i]+solve(i+1,0,prices,dp),solve(i+1,1,prices,dp));
//         }
//         else{
//             profit=Math.max(prices[i]+solve(i+1,1,prices,dp),solve(i+1,0,prices,dp));
//         }
//         return dp[i][buy]=profit;
//     }
}