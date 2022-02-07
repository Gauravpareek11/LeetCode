class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans=new int[n][n];
        int rowStart=0;
        int colStart=0;
        int rowEnd=n-1;
        int colEnd=n-1;
        int a=1;
        while(rowStart<=rowEnd && colStart<=colEnd){
            for(int i=colStart;i<=colEnd;i++){
                ans[rowStart][i]=a;
                a++;
            }
            rowStart++;
            for(int i=rowStart;i<=rowEnd;i++){
                ans[i][colEnd]=a;
                a++;
            }
            colEnd--;
            if(rowStart<=rowEnd){
                for(int i=colEnd;i>=colStart;i--){
                    ans[rowEnd][i]=a++;
                }
            }
            rowEnd--;
            if(colStart<=colEnd){
                for(int i=rowEnd;i>=rowStart;i--){
                    ans[i][colStart]=a++;
                }
            }
            colStart++;
        }
        return ans;
    }
}