class pair{
    int val;
    int in;
    pair(int val,int in){
        this.val=val;
        this.in=in;
    }
}
class Solution {
    public int candy(int[] rat) {
        HashMap<Integer,Integer>m1=new HashMap<>();
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(int i=0;i<rat.length;i++){
            pq.add(new pair(rat[i],i));
        }
        int count=1;
        while(!pq.isEmpty()){
            pair p=pq.poll();
            int i=p.in;
            int a=m1.getOrDefault(i-1,0);
            int b=m1.getOrDefault(i+1,0);
            // System.out.println(i+" "+a+" "+b);
            if(a==0 && b==0){
                m1.put(i,count);
            }
            else if(a!=0 && b!=0){
                    if(rat[i-1]<p.val && p.val>rat[i+1])
                        m1.put(i,Math.max(a,b)+1);
                    else if(rat[i-1]>=p.val && rat[i+1]<p.val){
                        m1.put(i,b+1);
                    }
                   else if(rat[i-1]<p.val && rat[i+1]>=p.val){
                       m1.put(i,a+1);
                   }
                   else m1.put(i,Math.max(a,b));
            }
            else if(a==0){
                if(p.val>rat[i+1]){
                    m1.put(i,b+1);
                }
                else m1.put(i,count);
            }
            else{
                if(p.val>rat[i-1]){
                    m1.put(i,a+1);
                }
                else m1.put(i,count);
            }
            // System.out.println(p.in+" "+p.val);
            // System.out.println(m1);
        }
        int sum=0;
        for(int i:m1.keySet()){
            sum+=m1.get(i);
        }
        return sum;
    }
}