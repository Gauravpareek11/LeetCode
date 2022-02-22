// { Driver Code Starts
import java.util.*;
import java.math.*;

class Pair{
    
    int x,y;
    Pair(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
}

class Gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int m = Integer.parseInt(sc.next());
            int n = Integer.parseInt(sc.next());
            char mat[][] = new char[m][n];
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    mat[i][j] = sc.next().charAt(0);
                }
            }
           
            Solution T = new Solution();
            int ans[][] = T.findDistance(mat, m, n);
            
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// class Solution
// {
//     static boolean[][] visited;
//     public static int[][] findDistance(char mat[][], int m,int n)
//     {
//         // Your code goes here
//         int[][] ans=new int[m][n];
//         visited=new boolean[m][n];
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(mat[i][j]=='O'){
//                     System.out.println(solve(mat,i,j));
//                     ans[i][j]=(solve(mat,i,j)>=(int)1e6?-1:solve(mat,i,j));
//                 }
//                 else if(mat[i][j]=='W') ans[i][j]=-1;
//                 else mat[i][j]=0;
//             }
//         }
//         return ans;
//     }
//     static int solve(char mat[][],int m,int n){
//         if(m<0 || n<0 || m>=mat.length || n>=mat.length || mat[m][n]=='W'||
//         visited[m][n]) return (int)1e6+1;
        
//         if(mat[m][n]=='B') return 0;
//         visited[m][n]=true;
//         int up=1+solve(mat,m-1,n);
//         int r=1+solve(mat,m,n+1);
//         int dn=1+solve(mat,m+1,n);
//         int l=1+solve(mat,m,n-1);
//         visited[m][n]=false;
//         int a=Math.min(l,Math.min(r,Math.min(up,dn)));
//         return a;
//     }
    
// }

class ThreePair{
   int row;
   int col;
   int time;
   ThreePair(int row, int col, int time){
       this.row=row;
       this.col=col;
       this.time=time;
   }
}
class Solution
{
   public static int[][] findDistance(char mat[][], int n,int m)
   {
       int[][] ans=new int[n][m];
       Queue<ThreePair> q=new LinkedList<>();
       boolean[][] vis=new boolean[n][m];
       int mx=Integer.MAX_VALUE;
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(mat[i][j]=='W') {
                   ans[i][j]=-1;
                   vis[i][j]=true;
               }
               else if(mat[i][j]=='B') {
                   ans[i][j]=0;
                   q.add(new ThreePair(i,j,0));
                   vis[i][j]=true;
               }
               else ans[i][j]=mx;
           }
       }
       
       while(!q.isEmpty()){
           int k=q.size();
           for(int i=0;i<k;i++){
               ThreePair t=q.poll();
               int a=t.row;
               int b=t.col;
               int c=t.time;
               int[] xidx=new int[]{-1, 0, 1, 0};
               int[] yidx=new int[]{0, 1, 0, -1};
               for(int j=0;j<4;j++){
                   int ni=a+xidx[j];
                   int nj=b+yidx[j];
                   if(ni>=0 && nj>=0
                           && ni<n && nj<m && mat[ni][nj]!=('W'|'B') && vis[ni][nj]==false ){
                       vis[ni][nj]=true;
                       ans[ni][nj]=c+1;
                       q.add(new ThreePair(ni,nj,c+1));
                   }
               }
           }
       }
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(ans[i][j]==mx){
                   ans[i][j]=-1;
               }
           }
       }
       return ans;
   }
}