class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3) return 0;
        int ans=0;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+2;j<nums.length;j++){
                if(nums[i+1]-nums[i]==nums[j]-nums[j-1]) ans++;
                else break;
            }
        }
        return ans;
    }
}