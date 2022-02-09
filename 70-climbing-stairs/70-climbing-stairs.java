class Solution {
    public int climbStairs(int n) {
        // int[] dp=new int[n+1];
        // dp[0]=1;
        // dp[1]=1;
        // for(int i=2;i<=n;i++){
        //     dp[i]=dp[i-1]+dp[i-2];
        // }
        // return dp[n];
        int prev=1;
        int prev2=1;
        int c=0;
        for(int i=2;i<=n;i++){
            c=prev+prev2;
            prev2=prev;
            prev=c;
        }
        return prev;
    }
}