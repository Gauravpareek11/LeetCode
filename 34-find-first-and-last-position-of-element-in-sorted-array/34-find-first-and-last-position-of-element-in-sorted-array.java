class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        ans[0]=bs1(nums,target);
        ans[1]=bs2(nums,target);
        return ans;
    }
    int bs1(int[] nums,int target){
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]==target && (mid-1<0 || nums[mid-1]<target)) return mid;
            else if(nums[mid]>=target) j=mid-1;
            else i=mid+1;
        }
        return -1;
    }
    int bs2(int[] nums,int target){
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]==target && (mid+1==nums.length || nums[mid+1]>target)) return mid;
            else if(nums[mid]>target) j=mid-1;
            else i=mid+1;
        }
        return -1;
    }
}