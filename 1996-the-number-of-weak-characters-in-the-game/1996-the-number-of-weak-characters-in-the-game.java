class Solution {
    public int numberOfWeakCharacters(int[][] p) {
        Arrays.sort(p,(x,y)->Integer.compare(x[1],y[1]));
        Arrays.sort(p,(x,y)->Integer.compare(y[0],x[0]));

        int ans=0;
        int prev=0;
        for(int i=0;i<p.length;i++){
            if(p[i][1]<prev){
                ans++;
            }
            prev=Math.max(prev,p[i][1]);
        }
        return ans;
    }
}