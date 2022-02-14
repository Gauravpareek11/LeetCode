class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp=new int[triangle.size()][triangle.size()];
        for(int i=0;i<triangle.size();i++){
            Arrays.fill(dp[i],-1);
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<triangle.get(triangle.size()-1).size();i++){
            min=Math.min(min,solve(triangle,triangle.size()-1,i,dp));
        }
        return min;
    }
    int solve(List<List<Integer>>triangle,int i,int j,int[][] dp){
        if(i==0) return triangle.get(i).get(0);
        if(j<0 || j>=triangle.get(i).size()) return Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=triangle.get(i).get(j)+Math.min(solve(triangle,i-1,j,dp),solve(triangle,i-1,j-1,dp));
    }
}