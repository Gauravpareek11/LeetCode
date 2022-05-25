class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->Integer.compare(b[1],a[1]));
        Arrays.sort(envelopes,(a,b)->Integer.compare(a[0],b[0]));
        
        int[] dp=new int[envelopes.length];
        int maxii=0;
        for(int i=0;i<envelopes.length;i++){
            int ind=search(dp,0,maxii,envelopes[i][1]);
            dp[ind]=envelopes[i][1];
            if(maxii==ind) maxii++;
        }
        return maxii;
    }
    int search(int[] a,int low,int high,int x){
        while(low<high){
            int mid=low+(high-low)/2;
            if(a[mid]==x) return mid;
            else if(a[mid]<x) low=mid+1;
            else high=mid;
        }
        return low;
    }
}