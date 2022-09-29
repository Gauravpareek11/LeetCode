class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        PriorityQueue<Integer>pq=new PriorityQueue<Integer>((a,b)->(Math.abs(b-x)==Math.abs(a-x)?b-a:Math.abs(b-x)-Math.abs(a-x)));
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        for(int i=k;i<n;i++){
            if(Math.abs(pq.peek()-x)>Math.abs(arr[i]-x)){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        List<Integer>l1=new ArrayList<>();
        while(!pq.isEmpty()){
            l1.add(pq.poll());
        }
        Collections.sort(l1);
        return l1;
    }
}