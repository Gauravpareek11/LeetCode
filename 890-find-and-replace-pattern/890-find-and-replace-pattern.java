class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String>ans=new ArrayList<>();
        for(String s:words){
            if(pattern.length()!=s.length()) continue;
            HashMap<Character,Character>m1=new HashMap<>();
            int[] count=new int[26];
            boolean f=true;
            for(int i=0;i<s.length();i++){
                if(m1.containsKey(s.charAt(i))){
                    if(m1.get(s.charAt(i))!=pattern.charAt(i)){
                        f=false;
                        break;
                    }
                }
                else {
                    if(count[pattern.charAt(i)-'a']!=-1){
                        m1.put(s.charAt(i),pattern.charAt(i));
                        count[pattern.charAt(i)-'a']=-1;
                    }
                    else{
                        f=false;
                        break;
                    }
                }
            }
            if(f) ans.add(s);
        }
        return ans;
    }
}