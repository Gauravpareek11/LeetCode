class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer>m1=new HashMap<>();
        for(int i:arr){
            m1.put(i,m1.getOrDefault(i,0)+1);
        }
        ArrayList<Integer>l1=new ArrayList<Integer>();
        for(int i:m1.keySet()){
            l1.add(m1.get(i));
        }
        Collections.sort(l1);
        Collections.reverse(l1);
        int n=arr.length;
        int c=0;
        int ans=0;
        for(int i=0;i<l1.size();i++){
            c+=l1.get(i);
            if(c>=n/2){
                ans++;
                return ans;
            }
            ans++;
        }
        return ans;
    }
}