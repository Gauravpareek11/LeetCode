// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int[][] dp=new int[N][N];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return solve(0,N-1,arr,dp);
    }
    static int solve(int i,int j,int[] arr,int[][] dp){
        if(i>=j-1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int s=arr[i]*arr[k]*arr[j]+solve(i,k,arr,dp)+solve(k,j,arr,dp);
            min=Math.min(min,s);
        }
        return dp[i][j]=min;
    }
}