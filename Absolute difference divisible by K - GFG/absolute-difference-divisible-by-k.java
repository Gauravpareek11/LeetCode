//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException {
		BufferedReader read =
		new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(read.readLine());
			String S[] = read.readLine().split(" ");
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(S[i]);
			int k = Integer.parseInt(read.readLine());

			Solution ob = new Solution();
			System.out.println(ob.countPairs(n, arr, k));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution {
	static long countPairs(int n, int[] arr, int k) {
		// code here
		HashMap<Integer,Integer>m1=new HashMap<>();
		for(int i:arr){
		    m1.put(i%k,m1.getOrDefault(i%k,0)+1);
		}
		long ans=0;
		for(int i:m1.keySet()){
		    ans+=((long)m1.get(i)*(long)(m1.get(i)-1))/(long)2;
		}
		return ans;
	}
}