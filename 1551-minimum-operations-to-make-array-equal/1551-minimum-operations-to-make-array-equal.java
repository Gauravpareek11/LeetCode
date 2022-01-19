class Solution {
    public int minOperations(int n) {
        int mid=0;
        if(n%2!=0){
            mid=(2*(n/2))+1;
        }
        else{
            int a=(2*(n/2-1))+1;
            int b=(2*(n/2))+1;
            mid=(a+b)/2;
        }
        int ans=0;
        for(int i=0;i<n/2;i++){
            ans+=mid-((2*i)+1);
        }
        return ans;
    }
}