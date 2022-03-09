class pair{
    int a;
    int b;
    int count;
    pair(int a,int b,int count){
        this.a=a;
        this.b=b;
        this.count=count;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        Queue<pair>q1=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    visited[i][j]=true;
                    q1.add(new pair(i,j,0));
                }
            }
        }
        if(q1.size()==grid.length*grid[0].length) return 0;
        int counter=0;
        int row[]={0,-1,0,1};
        int col[]={-1,0,1,0};
        while(!q1.isEmpty()){
            pair p=q1.poll();
            counter=p.count;
            for(int i=0;i<4;i++){
                if(p.a+row[i]>=0 && p.b+col[i]>=0 && p.a+row[i]<grid.length && p.b+col[i]<grid[0].length && !visited[p.a+row[i]][p.b+col[i]] && grid[p.a+row[i]][p.b+col[i]]==1){
                    grid[p.a+row[i]][p.b+col[i]]=2;
                    visited[p.a+row[i]][p.b+col[i]]=true;
                    q1.add(new pair(p.a+row[i],p.b+col[i],counter+1));
                }
            }
            
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return counter;
    }
}