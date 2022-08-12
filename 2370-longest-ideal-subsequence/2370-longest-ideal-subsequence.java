class Solution {
    public int longestIdealString(String s, int k) {
        // int[][] dp=new int[s.length()+1][s.length()+1];
        // for(int[] a:dp){
        //     Arrays.fill(a,-1);
        // }
        // return solve(s,k,0,-1,dp);
        int[] dp=new int[26];
        int ans=1;
        for(int i=0;i<s.length();i++){
            int x=s.charAt(i)-'a';
            dp[x]+=1;
            
            for(int j=Math.max(0,x-k);j<=Math.min(25,x+k);j++){
                if(x!=j){
                    dp[x]=Math.max(dp[x],dp[j]+1);
                }
            }
            ans=Math.max(ans,dp[x]);
        }
        return ans;
    }
//     int solve(String s,int k,int i,int prev,int[][] dp){
//         if(i==s.length()) return 0;
        
//         if(dp[i][prev+1]!=-1) return dp[i][prev+1];
//         int not_pick=solve(s,k,i+1,prev,dp);
//         int pick=0;
//         if(prev==-1||Math.abs((s.charAt(i)-'a')-(s.charAt(prev)-'a'))<=k) pick=1+solve(s,k,i+1,i,dp);
//         return dp[i][prev+1]=Math.max(pick,not_pick);
//     }
}