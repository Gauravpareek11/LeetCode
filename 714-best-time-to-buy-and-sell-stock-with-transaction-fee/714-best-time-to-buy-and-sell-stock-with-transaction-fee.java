class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp=new int[prices.length+1][2];
        // for(int[] a:dp){
        //     Arrays.fill(a,-1);
        // }
        // return solve(0,1,prices,fee,dp);
        for(int i=prices.length-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                int profit=0;
                if(buy==1){
                    profit=Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
                }
                else{
                    profit=Math.max(prices[i]-fee+dp[i+1][1],dp[i+1][0]);
                }
                dp[i][buy]=profit;
            }
        }
        return dp[0][1];
    }
//     int solve(int i,int buy,int[] prices,int fee,int[][] dp){
//         if(i==prices.length) return 0;
        
//         if(dp[i][buy]!=-1) return dp[i][buy];
//         int profit=0;
//         if(buy==1){
//             profit=Math.max(-prices[i]+solve(i+1,0,prices,fee,dp),solve(i+1,1,prices,fee,dp));
//         }
//         else{
//             profit=Math.max(prices[i]-fee+solve(i+1,1,prices,fee,dp),solve(i+1,0,prices,fee,dp));
//         }
//         return dp[i][buy]=profit;
//     }
}