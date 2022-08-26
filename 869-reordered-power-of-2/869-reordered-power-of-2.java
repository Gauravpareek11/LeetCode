class Solution {
    public boolean reorderedPowerOf2(int n) {
        if(n==1) return true;
        int i=2;
        String s=Integer.toString(n);
        while((long)i<=(int)1e9){
            String x=Integer.toString(i);
            if(check(s,x)) return true;
            i=i*2;
        }
        return false;
    }
    boolean check(String a,String b){
        if(a.length()!=b.length()) return false;
        int[] count=new int[10];
        for(int i=0;i<a.length();i++){
            count[a.charAt(i)-'0']++;
            count[b.charAt(i)-'0']--;
        }
        for(int i=0;i<10;i++){
            if(count[i]!=0) return false;
        }
        return true;
    }
}