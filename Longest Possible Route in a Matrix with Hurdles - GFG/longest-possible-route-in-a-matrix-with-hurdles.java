// { Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 2);
            
            
            int[] b = IntArray.input(br, 4);
            
            
            int[][] mat = IntMatrix.input(br, a[0], a[1]);
            
            Solution obj = new Solution();
            int res = obj.longestPath(mat,a[0],a[1],b[0],b[1],b[2],b[3]);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int longestPath(int[][] mat,int n,int m,int xs,int ys,int xd,int yd) {
        // code here
        boolean[][] vis=new boolean[n][m];
        int a=solve(mat,xs,ys,xd,yd,vis);
        if(a>0) return a;
        return -1;
    }
    static int solve(int[][] mat,int x,int y,int xd,int yd,boolean[][] vis){
        if(x==xd && y==yd){
            if(mat[x][y]==0) return (int)-1e6;
            return 0;
        }
        if(x<0||y<0||x>=mat.length||y>=mat[0].length||mat[x][y]==0||vis[x][y])
            return (int)-1e6;
            
       vis[x][y]=true;
       int a=1+solve(mat,x+1,y,xd,yd,vis);
       int b=1+solve(mat,x,y+1,xd,yd,vis);
       int c=1+solve(mat,x-1,y,xd,yd,vis);
       int d=1+solve(mat,x,y-1,xd,yd,vis);
       vis[x][y]=false;
       return Math.max(Math.max(a,b),Math.max(c,d));
    }
}
        
