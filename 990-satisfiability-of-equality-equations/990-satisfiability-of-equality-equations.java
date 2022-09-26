class Solution {
    public boolean equationsPossible(String[] eq) {
        int[] c=new int[26];
        for(int i=0;i<26;i++){
            c[i]=i;
        }
        for(String x:eq){
            if(x.charAt(1)=='='){
                c[find(x.charAt(0)-'a',c)]=find(x.charAt(3)-'a',c);
            }
        }
        for(String x:eq){
            if(x.charAt(1)=='!' && find(x.charAt(0)-'a',c)==find(x.charAt(3)-'a',c)) 
                return false;
        }
        return true;
    }
    int find(int a,int[] c){
        if(a==c[a]) return a;
        return find(c[a],c);
    }
}