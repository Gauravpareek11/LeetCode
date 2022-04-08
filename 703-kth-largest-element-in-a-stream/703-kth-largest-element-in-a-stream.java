class KthLargest {
    PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->Integer.compare(a,b));
    int k_largest;
    public KthLargest(int k, int[] nums) {
        for(int i:nums){
            pq.add(i);
        }
        k_largest=k;
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size()>k_largest){
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */