class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer>l1=new ArrayList<Integer>();
        l1.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]>l1.get(l1.size()-1)) l1.add(nums[i]);
            else{
                int ind=search(l1,0,l1.size()-1,nums[i]);
                l1.set(ind,nums[i]);
            }
        }
        return l1.size();
    }
    int search(ArrayList<Integer>l1,int low,int high,int x){
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(l1.get(mid)==x) return mid;
            else if(l1.get(mid)>x){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    //     // int[][] dp=new int[nums.length+1][nums.length+1];
    //     int[] cur=new int[nums.length+1];
    //     int[] prev=new int[nums.length+1];
    //     // for(int[] a:dp){
    //     //     Arrays.fill(a,-1);
    //     // }
    //     // return solve(0,nums,-1,dp);
    //     for(int i=nums.length-1;i>=0;i--){
    //         for(int x=i-1;x>=-1;x--){
    //             int not_pick=prev[x+1];
    //             int pick=0;
    //             if(x==-1||nums[i]>nums[x]) pick=1+prev[i+1];;
    //             cur[x+1]=Math.max(pick,not_pick);
    //         }
    //         prev=cur;
    //     }
    //     return prev[0];
    // }
    // int solve(int i,int[] nums,int x,int[][] dp){
    //     if(i==nums.length-1){
    //         if(x==-1||nums[i]>nums[x]) return 1;
    //         else return 0;
    //     }
    //     if(dp[i][x+1]!=-1) return dp[i][x+1];
    //     int not_pick=solve(i+1,nums,x,dp);
    //     int pick=0;
    //     if(x==-1||nums[i]>nums[x]) pick=1+solve(i+1,nums,i,dp);
    //     return dp[i][x+1]=Math.max(pick,not_pick);
    // }
         
}