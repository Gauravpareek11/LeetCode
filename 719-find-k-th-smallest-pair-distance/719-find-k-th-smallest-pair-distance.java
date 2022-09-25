class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        
        Arrays.sort(nums);
        int low=0;
        int high=nums[nums.length-1]-nums[0];
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(check(nums,k,mid)){
                low=mid+1;
                ans=low;
            }
            else high=mid-1;
        }
        return ans;
    }
    boolean check(int[] nums,int k,int mid){
        int n=nums.length, cnt=0;
        for(int i=0, j=1;i<n;i++){
            while(j<n && nums[j]-nums[i]<=mid)j++;
            j--;
            cnt+=j-i;
        }
        return cnt<k;
    }
}