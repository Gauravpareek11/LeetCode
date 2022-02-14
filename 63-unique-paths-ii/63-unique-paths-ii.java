class Solution {
    public int uniquePathsWithObstacles(int[][] matrix) {
        if(matrix[0][0]==1) return 0;
        int[][] dp=new int[matrix.length][matrix[0].length];
        // for(int i=0;i<matrix.length;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return solve(dp,matrix,matrix.length-1,matrix[0].length-1);
        dp[0][0]=1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0 && j==0) continue;
                if(i-1>=0)dp[i][j]+=dp[i-1][j];
                if(j-1>=0) dp[i][j]+=dp[i][j-1];
                if(matrix[i][j]==1) dp[i][j]=0;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    // int solve(int[][] dp,int[][] matrix,int i,int j){
    //     if(i==0 && j==0) return 1;
    //     if(i<0 || j<0 || matrix[i][j]==1) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     return dp[i][j]=solve(dp,matrix,i-1,j)+solve(dp,matrix,i,j-1);
    // }
}