class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        HashMap<Integer,Integer>m1=new HashMap<Integer,Integer>();
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum%k==0 && i>0) return true;
            if(m1.containsKey(sum%k)){
                if(i-m1.get(sum%k)>1) return true;
            }
            else m1.put(sum%k,i);
        }
        return false;
    }
}