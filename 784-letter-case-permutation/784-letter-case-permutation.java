class Solution {
    public List<String> letterCasePermutation(String s) {
        char[] a=s.toCharArray();
        List<String>ans=new ArrayList<>();
        // ans.add(s);
        permute(ans,a,0);
        return ans;
    }
    void permute(List<String>ans,char[] a,int i){
        ans.add(new String(a));
        for(int j=i;j<a.length;j++){
            if((a[j]>='a' && a[j]<='z') || (a[j]>='A' && a[j]<='Z')){
                if(Character.isUpperCase(a[j])){
                    a[j]=Character.toLowerCase(a[j]);
                    permute(ans,a,j+1);
                    a[j]=Character.toUpperCase(a[j]);
                }
                else{
                    a[j]=Character.toUpperCase(a[j]);
                    permute(ans,a,j+1);
                    a[j]=Character.toLowerCase(a[j]);
                }
            }
        }
        return;
    }
}