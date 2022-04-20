// { Driver Code Starts
//Initial Template for Java

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
            String s1 = br.readLine().trim();
            String []S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            long C = Long.parseLong(S1[1]);
            String s2 = br.readLine().trim();
            String []S2 = s2.split(" ");
            long [] w = new long[n];
            long [] p = new long[n];
            for(int i = 0; i < n; i++){
                w[i] = Long.parseLong(S2[2*i]);
                p[i] = Long.parseLong(S2[(2*i)+1]);
            }
            Solution ob = new Solution();
            double ans = ob.maximumProfit(n, C, w, p);
            String a1 = String.format("%.3f",ans);
            System.out.println(a1);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class pair{
    long profit;
    long wt;
    double ratio;
    pair(long profit,long wt,double ratio){
        this.profit=profit;
        this.wt=wt;
        this.ratio=ratio;
    }
}
class Solution
{
    public double maximumProfit(int N, long C, long w[], long p[])
    {
        // Code here
        pair[] a=new pair[N];
        for(int i=0;i<N;i++){
            double x=p[i]/(double)w[i];
            a[i]=new pair(p[i],w[i],x);
        }
        Arrays.sort(a,(x,y)->Double.compare(y.ratio,x.ratio));
        double ans=0;
        for(int i=0;i<N;i++){
            long x=a[i].wt;
            long y=(long)Math.sqrt(a[i].wt);
            if(y*y==x) continue;
            else if(C>=a[i].wt){
                ans+=a[i].profit;
                C-=a[i].wt;
            }
            else if(C>0){
                ans+=(C*a[i].ratio);
                C=0;
                break;
            }
        }
        return ans;
    }
}