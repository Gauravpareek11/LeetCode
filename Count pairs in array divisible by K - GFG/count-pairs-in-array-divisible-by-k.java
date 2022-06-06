// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    int k = Integer.parseInt(br.readLine().trim());
		    
		    Solution ob= new Solution();
		    System.out.println(ob.countKdivPairs(arr, n, k));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static long countKdivPairs(int arr[], int n, int k)
    {
        HashMap<Integer,Integer>m1=new HashMap<>();
        for(int i:arr){
            if(m1.containsKey(i%k)){
                m1.put(i%k,m1.get(i%k)+1);
            }
            else m1.put(i%k,1);
        }
        long ans=0;
        for(int i:arr){
            m1.put(i%k,m1.get(i%k)-1);
            int a=k-(i%k);
            if(a==k) a=0;
            if(m1.containsKey(a)) ans+=m1.get(a);
        }
        return ans;
    }
}