class Solution {
    public int maxCoins(int[] nums) {
        ArrayList<Integer>l1=new ArrayList<>();
        l1.add(1);
        for(int i:nums){
            l1.add(i);
        }
        l1.add(1);
        int[][] dp=new int[l1.size()][l1.size()];
        // for(int i[]:dp){
        //     Arrays.fill(i,-1);
        // }
        // return solve(1,nums.length,l1,dp);
        for(int i=nums.length;i>0;i--){
            for(int j=i;j<=nums.length;j++){
                int max=0;
                for(int k=i;k<=j;k++){
                    int steps=l1.get(i-1)*l1.get(k)*l1.get(j+1)+dp[i][k-1]+dp[k+1][j];
                    max=Math.max(max,steps);
                }
                dp[i][j]=max;
            }
        }
        return dp[1][nums.length];
    }
//     int solve(int i,int j,ArrayList<Integer>l1,int[][] dp){
//         if(i>j) return 0;
        
//         if(dp[i][j]!=-1) return dp[i][j];
//         int max=0;
//         for(int k=i;k<=j;k++){
//             int steps=l1.get(i-1)*l1.get(k)*l1.get(j+1)+solve(i,k-1,l1,dp)+solve(k+1,j,l1,dp);
//             max=Math.max(max,steps);
//         }
//         return dp[i][j]=max;
//     }
}