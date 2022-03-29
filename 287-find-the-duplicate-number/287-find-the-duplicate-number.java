class Solution {
    public int findDuplicate(int[] nums) {
       HashSet<Integer>s1=new HashSet<Integer>();
        for(int i:nums){
            if(s1.contains(i)){
                return i;
            }
            s1.add(i);
        }
        return 0;
    }
}