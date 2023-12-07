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
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        List<String>ans = new ArrayList<>();
       for(int i=0;i<(1<<s.length());i++){
           
           StringBuilder sb = new StringBuilder("");
           
           for(int j=0;j<s.length();j++){
               if((i & (1<<j)) > 0) sb.append(s.charAt(j));
           }
           
           if(sb.length()>=1) ans.add(sb.toString());
       }
      Collections.sort(ans);
      return ans;
    }
}