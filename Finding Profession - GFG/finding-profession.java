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
            String a[] = in.readLine().trim().split("\\s+");
            int level = Integer.parseInt(a[0]);
            int pos = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            if(ob.profession(level, pos) == 'd')
                System.out.println("Doctor");
            else
                System.out.println("Engineer");
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static char profession(int level, int pos){
        // code here
        if(solve(pos)) return 'e';
        return 'd';
    }
    static boolean solve(int pos){
        if(pos==1) return true;
        if(pos==2) return false;
        
        if(pos%2==0) return !solve((int)Math.ceil(pos/2.0));
        else return solve((int)Math.ceil(pos/2.0));
    }
}