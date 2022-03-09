// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int Arr[] = new int[m];
            for (int i = 0; i < m; i++) Arr[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(Arr, m, n));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int S[], int m, int n) {
        // code here.
        long[][] dp=new long[m][n+1];
        for(long[] a:dp){
            Arrays.fill(a,-1);
        }
        return solve(S,n,S.length-1,dp);
        
    }
    long solve(int a[],int target,int i,long[][] dp){
        if(i==0){
            if(target%a[i]==0) return 1;
            else return 0;
        }
        if(dp[i][target]!=-1) return dp[i][target];
        long not_take=solve(a,target,i-1,dp);
        long take=0;
        if(a[i]<=target) take=solve(a,target-a[i],i,dp);
        return dp[i][target]=not_take+take;
    }
}