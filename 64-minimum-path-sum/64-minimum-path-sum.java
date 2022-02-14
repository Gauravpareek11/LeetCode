class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(grid,grid.length-1,grid[0].length-1,dp);
    }
    int solve(int[][] grid,int i,int j,int[][] dp){
        if(i==0 && j==0) return grid[i][j];
        if(i<0 || j<0) return 100000;            //101 is according to the constraints
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=Math.min(grid[i][j]+solve(grid,i-1,j,dp),grid[i][j]+solve(grid,i,j-1,dp));
    }
}