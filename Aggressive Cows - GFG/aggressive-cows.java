//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        int low=0;
        int high=(int)1e9;
        Arrays.sort(stalls);
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(check(mid,stalls,k)){
                ans=mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        return ans;
    }
    static boolean check(int mid,int[] stalls,int k){
        int c=1;
        int prev=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-prev>=mid){
                prev=stalls[i];
                c++;
            }
        }
        return c>=k;
    }
}