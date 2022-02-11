class Solution {
    public int rob(int[] nums) {
        // int prev=0;
        // int curr=0;
        // for(int i:nums){
        //     int temp=prev;
        //     prev=Math.max(prev,curr);
        //     curr=i+temp;
        // }
        // return Math.max(prev,curr);
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return solve(nums.length-1,nums,dp);
    }
    int solve(int n,int[] nums,int[] dp){
        if(n==0) return nums[0];
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int take=nums[n]+solve(n-2,nums,dp);
        int n_take=0+solve(n-1,nums,dp);
        return dp[n]=Math.max(take,n_take);
    }
}