class MyHashSet {
    ArrayList<Integer>l1=new ArrayList<>();
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        if(!l1.contains(key))
            l1.add(key);
    }
    
    public void remove(int key) {
        l1.remove((Integer)key);
    }
    
    public boolean contains(int key) {
        return l1.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */