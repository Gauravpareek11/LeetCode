class Solution {
    public int climbStairs(int n) {
         int prev=1;
        int prev2=1;
        int c=0;
        for(int i=2;i<=n;i++){
            c=prev+prev2;
            prev2=prev;
            prev=c;
        }
        return prev;
    }
}