class Solution {
    // int count=0;
    public int uniquePaths(int m, int n) {
        // int[][] a=new int[m][n];
        // for(int i=0;i<m;i++){ //first column 1;
        //     a[i][0]=1;
        // }
        // for(int j=0;j<n;j++){ //first row 1;
        //     a[0][j]=1;
        // }
        // for(int i=1;i<m;i++){
        //     for(int j=1;j<n;j++){
        //         a[i][j]=a[i-1][j]+a[i][j-1];
        //     }
        // }
        // return a[m-1][n-1];
        
        
        // count=0;
        // boolean[][] visited=new boolean[m][n];
        // solve(0,0,m,n);
        // return count;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        dp[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) continue;
                int up=0,left=0;
                if(i-1>=0) up=dp[i-1][j];
                if(j-1>=0) left=dp[i][j-1];
                dp[i][j]=up+left;
            }
        }
        return dp[m-1][n-1];
    }
    // void solve(int i,int j,int m,int n){
    //     if(i==m-1 && j==n-1){
    //         count++;
    //         return;
    //     }
    //     if(!isValid(i,j,m,n)){
    //         return;
    //     }
    //     // visited[i][j]=true;
    //     solve(i+1,j,m,n);
    //     solve(i,j+1,m,n);
    //     // visited[i][j]=false;
    // }
    // boolean isValid(int i,int j,int m,int n){
    //     if(i<0 || j<0 || i>=m || j>=n){
    //         return false;
    //     }
    //     return true;
    // }
    
    
    // int solve(int i,int j,int[][] dp){
    //     if(i==0 && j==0) return 1;
    //     if(i<0 || j<0) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     return dp[i][j]=solve(i-1,j,dp)+solve(i,j-1,dp);
    // }
}