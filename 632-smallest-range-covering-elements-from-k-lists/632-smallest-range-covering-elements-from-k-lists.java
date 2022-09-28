class pair{
    int val;
    int index;
    int row;
    pair(int val,int index,int row){
        this.val=val;
        this.index=index;
        this.row=row;
    }
}
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int k=nums.size();
        for(int i=0;i<k;i++){
            pq.add(new pair(nums.get(i).get(0),0,i));
            max=Math.max(max,nums.get(i).get(0));
            min=Math.min(min,nums.get(i).get(0));
        }
        boolean f=true;
        int[] ans=new int[2];
        int range=max-min;
        ans[0]=min;
        ans[1]=max;
        while(f){
            pair p=pq.poll();
            int mn=max-p.val;
            if(mn<range){
                range=mn;
                ans[0]=p.val;
                ans[1]=max;
            }
            if(p.index+1>=nums.get(p.row).size()){
                f=false;
                break;
            }
            pq.add(new pair(nums.get(p.row).get(p.index+1),p.index+1,p.row));
            max=Math.max(max,nums.get(p.row).get(p.index+1));
        }
        return ans;
    }
}