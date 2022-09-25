class MyCircularQueue {
    int[] a;
    int front;
    int rear;
    int k;
    int c;
    public MyCircularQueue(int k) {
        a=new int[k];
        front=-1;
        rear=-1;
        this.k=k;
        c=0;
        
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        else{
            rear=(rear+1)%k;
            a[rear]=value;
            if(front==-1) front=rear;
            c+=1;
            return true;
        }
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        else{
            if(front==rear){
                front=-1;
                rear=-1;
                c=0;
            }
            else{
                front=(front+1)%k;
                c-=1;
            }
            return true;
        }
    }
    
    public int Front() {
        if(isEmpty()) return  -1;
        return a[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return a[rear];
    }
    
    public boolean isEmpty() {
        return (c==0);
    }
    
    public boolean isFull() {
        return (c==k);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */