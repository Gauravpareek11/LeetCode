class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        double[][] dp=new double[100][100];
        dp[0][0]=poured;
        int i=1;
        while(i<=query_row){
            for(int j=0;j<=i;j++){
                if(j==0){
                    if(dp[i-1][j]>1) dp[i][j]=(dp[i-1][j]-1.0)/2.0;
                }
                else if(j==i){
                   if(dp[i-1][j-1]>1) dp[i][j]=(dp[i-1][j-1]-1.0)/2.0;
                }
                else {
                   if(dp[i-1][j]>1) dp[i][j]+=(dp[i-1][j]-1.0)/2.0;
                   if(dp[i-1][j-1]>1) dp[i][j]+=(dp[i-1][j-1]-1.0)/2.0;
                }
                // if(dp[i][j]==0) f=true;break;
            }
            // if(f) break;
            i++;
        }
        // System.out.println(dp[query_row][query_glass]);
        return Math.min(dp[query_row][query_glass],(double)1.00);
    }
}