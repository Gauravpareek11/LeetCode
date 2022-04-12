class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        // for(int[] a:dp){
        //     Arrays.fill(a,-1);
        // }
        // return solve(word1,word2,word1.length()-1,word2.length()-1,dp);
        for(int i=0;i<=word1.length();i++){
            for(int j=0;j<=word2.length();j++){
                if(i==0) dp[i][j]=j;
                else if(j==0) dp[i][j]=i;
                else{
                    if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                    else{
                        int a=1+dp[i][j-1];
                        int b=1+dp[i-1][j];
                        int c=1+dp[i-1][j-1];
                        dp[i][j]=Math.min(a,Math.min(b,c));
                    }
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
//     int solve(String a,String b,int i,int j,int[][] dp){
//         if(i<0) return j+1;
//         if(j<0) return i+1;
        
//         if(dp[i][j]!=-1) return dp[i][j];
        
//         if(a.charAt(i)==b.charAt(j)) return dp[i][j]=solve(a,b,i-1,j-1,dp);
//         else{
//             int x=1+solve(a,b,i,j-1,dp);
//             int y=1+solve(a,b,i-1,j,dp);
//             int z=1+solve(a,b,i-1,j-1,dp);
//             return dp[i][j]=Math.min(x,Math.min(y,z));
//         }
//     }
}