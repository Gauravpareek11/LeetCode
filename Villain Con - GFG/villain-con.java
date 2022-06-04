// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int M = Integer.parseInt(a[1]);
            int mat[][] = new int[M][2];
            for(int i = 0;i < M;i++){
                String a1[] = in.readLine().trim().split("\\s+");
                mat[i][0] = Integer.parseInt(a1[0]);
                mat[i][1] = Integer.parseInt(a1[1]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.minColour(N, M, mat));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minColour(int N, int M, int mat[][]) {
        // code here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<=N;i++){
            adj.add(new ArrayList<Integer>());
        }
        int[] in=new int[N+1];
        for(int[]a:mat){
            adj.get(a[0]).add(a[1]);
            in[a[1]]++;
        }
        boolean vis[]=new boolean[N+1];
        int max=0;
        int[] c=new int[N+1];
        for(int i=1;i<=N;i++){
            if(in[i]==0){
                max=Math.max(max,dfs(i,adj,vis,c));
            }
        }
        return max;
    }
    static int dfs(int i,ArrayList<ArrayList<Integer>>adj,boolean[] vis,int[] c){
        vis[i]=true;
        int max=0;
        for(int node:adj.get(i)){
            int d=0;
            if(!vis[node]) d=dfs(node,adj,vis,c);
            else d=c[node];
            max=Math.max(max,d);
        }
        c[i]=max+1;
        return c[i];
    }
}