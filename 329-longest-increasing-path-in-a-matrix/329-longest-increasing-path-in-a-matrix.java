class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] store=new int[matrix.length][matrix[0].length];
        int ans=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                ans=Math.max(ans,dfs(matrix,-1,i,j,store));
            }
        }
        return ans;
    }
    int dfs(int[][] matrix,int prev,int i,int j,int[][] store){
        if(i>=matrix.length || i<0 || j<0 || j>=matrix[0].length||matrix[i][j]<=prev) return 0;
        if(store[i][j]!=0){
            return store[i][j];
        }
        else{
            // ans=Math.max(ans,count);
            int count=0;
            if(i+1<matrix.length && i+1>=0 && j>=0 && j<matrix[0].length) 
                count=Math.max(dfs(matrix,matrix[i][j],i+1,j,store),count);
            if(i-1<matrix.length && i-1>=0 && j>=0 && j<matrix[0].length) 
                count=Math.max(dfs(matrix,matrix[i][j],i-1,j,store),count);
            if(i<matrix.length && i>=0 && j+1>=0 && j+1<matrix[0].length) 
                count=Math.max(dfs(matrix,matrix[i][j],i,j+1,store),count);
            if(i<matrix.length && i>=0 && j-1>=0 && j-1<matrix[0].length) 
                count=Math.max(dfs(matrix,matrix[i][j],i,j-1,store),count);
            count=count+1;
            store[i][j]=count;
            return count;
        }
    }
}