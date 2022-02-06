class Solution {
    public int removeDuplicates(int[] nums) {
        // Arrays.sort(nums);
        int n=nums.length;
        int i=0;
        while(i<n-1){
            if(i>0 && i<n){
                if(nums[i-1]==nums[i+1]){
                    rotate(nums,i,n);
                    n--;
                }
                else{
                    i++;
                }
            }
            else i++;
        }
        return n;
    }
    void rotate(int[] nums,int l,int r){
        int a=nums[l];
        for(int i=l;i<r-1;i++){
            nums[i]=nums[i+1];
        }
        nums[r-1]=a;
    }
}