class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
       int[][] a=new int[strs.length][2];
        for(int i=0;i<strs.length;i++){
            int count_0=0;
            int count_1=0;
            for(int j=0;j<strs[i].length();j++){
                if(strs[i].charAt(j)=='1') count_1++;
                else count_0++;
            }
            a[i][0]=count_0;
            a[i][1]=count_1;
        }
        int[][][] dp=new int[strs.length][m+1][n+1];
        for(int[][] b:dp){
            for(int[] c:b){
                Arrays.fill(c,-1);
            }
        }
        return solve(strs.length-1,a,m,n,dp);
    }
    int solve(int i,int[][] a,int m,int n,int[][][] dp){
        if(i==0){
            if(m-a[0][0]>=0 && n-a[0][1]>=0) return 1;
            else return 0;
        }
        if(dp[i][m][n]!=-1) return dp[i][m][n];
        int not_pick=solve(i-1,a,m,n,dp);
        int pick=0;
        if(m-a[i][0]>=0 && n-a[i][1]>=0) pick=1+solve(i-1,a,m-a[i][0],n-a[i][1],dp);
        return dp[i][m][n]=Math.max(pick,not_pick);
    }
}