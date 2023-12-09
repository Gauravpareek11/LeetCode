//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            ArrayList<Integer>ans=obj.longestIncreasingSubsequence(N, arr);
            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public ArrayList<Integer> longestIncreasingSubsequence(int N, int arr[]){
        // Code here
        
        int[] dp = new int[N];
        int[] par = new int[N];
        
        for(int i=0;i<N;i++){
            dp[i]=1;
            par[i]=i;
        }
        int max=0;
        int maxi=0;
        for(int i=0;i<N;i++){
            
            for(int j=0;j<i;j++){
                
                if(arr[i]>arr[j]){
                    
                    if(dp[i] < 1+dp[j]){
                        par[i] = j;
                        dp[i] = 1+dp[j];
                    }
                }
            }
            if(dp[i]>max){
                max = dp[i];
                maxi = i;
            }
        }
        
        ArrayList<Integer>ans = new ArrayList<>();
        
        while(par[maxi]!=maxi){
            ans.add(arr[maxi]);
            maxi = par[maxi];
        }
        ans.add(arr[maxi]);
        
        Collections.reverse(ans);
        return ans;
    }
}
