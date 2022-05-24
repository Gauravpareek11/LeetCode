class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[] prev=new int[2];
        int[] cur=new int[2];
        // for(int[] a:dp){
        //     Arrays.fill(a,-1);
        // }
        // return solve(0,1,prices,fee,dp);
        for(int i=prices.length-1;i>=0;i--){
            cur[1]=Math.max(-prices[i]+prev[0],prev[1]);
            cur[0]=Math.max(prices[i]-fee+prev[1],prev[0]);
            prev=cur;
        }
        return prev[1];
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