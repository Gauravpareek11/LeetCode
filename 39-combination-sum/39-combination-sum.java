class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<List<Integer>>();
        List<Integer>l1=new ArrayList<Integer>();
        solve(candidates,l1,ans,target);
        return ans;
    }
    void solve(int[] candidates,List<Integer>l1,List<List<Integer>>ans,int target){
        if(sum(l1)>target) return;
        if(sum(l1)==target){
            Collections.sort(l1);
            if(!ans.contains(l1)) ans.add(l1);
        }
        for(int i=0;i<candidates.length;i++){
            List<Integer>temp=new ArrayList<Integer>(l1);
            temp.add(candidates[i]);
            solve(candidates,temp,ans,target);
        }
    }
    int sum(List<Integer>l1){
        int sum=0;
        for(int i:l1){
            sum+=i;
        }
        return sum;
    }
}