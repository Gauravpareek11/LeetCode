// { Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i]  =Integer.parseInt(S[i]);
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            System.out.println(obj.solveWordWrap(nums, k));
        }
    }
}
// } Driver Code Ends


class Solution
{
    final static int inf=Integer.MAX_VALUE;
    
    public int solveWordWrap (int[] nums, int m)
    {
        
        int n=nums.length;
		int space[][]=new int[n+1][n+1];
		int ls[][]=new int[n+1][n+1];
		int c[]=new int[n+1];
	
		
		for(int i=1;i<=n;i++) {
			space[i][i]=m-nums[i-1];
		
			for(int j=i+1;j<=n;j++) {
				space[i][j]=space[i][j-1]-nums[j-1]-1;
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=i;j<=n;j++) {
				if(space[i][j]<0) {
					ls[i][j]=inf;
				}else if(j==n && space[i][j]>=0) ls[i][j]=0;
				else {
					ls[i][j]=space[i][j]*space[i][j];
				}
			}
		}
		

		c[0] = 0;
        for (int j = 1; j <= n; j++)
        {
            c[j] = inf;
            for (int i = 1; i <= j; i++)
            {        
                if (c[i-1] != inf && ls[i][j] != inf 
                &&(c[i-1] + ls[i][j] < c[j])) {        
                             	
                    c[j] = c[i-1] + ls[i][j];                  
                }
            }
        }
        return c[n];
    }
}