class pair{
    int a;
    int b;
    double d;
    pair(int a,int b,double d){
        this.a=a;
        this.b=b;
        this.d=d;
    }
}
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<pair>pq=new PriorityQueue<pair>((a,b)->Double.compare(b.d,a.d));
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(pq.size()<k){
                    pq.add(new pair(arr[i],arr[j],(double)arr[i]/(double)arr[j]));
                }
                else if(pq.size()==k){
                    if(pq.peek().d>(double)arr[i]/(double)arr[j]){
                        pq.poll();
                        pq.add(new pair(arr[i],arr[j],(double)arr[i]/(double)arr[j]));
                    }
                }
            }
        }
        int[] ans=new int[2];
        ans[0]=pq.peek().a;
        ans[1]=pq.peek().b;
        return ans;
    }
}