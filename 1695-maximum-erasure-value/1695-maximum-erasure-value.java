class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        HashSet<Integer>s1=new HashSet<>();
        int i=0;
        int j=0;
        while(j<nums.length){
            if(!s1.contains(nums[j])){
                sum+=nums[j];
                s1.add(nums[j]);
                max=Math.max(sum,max);
            }
            else{
                while(nums[i]!=nums[j]){
                    sum-=nums[i];
                    s1.remove(nums[i]);
                    i++;
                }
                sum-=nums[i];
                i++;
                sum+=nums[j];
            }
            j++;
        }
        return max;
    }
}