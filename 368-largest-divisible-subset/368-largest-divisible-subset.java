class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp=new int[nums.length];
        int[] hash=new int[dp.length];
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++){
            hash[i]=i;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(dp[j]+1>dp[i]){
                        dp[i]=1+dp[j];
                        hash[i]=j;
                    }
                }
            }
        }
        int maxii=0;
        int max=1;
        for(int i=0;i<dp.length;i++){
            if(dp[i]>max){
                max=dp[i];
                maxii=i;
            }
        }
        ArrayList<Integer>l1=new ArrayList<>();
        l1.add(nums[maxii]);
        while(hash[maxii]!=maxii){
            maxii=hash[maxii];
            l1.add(nums[maxii]);
        }
        Collections.reverse(l1);
        return l1;
    }
}