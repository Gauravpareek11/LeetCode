class Solution {
    boolean flag=false;
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
       int ans=solve(nums,nums.length-1,dp,1);
        Arrays.fill(dp,-1);
        ans=Math.max(ans,solve(nums,nums.length-2,dp,0));
      
        return ans;
    }
    int solve(int[] nums,int i,int[] dp,int end){
        if(i==0){
            if(end==0) return nums[i];
            else return 0;
        }
        if(i<end) return 0;
        if(dp[i]!=-1) return dp[i];
        int pick=0;
        int not_pick=0;
        pick=nums[i]+solve(nums,i-2,dp,end);
        not_pick=solve(nums,i-1,dp,end);
        // System.out.println(Math.max(pick,not_pick));
        return dp[i]=Math.max(pick,not_pick);
    }
}