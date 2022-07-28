class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        HashSet<String>s1=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int count=0;
            StringBuilder sb=new StringBuilder("");
            for(int j=i;j<nums.length;j++){
                if(nums[j]%p==0 && count==k) break;
                if(nums[j]%p==0) count++;
                sb.append(nums[j]+" ");
                s1.add(sb.toString());
            }
        }
        return s1.size();
    }
}