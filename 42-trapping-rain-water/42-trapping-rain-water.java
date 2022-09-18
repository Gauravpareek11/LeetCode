class Solution {
    public int trap(int[] height) {
        int[] lm=new int[height.length];
        int[] rm=new int[height.length];
        
        lm[0]=-1;
        int max=height[0];
        for(int i=1;i<height.length;i++){
            lm[i]=max;
            max=Math.max(height[i],max);
        }
        rm[rm.length-1]=-1;
        max=height[rm.length-1];
        for(int i=rm.length-2;i>=0;i--){
            rm[i]=max;
            max=Math.max(max,height[i]);
        }
        int ans=0;
        for(int i=0;i<height.length;i++){
            if(lm[i]>height[i] && rm[i]>height[i]){
                ans+=Math.min(lm[i],rm[i])-height[i];
            }
        }
        return ans;
    }
}