class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length+1][nums.length+1];
        // for(int[] a:dp){
        //     Arrays.fill(a,-1);
        // }
        // return solve(0,nums,-1,dp);
        for(int i=nums.length-1;i>=0;i--){
            for(int x=i-1;x>=-1;x--){
                int not_pick=dp[i+1][x+1];
                int pick=0;
                if(x==-1||nums[i]>nums[x]) pick=1+dp[i+1][i+1];;
                dp[i][x+1]=Math.max(pick,not_pick);
            }
        }
        return dp[0][0];
    }
    // int solve(int i,int[] nums,int x,int[][] dp){
    //     if(i==nums.length-1){
    //         if(x==-1||nums[i]>nums[x]) return 1;
    //         else return 0;
    //     }
    //     if(dp[i][x+1]!=-1) return dp[i][x+1];
    //     int not_pick=solve(i+1,nums,x,dp);
    //     int pick=0;
    //     if(x==-1||nums[i]>nums[x]) pick=1+solve(i+1,nums,i,dp);
    //     return dp[i][x+1]=Math.max(pick,not_pick);
    // }
}