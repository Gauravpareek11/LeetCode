class Solution {
    public int findMaximumXOR(int[] nums) {
        int max=0,mask=0;
        for(int i=31;i>=0;i--){
            mask=mask|(1<<i);
            HashSet<Integer>s1=new HashSet<>();
            for(int n:nums){
                s1.add(n&mask);
            }
            int temp=max|(1<<i);
            for(int s:s1){
                if(s1.contains(s^temp)){
                    max=temp;
                    break;
                }
            }
        }
        return max;
    }
}