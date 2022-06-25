// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int S = Integer.parseInt(input_line[1]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int cap[] = new int[N];
            for(int i=0;i<N;i++){
                cap[i] = Integer.parseInt(input_line1[i]);
            }
            int Edges[][] = new int[N-1][2];
            for(int i=0;i<N-1;i++){
                String input_line2[] = read.readLine().trim().split("\\s+");
                Edges[i][0] = Integer.parseInt(input_line2[0]);
                Edges[i][1] = Integer.parseInt(input_line2[1]);
            }
            Solution ob = new Solution();
            long ans = ob.minimum_amount(Edges, N, S, cap);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends

class Solution{
    long MAX = (long)1e18;
    boolean possible = true;
    
    long minimum_amount(int [][]Edges, int N, int S, int []Cap){
        // Code here
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        boolean [] vis = new boolean[N+1];
        
        for(int [] edge : Edges){
            int u = edge[0];
            int v= edge[1];
            ArrayList<Integer> ne = adj.getOrDefault(u, new ArrayList<Integer>());
            ne.add(v);
            adj.put(u, ne);
            ne = adj.getOrDefault(v, new ArrayList<Integer>());
            ne.add(u);
            adj.put(v, ne);
        }
        
        long temp = dfs(S, adj, Cap, vis);
        
        return ((!possible) || (temp>MAX)) ? -1 : temp;
    }
    
    long dfs(int curr, HashMap<Integer, ArrayList<Integer>> adj, int [] cap, boolean [] vis){
        vis[curr] = true;
        int branches = 0;
        long supply = 0;
        for(int x : adj.get(curr)){
            if(!vis[x]){
                branches++;
                supply = Math.max(supply, dfs(x, adj, cap, vis));
                if(branches * supply > MAX){
                    possible = false;
                    return -1;
                }
            }
        }
        return cap[curr-1] + supply*branches;
    }
    
}