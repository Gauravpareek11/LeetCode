class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->b[0]==a[0]?a[1]-b[1]:b[0]-a[0]);
        ArrayList<int[]>l1=new ArrayList<>();
        for(int i=0;i<people.length;i++){
            l1.add(people[i][1],people[i]);
        }
        for(int i=0;i<l1.size();i++){
            people[i]=l1.get(i);
        }
        return people;
    }
}