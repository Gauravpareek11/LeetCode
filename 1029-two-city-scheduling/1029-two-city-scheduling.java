class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n=costs.length;
        int[][] diff=new int[n][2];
        for(int i=0;i<n;i++){
            diff[i][0]=costs[i][0]-costs[i][1];
            diff[i][1]=i;
        }
        Arrays.sort(diff,(a,b)->Integer.compare(a[0],b[0]));
        int sum=0;
        for(int i=0;i<n/2;i++){
            sum+=costs[diff[i][1]][0];
        }
        for(int i=n/2;i<n;i++){
            sum+=costs[diff[i][1]][1];
        }
        return sum;
        
    }
}