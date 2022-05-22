class Solution {
    public int countSubstrings(String s) {
        int ans=s.length();
        HashMap<String,Boolean>m1=new HashMap<>();
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                if(check(s.substring(i,j+1),m1)) ans++;
            }
        }
        return ans;
    }
    boolean check(String s,HashMap<String,Boolean>m1){
        if(m1.containsKey(s)) return m1.get(s);
        int a=0;
        int b=s.length()-1;
        while(a<b){
            if(s.charAt(a)!=s.charAt(b)){
                m1.put(s,false);
                return false;
            }
            a++;
            b--;
        }
        m1.put(s,true);
        return true;
    }
}