// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    ans++;
                    dfs(i,j,grid,visited);
                }
            }
        }
       return ans;
    }
    void dfs(int i,int j,char[][] grid,boolean[][] visited){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0') return;
        
        visited[i][j]=true;
        if(isSafe(i+1,j,grid,visited)) dfs(i+1,j,grid,visited);
        if(isSafe(i-1,j,grid,visited)) dfs(i-1,j,grid,visited);
        
        if(isSafe(i,j+1,grid,visited)) dfs(i,j+1,grid,visited);
        if(isSafe(i,j-1,grid,visited)) dfs(i,j-1,grid,visited);
        
        if(isSafe(i+1,j+1,grid,visited)) dfs(i+1,j+1,grid,visited);
        if(isSafe(i+1,j-1,grid,visited)) dfs(i+1,j-1,grid,visited);
        
        if(isSafe(i-1,j+1,grid,visited)) dfs(i-1,j+1,grid,visited);
        if(isSafe(i-1,j-1,grid,visited)) dfs(i-1,j-1,grid,visited);
    }
    boolean isSafe(int i,int j,char[][] grid,boolean[][] visited){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0'
        || visited[i][j]) return false;
        return true;
    }
}