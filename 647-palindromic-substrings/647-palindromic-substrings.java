class Solution {
    public int countSubstrings(String s) {
        int ans=s.length();
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                if(check(s.substring(i,j+1))) ans++;
            }
        }
        return ans;
    }
    boolean check(String s){
        int a=0;
        int b=s.length()-1;
        while(a<b){
            if(s.charAt(a)!=s.charAt(b)){
                return false;
            }
            a++;
            b--;
        }
        return true;
    }
}