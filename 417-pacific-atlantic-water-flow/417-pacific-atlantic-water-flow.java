class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                boolean[][] vis=new boolean[heights.length][heights[0].length];
                boolean[] t=new boolean[3];
                if(i==0 || j==0) t[0]=true;
                if(i==heights.length-1 || j==heights[0].length-1) t[1]=true;
                dfs(i,j,heights,vis,t);
                if(t[2]==true || (t[0]==true && t[1]==true)){
                    List<Integer>l1=new ArrayList<Integer>();
                    l1.add(i);
                    l1.add(j);
                    ans.add(l1);
                }
            }
        }
        return ans;
    }
    void dfs(int i,int j,int[][] a,boolean[][] vis,boolean[] t){
        if(i<0 || j<0 || i>a.length-1 || j>a[0].length-1) {
            return;
        }
        if(i==0 || j==0) {
            t[0]=true;
        }
        if(i==a.length-1 || j==a[0].length-1) {
            t[1]=true;
        }
        vis[i][j]=true;
        
        // int l=0;
        // int u=0;
        // int d=0;
        // int r=0;
        if(j-1>=0 && !vis[i][j-1] && a[i][j-1]<=a[i][j]) dfs(i,j-1,a,vis,t);
        if(j+1<=a[0].length-1 && !vis[i][j+1] && a[i][j+1]<=a[i][j]) dfs(i,j+1,a,vis,t);
        if(i-1>=0 && !vis[i-1][j] &&a[i-1][j]<=a[i][j]) dfs(i-1,j,a,vis,t);
        if(i+1<=a.length-1 && !vis[i+1][j] && a[i+1][j]<=a[i][j]) dfs(i+1,j,a,vis,t);
        
        if(t[0]==true && t[1]==true){
            t[2]=true;
        }
    }
}