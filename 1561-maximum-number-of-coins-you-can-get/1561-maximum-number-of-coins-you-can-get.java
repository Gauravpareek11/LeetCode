class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int max=0;
        int i=piles.length-1;
        int j=0;
        while(i>j){
            max+=(piles[i-1]);
            i=i-2;
            j++;
        }
        return max;
    }
}