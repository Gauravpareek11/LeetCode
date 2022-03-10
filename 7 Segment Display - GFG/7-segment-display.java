// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.sevenSegments(S,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static String sevenSegments(String S, int N)
    {
        // code here
        int segments[] = {6, 2, 5, 5, 4, 5, 6, 3, 7, 5};
        
        int total_segments = 0;
        for(int i=0; i<N; i++)
        {
            int ch = S.charAt(i)-'0';
            total_segments += segments[ch];
        }
        
        int a[] = new int[N];
        
        for(int i=0; i<N; i++)
        {
            a[i] = 2;
            total_segments-=2;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(6, 0);
        map.put(2, 1);
        map.put(5, 2);
        map.put(4, 4);
        map.put(3, 7);
        map.put(7, 8);
        
        
        int i = 0;
        
        while(total_segments>=4 && i<N)
        {
            a[i++] += 4;
            total_segments -= 4;
        }
        
        int j = N-1;
        
        while(total_segments>0 && j>=0)
        {
            int res = 7-a[j];
            int min_val = Math.min(total_segments, res);
            a[j] += min_val;
            total_segments -= min_val;
            j--;
        }
        
        StringBuilder ans = new StringBuilder();
        
        for(int x : a)
        {
            ans.append(map.get(x));
        }
        
        
        return ans.toString();
        
        
    }
};