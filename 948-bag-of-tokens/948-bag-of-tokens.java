class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i=0;
        int j=tokens.length-1;
        int ans=0;
        int max=0;
        while(i<=j){
            if(tokens[i]<=power){
                ans+=1;
                power-=tokens[i];
                i++;
            }
            else if(ans>0){
                ans-=1;
                power+=tokens[j];
                j--;
            }
            else{
                return max;
            }
            max=Math.max(max,ans);
        }
        return max;
    }
}