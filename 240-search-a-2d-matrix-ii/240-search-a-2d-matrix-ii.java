class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] row:matrix){
            if(search(row,target)){
                return true;
            }
        }
        return false;
    }
    boolean search(int[] arr,int target){
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low);
            if(arr[mid]==target) return true;
            else if(arr[mid]<target) low=mid+1;
            else high=mid-1;
        }
        return false;
    }
}