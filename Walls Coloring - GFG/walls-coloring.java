//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine().trim());
			int [][] colors = new int[N][3];
			for(int i = 0; i < N; i++) {
				String [] str = br.readLine().trim().split(" ");
				colors[i][0] = Integer.parseInt(str[0]);
				colors[i][1] = Integer.parseInt(str[1]);
				colors[i][2] = Integer.parseInt(str[2]);
			}
			Solution obj = new Solution();
			out.println(obj.minCost(colors, N));
		}
		out.close();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minCost(int [][] colors, int N){
        //Write your code here
        int[][] dp=new int[N][4];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return solve(0,colors,3,dp);
    }
    int solve(int i,int[][] colors,int prev,int[][] dp){
        if(i>=colors.length) return 0;
        if(dp[i][prev]!=-1) return dp[i][prev];
        int pink=(int)1e9;
        int black=(int)1e9;
        int yellow=(int)1e9;
        
        if(prev!=0){
            pink=colors[i][0]+solve(i+1,colors,0,dp);
        }
        if(prev!=1){
            black=colors[i][1]+solve(i+1,colors,1,dp);
        }
        if(prev!=2){
            yellow=colors[i][2]+solve(i+1,colors,2,dp);
        }
        return dp[i][prev]=Math.min(pink,Math.min(black,yellow));
    }
}