class Solution {
    public boolean validPartition(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        int a=solve(nums,0,dp);
        return a==0?false:true;
    }
    int solve(int[] nums,int i,int[] dp){
        if(i==nums.length) return 1;
        
        if(dp[i]!=-1) return dp[i];
        
        int a=0;
        int b=0;
        int c=0;
        if(i+1<nums.length && nums[i]==nums[i+1]){
            a=solve(nums,i+2,dp);
        }
        if(i+2<nums.length && nums[i]==nums[i+1] && nums[i+1]==nums[i+2]){
            b=solve(nums,i+3,dp);
        }
        if(i+2<nums.length && nums[i]==nums[i+1]-1 && nums[i+1]==nums[i+2]-1){
            c=solve(nums,i+3,dp);
        }
        return dp[i]=Math.max(a,Math.max(b,c));
    }
}