class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int count[]=new int[26];
        for(String a:words2){
            int[] temp=new int[26];
            for(int i=0;i<a.length();i++){
                temp[a.charAt(i)-'a']++;
            }
            for(int i=0;i<26;i++){
                count[i]=Math.max(count[i],temp[i]);
            }
        }
        List<String>ans=new ArrayList<>();
        for(String a:words1){
            int[] temp=count.clone();
            for(int i=0;i<a.length();i++){
                temp[a.charAt(i)-'a']--;
            }
            boolean f=true;
            for(int i=0;i<26;i++){
                if(temp[i]>0){
                    f=false;
                    break;
                }
            }
            if(f)ans.add(a);
        }
        return ans;
    }
}