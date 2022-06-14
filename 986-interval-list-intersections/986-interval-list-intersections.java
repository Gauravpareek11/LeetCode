class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]>l1=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<firstList.length && j<secondList.length){
            if(Math.max(firstList[i][0],secondList[j][0])<=Math.min(firstList[i][1],secondList[j][1])){
                int a=Math.max(firstList[i][0],secondList[j][0]);
                int b=Math.min(firstList[i][1],secondList[j][1]);
                l1.add(new int[]{a,b});
                if(b==firstList[i][1]) i++;
                else j++;
            }
            else if(firstList[i][0]>secondList[j][0]) j++;
            else i++;
        }
        int[][] ans=new int[l1.size()][2];
        for(i=0;i<l1.size();i++){
            ans[i][0]=l1.get(i)[0];
            ans[i][1]=l1.get(i)[1];
        }
        return ans;
    }
}