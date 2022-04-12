// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}



// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp=new int[n][W+1];
        //  for(int[] a:dp){
        //      Arrays.fill(a,-1);
        //  }
        //  return solve(wt,val,n-1,W,dp);
        for(int i=0;i<=W;i++){
            if(wt[0]<=i) dp[0][i]=val[0];
            else dp[0][i]=0;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=W;j++){
                int not_pick=dp[i-1][j];
                int pick=0;
                if(wt[i]<=j) pick=val[i]+dp[i-1][j-wt[i]];
                dp[i][j]=Math.max(pick,not_pick);
            }
        }
        return dp[n-1][W];
    }
    // static int solve(int wt[],int[] val,int i,int W,int[][] dp){
    //     if(i==0){
    //         if(wt[0]<=W) return val[0];
    //         return 0;
    //     }
    //     if(dp[i][W]!=-1) return dp[i][W];
    //     int not_pick=solve(wt,val,i-1,W,dp);
    //     int pick=0;
    //     if(wt[i]<=W) pick=val[i]+solve(wt,val,i-1,W-wt[i],dp);
    //     return dp[i][W]=Math.max(pick,not_pick);
    // }
}


