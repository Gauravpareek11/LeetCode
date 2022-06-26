class Solution {
    public int maxScore(int[] nums, int k) {
        int[]left=new int[k];
        int[] right=new int[k];
        left[0]=nums[0];
        for(int i=1;i<k;i++){
            left[i]=left[i-1]+nums[i];
        }
        right[k-1]=nums[nums.length-1];
        int x=k-2;
        for(int i=nums.length-2;i>=nums.length-k;i--){
            right[x]=right[x+1]+nums[i];
            x--;
        }
        int max=0;
        for(int i=0;i<k-1;i++){
            int a=left[i]+right[i+1];
            max=Math.max(a,max);
        }
        max=Math.max(max,Math.max(left[k-1],right[0]));
        return max;
    }
}