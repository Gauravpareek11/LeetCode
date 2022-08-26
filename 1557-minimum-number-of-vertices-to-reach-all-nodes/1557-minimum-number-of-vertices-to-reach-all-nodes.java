class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        List<Integer>l1=new ArrayList<Integer>();
        int[] in=new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer>l2:edges){
            adj.get(l2.get(0)).add(l2.get(1));
            in[l2.get(1)]++;
        }
        for(int i=0;i<n;i++){
            if(in[i]==0) l1.add(i);
        }
        return l1;
    }
}