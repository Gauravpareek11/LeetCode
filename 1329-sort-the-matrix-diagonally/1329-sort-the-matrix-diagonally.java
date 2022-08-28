class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int i=0;
        for(int j=0;j<mat[0].length;j++){
            int x=i;
            int y=j;
            while(x<mat.length && y<mat[0].length){
                int m=x+1;
                int n=y+1;
                while(m<mat.length && n<mat[0].length){
                    if(mat[x][y]>mat[m][n]){
                        int temp=mat[x][y];
                        mat[x][y]=mat[m][n];
                        mat[m][n]=temp;
                    }
                    m++;
                    n++;
                }
                x++;
                y++;
            }
        }
        int j=0;
        for(i=0;i<mat.length;i++){
            int x=i;
            int y=j;
            while(x<mat.length && y<mat[0].length){
                int m=x+1;
                int n=y+1;
                while(m<mat.length && n<mat[0].length){
                    if(mat[x][y]>mat[m][n]){
                        int temp=mat[x][y];
                        mat[x][y]=mat[m][n];
                        mat[m][n]=temp;
                    }
                    m++;
                    n++;
                }
                x++;
                y++;
            }
        }
        return mat;
    }
}