//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int mod=(int)1e9+7;
    static int uniquePaths(int n, int m, int[][] grid) {
        // code here
        int[][] dp=new int[n][m];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        if(grid[0][0]==0 || grid[grid.length-1][grid[0].length-1]==0) return 0;
        return solve(0,0,grid,dp);
    }
    static int solve(int i,int j,int[][] grid,int[][] dp){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0){
            return 0;
        }
        if(i==grid.length-1 && j==grid[0].length-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int right=solve(i,j+1,grid,dp);
        int down=solve(i+1,j,grid,dp);
        return dp[i][j]=(int)((long)right+(long)down)%mod;
    }
};