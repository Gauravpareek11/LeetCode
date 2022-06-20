// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.posIntSol(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long posIntSol(String s)
    {
        int n =0 ;
        int k =0;
        int f=-1;
        for(int i = 0; i < s.length();i++)
        {
            if(s.charAt(i)=='+')
            n++;
            if(s.charAt(i)=='=')
            f=i;
        }
      
        String a = s.substring(f+1);
          //cout<<a<<endl;
        k = Integer.parseInt(a);
        n=n+1;
        if(n>k)
        return 0;
        if(n==k)
        return 1;
    
        return calculate(n,k);
    }
    long calculate(int n ,int k)
    {
        if(k==0 && n==0)
        return 1;
        if(n==0)
        return 0;
        if(k<=0)
        return 0;
        long ans =0;
        for(int i = 1 ; i <=k ; i++)
        {
            ans = ans+ calculate(n-1,k-i);
        }
        return ans;
    }
}