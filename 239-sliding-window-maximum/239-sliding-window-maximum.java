class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // if(k==1) return nums;
        // // int max=Integer.MIN_VALUE;
        // PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        // for(int i=0;i<k;i++){
        //     // max=Math.max(nums[i],max);
        //     pq.add(nums[i]);
        // }
        // int[] ans=new int[nums.length-k+1];
        // // ans[0]=max;
        // for(int i=k;i<nums.length;i++){
        //     ans[i-k]=pq.peek();
        //     pq.remove(nums[i-k]);
        //     pq.add(nums[i]);
        // }
        // ans[nums.length-k]=pq.peek();
        // return ans;
        Deque<Integer> q = new ArrayDeque<>();  // stores *indices*
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
            if (q.getFirst() == i - k) {
                q.removeFirst();
            }
            if (i >= k - 1) {
                res.add(nums[q.peek()]);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}