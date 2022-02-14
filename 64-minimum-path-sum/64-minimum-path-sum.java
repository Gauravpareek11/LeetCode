class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        // for(int i=0;i<grid.length;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return solve(grid,grid.length-1,grid[0].length-1,dp);
        dp[0][0]=grid[0][0];
        int x=Integer.MAX_VALUE;
        int y=Integer.MAX_VALUE;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0) continue;
                if(i-1>=0) x=dp[i-1][j];
                if(j-1>=0) y=dp[i][j-1];
                dp[i][j]=grid[i][j]+Math.min(x,y);
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    // int solve(int[][] grid,int i,int j,int[][] dp){
    //     if(i==0 && j==0) return grid[i][j];
    //     if(i<0 || j<0) return 100000;            
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     return dp[i][j]=Math.min(grid[i][j]+solve(grid,i-1,j,dp),grid[i][j]+solve(grid,i,j-1,dp));
    // }
}