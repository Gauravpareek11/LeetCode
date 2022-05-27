class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        int[] count=new int[dp.length];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[j]+1>dp[i]){
                    dp[i]=1+dp[j];
                    count[i]=count[j];
                }
                else if(nums[i]>nums[j] && dp[j]+1==dp[i]){
                    count[i]+=count[j];
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        // System.out.println(Arrays.toString(count));
        int maxii=1;
        for(int i=0;i<dp.length;i++){
            if(dp[i]>maxii){
                maxii=dp[i];
            }
        }
        if(maxii==1)return nums.length;
        int ans=0;
        for(int i=0;i<dp.length;i++){
            if(dp[i]==maxii) ans+=count[i];
        }
        return ans;
    }
}