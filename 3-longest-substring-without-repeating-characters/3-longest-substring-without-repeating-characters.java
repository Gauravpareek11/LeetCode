class Solution {
    public int lengthOfLongestSubstring(String s) {
        // int f=Integer.MIN_VALUE;
        // int start=0,end=0;
        // Set<Character>s1=new HashSet<Character>();
        // if(s.length()==0){
        //     return 0;
        // }
        // while(end<s.length()){
        //     if(!s1.contains(s.charAt(end))){
        //         s1.add(s.charAt(end++));
        //         f=Math.max(f,s1.size());
        //     }
        //     else{
        //         s1.remove(s.charAt(start++));
        //     }
        // }
        // return f;
        int ans=0;
        int start=0,end=0;
        HashSet<Character>s1=new HashSet<Character>();
        while(end<s.length()){
            if(!s1.contains(s.charAt(end))){
                s1.add(s.charAt(end));
                ans=Math.max(ans,s1.size());
                end++;
            }
            else{
                s1.remove(s.charAt(start++));
            }
        }
        return ans;
    }
}