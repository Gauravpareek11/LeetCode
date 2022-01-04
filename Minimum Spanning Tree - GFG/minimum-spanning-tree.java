// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        int[] key=new int[V];
        boolean[] mst=new boolean[V];
        int parent[]=new int[V];
        Arrays.fill(key,Integer.MAX_VALUE);
        Arrays.fill(parent,-1);
        key[0]=0;
        mst[0]=true;
        // int i=0;
        // System.out.println(adj);
        for(int i=0;i<V-1;i++){
            int min=Integer.MAX_VALUE;
            int j=0;
            for(int v=0;v<V;v++){
                if(!mst[v] && key[v]<min){
                    min=key[v];
                    j=v;
                }
            }
            mst[j]=true;
            for(ArrayList<Integer>l1:adj.get(j)){
                if(!mst[l1.get(0)] && l1.get(1)<key[l1.get(0)]){
                    key[l1.get(0)]=l1.get(1);
                    parent[l1.get(0)]=j;
                }
            }
        }
        int w=0;
        for(int k:key){
            w+=k;
        }
        return w;
    }
}
