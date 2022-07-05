class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>s1=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            s1.add(nums[i]);
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(!s1.contains(nums[i]-1)){
                int p=nums[i];
                while(s1.contains(p)){
                    p++;
                }
                ans=Math.max(ans,p-nums[i]);
            }
        }
        return ans;
    }
}