class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i=1;
        int c=0;
        HashSet<Integer>s1=new HashSet<>();
        for(int j=0;j<arr.length;j++){
            s1.add(arr[j]);
        }
        while(c<k){
            if(!s1.contains(i)){
                c++;
                if(c==k) return i;
                i++;
            }
            else i++;
        }
        return i;
    }
}