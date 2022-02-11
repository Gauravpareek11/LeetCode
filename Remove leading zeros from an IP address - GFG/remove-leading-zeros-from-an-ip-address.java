// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.newIPAdd(s));
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String newIPAdd(String S)
    {
        String[] in=S.split("[.]");
        for(int i=0;i<in.length;i++){
            String a =in[i];
            while(a.length()>1 && a.charAt(0)=='0'){
                a=a.substring(1);
            }
           in[i]=a; 
        }
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<in.length;i++){
            sb.append(in[i]);
            if(i!=in.length-1) sb.append('.');
        }
        return sb.toString();
    }
}