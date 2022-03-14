class Solution {
    public String simplifyPath(String path) {
        String[] s=path.split("/");
         // System.out.println(Arrays.toString(s));
        Stack<String>s1=new Stack<>();
        int count=0;
        for(int i=s.length-1;i>=0;i--){
            if(!s[i].equals("") && !s[i].equals("..") && count==0) s1.add(s[i]);
            else if(s[i].equals("..")) count++;
            else if(!s[i].equals(".") && !s[i].equals("") && count>0){
                count--;
            }
            
        }
        // System.out.println(s1);
        StringBuilder sb=new StringBuilder("/");
        while(!s1.isEmpty()){
            if(s1.peek().equals(".")) s1.pop();
            else{
                sb.append(s1.pop());
                sb.append("/");
            }
        }
        String ans=sb.toString();
        if(ans.length()>1) ans=ans.substring(0,ans.length()-1);
        return ans;
    }
}