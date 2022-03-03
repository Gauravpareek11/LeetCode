// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            Solution obj = new Solution();
            int[] p = obj.endPoints(matrix,r,c);
            System.out.print("(" +  p[0]+ ", " +  p[1]+ ")" +"\n");
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int [] endPoints(int [][]arr, int m, int n){
        //code here
        int[] ans=new int[2];
        int i=0;
        int j=0;
        char d='r';
        while(i<m && j<n && i>=0 && j>=0){
            if(arr[i][j]==0){
                if(d=='r') j++;
                if(d=='d') i++;
                if(d=='l') j--;
                if(d=='u') i--;
            }
            else{
                arr[i][j]=0;
                if(d=='r'){
                    i++;
                    d='d';
                }
                else if(d=='d'){
                    j--;
                    d='l';
                }
                else if(d=='l'){
                    i--;
                    d='u';
                }
                else if(d=='u'){
                    j++;
                    d='r';
                }
            }
        }
        if(i==-1) i=0;
        if(i==m) i=i-1;
        if(j==-1) j=0;
        if(j==n) j=j-1;
        ans[0]=i;
        ans[1]=j;
        return ans;
    }
}