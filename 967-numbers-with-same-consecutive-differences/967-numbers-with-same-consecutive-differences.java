class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer>l1=new ArrayList<>();
        for(int i=1;i<=9;i++){
            solve(n-1,k,i,l1);
        }
        int[] ans=new int[l1.size()];
        for(int i=0;i<l1.size();i++){
            ans[i]=l1.get(i);
        }
        return ans;
    }
    void solve(int n,int k,int num,ArrayList<Integer>ans){
        if(n==0){
            ans.add(num);
            return;
        }
        int rem=num%10;
        for(int i=0;i<=9;i++){
            if(Math.abs(i-rem)==k){
                solve(n-1,k,((num*10)+i),ans);
            }
        }
    }
}