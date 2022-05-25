class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(c,d)->Integer.compare(c.length(),d.length()));
        int[] dp=new int[words.length];
        Arrays.fill(dp,1);
        for(int i=0;i<words.length;i++){
            for(int j=0;j<i;j++){
                if(words[j].length()+1!=words[i].length()) continue;
                for(int k=0;k<words[i].length();k++){
                    String a=words[i].substring(0,k);
                    String b=words[i].substring(k+1,words[i].length());
                    String x=a+b;
                    if(x.indexOf(words[j])!=-1){
                        dp[i]=Math.max(dp[i],1+dp[j]);
                        break;
                    }
                }
            }
        }
        int max=1;
        for(int i=0;i<dp.length;i++){
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}