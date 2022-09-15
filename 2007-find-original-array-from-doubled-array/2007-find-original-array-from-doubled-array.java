class Solution {
    public int[] findOriginalArray(int[] changed) {
        HashMap<Integer,Integer>m1=new HashMap<>();
        for(int i:changed){
            m1.put(i,m1.getOrDefault(i,0)+1);
        }
        int[] ans=new int[changed.length/2];
        if(changed.length%2==1) return new int[]{};
        int x=0;
        Arrays.sort(changed);
        for(int i:changed){
            if(m1.getOrDefault(i,0)>=1 && m1.getOrDefault(2*i,0)>=1){
                if(i==0){
                    if(m1.get(i)>=2)
                    {
                        ans[x++]=i;
                        m1.put(i,m1.get(i)-1);
                        m1.put(2*i,m1.get(2*i)-1);
                    }
                }
                else{
                    ans[x++]=i;
                    m1.put(i,m1.get(i)-1);
                    m1.put(2*i,m1.get(2*i)-1);
                }
            }
        }
        if(x!=ans.length) return new int[]{};
        else return ans;
    }
}