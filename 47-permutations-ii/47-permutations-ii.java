class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer>l1=new ArrayList<Integer>();
        for(int i:nums){
            l1.add(i);
        }
        List<List<Integer>>ans=new ArrayList<List<Integer>>();
        permute(l1,ans,0);
        return ans;
    }
   void permute(List<Integer>nums,List<List<Integer>>ans,int i){
        if(i==nums.size()){
            if(!ans.contains(nums)) ans.add(new ArrayList<Integer>(nums));
        }
        for(int j=i;j<nums.size();j++){
            swap(nums,i,j);
            permute(nums,ans,i+1);
            swap(nums,i,j);
        }
    }
    void swap(List<Integer>nums,int i,int j){
        int temp=nums.get(i);
        nums.set(i,nums.get(j));
        nums.set(j,temp);
    }
}