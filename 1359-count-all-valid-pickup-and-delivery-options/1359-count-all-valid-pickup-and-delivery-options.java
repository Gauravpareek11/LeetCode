class Solution {
    public int countOrders(int n) {
        if(n==1) return 1;
        int mod=(int)1e9+7;
        // long[] dp=new long[2*n+1];
        // Arrays.fill(dp,-1);
        // // System.out.println(fact(n+n,dp));
        // long ans=(fact(n+n,dp)/(int)Math.pow(2,n))%mod;
        // return (int) ans;
        long ans=1;
        for(int i=1;i<=n;i++){
            ans=(ans*i)%mod;
            ans=ans*(2*i-1)%mod;
        }
        return (int)ans;
    }
    // long fact(int n,long[]dp){
    //     if(n==0 || n==1) return 1;
    //     if(dp[n]!=-1) return dp[n];
    //     return (n*fact(n-1,dp));
    // }
}