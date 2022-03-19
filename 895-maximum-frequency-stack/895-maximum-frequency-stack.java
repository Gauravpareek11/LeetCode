class FreqStack {
    HashMap<Integer,Integer>m1;
    HashMap<Integer,Stack<Integer>>m2;
    int maxfreq;
    public FreqStack() {
        m1=new HashMap<>();
        m2=new HashMap<>();
        maxfreq=0;
    }
    
    public void push(int val) {
        if(m1.containsKey(val)) m1.put(val,m1.get(val)+1);
        else m1.put(val,1);
        int f=m1.get(val);
        if(f>maxfreq) maxfreq=f;
        if(m2.containsKey(f)){
            m2.get(f).add(val);
        }
        else{
            Stack<Integer>s1=new Stack<>();
            s1.add(val);
            m2.put(f,s1);
        }
    }
    
    public int pop() {
        int x=m2.get(maxfreq).pop();
        m1.put(x,maxfreq-1);
        if(m2.get(maxfreq).size()==0) maxfreq--;
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */