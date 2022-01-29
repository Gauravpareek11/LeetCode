class Solution {
    public void gameOfLife(int[][] board) {
        int[][] ans=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int count_l=0;
                int count_d=0;
                if(i+1<board.length){
                    if(board[i+1][j]==0) count_d++;
                    else count_l++;
                }
                if(i-1>=0){
                    if(board[i-1][j]==0) count_d++;
                    else count_l++;
                }
                if(j+1<board[0].length){
                    if(board[i][j+1]==0) count_d++;
                    else count_l++;
                }
                if(j-1>=0){
                    if(board[i][j-1]==0) count_d++;
                    else count_l++;
                }
                if(i+1<board.length && j+1<board[0].length){
                    if(board[i+1][j+1]==0) count_d++;
                    else count_l++;
                }
                if(i+1<board.length && j-1>=0){
                    if(board[i+1][j-1]==0) count_d++;
                    else count_l++;
                }
                if(i-1>=0 && j-1>=0){
                    if(board[i-1][j-1]==0) count_d++;
                    else count_l++;
                }
                if(i-1>=0 && j+1<board[0].length){
                    if(board[i-1][j+1]==0) count_d++;
                    else count_l++;
                }
                if(board[i][j]==0){
                    if(count_l==3) ans[i][j]=1;
                }
                if(board[i][j]==1){
                    if(count_l<2 || count_l>3) ans[i][j]=0;
                    else ans[i][j]=1;
                }
            }
        }
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                board[i][j]=ans[i][j];
            }
        }
    }
}