class NumMatrix {
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            this.matrix[i][0]=matrix[i][0];
            for(int j=1;j<matrix[0].length;j++){
                this.matrix[i][j]=this.matrix[i][j-1]+matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans=0;
        for(int i=row1;i<=row2;i++){
            int sum=0;
            if(col1>0) sum=this.matrix[i][col1-1];
            ans+=this.matrix[i][col2]-sum;
        }
         return ans;   
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */