class LRUCache {
    
    HashMap<Integer,Integer>m1;
    ArrayList<Integer>l1;
    int cap=0;
    int count;
    public LRUCache(int capacity) {
        this.cap=capacity;
        this.count=0;
        this.m1=new HashMap<>();
        this.l1=new ArrayList<>();
        
    }
    
    public int get(int key) {
        if(m1.containsKey(key)){
            int x=index(key);
            l1.remove(x);
            l1.add(key);
            return m1.get(key);
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(m1.containsKey(key)){
            int x=index(key);
            l1.remove(x);
            l1.add(key);
            m1.put(key,value);
        }
        else if(count==cap){
            int a=l1.get(0);
            l1.remove(0);
            m1.remove(a);
            m1.put(key,value);
            l1.add(key);
        }
        else{
            m1.put(key,value);
            l1.add(key);
            count++;
        }
        
    }
    private int index(int num){
        for(int i=0;i<l1.size();i++){
            if(l1.get(i)==num) return i;
        }
        return -1;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */