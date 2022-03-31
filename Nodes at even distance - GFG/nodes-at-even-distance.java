// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            for(int i = 0; i <= n; i++) {
            	graph.add(new ArrayList<>());
            }
            
            int temp = n;
            while(temp-- > 1){
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            Solution ob = new Solution();
            System.out.println(ob.countOfNodes(graph, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int countOfNodes(ArrayList<ArrayList<Integer>> graph, int n) 
    {
        // Write your code here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<=n;i++){
            for(int j:graph.get(i)){
                adj.get(i).add(j);
            }
        }
        boolean visited[]=new boolean[n+1];
        int count[] =new int[2];
        solve(1,0,visited,adj,count);
        // System.out.println(Arrays.toString(count));
        int ans=count[0]*(count[0]-1)/2;
        ans+=count[1]*(count[1]-1)/2;
        return ans;
    }
    void solve(int node,int dis,boolean[] visited,ArrayList<ArrayList<Integer>>adj,int[] count){
        visited[node]=true;
        if(dis%2==0) count[0]++;
        else count[1]++;
        for(int i:adj.get(node)){
            if(!visited[i]) solve(i,dis+1,visited,adj,count);
        }
    }
}