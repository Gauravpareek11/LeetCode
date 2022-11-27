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
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            String b = input[1];
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String addBinary(String A, String B) {
        // code here
        int i=A.length()-1;
        int j=B.length()-1;
        int rem=0;
        StringBuilder sb=new StringBuilder("");
        while(i>=0 && j>=0){
            int sum=(A.charAt(i)-'0')+(B.charAt(j)-'0')+rem;
            rem=sum/2;
            sb.append(Integer.toString(sum%2));
            i--;
            j--;
        }
        while(i>=0){
            int sum=(A.charAt(i)-'0')+rem;
            rem=sum/2;
            sb.append(Integer.toString(sum%2));
            i--;
        }
        while(j>=0){
            int sum=(B.charAt(j)-'0')+rem;
            rem=sum/2;
            sb.append(Integer.toString(sum%2));
            j--;
        }
        if(rem>0) sb.append(Integer.toString(rem));
        String ans=sb.reverse().toString();
        while(ans.length()>0 && ans.charAt(0)=='0'){
            ans=ans.substring(1);
        }
        return ans;
    }
}