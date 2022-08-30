class Solution {
    public void rotate(int[][] matrix) {
        
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                matrix[i][j]=matrix[i][j]^matrix[j][i];
                matrix[j][i]=matrix[i][j]^matrix[j][i];
                matrix[i][j]=matrix[i][j]^matrix[j][i];
            }
            int x=0;
            int y=matrix[0].length-1;
            while(x<y){
                matrix[i][x]=matrix[i][x]^matrix[i][y];
                matrix[i][y]=matrix[i][x]^matrix[i][y];
                matrix[i][x]=matrix[i][x]^matrix[i][y];
                x++;
                y--;
            }
        }
    }
}