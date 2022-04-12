// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int mod=(int)1e9+7;
    static int nCr(int n, int r)
    {
        int[][] dp=new int[n+1][r+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return solve(n,r,dp);
    }
    static int solve(int n,int r,int [][]dp){
        if(n<r) return 0;
        if(r==0||r==n) return 1;
        if(dp[n][r]!=-1) return dp[n][r];
        return dp[n][r]=(solve(n-1,r-1,dp)%mod+solve(n-1,r,dp)%mod)%mod;
    }
}