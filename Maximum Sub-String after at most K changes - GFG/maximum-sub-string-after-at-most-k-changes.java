//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.characterReplacement(s, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int characterReplacement(String s, int k)
    {
        // code here
        HashMap<Character,Integer>m1=new HashMap<>();
        // int i=0;
        int j=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            m1.put(s.charAt(i),m1.getOrDefault(s.charAt(i),0)+1);
            int x=count(m1);
            if(x<=k){
                ans=Math.max(ans,i-j+1);
            }
            else{
                if(m1.get(s.charAt(j))==1) m1.remove(s.charAt(j));
                else m1.put(s.charAt(j),m1.get(s.charAt(j))-1);
                j++;
            }
        }
        // while(j<s.length()){
        //     m1.put(s.charAt(j),m1.getOrDefault(s.charAt(j),0)+1);
        //     int x=count(m1);
        //     if(x>k){
        //         ans=Math.max(j-i,ans);
        //         while(i<j){
        //             if(m1.get(s.charAt(i))==1) m1.remove(s.charAt(i));
        //             else m1.put(s.charAt(i),m1.get(s.charAt(i))-1);
        //             int y=count(m1);
        //             i++;
        //             if(y<=k) break;
        //         }
        //     }
        //     j++;
        // }
        // ans=Math.max(ans,j-i);
        return ans;
    }
    int count(HashMap<Character,Integer>m1){
        int max=0;
        int sum=0;
        for(char i:m1.keySet()){
            max=Math.max(max,m1.get(i));
            sum+=m1.get(i);
        }
        return sum-max;
    }
}