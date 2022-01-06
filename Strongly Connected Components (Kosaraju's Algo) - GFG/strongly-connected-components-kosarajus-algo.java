// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        boolean[] vis=new boolean[V];
        Stack<Integer>s1=new Stack<>();
        for(int i=0;i<V;i++){
            if(!vis[i]) dfs(i,adj,vis,s1);
        }
        ArrayList<ArrayList<Integer>>dummy=new ArrayList<>();
        for(int i=0;i<V;i++){
            dummy.add(new ArrayList<Integer>());
        }
        for(int i=0;i<V;i++){
            vis[i]=false;
            for(int j:adj.get(i)){
                dummy.get(j).add(i);
            }
        }
        // System.out.println(s1.peek());
        // System.out.println(dummy);
        // System.out.println(Arrays.toString(vis));
        int count=0;
        while(!s1.isEmpty()){
            int i=s1.pop();
            if(!vis[i]){
                dfs1(i,dummy,vis);
                count++;
            }
        }
        return count;
    }
    void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis,Stack<Integer>s1){
        vis[node]=true;
        for(int i:adj.get(node)){
            if(!vis[i]){
                // vis[i]=true;
                dfs(i,adj,vis,s1);
            }
        }
        s1.push(node);
    }
   void dfs1(int node,ArrayList<ArrayList<Integer>>dummy,boolean[] vis){
       vis[node]=true;
       for(int i:dummy.get(node)){
           if(!vis[i]) dfs1(i,dummy,vis);
       }
   }
}
