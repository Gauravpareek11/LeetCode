//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            out.println(ob.minVal(a, b));
        }
        out.flush();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int minVal(int a, int b) {
        int a1=a;
        // code here
        int[] c=new int[32];
        int i=31;
        while(a>0){
            if((a&1)==1) c[i]=1;
            i--;
            a=a>>1;
        }
        int count=0;
        while(b>0){
            if((b&1)==1) count++;
            b=b>>1;
        }
        for(i=0;i<32;i++){
            if(c[i]==1) {
                c[i]=-1;
                count--;
            }
            if(count==0) break;
        }
        if(count>0){
            for(i=31;i>=0;i--){
                if(c[i]==0){
                    c[i]=1;
                    count--;
                }
                if(count==0) break;
            }
        }
        int ans=0;
        int x=1;
        for(i=31;i>=0;i--){
            if(c[i]==1){
                ans+=x;
            }
            x=x<<1;
        }
        return ans^a1;
    }
}