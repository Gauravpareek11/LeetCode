class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>>m1=new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            if(m1.containsKey(prerequisites[i][0])){
                m1.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
            else{
                List<Integer>l1=new ArrayList<Integer>();
                l1.add(prerequisites[i][1]);
                m1.put(prerequisites[i][0],l1);
            }
        }
        int[] inorder=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            inorder[prerequisites[i][1]]++;
        }
        Queue<Integer>q1=new LinkedList<>();
        int cnt=0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==0) q1.add(i);
        }
        while(!q1.isEmpty()){
            int a=q1.poll();
            cnt++;
            if(m1.containsKey(a)){
                 for(int i:m1.get(a)){
                    inorder[i]--;
                    if(inorder[i]==0) q1.add(i);
                }
            }
        }
        // System.out.println(cnt);
        if(cnt==numCourses) return true;
        return false;
    }
}