//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] H = new int[N];
            
            for(int i=0; i<N; i++)
                H[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            out.println(ob.removeStudents(H,N));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int removeStudents(int[] H, int N) {
        // code here
        ArrayList<Integer>l1=new ArrayList<>();
        for(int i=0;i<N;i++){
            int x=solve(l1,H[i]);
            if(x>=l1.size()) l1.add(H[i]);
            else l1.set(x,H[i]);
        }
        return N-l1.size();
    }
    int solve(ArrayList<Integer>l1,int x){
        int low=0;
        int high=l1.size()-1;
        int ans=high+1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(l1.get(mid)<x) low=mid+1;
            else{
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
    }
};