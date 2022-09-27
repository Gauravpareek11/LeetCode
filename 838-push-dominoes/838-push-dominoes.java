class Solution {
    public String pushDominoes(String s) {
        int n=s.length();
        int[] force=new int[n];
        int f=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='R') f=n;
            else if(s.charAt(i)=='L') f=0;
            else f=Math.max(f-1,0);
            force[i]+=f;
        }
        f=0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='L') f=n;
            else if(s.charAt(i)=='R') f=0;
            else f=Math.max(f-1,0);
            force[i]-=f;
        }
        
        StringBuilder ans=new StringBuilder("");
        for(int i:force){
            if(i<0) ans.append("L");
            else if(i>0) ans.append("R");
            else ans.append(".");
        }
        return ans.toString();
    }
}