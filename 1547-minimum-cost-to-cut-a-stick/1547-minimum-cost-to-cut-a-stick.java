class Solution {
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer>l1=new ArrayList<>();
        l1.add(0);
        Arrays.sort(cuts);
        for(int i:cuts){
            l1.add(i);
        }
        l1.add(n);
        int[][] dp=new int[l1.size()][l1.size()];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return solve(1,cuts.length,l1,dp);
    }
    int solve(int i,int j,ArrayList<Integer>l1,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min=(int)1e9;
        for(int k=i;k<=j;k++){
            int steps=l1.get(j+1)-l1.get(i-1)+solve(i,k-1,l1,dp)+solve(k+1,j,l1,dp);
            min=Math.min(steps,min);
        }
        return dp[i][j]=min;
    }
}