// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    ArrayList<Integer> A = new ArrayList<Integer>();
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		        A.add(arr[i]);
		        
		    }
		   
		   
		    
		    ArrayList <ArrayList<Integer>> res = new Solution().subsets(A);
		    for (int i = 0; i < res.size (); i++)
		    {
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		          System.out.print(res.get(i).get(j)+" ");
		        }
		        System.out.println();
		      
		    }
		    //System.out.println();
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
   public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A)
   {
       //code here
       ArrayList<ArrayList<Integer>> res = new ArrayList<>();
       
       ArrayList<Integer> empty = new ArrayList<>();
       res.add(empty);
       
       for(int i=0; i<A.size(); i++)
       {
           ArrayList<Integer> temp = new ArrayList<>();
           
           int ele = A.get(i);
           
           int size = res.size();
           for(int j=1; j<size; j++)
           {
               ArrayList<Integer> tt = (ArrayList)res.get(j).clone();
               tt.add(ele);
               res.add(tt);
           }
           
           temp.add(ele);
           res.add(temp);
           
       }
       
       Collections.sort(res, new MIN());
       
       return res;
   }
   
   static class MIN implements Comparator<ArrayList<Integer>>
   {
       public int compare(ArrayList<Integer> a,ArrayList<Integer> b)
       {
           for(int i=0;i<Math.min(a.size(),b.size());i++)
           {
               if(a.get(i)>b.get(i)) return 1;
               else if(a.get(i)<b.get(i)) return -1;
               else continue;
           }
           return a.size()-b.size();
       }
   }
   
}