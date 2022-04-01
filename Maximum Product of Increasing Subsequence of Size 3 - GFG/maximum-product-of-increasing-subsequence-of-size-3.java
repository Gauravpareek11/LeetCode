// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int arr [] = new int[N];
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<N;i++){
	            arr[i] = Integer.parseInt(elements[i]);    
	        }
	        
		    Solution obj = new Solution();
		    ArrayList<Integer> ans;
		    ans = obj.maxProductSubsequence(arr, N);
        	if(ans.get(0) == -1)
        	    System.out.println("Not Present");
        	else{
        	    for(int i: ans)
        	        System.out.print(i + " ");
        	    System.out.println();
        	}
        	
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    
   
    public static ArrayList<Integer> maxProductSubsequence (int arr[], int n)
    {
        TreeSet<Integer> set = new TreeSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        int smaller[] = new int[n];
        
        for(int i=0; i<n; i++)
        {
            Integer lower_num = set.lower(arr[i]);
            if(lower_num!=null)
            {
                smaller[i] = lower_num;
            }
            else
            {
                smaller[i] = -1;
            }
            
            set.add(arr[i]);
            
        }
        
        double max_p = 0;
        
        int max_right = 0;
        
        for(int i=n-1; i>=1; i--)
        {
            if(max_right<=arr[i])
            {
                max_right = arr[i];
            }
            else if(smaller[i]!=-1)
            {
                double prod = (double)max_right * (double)arr[i] * (double)smaller[i];
                if(prod>max_p)
                {
                    max_p = prod;
                    ans.clear();
                    ans.add(smaller[i]);
                    ans.add(arr[i]);
                    ans.add(max_right);
                }
            }
            
        }
        
        
        
        if(ans.size()==0) ans.add(-1);
        
        return ans;
        
    }
    
    
}