// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public int editDistance(String s, String t) {
        // Code here
        int[][] dp=new int[s.length()][t.length()];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return solve(s.length()-1,t.length()-1,s,t,dp);
    }
    int solve(int i,int j,String s,String t,int[][] dp){
        if(i<0 || j<0){
            return 1+Math.max(i,j);
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=0;
        if(s.charAt(i)==t.charAt(j)){
            ans=solve(i-1,j-1,s,t,dp);
        }
        else{
            int a=1+solve(i-1,j-1,s,t,dp);
            int b=1+solve(i-1,j,s,t,dp);
            int c=1+solve(i,j-1,s,t,dp);
            ans=Math.min(a,Math.min(b,c));
        }
        return dp[i][j]=ans;
    }
}