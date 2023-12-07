//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n){
    
        // Your code here
        // int i=0;
        // int ans=0;
        
        // while((1<<i)<=n){
            
        //     int change = 1 << i;
            
        //     boolean check = false;
            
        //     for(int j=0;j<=n;j++){
                
        //         if(check) ans+=1;
                
        //         if(change == 1){
        //             check = !check;
        //             change = 1 << i;
        //         }
        //         else change-- ;
        //     }
        //     i++;
        // }
        // return ans;
        
        if(n<=1) return n;
        
        int x = leftMostBit(n);
        
        return ( x*(int)Math.pow(2,x-1) + (n - (int)Math.pow(2,x) + 1) + countSetBits(n - (int)Math.pow(2,x)));
    }
    static int leftMostBit(int n){
        
        int x = 0;
        while((1<<x)<=n){
            x++;
        }
        return x-1;
        
    }
}

//{ Driver Code Starts.

// Driver code
class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//testcases
		int x, n;
		while(t-->0) {
	        n = sc.nextInt();//input n

		    Solution obj = new Solution();

		    System.out.println(obj.countSetBits(n));//calling countSetBits() method
		}
	}
}

// } Driver Code Ends