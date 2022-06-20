class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words,(a,b)->Integer.compare(b.length(),a.length()));
        int ans=0;
        for(int i=0;i<words.length;i++){
            boolean f=false;
            for(int j=0;j<=i-1;j++){
                if(words[j].endsWith(words[i])){
                    f=true;
                    break;
                }
            }
            if(f) continue;
            else ans+=words[i].length()+1;
        }
        return ans;
    }
}