class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for(int i:nums){
            max=Math.max(i,max);
        }
        int[] a=new int[max+1];
        for(int i=0;i<nums.length;i++){
            a[nums[i]]++;
        }
        int[] dp=new int[a.length];
        Arrays.fill(dp,-1);
        return solve(a,a.length-1,dp);
    }
    int solve(int[] nums,int i,int[] dp){
        if(i<0) return 0;
        if(i==0){
            return nums[i]*i;
        }
        if(dp[i]!=-1) return dp[i];
        int not_pick=solve(nums,i-1,dp);
        int pick=nums[i]*i+solve(nums,i-2,dp);
        return dp[i]=Math.max(pick,not_pick);
    }
}
