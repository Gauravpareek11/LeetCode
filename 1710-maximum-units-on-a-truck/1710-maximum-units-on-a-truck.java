class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int ans=0;
        int i=0;
        while(truckSize!=0 && i<boxTypes.length){
            int x=Math.min(truckSize,boxTypes[i][0]);
            ans+=x*boxTypes[i][1];
            truckSize-=x;
            i++;
        }
        return ans;
    }
}