class Solution {
    public int minDeletions(String s) {
        int[] count=new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        int ans=0;
        HashSet<Integer>s1=new HashSet<>();
        for(int i=0;i<26;i++){
            while(count[i]>0 && s1.contains(count[i])){
                count[i]--;
                ans++;
            }
            s1.add(count[i]);
        }
        return ans;
    }
}