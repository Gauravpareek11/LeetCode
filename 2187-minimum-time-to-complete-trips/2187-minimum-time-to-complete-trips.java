class Solution {
    public long minimumTime(int[] a, int totalTrips) {
        if(a.length==1) return (long)a[0]*totalTrips;
        long low=1;
        long high=(long)1e14;
        long ans=1;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(isPossible(a,totalTrips,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    boolean isPossible(int[] a,int k,long mid){
        long c=0;
        for(int i:a){
            c+=(long)((long)mid/(long)i);
        }
        return (c>=(long)k);
    }
}