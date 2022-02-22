class Solution {
    public int titleToNumber(String columnTitle) {
       int ans=0;
        int n=columnTitle.length();
        for(int i=0;i<n;i++){
            ans+=(columnTitle.charAt(i)-'A'+1)*((int)Math.pow(26,columnTitle.substring(i,n).length()-1));
        }
        return ans;
    }
}