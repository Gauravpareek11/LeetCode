class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int x=Math.max(s1.length(),s2.length());
        int[][] dp=new int[x+1][x+1];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return solve(s1,s2,s3,0,0,dp);
    }
    boolean solve(String s1,String s2,String s3,int i,int j,int[][] dp){
        if(i==s1.length() && j==s2.length() && (i+j)==s3.length()) return true;
        // if(i==s1.length()){
        //     if(s2.substring(j,s2.length())==s3.substring(i+j,s3.length())) return true;
        //     return false;
        // }
        // if(j==s2.length()){
        //     if(s1.substring(i,s1.length())==s3.substring(i+j,s3.length())) return true;
        //     return false;
        // }
        if(dp[i][j]!=-1) return dp[i][j]==1?true:false;
        
        if(i<s1.length() && j<s2.length() && i+j<s3.length() && s1.charAt(i)==s2.charAt(j) && s2.charAt(j)==s3.charAt(i+j)){
            boolean a=(solve(s1,s2,s3,i+1,j,dp) || solve(s1,s2,s3,i,j+1,dp));
            dp[i][j]=(a==true?1:0);
            return a;
        }
        else if(i<s1.length() && i+j<s3.length() && s1.charAt(i)==s3.charAt(i+j)){
            dp[i][j]=(solve(s1,s2,s3,i+1,j,dp)==true?1:0);
            return dp[i][j]==1?true:false;
        }
        else if(j<s2.length() && i+j<s3.length() && s2.charAt(j)==s3.charAt(i+j)){
            dp[i][j]=(solve(s1,s2,s3,i,j+1,dp)==true?1:0);
            return dp[i][j]==1?true:false;
        }
        else{
            dp[i][j]=0;
            return false;
        }
    }
}