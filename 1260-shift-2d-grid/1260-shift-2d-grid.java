class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        k=k%(grid.length*grid[0].length);
        // if(k==0) temp=grid;
        while(k>0){
            int[][] temp=new int[grid.length][grid[0].length];
            for(int i=0;i<grid.length;i++){
                for(int j=1;j<grid[0].length;j++){
                    temp[i][j]=grid[i][j-1];
                }
            }
            for(int i=1;i<grid.length;i++){
                temp[i][0]=grid[i-1][grid[0].length-1];
            }
            temp[0][0]=grid[grid.length-1][grid[0].length-1];
            grid=temp;
            k--;
        }
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            ans.add(new ArrayList<Integer>());
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                ans.get(i).add(grid[i][j]);
            }
        }
        return ans;
    }
}