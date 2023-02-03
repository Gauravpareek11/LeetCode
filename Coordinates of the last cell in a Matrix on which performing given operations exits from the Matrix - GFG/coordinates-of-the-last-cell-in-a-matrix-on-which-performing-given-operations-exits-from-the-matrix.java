//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
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
            out.print("(" +  p[0]+ ", " +  p[1]+ ")" +"\n");
        }
        out.close();
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[] ans;
    static int [] endPoints(int [][]arr, int m, int n){
        //code here
        
        ans=new int[2];
        solve(0,0,0,arr);
        return ans;
    }
    static void solve(int i,int j,int dir,int[][] a){
        if(a[i][j]==0){
            if(dir==0){
                if(j+1==a[0].length){
                    ans[0]=i;
                    ans[1]=j;
                    return;
                }
                else solve(i,j+1,dir,a);
            }
            else if(dir==1){
                if(i+1==a.length){
                    ans[0]=i;
                    ans[1]=j;
                    return;
                }
                else solve(i+1,j,dir,a);
            }
            else if(dir==2){
                if(j-1<0){
                    ans[0]=i;
                    ans[1]=j;
                   return;
                }
                else solve(i,j-1,dir,a);
            }
            else{
                if(i-1<0){
                    ans[0]=i;
                    ans[1]=j;
                    return;
                }
                else solve(i-1,j,dir,a);
            }
        }
        else{
             a[i][j]=0;
            if(dir==0){
                solve(i,j,1,a);
            }
            else if(dir==1){
                solve(i,j,2,a);
            }
            else if(dir==2){
                solve(i,j,3,a);
            }
            else solve(i,j,0,a);
        }
    }
}