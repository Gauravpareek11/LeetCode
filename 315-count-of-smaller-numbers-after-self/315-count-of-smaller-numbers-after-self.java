class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[][] a=new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            a[i][0]=nums[i];
            a[i][1]=i;
        }
        Arrays.sort(a,(x,y)->Integer.compare(x[0],y[0]));
        List<Integer>ans=new ArrayList<>();
        List<Integer>l1=new ArrayList<>();
        int[] temp=new int[nums.length];
        for(int i=0;i<a.length;i++){
            if(l1.size()==0){
                l1.add(a[i][1]);
                temp[a[i][1]]=0;
            }
            else{
                int low=0;
                int high=l1.size()-1;
                while(low<=high){
                    int mid=low+(high-low)/2;
                    if(l1.get(mid)<=a[i][1]){
                        low=mid+1;
                    }
                    else high=mid-1;
                }
                temp[a[i][1]]=l1.size()-low;
                l1.add(low,a[i][1]);
            }
        }
        for(int i:temp){
            ans.add(i);
        }
        return ans;
    }
}