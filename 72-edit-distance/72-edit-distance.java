class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()][word2.length()];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return solve(word1,word2,word1.length()-1,word2.length()-1,dp);
    }
    int solve(String a,String b,int i,int j,int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        if(a.charAt(i)==b.charAt(j)) return dp[i][j]=solve(a,b,i-1,j-1,dp);
        else{
            int x=1+solve(a,b,i,j-1,dp);
            int y=1+solve(a,b,i-1,j,dp);
            int z=1+solve(a,b,i-1,j-1,dp);
            return dp[i][j]=Math.min(x,Math.min(y,z));
        }
    }
}