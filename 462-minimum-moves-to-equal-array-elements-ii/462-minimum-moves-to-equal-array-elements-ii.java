class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        for(int i:nums){
            ans+=Math.abs(i-nums[nums.length/2]);
        }
        return ans;
    }
}