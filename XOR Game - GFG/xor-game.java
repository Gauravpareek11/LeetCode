// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.xorCal(k));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int xorCal(int k){
        if(k==1) return 2;
        k=k+1;
        double a=Math.log(k)/Math.log(2);
        if(a==(int)a) return (int)Math.pow(2,a-1)-1;
        else return -1;
    }
}