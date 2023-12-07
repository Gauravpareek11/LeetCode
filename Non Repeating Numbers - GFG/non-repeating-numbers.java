//{ Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // Code here
        int xor = 0;
        
        for(int i:nums){
            xor^=i;
        }
        xor = (xor & ~(xor-1));   //getting rightmost set bit
        
        int num1 = 0;
        
        int num2 =0;
        
        for(int i:nums){
            if((xor & i) >0){
                num1^=i;
            }
            else {
                num2^=i;
            }
        }
        int [] ans = new int[]{num1,num2};
        Arrays.sort(ans);
        return ans;
    }
}