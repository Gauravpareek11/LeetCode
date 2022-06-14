// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            
            System.out.println(new Solution().findNum(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findNum(int n)
    {
        // Complete this function
        int low=0;
        int high=n*5;
        int x=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(check(mid,n)){
                x=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return x;
    }
    boolean check(int mid,int n){
        int a=5,count=0;
        while(a<=mid){
            count+=mid/a;
            a=a*5;
        }
        return(count>=n);
    }
}