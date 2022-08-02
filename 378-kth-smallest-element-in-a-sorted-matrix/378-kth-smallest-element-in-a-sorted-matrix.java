class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<Integer>((a,b)->Integer.compare(b,a));
        // k--;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                pq.add(matrix[i][j]);
                if(pq.size()>k) pq.poll();
            }
        }
        // while(pq.size()>1){
        //     pq.poll();
        // }
        return pq.peek();
    }
}