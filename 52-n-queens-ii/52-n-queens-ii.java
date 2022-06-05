class Solution {
    public int totalNQueens(int n) {
        boolean[][] grid=new boolean[n][n];
        return queen(grid,0);
    }
    static int queen(boolean[][] grid,int row){
        if(row==grid.length){
            return 1;
        }
        int count=0;
        for(int col=0;col<grid.length;col++){
            if(isSafe(grid,row,col)){
                grid[row][col]=true;
                count+=queen(grid,row+1);
                grid[row][col]=false;
            }
        }
        return count;
    }
    static boolean isSafe(boolean[][] board,int row,int col){
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if(board[row-i][col-i]) {
                return false;
            }
        }

        // diagonal right
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if(board[row-i][col+i]) {
                return false;
            }
        }

        return true;
    }
}