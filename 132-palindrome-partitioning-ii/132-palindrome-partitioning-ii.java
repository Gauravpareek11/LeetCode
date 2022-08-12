class Solution {
    public int minCut(String s) {
        int[][] dp=new int[s.length()][s.length()];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return solve(0,s.length()-1,s,dp);
    }
    int solve(int i,int j,String s,int[][] dp){
        if(i>=j) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        if(isPalin(s,i,j)) return 0;
        int min=Integer.MAX_VALUE;
        for(int x=i;x<j;x++){
            if(isPalin(s,i,x)){
                min=Math.min(min,1+solve(x+1,j,s,dp));
            }
        }
        return dp[i][j]=min;
    }
    boolean isPalin(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}