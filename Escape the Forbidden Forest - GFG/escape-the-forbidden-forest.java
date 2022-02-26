// { Driver Code Starts
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            String str1 = sc.next();
            String str2 = sc.next();
            Sol obj = new Sol();
            System.out.println(obj.build_bridges(str1,str2));
        }
    }
}// } Driver Code Ends


class Sol
{
    public static int build_bridges(String str1 , String str2)
    {
       int[][] dp=new int[str1.length()+1][str2.length()+1];
       for(int i=dp.length-2;i>=0;i--){
           for(int j=dp[0].length-2;j>=0;j--){
               if(str1.charAt(i)==str2.charAt(j))
                    dp[i][j]=1+dp[i+1][j+1];
                else
                    dp[i][j]=Math.max(dp[i][j+1],dp[i+1][j]);
           }
       }
       return dp[0][0];
    }
}