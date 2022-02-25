// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java

class Solution{
    public static String moveRobots(String s1, String s2){
        //code here
        int count=0;
        for(int i=0;i<s1.length();i++){
            if((s1.charAt(i)=='A' && count!=0) || count<0) return "No";
            if(s1.charAt(i)=='B') count++;
            if(s2.charAt(i)=='B') count--;
        }
        count=0;
        for(int i=s1.length()-1;i>=0;i--){
            if((s1.charAt(i)=='B' && count!=0) || count<0) return "No";
            if(s1.charAt(i)=='A') count++;
            if(s2.charAt(i)=='A') count--;
        }
        return "Yes";
    }
}


// { Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s1=read.readLine();
            String s2=read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.moveRobots(s1, s2));
        }
    }
}  // } Driver Code Ends