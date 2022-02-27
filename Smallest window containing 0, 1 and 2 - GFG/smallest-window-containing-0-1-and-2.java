// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        int c_0=0;
        int c_1=0;
        int c_2=0;
        int start=0;
        int end=0;
        int ans=Integer.MAX_VALUE;
        while(end<S.length()){
            if(c_0<1 || c_1<1 || c_2<1){
                if(S.charAt(end)=='0')c_0++;
                else if(S.charAt(end)=='1')c_1++;
                else c_2++;
                end++;
            }
            else{
                ans=Math.min(end-start,ans);
                if(S.charAt(start)=='0') c_0--;
                else if(S.charAt(start)=='1')c_1--;
                else c_2--;
                start++;
            }
        }
        end--;
        while(start<end)
        {
            if(c_0>=1 && c_1>=1 && c_2>=1)
            {
                ans=Math.min(end-start+1,ans);
                if(S.charAt(start)=='0') c_0--;
                else if(S.charAt(start)=='1')c_1--;
                else c_2--;
                start++;
            }
            else break;
        }
        return (ans==Integer.MAX_VALUE?-1:ans);
    }
};
