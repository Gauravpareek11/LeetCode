class Solution {
    public int minSwaps(int[] nums) {
        int count1=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1) count1++;
        }
        if(count1==nums.length) return 0;
        if(count1==0) return 0;
    //     int i=0;
    //     int j=count1-1;
    //     int ans=count1;
    //     while(j<nums.length){
    //         ans=Math.min(ans,count(i,j,nums));
    //         i++;
    //         j++;
    //     }
    //     i=nums.length-count1+1;
    //     j=0;
    //     while(i<nums.length){
    //         ans=Math.min(ans,count(i,j,nums));
    //         i+=1;
    //         j+=1;
    //     }
    //     return ans;
    // }
    // int count(int start,int end,int[] nums){
    //     int c=0;
    //     if(start>end){
    //         while(start<nums.length){
    //             if(nums[start]==0) c++;
    //             start+=1;
    //         }
    //         start=0;
    //         while(start<=end){
    //             if(nums[start]==0) c++;
    //             start+=1;
    //         }
    //     }
    //     else{
    //         while(start<=end){
    //             if(nums[start]==0) c++;
    //             start+=1;
    //             // if(start==nums.length) start=0;
    //             }
    //     }
    //     // if(nums[start]==0) c++;
    //     return c;
    // }
        int ans=count1;
        int count=0;
        int n=nums.length;
        for(int i=0;i<count1;i++){
            if(nums[i]==1) count++;
        }
        for(int i=count1;i<n+count1;i++){
            if(nums[i%n]==1) count++;
            if(nums[(i-count1)%n]==1) count--;
            ans=Math.min(ans,count1-count);
        }
        return ans;
    }
}