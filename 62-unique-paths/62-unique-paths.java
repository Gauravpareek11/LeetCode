class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        // dp[0][0]=1;
        // for(int i=1;i<m;i++){
        //     for(int j=1;j<n;j++){
        //         int a=dp[i][j-1];
        //         int b=dp[i-1][j];
        //         dp[i][j]=a+b;
        //     }
        // }
        // return dp[m-1][n-1];
        return solve(m-1,n-1,dp);
    }
    int solve(int i,int j,int[][] dp){
        if(i<0 || j<0) return 0;
        if(i==0 && j==0) return 1;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int a=solve(i-1,j,dp);
        int b=solve(i,j-1,dp);
        return dp[i][j]=a+b;
    }
}