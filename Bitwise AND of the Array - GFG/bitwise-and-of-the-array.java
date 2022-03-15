// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            int ans = ob.count(N, A, X); 
            System.out.println(ans);
        }
    } 
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int count(int N, int A[], int X) 
    {   
        int mask=0;
        int ans=N;
        for(int i=30;i>=0;i--){
            if(((X>>i)&1)==1){
                mask^=(1<<i);
                continue;
            }
            int alt_mask=mask^(1<<i);
            int cnt=0;
            for(int j:A){
                if((j&alt_mask)==alt_mask) cnt++;
            }
            ans=Math.min(ans,N-cnt);
        }
        return ans;
    }
} 