class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>ans=new ArrayList<>();
        ArrayList<Integer>l1=new ArrayList<>();
        solve(ans,0,k,-1,n,l1);
        return ans;
    }
    void solve(List<List<Integer>>ans,int i,int k,int parent,int n,List<Integer>l1){
        // System.out.println(l1);
        if(i==k){
            if(!ans.contains(new ArrayList<>(l1))){
                ans.add(new ArrayList<>(l1));
                return;
            }
        }
        int j=(parent==-1?1:parent+1);
        for(;j<=n;j++){
            // System.out.println(n);
            if(j!=parent){
                l1.add(j);
                solve(ans,i+1,k,j,n,l1);
                l1.remove(l1.size()-1);
            }
        }
    }
}