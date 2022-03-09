class Solution {
    public int rob(int[] nums) {
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
}