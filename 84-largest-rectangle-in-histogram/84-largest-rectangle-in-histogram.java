class Solution {
    public int largestRectangleArea(int[] heights) {
        long ans=0;
        // for(int i=0;i<heights.length;i++){
        //     long k=heights[i];
        //     ans=Math.max(ans,k);
        //     long h=k;
        //     for(int j=i+1;j<heights.length;j++){
        //         k=Math.min(k,heights[j]);
        //         h=k*(j-i+1);
        //         ans=Math.max(ans,h);
        //     }
        // }
        // return (int)ans;
        int n=heights.length;
        int[] ps=new int[n];
        int[] ns=new int[n];
        Arrays.fill(ps,-1);
        Arrays.fill(ns,n);
        Stack<Integer>s1=new Stack<>();
        for(int i=0;i<n;i++){
            while(!s1.isEmpty() && heights[s1.peek()]>=heights[i]){
                s1.pop();
            }
            if(!s1.isEmpty()) ps[i]=s1.peek();
            s1.add(i);
        }
        s1.clear();
        for(int i=n-1;i>=0;i--){
            while(!s1.isEmpty() && heights[s1.peek()]>=heights[i]){
                s1.pop();
            }
            if(!s1.isEmpty()) ns[i]=s1.peek();
            s1.add(i);
        }
        for(int i=0;i<n;i++){
            ans=Math.max(ans,heights[i]*(ns[i]-ps[i]-1));
        }
        return (int)ans;
    }
}