class Solution {
    public boolean isPowerOfThree(int n) {
        // for(int i=31;i>0;i--){
        //     int mask=1<<i;
        //     n=(n^mask);
        //     if(n<=9) break;
        // }
        // if(n==9 || n==3 || n==1) return true;
        // return false;
        if(n==0) return false;
        if(n==1) return true;
        float x=(float)(Math.log10(n)/Math.log10(3));
        // System.out.println(x);
        if(Math.pow(3,x)==n) return true;
        return false;
    }
}