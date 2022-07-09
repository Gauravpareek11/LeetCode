class pair{
    int value;
    int ind;
    pair(int value,int ind){
        this.value=value;;
        this.ind=ind;
    }
}
class Solution {
    public int maxResult(int[] nums, int k) {
      PriorityQueue<pair> pq = new PriorityQueue<>(k,(a,b)->Integer.compare(b.value,a.value));
            pq.offer(new pair(nums[0],0));

        int max = nums[0], ans;
        for (int i = 1; i < nums.length; i++) {
            while (pq.peek().ind < i - k) { // We just compare the top node and see if it is outside of window or not.
                pq.poll();
            }

            max = nums[i] + pq.peek().value;
            pq.offer(new pair(max,i));
        }

        return max;  
    }
}