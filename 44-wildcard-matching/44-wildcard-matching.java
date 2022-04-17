class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        // for(int[] a:dp){
        //     Arrays.fill(a,-1);
        // }
        // return solve(s,p,dp,s.length()-1,p.length()-1);
        dp[0][0]=true;
        for(int i=1;i<=s.length();i++){
            dp[i][0]=false;
        }
        for(int j=1;j<=p.length();j++){
            boolean flag=true;
            for(int k=1;k<=j;k++){
                if(p.charAt(k-1)!='*'){
                    flag=false;
                    break;
                }
            }
            dp[0][j]=flag;
        }
        
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if(p.charAt(j-1)==s.charAt(i-1) || p.charAt(j-1)=='?') 
                    dp[i][j]=dp[i-1][j-1];
                
                else if(p.charAt(j-1)=='*'){
                    dp[i][j]=(dp[i][j-1]||dp[i-1][j]);
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    boolean solve(String s,String p,int[][] dp,int i,int j){
        if(i<0 && j<0) return true;
        if(i<0 && j>=0){
            for(int k=0;k<=j;k++){
                if(p.charAt(k)!='*') return false;
            }
            return true;
        }
        if(i>=0 && j<0) return false;
        
        if(dp[i][j]!=-1) return (dp[i][j]==0?false:true);
        
        if(p.charAt(j)==s.charAt(i) || p.charAt(j)=='?'){
            dp[i][j]=((solve(s,p,dp,i-1,j-1))==false?0:1);
            return (dp[i][j]==0?false:true);
        }
        if(p.charAt(j)=='*'){
            dp[i][j]=((solve(s,p,dp,i,j-1)||solve(s,p,dp,i-1,j))==false?0:1);
            return (dp[i][j]==0?false:true);
        }
        return false;
    }
}