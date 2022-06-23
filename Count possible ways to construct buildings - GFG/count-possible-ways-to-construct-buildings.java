// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int mod=(int)1e9+7;
    public int TotalWays(int N)
    {
        // Code here
        if(N==1) return 4;
        long[] dp=new long[N];
        dp[0]=2;
        dp[1]=3;
        for(int i=2;i<N;i++){
            dp[i]=(dp[i-1]+dp[i-2])%mod;
        }
        return (int)((dp[N-1]*dp[N-1])%mod);
    }
    // int solve(int N,int[] dp){
    //     if(N==0) return 2;
    //     if(N==1) return 3;
        
    //     if(dp[N]!=-1) return dp[N];
    //     return (solve(N-1,dp)%mod+solve(N-2,dp)%mod)%mod;
    // }
}