class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>ans=new ArrayList<List<Integer>>();
        List<Integer>l1=new ArrayList<Integer>();
        solve(k,n,l1,ans);
        return ans;
    }
   void solve(int k,int n,List<Integer>l1,List<List<Integer>>ans){
        if(n==0 && k==0){
            Collections.sort(l1);
            if(!ans.contains(l1)) ans.add(l1);
            return;
        }
       if(k==0) return;
        for(int i=1;i<=9;i++){
            if(n-i>=0 && !l1.contains(i)){
                l1.add(i);
                solve(k-1,n-i,new ArrayList<Integer>(l1),ans);
                l1.remove(l1.size()-1);
            }
        }
    }
}