class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] ans=new int[nums.length];
        int x=1<<maximumBit;
        x--;
        ans[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            ans[i]=ans[i-1]^nums[i];
        }
        for(int i=0;i<nums.length;i++){
            ans[i]=ans[i]^x;
        }
        int i=0;
        int j=ans.length-1;
        while(i<j){
            swap(i,j,ans);
            i++;
            j--;
        }
        return ans;
    }
    void swap(int i,int j,int[] ans){
        int temp=ans[i];
        ans[i]=ans[j];
        ans[j]=temp;
    }
}