class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(new ArrayList<Integer>());
        }
        ans.get(0).add(1);
        if(n==1) return ans;
        for(int i=1;i<n;i++){
            for(int j=0;j<ans.get(i-1).size()+1;j++){
                if(j==0) ans.get(i).add(1);
                else if(j==ans.get(i-1).size()) ans.get(i).add(1);
                else{
                    ans.get(i).add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
                }
            }
        }
        return ans;
    }
}