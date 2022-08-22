class Solution {
    public boolean isPowerOfFour(int n) {
        if((n&(n-1))!=0) return false;
        else{
            int c=0;
            while(n>1 && (n&1)==0){
                c++;
                n>>=1;
            }
            if(n==1 && (c&1)==0) return true;
            return false;
        }
    }
}