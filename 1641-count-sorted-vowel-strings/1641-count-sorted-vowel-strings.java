class Solution {
    public int countVowelStrings(int n) {
        int[] a={1,1,1,1,1};
        int sum=5;
        for(int i=2;i<=n;i++){
            int[] temp=new int[5];
            temp[0]=sum;
            temp[1]=sum-a[0];
            temp[2]=temp[1]-a[1];
            temp[3]=temp[2]-a[2];
            temp[4]=temp[3]-a[3];
            sum=temp[0]+temp[1]+temp[2]+temp[3]+temp[4];
            a=temp;
        }
        return sum;
    }
}