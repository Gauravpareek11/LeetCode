class Solution {
    public int firstUniqChar(String s) {
        int[] c=new int[26];
        for(int i=0;i<s.length();i++){
            c[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(c[s.charAt(i)-'a']==1) return i;
        }
        return -1;
    }
}