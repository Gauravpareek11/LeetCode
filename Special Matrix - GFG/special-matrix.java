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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
            int[][] blocked_cells = new int[k][2];
            for(int i = 0; i < k; i++){
                String[] s1 = br.readLine().trim().split(" ");
                for(int j = 0; j < 2; j++){
                    blocked_cells[i][j] = Integer.parseInt(s1[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.FindWays(n, m, blocked_cells);
            System.out.println(ans);

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int mod=(int)1e9+7;
    public int FindWays(int n, int m, int[][] blocked_cells)
    {
        // Code here
        int[][] mat=new int[n][m];
        for(int[] a:blocked_cells){
            mat[a[0]-1][a[1]-1]=1;
        }
        if(mat[0][0]==1) return 0;
        int[][] dp=new int[n][m];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return solve(mat,n-1,m-1,dp);
    }
    int solve(int[][] mat,int i,int j,int[][] dp){
        if(i==0 && j==0 && mat[i][j]!=1){
            return 1;
        }
        if(i<0 || j<0) return 0;
        if(mat[i][j]==1) return 0;
        if(dp[i][j]!=-1) return dp[i][j]%mod;
        return dp[i][j]=(solve(mat,i-1,j,dp)%mod+solve(mat,i,j-1,dp)%mod)%mod;
    }
}