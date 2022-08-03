class MyCalendar {
    TreeMap<Integer,Integer>m1;
    public MyCalendar() {
        m1=new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        // boolean f=false;
        int maxend=-1;
        for(int i:m1.keySet()){
            if(maxend<=start && end<=i){
               m1.put(start,end);
               return true;
            }
            maxend=m1.get(i);
        }
        if(maxend<=start) {
            m1.put(start,end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */