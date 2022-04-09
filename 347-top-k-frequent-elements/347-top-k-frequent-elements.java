class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>m1=new HashMap<Integer,Integer>();
        for(int i:nums){
            if(m1.containsKey(i)){
                m1.put(i,m1.get(i)+1);
            }
            else{
                m1.put(i,1);
            }
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->Integer.compare(m1.get(b),m1.get(a)));
        for(int i:m1.keySet()){
            pq.add(i);
        }
        int ans[]=new int[k];
        int i=0;
        while(i<k){
            ans[i]=pq.poll();
            i++;
        }
        return ans;
    }
}