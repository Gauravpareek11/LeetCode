class Solution {
    public int maxPoints(int[][] points) {
        int ans=1;
        for(int i=0;i<points.length;i++){
            HashMap<Double,Integer>m1=new HashMap<>();
            double x1=points[i][0];
            double y1=points[i][1];
            for(int j=0;j<points.length;j++){
                if(j==i) continue;
                double slope=(double)((points[j][0]-x1)/((double)points[j][1]-y1));
                if(m1.containsKey(slope)){
                    m1.put(slope,m1.get(slope)+1);
                }
                else m1.put(slope,1);
            }
            int max=0;
            for(double m:m1.keySet()){
                max=Math.max(max,m1.get(m));
            }
            ans=Math.max(max+1,ans);
        }
        return ans;
    }
}