class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<List<Integer>>();
        permute(nums,0,nums.length,ans);
        return ans;
    }
   void permute(int[] a,int start,int n,List<List<Integer>>ans){
        if(start==n){
            List<Integer>l1=new ArrayList<Integer>();
            for(int i:a){
                l1.add(i);
            }
            ans.add(l1);
        }
        for(int i=start;i<n;i++){
            swap(a,i,start);
            permute(a,start+1,n,ans);
            swap(a,i,start);
        }
    }
    void swap(int[] a,int i,int j){
        int temp=a[j];
        a[j]=a[i];
        a[i]=temp;
    }
}