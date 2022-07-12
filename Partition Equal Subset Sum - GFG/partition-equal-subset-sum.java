// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        if((sum&1)==1) return 0;
        else 
        {
            int[][] dp=new int[N][sum/2+1];
            for(int[] a:dp){
                Arrays.fill(a,-1);
            }
            return solve(0,arr,sum/2,dp);
        }
    }
    static int solve(int i,int[] arr,int sum,int[][] dp){
        if(sum==0) return 1;
        if(i==arr.length) return 0;
        
        if(dp[i][sum]!=-1) return dp[i][sum];
        int not_pick=solve(i+1,arr,sum,dp);
        int pick=0;
        if(arr[i]<=sum) pick=solve(i+1,arr,sum-arr[i],dp);
        return dp[i][sum]=Math.max(pick,not_pick);
    }
}