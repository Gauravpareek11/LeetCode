class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        
        for(int i=0;i<=text1.length();i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=text2.length();j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=text1.length();i++){
            for(int j=1;j<=text2.length();j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)) dp[i][j]= 1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[text1.length()][text2.length()];
        
        // for(int[] a:dp){
        //     Arrays.fill(a,-1);
        // }
        // return lcs(text1,text2,text1.length()-1,text2.length()-1,dp);
    }
    int lcs(String a,String b,int i,int j,int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)) return dp[i][j]=1+lcs(a,b,i-1,j-1,dp);
        return dp[i][j]=Math.max(lcs(a,b,i-1,j,dp),lcs(a,b,i,j-1,dp));
    }
}