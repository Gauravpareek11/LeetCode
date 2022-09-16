class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        // boolean f=false;
        // for(int i:nums){
        //     if(i!=0){
        //         f=true;
        //     }
        // }
        // if(!f) return 0;
        int[][] dp=new int[multipliers.length][multipliers.length];
        for(int[] a:dp){
            Arrays.fill(a,-1001);
        }
        int diff=nums.length-multipliers.length;
        return solve(0,0,nums.length-1,nums,multipliers,dp,diff);
    }
    int solve(int x,int i,int j,int[] nums,int[] mult,int[][] dp,int diff){
        if(x>=mult.length || i>j) return 0;
        if(dp[i][j-diff]!=-1001) return dp[i][j-diff];
        
        int start=mult[x]*nums[i]+solve(x+1,i+1,j,nums,mult,dp,diff);
        int end=mult[x]*nums[j]+solve(x+1,i,j-1,nums,mult,dp,diff);
        return dp[i][j-diff]=Math.max(start,end);
    }
}