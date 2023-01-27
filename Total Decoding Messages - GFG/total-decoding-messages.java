//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int mod=(int)1e9+7;
    public int CountWays(String str)
    {
        // code here
        int[] dp=new int[str.length()];
        Arrays.fill(dp,-1);
        return solve(0,str,dp);
    }
    int solve(int i,String s,int[] dp){
        if(i>=s.length()) return 1;
        if(s.charAt(i)=='0') return 0;
        if(dp[i]!=-1) return dp[i];
        int one=0;
        int two=0;
        one=solve(i+1,s,dp);
        if(i+1<s.length() && Integer.parseInt(s.substring(i,i+2))<=26 && Integer.parseInt(s.substring(i,i+2))>=1) 
            two=solve(i+2,s,dp);
        return dp[i]=(one+two)%mod;
    }
}