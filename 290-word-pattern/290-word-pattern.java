class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] in=s.split(" ");
        if(in.length!=pattern.length()) return false;
        HashMap<String,Integer>m1=new HashMap<>();
        int j=0;
        for(int i=0;i<in.length;i++){
            if(!m1.containsKey(in[i])){
                m1.put(in[i],j);
                j++;
            }
        }
       HashMap<Character,Integer>m2=new HashMap<>();
        j=0;
        for(int i=0;i<pattern.length();i++){
            if(!m2.containsKey(pattern.charAt(i))){
                m2.put(pattern.charAt(i),j);
                j++;
            }
        }
        for(int i=0;i<in.length;i++){
            if(m1.get(in[i])!=m2.get(pattern.charAt(i))) return false;
        }
        return true;
    }
}