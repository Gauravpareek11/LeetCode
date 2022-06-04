class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] mat=new boolean[n][n];
        List<List<String>>ans=new ArrayList<>();
        solve(mat,0,ans);
        return ans;
    }
    void solve(boolean[][] mat,int row,List<List<String>>ans){
        if(row==mat.length){
            List<String>l1=new ArrayList<>();
            for(boolean[] a:mat){
                StringBuilder sb=new StringBuilder("");
                for(boolean i:a){
                    if(i) sb.append('Q');
                    else sb.append('.');
                }
                l1.add(sb.toString());
            }
            ans.add(l1);
            return;
        }
        for(int j=0;j<mat[0].length;j++){
            if(isSafe(mat,row,j)){
                mat[row][j]=true;
                solve(mat,row+1,ans);
                mat[row][j]=false;
            }
        }
    }
    boolean isSafe(boolean[][] mat,int row,int col){
        for(int i=0;i<row;i++){
            if(mat[i][col]) return false;
        }
        int i=row;
        int j=col;
        while(i>=0 && j>=0){
            if(mat[i][j]) return false;
            i--;
            j--;
        }
        i=row;
        j=col;
        while(i>=0 && j<mat[0].length){
            if(mat[i][j]) return false;
            i--;
            j++;
        }
        return true;
    }
}