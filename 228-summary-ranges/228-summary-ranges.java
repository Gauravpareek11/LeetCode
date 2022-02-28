class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String>ans=new ArrayList<>();
        if(nums.length==1) {
            ans.add(Integer.toString(nums[0]));
            return ans;
        }
        int start=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]+1==nums[i+1]){
                if(i+1==nums.length-1){
                    String s=nums[start]+"->"+nums[i+1];
                    ans.add(s);
                }
            }
            else{
                if(i==start){
                    if(i+1==nums.length-1){
                        ans.add(Integer.toString(nums[i]));
                        ans.add(Integer.toString(nums[i+1]));
                    }
                    else{
                        ans.add(Integer.toString(nums[i]));
                        start=i+1;
                    }
                }
                else if(i+1==nums.length-1){
                    String s=nums[start]+"->"+nums[i];
                    ans.add(s);
                    ans.add(Integer.toString(nums[i+1]));
                }
                else{
                    String s=nums[start]+"->"+nums[i];
                    ans.add(s);
                    start=i+1;
                }
            }
        }
        return ans;
    }
}