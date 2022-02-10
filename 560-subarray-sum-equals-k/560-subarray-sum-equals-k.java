class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>m1=new HashMap<>();
        int c=0,sum=0;
        m1.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(m1.containsKey(sum-k)) c+=m1.get(sum-k);
            if(m1.containsKey(sum)) m1.put(sum,m1.get(sum)+1);
            else m1.put(sum,1);
        }
        return c;
    }
}