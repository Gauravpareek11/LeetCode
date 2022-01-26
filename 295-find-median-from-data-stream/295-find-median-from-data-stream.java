class MedianFinder {
    PriorityQueue<Integer>small=new PriorityQueue<>((a,b)->Integer.compare(b,a));
    PriorityQueue<Integer>large=new PriorityQueue<>();
    boolean even=true;
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(even){
            large.add(num);
            small.add(large.poll());
        }
        else{
            small.add(num);
            large.add(small.poll());
        }
        even=!even;
    }
    
    public double findMedian() {
        if(even){
            return (small.peek()+large.peek())/2.0;
        }
        return small.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */