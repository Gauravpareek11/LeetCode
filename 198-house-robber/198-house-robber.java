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
        // int[] dp=new int[nums.length+1];
        // Arrays.fill(dp,-1);
        // dp[0]=nums[0];
        // return solve(nums.length-1,nums,dp);
        // int pick;
        // for(int i=1;i<nums.length;i++){
        //     if(i>1) pick=dp[i-2]+nums[i];
        //     else pick=nums[i];
        //     int n_pick=dp[i-1]+0;
        //     dp[i]=Math.max(pick,n_pick);
        // }
        // return dp[nums.length-1];
        int prev=nums[0];
        int prev2=0;
        int curr;
        for(int i=1;i<nums.length;i++){
            curr=Math.max(prev,prev2+nums[i]);
            prev2=prev;
            prev=curr;
        }
        return prev;
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