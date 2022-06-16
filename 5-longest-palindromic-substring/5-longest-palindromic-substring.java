class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb=new StringBuilder(s);
        String s2=sb.reverse().toString();
        int[][] dp=new int[s.length()+1][s.length()+1];
        
        int x=0;
        int y=0;
        int max=0;
        String ans="";
        for(int i=0;i<=s.length();i++){
            for(int j=0;j<=s2.length();j++){
                
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else{
                    if(s.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                    else dp[i][j]=0;
                    if(max<dp[i][j]){
                        String temp=s.substring(i-dp[i][j],i);
                        StringBuilder revtemp=new StringBuilder(temp);
                        if(revtemp.reverse().toString().equals(temp))
                        {
                            max=dp[i][j];
                            ans=temp;
                        }
                    }
                }
            }
        }
        // StringBuilder ans=new StringBuilder("");
        // while(x>=1 && y>=1 && max>0){
        //     if(s.charAt(x-1)==s2.charAt(y-1)){
        //         ans.append(s.charAt(x-1));
        //         max--;
        //     }
        //     x--;
        //     y--;
        // }
        return ans;
    }
}