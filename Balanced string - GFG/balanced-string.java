//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Position this line where user code will be pasted.
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.BalancedString(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static String BalancedString(int N) {
        
        int x=N;
        StringBuilder sb=new StringBuilder("");
        while(N>=26){
            int i=0;
            while(i<26){
                sb.append((char)(97+i));
                i++;
            }
            N-=26;
        }
        if(N>0){
            if(N%2==0){
                int beg=(N)/2;
                int end=(N)/2;
                for(int i=0;i<beg;i++){
                    sb.append((char)(97+i));
                }
                for(int i=26-end;i<26;i++){
                    sb.append((char)(97+i));
                }
            }
            else{
                int sum=0;
                int a=x;
                while(a>0){
                    sum+=(a%10);
                    a=a/10;
                }
                int beg=0;
                int end=0;
                if(sum%2==0){
                    beg=(N+1)/2;
                    end=(N-1)/2;
                }
                else{
                    beg=(N-1)/2;
                    end=(N+1)/2;
                }
                for(int i=0;i<beg;i++){
                    sb.append((char)(97+i));
                }
                for(int i=26-end;i<26;i++){
                    sb.append((char)(97+i));
                }
            }
        }
        return sb.toString();
        // code here
    }
}