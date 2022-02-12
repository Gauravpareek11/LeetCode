class pair{
    String v;
    int dis;
    pair(String v,int dis){
        this.v=v;
        this.dis=dis;
    }
}
class Solution {
    int ans=Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        HashMap<String,List<String>>m1=new HashMap<>();
        List<String>l1=new ArrayList<>();
        for(String x:wordList){
            if(wordsMatch(beginWord,x)) l1.add(x);
        }
        m1.put(beginWord,l1);
        for(int i=0;i<wordList.size();i++){
            List<String>temp=new ArrayList<>();
            for(String x:wordList){
                if(wordsMatch(wordList.get(i),x)) temp.add(x);
            }
            m1.put(wordList.get(i),temp);
        }
        // System.out.println(m1);
        List<String>Visited=new ArrayList<>();
        HashMap<String,Integer>dis=new HashMap<>();
        for(int i=0;i<wordList.size();i++){
            dis.put(wordList.get(i),Integer.MAX_VALUE);
        }
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->Integer.compare(a.dis,b.dis));
        dis.put(beginWord,0);
        pq.add(new pair(beginWord,1));
        while(!pq.isEmpty()){
            pair p=pq.poll();
            for(String i:m1.get(p.v)){
                if(dis.get(i)>1+p.dis){
                    dis.put(i,1+p.dis);
                    pq.add(new pair(i,dis.get(i)));
                }
            }
        }
        return (dis.get(endWord)==Integer.MAX_VALUE?0:dis.get(endWord));
    }
    boolean wordsMatch(String a,String b){
        int c=0;
        if(a.length()!=b.length()) return false;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)) c++;
        }
        return c==1;
    }
}