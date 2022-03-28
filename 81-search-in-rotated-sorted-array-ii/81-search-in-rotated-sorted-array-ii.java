class Solution {
    public boolean search(int[] nums, int target) {
        int n=nums.length;
        if(n==1 && nums[0]!=target){
            return false;
        }
        if(n==1 && nums[0]==target){
            return true;
        }
        int p=peak(nums,0,n-1);
        // System.out.println(p);
        if(nums[p]==target){
            return true;
        }
        if(p==0){
            return binarysearch(nums,0,n-1,target);
        }
            return (binarysearch(nums,p,n-1,target) || binarysearch(nums,0,p,target));
    }
    boolean binarysearch(int[] a,int low,int high,int target){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(a[mid]==target){
               return true;
            }
            else if(a[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return false;
    }
    int peak(int[] a,int start,int end){
        int mid=start+(end-start)/2;
            if(mid!=a.length-1 && a[mid]>a[mid+1]){
                return mid+1;
            }
            if(start>=end){
            return 0;
            }
            int x=peak(a,start,mid-1);
            int y=peak(a,mid+1,end); 
            return Math.max(x,y);
        }
}