class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int even=0;
        int odd=0;
        int[] ans=new int[queries.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0) even+=nums[i];
            else odd+=nums[i];
        }
        // System.out.println(even+" "+odd);
        int x=0;
        for(int[]a:queries){
            int i=a[1];
            int val=a[0];
            // System.out.println(i+" "+val);
            if(nums[i]%2==0 && val%2==0){
                even+=val;
                nums[i]+=val;
            }
            else if(nums[i]%2!=0 && val%2!=0){
                odd-=nums[i];
                nums[i]+=val;
                even+=nums[i];
            }
            else if(nums[i]%2==0 && val%2!=0){
                even-=nums[i];
                nums[i]+=val;
                odd+=nums[i];
            }
            else{
                odd+=val;
                nums[i]+=val;
            }
            // System.out.println(odd+" "+even);
            ans[x++]=even;
        }
        return ans;
    }
}