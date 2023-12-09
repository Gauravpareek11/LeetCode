//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
        // int[][] dp = new int[a.length][a.length+1];
        // for(int[] arr:dp){
        //     Arrays.fill(arr,-1);
        // }
        // return solve(0,a,-1,dp);
        
        ArrayList<Integer>l1 = new ArrayList<>();
        l1.add(a[0]);
        for(int i=1;i<size;i++){
            
            if(a[i] > l1.get(l1.size()-1)) l1.add(a[i]);
            else{
                int index = search(l1,a[i]);
                l1.set(index,a[i]);
            }
        }
        return l1.size();
        
    }
    static int search(ArrayList<Integer>l1,int x){
        int low = 0;
        int high = l1.size() -1;
        while(low<=high){
            
            int mid = low + (high-low)/2;
            if(l1.get(mid)<x) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
    // static int solve(int i,int[] a,int prev,int[][] dp){
    //     if(i>=a.length) return 0;
        
    //     if(dp[i][prev+1] != -1) return dp[i][prev+1];
    //     int not_pick = solve(i+1,a,prev,dp);
        
    //     int pick = 0;
        
    //     if(prev == -1 || a[i]>a[prev]) pick = 1+solve(i+1,a,i,dp);
        
    //     return dp[i][prev+1]=Math.max(pick,not_pick);
    // }
} 