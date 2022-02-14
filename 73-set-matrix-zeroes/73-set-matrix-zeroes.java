class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer>row=new ArrayList<>();
        ArrayList<Integer>col=new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                    }
            }
        }
        for(int i=0;i<row.size();i++){
            Arrays.fill(matrix[row.get(i)],0);
        }
        for(int j=0;j<col.size();j++){
            for(int i=0;i<matrix.length;i++){
                matrix[i][col.get(j)]=0;
            }
        }
    }
}