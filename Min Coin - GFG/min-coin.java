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
            String S = br.readLine().trim();
            String[] S1 = S.split(" ");
            int n = Integer.parseInt(S1[0]);
            int amount  = Integer.parseInt(S1[1]);
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.MinCoin(nums, amount);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int MinCoin(int[] nums, int amount)
    {
        // Code here
        int[][] dp=new int[nums.length][amount+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return (solve(nums,nums.length-1,amount,dp)>=(int)1e9?-1:solve(nums,nums.length-1,amount,dp));
    }
   static int solve(int[] a,int i,int x,int[][] dp){
        if(i==0){
            // System.out.println(x);
            if(x%a[i]==0) return x/a[i];
            else return (int)1e9;
        }
        if(dp[i][x]!=-1) return dp[i][x];
        int not_pick=solve(a,i-1,x,dp);
        int pick=(int)1e9;
        if(a[i]<=x) pick=1+solve(a,i,x-a[i],dp);
        return dp[i][x]=Math.min(pick,not_pick);
    }
}