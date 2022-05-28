class Solution {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()+1];
        dp[s.length()]=1;
        // Arrays.fill(dp,-1);
        // return solve(s,0,dp);
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='0')continue;
            int ans=0;

            ans+=dp[i+1];
            if(i<s.length()-1 && isValid(s.substring(i,i+2))) ans+=dp[i+2];
            dp[i]=ans;
        }
        return dp[0];
    }
//     int solve(String s,int i,int[] dp){
//         if(i==s.length()) return 1;
        
//         if(dp[i]!=-1) return dp[i];
//         if(s.charAt(i)=='0') return dp[i]=0;
//         int ans=0;
        
//         ans+=solve(s,i+1,dp);
//         if(i<s.length()-1 && isValid(s.substring(i,i+2))) ans+=solve(s,i+2,dp);
//         return dp[i]=ans;
//     }
    boolean isValid(String s){
        if(s.charAt(0)=='0') return false;
        if(Integer.parseInt(s)<=26) return true;
        return false;
    }
}