/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger>s1=new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        prepare(nestedList);
    }

    @Override
    public Integer next() {
        if(!hasNext()) return null;
        return s1.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!s1.isEmpty() && !s1.peek().isInteger()){
            List<NestedInteger>l1=s1.pop().getList();
            prepare(l1);
        }
        return !s1.isEmpty();
    }
    void prepare(List<NestedInteger>l1){
        for(int i=l1.size()-1;i>=0;i--){
            s1.add(l1.get(i));
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */