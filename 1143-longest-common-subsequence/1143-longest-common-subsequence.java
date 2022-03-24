class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()][text2.length()];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return lcs(text1,text2,text1.length()-1,text2.length()-1,dp);
    }
    int lcs(String a,String b,int i,int j,int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)) return dp[i][j]=1+lcs(a,b,i-1,j-1,dp);
        return dp[i][j]=Math.max(lcs(a,b,i-1,j,dp),lcs(a,b,i,j-1,dp));
    }
}