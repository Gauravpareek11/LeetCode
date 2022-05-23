class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp=new int[prices.length+1][2][3];
        // for(int[][] a:dp){
        //     for(int [] b:a){
        //         Arrays.fill(b,-1);
        //     }
        // }
        for(int i=0;i<=prices.length;i++){
            dp[i][0][0]=0;
            dp[i][1][0]=0;
        }
        for(int i=0;i<=2;i++){
             dp[prices.length][1][i]=dp[prices.length][0][i]=0;
        }
        // return solve(0,1,1,prices,dp);
        for(int i=prices.length-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    
                    int profit=0;
        
                    if(buy==1){
                        profit=Math.max(-prices[i]+dp[i+1][0][cap],dp[i+1][1][cap]);
                    }
                    else{
                        profit=Math.max(prices[i]+dp[i+1][1][cap-1],dp[i+1][0][cap]);
                    }
                    dp[i][buy][cap]=profit;
                }
            }
        }
        return dp[0][1][2];
    }
//     int solve(int i,int buy,int cap,int[] prices,int[][][] dp){
//         if(cap<0) return 0;
//         if(i==prices.length) return 0;
        
//         if(dp[i][buy][cap]!=-1) return dp[i][buy][cap];
        
        
//         int profit=0;
        
//         if(buy==1){
//             profit=Math.max(-prices[i]+solve(i+1,0,cap,prices,dp),solve(i+1,1,cap,prices,dp));
//         }
//         else{
//             profit=Math.max(prices[i]+solve(i+1,1,cap-1,prices,dp),solve(i+1,0,cap,prices,dp));
//         }
//         return dp[i][buy][cap]=profit;
//     }
}