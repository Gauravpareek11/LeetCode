class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        int max=0;
        while(i<=j){
           max=Math.max(nums[i]+nums[j],max);
            i++;
            j--;
        }
        return max;
    }
}