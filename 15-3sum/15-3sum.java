class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            int l=i+1;
            int j=n-1;
            while(l<j){
                if(nums[i]+nums[j]+nums[l]==0){
                    List<Integer>l1=new ArrayList<>();
                    l1.add(nums[i]);
                    l1.add(nums[l]);
                    l1.add(nums[j]);
                    ans.add(l1);
                    int x=nums[l];
                    int y=nums[j];
                    while(l<j && nums[l]==x) l++;
                    while(l<j && nums[j]==y) j--;
                }
                else if(nums[i]+nums[j]+nums[l]<0) l++;
                else j--;
            }
            while(i+1<n && nums[i]==nums[i+1]) i++;
        }
        return ans;
    }
}