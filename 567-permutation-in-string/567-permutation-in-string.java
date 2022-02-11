class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int a[]=new int[26];
        for(int i=0;i<s1.length();i++){
            a[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<=s2.length()-s1.length();i++){
            int b[]=new int[26];
            for(int j=0;j<s1.length();j++){
                b[s2.charAt(i+j)-'a']++;
            }
            if(matches(a,b)){
                return true;
            }
        }
        return false;
    }
    boolean matches(int[] a,int[] b){
        for(int i=0;i<26;i++){
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }
}