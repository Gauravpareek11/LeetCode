//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        int n=nums.length;
        int[] par=new int[n];
        int[] rank=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
        }
        int[][] a=new int[n][2];
        for(int i=0;i<n;i++){
            a[i][0]=nums[i];
            a[i][1]=i;
        }
        Arrays.sort(a,(x,y)->Integer.compare(x[0],y[0]));
        for(int i=0;i<n;i++){
            union(i,a[i][1],rank,par);
        }
        HashSet<Integer>s1=new HashSet<>();
        for(int i=0;i<n;i++){
            s1.add(find_par(i,par));
        }
        // System.out.println(s1.size());
        return n-s1.size();
    }
    int find_par(int v,int[] par){
        if(v==par[v]) return v;
        return find_par(par[v],par);
    }
    void union(int a,int b,int[] rank,int[] par){
        int par_a=find_par(a,par);
        int par_b=find_par(b,par);
        
        if(par_a==par_b) return;
        if(rank[par_a]<rank[par_b]){
            par[par_a]=par_b;
        }
        else if(rank[par_a]>rank[par_b]){
            par[par_b]=par_a;
        }
        else{
            par[par_b]=par_a;
            rank[par_a]+=1;
        }
    }
}