class Solution {
    public int countTriplets(int[] arr) {
        int ans=0;
        for(int i=0;i<arr.length;i++){
            int x=arr[i];
            for(int j=i+1;j<arr.length;j++){
                x^=arr[j];
                if(x==0) ans+=(j-i);
            }
        }
        return ans;
    }
}