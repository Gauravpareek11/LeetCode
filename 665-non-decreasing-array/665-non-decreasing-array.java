class Solution {
    public boolean checkPossibility(int[] nums) {
        // int[][] dp=new int[nums.length][nums.length+1];
        // for(int[] x:dp){
        //     Arrays.fill(x,-1);
        // }
        // int a=lis(0,nums,-1,dp);
        // return a>=nums.length-1;
        
        int cnt = 0;                                                                                                    //the number of changes
        for(int i = 1; i < nums.length && cnt<=1 ; i++){
            if(nums[i-1] > nums[i]){
                cnt++;
                if(i-2<0 || nums[i-2] <= nums[i])nums[i-1] = nums[i];                                                           //modify nums[i-1] of a priority
                else nums[i] = nums[i-1];                                                                                           //have to modify nums[i]
            }
        }
        return cnt<=1; 
    }
    // int lis(int i,int[] nums,int x,int[][] dp){
    //     if(i==nums.length){
    //         return 0;
    //     }
    //     if(dp[i][x+1]!=-1) return dp[i][x+1];
    //     int not_pick=lis(i+1,nums,x,dp);
    //     int pick=0;
    //     if(x==-1 || nums[x]<=nums[i]) pick=1+lis(i+1,nums,i,dp);
    //     return dp[i][x+1]=Math.max(pick,not_pick);
    // }
}