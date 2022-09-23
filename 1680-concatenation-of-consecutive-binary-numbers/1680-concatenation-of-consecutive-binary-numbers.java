class Solution {
    public int concatenatedBinary(int n) {
        long mod=(long)1e9+7;
        long ans=0;
        long i=1;
        while(i<=n){
            int digi=(int)(Math.log(i)/Math.log(2))+1;
            ans=ans<<digi;
            // ans=ans%mod;
            ans=(ans|i);
            ans=ans%mod;
            i++;
        }
        return (int)ans;
    }
}