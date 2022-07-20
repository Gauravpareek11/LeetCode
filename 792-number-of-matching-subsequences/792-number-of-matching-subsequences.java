class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character,ArrayList<Integer>>m1=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(m1.containsKey(s.charAt(i))){
                m1.get(s.charAt(i)).add(i);
            }
            else{
                ArrayList<Integer>l1=new ArrayList<Integer>();
                l1.add(i);
                m1.put(s.charAt(i),l1);
            }
        }
        // System.out.println(m1);
        int ans=0;
        for(String x:words){
            int start=-1;
            boolean f=true;
            int a=-1;
            for(int i=0;i<x.length();i++){
                if(!m1.containsKey(x.charAt(i))){
                    f=false;
                    break;
                }
                for(int j=0;j<m1.get(x.charAt(i)).size();j++){
                    if(m1.get(x.charAt(i)).get(j)>start){
                        a=m1.get(x.charAt(i)).get(j);
                        break;
                    }
                }
                if(a==start){
                    f=false;
                    break;
                }
                else{
                    start=a;
                }
            }
            if(f) ans++;
        }
        return ans;
    }
}