class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer>m1=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(m1.containsKey(nums[i])){
                m1.put(nums[i],m1.get(nums[i])+1);
            }
            else{
                m1.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer>in:m1.entrySet()){
            if(in.getValue()>n/2){
                return in.getKey();
            }
        }
        return -1;
    }
}