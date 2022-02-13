class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res=new ArrayList<List<Integer>>();
        solve(res,nums,nums.length);
        return res;
    }
    // void solve(List<Integer>l1,List<List<Integer>>res,int[] nums,int i,int n){
    //     if(!res.contains(l1)){
    //         res.add(new ArrayList<Integer>(l1));
    //     }
    //     if(i<n){
    //     l1.add(nums[i]);
    //     solve(l1,res,nums,i+1,n);
    //     l1.remove(l1.size()-1);
    //     solve(l1,res,nums,i+1,n);
    //     }
        void solve(List<List<Integer>>res,int[] nums,int n){
            for(int i=0;i<(1<<n);i++){
                List<Integer>l1=new ArrayList<Integer>();
                for(int j=0;j<n;j++){
                    if((i&(1<<j))>0){
                        l1.add(nums[j]);
                    }
                }
                res.add(l1);
            }
        }
}