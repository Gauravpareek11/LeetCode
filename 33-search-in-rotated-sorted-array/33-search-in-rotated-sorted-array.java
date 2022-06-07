class Solution {
    public int search(int[] nums, int target) {
        int pivot=find_pivot(nums);
        // System.out.println(pivot);
        return Math.max(solve(nums,0,pivot-1,target),solve(nums,pivot,nums.length-1,target));
    }
    int find_pivot(int[] nums){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if ((mid==low||nums[mid-1]>nums[mid]) && (mid==high||nums[mid]<nums[mid+1]))
                return mid;
            if (nums[mid] > nums[high])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return 0;
    }
    int solve(int[] nums,int low,int high,int target){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]<target) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
}