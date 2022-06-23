class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(x,y)->Integer.compare(x[1],y[1]));
        // int[][] dp=new int[courses.length][courses[courses.length-1][1]+1];
        // // for(int[] a:dp){
        // //     Arrays.fill(a,-1);
        // // }
        // for(int i=1;i<courses.length;i++){
        //     for(int j=1;j<=courses[courses.length-1][1];j++){
        //         int not_pick=dp[i-1][j];
        //         int pick=0;
        //         if(j+courses[i][0]<=courses[i][1]) pick=1+dp[i-1][j+courses[i][0]];
        //         dp[i][j]=Math.max(pick,not_pick);
        //     }
        // }
        // // return solve(0,courses,0,dp);
        // return dp[courses.length-1][courses[courses.length-1][1]];
        
        PriorityQueue<Integer> q = new PriorityQueue<>((i,j)->Integer.compare(j,i));
        int time =0;
        for(int i =0;i<courses.length;i++){
            int[] cur = courses[i];
            time+=cur[0];
            q.add(cur[0]);
            if(time>cur[1]) time-=q.poll();
        }
        return q.size();
        
    }
//     int solve(int i,int[][] course,int curr,int[][] dp){
// //         if(i>=course.length) return 0;
        
// //         if(dp[i][curr]!=-1) return dp[i][curr];
        
// //         int not_pick=solve(i+1,course,curr,dp);
// //         int pick=0;
// //         if(curr+course[i][0]<=course[i][1]) pick=1+solve(i+1,course,curr+course[i][0],dp);
// //         return dp[i][curr]=Math.max(pick,not_pick);
// //     }
}