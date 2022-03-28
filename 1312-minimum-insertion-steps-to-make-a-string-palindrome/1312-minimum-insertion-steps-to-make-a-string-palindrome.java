class Solution {
    public int minInsertions(String s) {
        int[][] dp=new int[s.length()+1][s.length()+1];
        StringBuilder sb=new StringBuilder(s);
        String s1=sb.reverse().toString();
        for(int i=0;i<=s.length();i++){
            for(int j=0;j<=s.length();j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else{
                    if(s.charAt(i-1)==s1.charAt(j-1)) dp[i][j]=dp[i-1][j-1]+1;
                    else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return s.length()-dp[s.length()][s.length()];
    }
}