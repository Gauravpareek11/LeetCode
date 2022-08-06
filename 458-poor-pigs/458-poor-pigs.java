class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int a=minutesToTest/minutesToDie;
        return (int)Math.ceil(Math.log(buckets)/Math.log(a+1));
    }
}