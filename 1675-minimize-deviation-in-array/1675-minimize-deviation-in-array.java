class Solution {
    public int minimumDeviation(int[] nums) {
        int ans=Integer.MAX_VALUE;
        int min=Integer.MAX_VALUE;
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0) nums[i]*=2;
            pq.add(nums[i]);
            min=Math.min(nums[i],min);
        }
        while(true){
            int p=pq.poll();
            ans=Math.min(ans,p-min);
            if(p%2!=0) break;
            min=Math.min(min,p/2);
            pq.add(p/2);
        }
        return ans;
    }
}