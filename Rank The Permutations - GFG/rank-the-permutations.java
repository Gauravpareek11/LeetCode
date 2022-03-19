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
            String str = br.readLine().trim();
            Solution obj = new Solution();
            long ans = obj.findRank(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    long fact(int n){
        long ans = 1;
        for(int i=2;i<=n;i++) ans *= i;
        return ans;
    }
    
    public long findRank(String s){
        // Code here
        boolean arr[] = new boolean[26];
        for(int i=0;i<s.length();i++) arr[s.charAt(i)-'a'] = true;
        long ans = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int count = 0;
            for(int j=ch-'a'-1;j>=0;j--) if(arr[j]) count++;
            arr[ch-'a'] = false;
            ans += count*fact(s.length()-i-1);
        }
        return ans+1;
    }
}
