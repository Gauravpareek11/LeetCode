class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer>m1=new HashMap<>();
        List<Integer>ans=new ArrayList<>();
        for(String a:words){
            m1.put(a,m1.getOrDefault(a,0)+1);
        }
        int x=words[0].length();
        int i=0;
        HashMap<String,Integer>m2=new HashMap<>();
        int j=0;
        while(j<s.length()){
            if(m1.equals(m2)) {
                ans.add(i);
                m2.clear();
                i+=1;
                j=i;
            }
            if(j+x<=s.length() && m1.containsKey(s.substring(j,j+x)) && m2.getOrDefault(s.substring(j,j+x),0)<m1.get(s.substring(j,j+x))){
                m2.put(s.substring(j,j+x),m2.getOrDefault(s.substring(j,j+x),0)+1);
                j+=x;
            }
            else{
                m2.clear();
                i+=1;
                j=i;
            }
            // System.out.println(m2);
        }
        if(m1.equals(m2)) ans.add(i);
        return ans;
    }
}