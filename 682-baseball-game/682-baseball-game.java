class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer>s1=new Stack<Integer>();
        for(String i:ops){
            if(i.equals("+")){
                int a=s1.pop();
                int b=s1.pop();
                int c=a+b;
                s1.add(b);
                s1.add(a);
                s1.add(c);
            }
            else if(i.equals("D")){
                int a=s1.peek();
                int c=2*a;
                s1.add(c);
            }
            else if(i.equals("C")){
                s1.pop();
            }
            else{
                s1.add(Integer.parseInt(i));
            }
        }
        int sum=0;
        while(!s1.isEmpty()){
            sum+=s1.pop();
        }
        return sum;
    }
}