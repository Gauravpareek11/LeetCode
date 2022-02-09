
class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>>l1=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[j]-nums[i]==k){
                    ArrayList<Integer>l2=new ArrayList<>();
                    l2.add(nums[i]);
                    l2.add(nums[j]);
                    if(!l1.contains(l2)) l1.add(l2);
                }
                if(nums[j]-nums[i]>k) break;
            }
        }
        // System.out.println(l1);
        return l1.size();
    }
}