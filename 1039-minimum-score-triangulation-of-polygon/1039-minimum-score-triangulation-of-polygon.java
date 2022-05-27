class Solution {
    public int minScoreTriangulation(int[] values) {
        int[][] dp=new int[values.length][values.length];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return solve(values,1,values.length-1,dp);
    }
    int solve(int[] a,int i,int j,int[][] dp){
        if(i==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int steps=a[i-1]*a[k]*a[j]+solve(a,i,k,dp)+solve(a,k+1,j,dp);
            min=Math.min(min,steps);
        }
        return dp[i][j]=min;
    }
}