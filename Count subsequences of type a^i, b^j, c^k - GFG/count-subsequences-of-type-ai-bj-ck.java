// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int t = Integer.parseInt(sc.next());
		
		while(t>0)
		{
		    String s = sc.next();
		    
		    Solution T = new Solution();
		    System.out.println(T.fun(s));
		    
		    t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   public int fun(String s)
   {
       long mod = 1000000007, a=0, ab=0,abc = 0;
       for(char ch:s.toCharArray())
       {
           if(ch == 'a')
               a = (2*a+1)%mod;
           else if(ch == 'b')
               ab = (2*ab+a)%mod;
           else
               abc = (2*abc+ab)%mod;
               
       }
       return (int)abc;
   }
}
    