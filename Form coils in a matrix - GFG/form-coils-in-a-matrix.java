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
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            int[][] ptr = ob.formCoils(n);
            
            for(int i=0; i<2; i++)
            {
                for(int j=0; j<ptr[i].length; j++)
                {
                    System.out.print(ptr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[][] formCoils(int n) {
        // code here
         int m = 8 * n * n;
    
        // Let us fill elements in coil 1.
        int coil1[] = new int[m];
    
        // First element of coil1
        // 4*n*2*n + 2*n;
        coil1[0] = 8 * n * n + 2 * n;
        int curr = coil1[0];
    
        int nflg = 1, step = 2;
    
        // Fill remaining m-1 elements in coil1[]
        int index = 1;
        while (index < m)
        {
            // Fill elements of current step from
            // down to up
            for (int i = 0; i < step; i++) 
                {
                    // Next element from current element
                    curr = coil1[index++] = (curr - 4 * n * nflg);
                    if (index >= m)
                    break;
                }
            if (index >= m)
                break;
        
            // Fill elements of current step from
            // up to down.
            for (int i = 0; i < step; i++) 
            {
                curr = coil1[index++] = curr + nflg;
                if (index >= m)
                break;
            }
            
            nflg = nflg * (-1);
            step += 2;
        }
    
        /* get coil2 from coil1 */
        int coil2[] = new int[m];
        for (int i = 0; i < 8 * n * n; i++)
            coil2[i] = 16 * n * n + 1 - coil1[i];
        int[][] ans=new int[2][m];
        ans[0]=coil1;
        ans[1]=coil2;
        return ans;
    }
}