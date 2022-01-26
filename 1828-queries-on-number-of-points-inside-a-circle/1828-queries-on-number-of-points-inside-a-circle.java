class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            for(int[]a:points){
                if(Math.pow(a[0]-queries[i][0],2)+Math.pow(a[1]-queries[i][1],2)<=Math.pow(queries[i][2],2)) ans[i]++;
            }
        }
                   return ans;
    }
}