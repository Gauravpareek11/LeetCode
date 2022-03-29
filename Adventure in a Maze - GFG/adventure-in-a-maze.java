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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int[] ans = obj.FindWays(matrix);
            for(int i = 0; i < ans.length; i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println();

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int mod=(int)1e9+7;
    public int[] FindWays(int[][] matrix)
    {
        // Code here
        int[][] dp1=new int[matrix.length][matrix.length];
        int[][] dp2=new int[matrix.length][(int)1e5];
        for(int[] a:dp1){
            Arrays.fill(a,-1);
        }
        for(int[] b:dp2){
            Arrays.fill(b,-1);
        }
        int[] ans=new int[2];
        ans[0]=solve(0,0,matrix,dp1)%mod;
        ans[1]=Math.max(0,max(0,0,matrix,dp2));
        return ans;
        
    }
    int solve(int i, int j,int[][] matrix,int[][] dp){
        if(i==matrix.length-1 && j==matrix.length-1) return 1;
        if(i>=matrix.length || j>=matrix.length) return 0;
        int count=0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(matrix[i][j]==1)  count=solve(i,j+1,matrix,dp)%mod;
        else if(matrix[i][j]==2)  count=solve(i+1,j,matrix,dp)%mod;
        else{
             count=(solve(i,j+1,matrix,dp)%mod+solve(i+1,j,matrix,dp)%mod)%mod;
        }
        return dp[i][j]=count;
    }
    int max(int i,int j,int[][] matrix,int[][] dp){
        if(i==matrix.length-1 && j==matrix.length-1) return matrix[i][j];
        if(i>=matrix.length || j>=matrix.length) return (int)-1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=0;
        if(matrix[i][j]==1) ans= matrix[i][j]+max(i,j+1,matrix,dp);
        else if(matrix[i][j]==2) ans= matrix[i][j]+max(i+1,j,matrix,dp);
        else{
            ans= matrix[i][j]+Math.max(max(i,j+1,matrix,dp),max(i+1,j,matrix,dp));
        }
        return dp[i][j]=ans;
    }
}