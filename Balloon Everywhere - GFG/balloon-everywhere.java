//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.maxInstance(s);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxInstance(String s) {
        // Code here
        HashMap<Character,Integer>m1=new HashMap<>();
        for(int i=0;i<s.length();i++){
            m1.put(s.charAt(i),m1.getOrDefault(s.charAt(i),0)+1);
        }
        String s1="balloon";
        int min=Integer.MAX_VALUE;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)=='l' || s1.charAt(i)=='o')
                min=Math.min(min,m1.getOrDefault(s1.charAt(i),0)/2);
            else min=Math.min(min,m1.getOrDefault(s1.charAt(i),0));
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}