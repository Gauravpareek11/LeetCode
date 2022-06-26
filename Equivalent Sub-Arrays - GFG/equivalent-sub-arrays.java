// { Driver Code Starts
//Initial Template for Java


//Initial Template for Java


import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


 
class Solution
{ 
    // Method to calculate distinct sub-array 
    static int countDistinctSubarray(int arr[], int n) 
    {
        HashSet<Integer>s1=new HashSet<>();
        for(int i=0;i<n;i++){
            s1.add(arr[i]);
        }
        HashMap<Integer,Integer>m1=new HashMap<>();
        int i=0;
        int j=0;
        int ans=0;
        HashSet<Integer>s2=new HashSet<>();
        while(j<n){
            m1.put(arr[j],m1.getOrDefault(arr[j],0)+1);
            s2.add(arr[j]);
            if(s2.size()==s1.size()){
                while(s2.size()==s1.size())
                {ans+=n-j;
                m1.put(arr[i],m1.get(arr[i])-1);
                if(m1.get(arr[i])==0) s2.remove(arr[i]);
                i++;}
            }
            j++;
        }
        return ans;
    }
}


// { Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    int n=Integer.parseInt(br.readLine());
		    String line1 = br.readLine();
		    String[] a1 = line1.trim().split("\\s+");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Integer.parseInt(a1[i]);
		    }
		    Solution ob=new Solution();
		    int ans=ob.countDistinctSubarray(a,n);
		    System.out.println(ans);
		    
		}
	}
}
  // } Driver Code Ends