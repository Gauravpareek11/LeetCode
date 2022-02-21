class Solution {
    int ans=0;
    public int reversePairs(int[] nums) {
        ans=0;
        mergesort(nums,0,nums.length-1);
        return ans;
    }
    void mergesort(int[] a,int low,int high){
        if(low<high)
        {
        int mid=low+(high-low)/2;
        mergesort(a,low,mid);
        mergesort(a,mid+1,high);
        merge(a,low,mid,high);
        }
    }
    void merge(int[] a,int low,int mid,int high){
        int[] temp=new int[high-low+1];
        int j=mid+1;
        for(int i=low;i<=mid;i++){
            while(j<=high && a[i]>(long)2*a[j]){
                j++;
            }
            ans+=(j-(mid+1));
        }
        int i=low;
        j=mid+1;
        int k=0;
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k]=a[i];
                k++;
                i++;
            }
            else{
                temp[k]=a[j];
                j++;
                k++;
            }
        }
        while(i<=mid){
            temp[k]=a[i];
            k++;
            i++;
        }
        while(j<=high){
            temp[k]=a[j];
            j++;
            k++;
        }
        for(int x=0;x<temp.length;x++){
            a[low+x]=temp[x];
        }
    }
}