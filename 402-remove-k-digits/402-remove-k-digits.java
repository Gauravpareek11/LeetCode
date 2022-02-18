class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()<=k) return "0";
        Stack<Character>s1=new Stack<>();
        s1.add(num.charAt(0));
        for(int i=1;i<num.length();i++){
            if(s1.peek()==num.charAt(i)) s1.add(num.charAt(i));
            else if(s1.peek()<num.charAt(i)) s1.add(num.charAt(i));
            else{
                while(!s1.isEmpty() && k!=0 && s1.peek()>num.charAt(i)){
                    s1.pop();
                    k--;
                }
                s1.add(num.charAt(i));
            }
        }
        while(k>0 && !s1.isEmpty()){
            s1.pop();
            k--;
        }
        Stack<Character>t=new Stack<>();
        while(!s1.isEmpty()){
            t.add(s1.pop());
        }
        while(t.peek()=='0' && t.size()!=1) t.pop();
        StringBuilder sb=new StringBuilder("");
        while(!t.isEmpty()) sb.append(t.pop());
        return sb.toString();
    }
}