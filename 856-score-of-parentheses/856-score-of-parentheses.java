class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer>s1=new Stack<>();
        s1.add(0);
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') s1.add(0);
            else{
                int x=s1.pop();
                int y=s1.pop();
                ans=y+Math.max(2*x,1);
                s1.add(ans);
            }
        }
        return ans;
    }
}