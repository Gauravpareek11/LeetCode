class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int ans=0;
        for(int i=0;i<visited.length;i++){
            for(int j=0;j<visited[0].length;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    solve(grid,visited,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
    void solve(char[][] grid,boolean[][] visited,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0') return;
        visited[i][j]=true;
        if(i+1<grid.length && grid[i+1][j]=='1' && !visited[i+1][j]) solve(grid,visited,i+1,j);
        if(i-1>=0 && grid[i-1][j]=='1' && !visited[i-1][j]) solve(grid,visited,i-1,j);
        if(j-1>=0 && grid[i][j-1]=='1' && !visited[i][j-1]) solve(grid,visited,i,j-1);
        if(j+1<grid[0].length && grid[i][j+1]=='1' && !visited[i][j+1]) solve(grid,visited,i,j+1);
    }
}