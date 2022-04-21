// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            String S = br.readLine();
            Solution ob = new Solution();
            System.out.println(ob.remove(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    String remove(String s) {
       StringBuilder ans=new StringBuilder();
       int i=0;
       int n=s.length();
       boolean flag=false;
       while(i<n){
           if(i<n-1 && s.charAt(i)==s.charAt(i+1)){
               while(i<n-1 && s.charAt(i)==s.charAt(i+1)){
                   i++;
                   flag=true;
               }
           }
           else{
               ans.append(s.charAt(i));
           }
           i++;
       }
       if(ans.length()!=0 && flag==true){
           return remove(ans.toString());
       }
       return ans.toString();
   }
    
}