//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>(N);
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(str[i]));
			}
			Solution obj = new Solution();
			System.out.println(obj.maxCoins(N, arr));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int maxCoins(int N, ArrayList<Integer> arr) {
        arr.add(0,1);
        arr.add(1);
		//Write your code here
		int[][] dp=new int[arr.size()][arr.size()];
		for(int[] a:dp){
		    Arrays.fill(a,-1);
		}
		return solve(1,N,arr,dp);
	}
	
    int solve(int i,int j,ArrayList<Integer>l1,int[][] dp){
        if(i>j) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        int max=0;
        for(int k=i;k<=j;k++){
            int steps=l1.get(i-1)*l1.get(k)*l1.get(j+1)+solve(i,k-1,l1,dp)+solve(k+1,j,l1,dp);
            max=Math.max(max,steps);
        }
        return dp[i][j]=max;
    }
}