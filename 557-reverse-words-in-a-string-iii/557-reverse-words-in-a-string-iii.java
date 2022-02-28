class Solution {
    public String reverseWords(String s) {
        String[] word=s.split(" ");
        String ans="";
        for(String x:word){
            for(int i=x.length()-1;i>=0;i--){
                ans+=x.charAt(i);
            }
            ans+=" ";
        }
        return ans.substring(0,ans.length()-1);
    }
}