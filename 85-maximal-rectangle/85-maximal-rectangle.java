class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[][] a=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                a[i][j]=matrix[i][j]-'0';
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i!=0){
                    if(a[i][j]==1){
                        a[i][j]=a[i][j]+a[i-1][j];
                    }
                }
            }
        }
        int ans=0;
        for(int i=0;i<matrix.length;i++){
            ans=Math.max(ans,solve(a[i],matrix[i].length));
        }
        return ans;
    }
    int solve(int[] a,int n){
        Stack<Integer>s1=new Stack<>();
        int[] ns=new int[n];
        int[] ps=new int[n];
        Arrays.fill(ns,n);
        Arrays.fill(ps,-1);
        for(int i=0;i<n;i++){
            while(!s1.isEmpty() && a[s1.peek()]>=a[i]){
                s1.pop();
            }
            if(!s1.isEmpty()) ps[i]=s1.peek();
            s1.add(i);
        }
        s1.clear();
        for(int i=n-1;i>=0;i--){
            while(!s1.isEmpty() && a[s1.peek()]>=a[i]){
                s1.pop();
            }
            if(!s1.isEmpty()) ns[i]=s1.peek();
            s1.add(i);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,a[i]*(ns[i]-ps[i]-1));
        }
        return ans;
    }
}