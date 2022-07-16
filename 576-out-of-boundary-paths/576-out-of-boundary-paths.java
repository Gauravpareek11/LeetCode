class Solution {
    static int mod=(int)1e9+7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long[][][] dp=new long[m][n][maxMove];
        for(long[][] a:dp){
            for(long[] b:a){
                Arrays.fill(b,-1);
            }
        }
        return (int)solve(startRow,startColumn,m,n,maxMove,0,dp)%mod;
        
    }
    long solve(int i,int j,int m,int n,int max_moves,int count,long[][][] dp){
        if(i<0 || j<0 || i>=m || j>=n) return 1;
        if(count==max_moves) return 0;
        
        if(dp[i][j][count]!=-1) return dp[i][j][count];
        long ans=0;
        ans+=solve(i+1,j,m,n,max_moves,count+1,dp);
        ans+=solve(i-1,j,m,n,max_moves,count+1,dp);
        ans+=solve(i,j-1,m,n,max_moves,count+1,dp);
        ans+=solve(i,j+1,m,n,max_moves,count+1,dp);
        return dp[i][j][count]=ans%mod;
    }
}