class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0)
            return mat;
        
        int m = mat.length, n = mat[0].length;
        int dirs[] = {0, 1, 0, -1, 0};
        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        if(queue.size() == 0 || queue.size() == m * n)
            return mat;
        
        while(!queue.isEmpty()) {
            int cell[] = queue.poll();
            
            int x = cell[0], y = cell[1];
            
            for(int k = 0; k < 4; k++) {
                int nextX = x + dirs[k];
                int nextY = y + dirs[k + 1];
                
                if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && 
                    !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    mat[nextX][nextY] = mat[x][y] + 1;
                    queue.add(new int[]{nextX, nextY});
                }
            }
            
        }
        
        return mat;
    }
}