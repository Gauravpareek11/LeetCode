class Solution {
    public int numSquares(int n) {
        int i=1;
        ArrayList<Integer>l1=new ArrayList<Integer>();
        while(i*i<=n){
            l1.add(i*i);
            i++;
        }
        int[][] dp=new int[l1.size()][n+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return solve(0,l1,n,dp);
    }
    int solve(int i,ArrayList<Integer>l1,int n,int[][] dp){
        if(i==l1.size()){
            if(n==0) return 0;
            else return (int)1e6;
        }
        
        if(dp[i][n]!=-1) return dp[i][n];
        int not_pick=solve(i+1,l1,n,dp);
        int pick=(int)1e6;
        if(n-l1.get(i)>=0) pick=1+solve(i,l1,n-l1.get(i),dp);
        return dp[i][n]=Math.min(pick,not_pick);
    }
}