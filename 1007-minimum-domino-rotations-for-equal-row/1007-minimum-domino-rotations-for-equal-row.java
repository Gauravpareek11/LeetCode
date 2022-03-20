class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashMap<Integer,Integer>m1=new HashMap<>();
        for(int i=0;i<bottoms.length;i++){
            if(m1.containsKey(bottoms[i])) m1.put(bottoms[i],m1.get(bottoms[i])+1);
            else m1.put(bottoms[i],1);
        }
        if(m1.size()==1) return 0;
        m1.clear();
        for(int i=0;i<tops.length;i++){
            if(m1.containsKey(tops[i])) m1.put(tops[i],m1.get(tops[i])+1);
            else m1.put(tops[i],1);
        }
        if(m1.size()==1) return 0;
        for(int i=0;i<bottoms.length;i++){
            if(m1.containsKey(bottoms[i])) m1.put(bottoms[i],m1.get(bottoms[i])+1);
            else m1.put(bottoms[i],1);
        }
        int maxfreq=0;
        int element=0;
        for(int i:m1.keySet()){
            if(maxfreq<m1.get(i)){
                maxfreq=m1.get(i);
                element=i;
            }
        }
        int ans1=0;
        for(int i=0;i<tops.length;i++){
            if(tops[i]!=element){
                if(bottoms[i]==element) ans1++;
                else return -1;
            }
        }
        
        int ans2=0;
        for(int i=0;i<tops.length;i++){
            if(bottoms[i]!=element){
                if(tops[i]==element) ans2++;
                else return -1;
            }
        }
        return Math.min(ans1,ans2);
    }
}