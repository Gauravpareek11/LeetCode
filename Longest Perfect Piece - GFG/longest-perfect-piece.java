//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.longestPerfectPiece(arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int longestPerfectPiece(int[] arr, int N) {
        // code here
        int max=arr[0];
        int min=arr[0];
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        PriorityQueue<Integer>pq1=new PriorityQueue<>(Collections.reverseOrder());
        pq.add(arr[0]);
        pq1.add(arr[0]);
        int i=0;
        int j=1;
        int ans=1;
        while(j<N){
            pq1.add(arr[j]);
            pq.add(arr[j]);
            if(pq1.peek()-pq.peek()<=1) ans=Math.max(ans,j-i+1);
            else{
                while(pq1.peek()-pq.peek()>1){
                    pq.remove(arr[i]);
                    pq1.remove(arr[i]);
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
};