// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            int numbers[]= new int[N];
            for(int i = 0; i < N; i++)
                numbers[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.countPairs(N, X, numbers); 
            System.out.println(ans);
        }
    } 
} // } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    long countPairs(int N, int X, int numbers[]) 
    { 
        // code here
        String xStr = Integer.toString(X);
        long count = 0;
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int num : numbers)
        {
            String n = Integer.toString(num);
            if(map.containsKey(n))
                map.put(n, map.get(n) + 1);
            else
                map.put(n, 1);
        }
        
        for(String key : map.keySet())
        {
            int currVal = map.get(key);
            
            if(xStr.startsWith(key))
            {
                String temp = xStr.substring(key.length());
                if(map.containsKey(temp))
                {
                    if(temp.equals(key))
                        currVal--;
                    
                    count += map.get(temp) * currVal;
                }
            }
        }
        
        return count;
    }
}