class Solution {
    public int maxProduct(String[] words) {
        int ans=0;
        for(int i=0;i<words.length;i++){
            char[] c=words[i].toCharArray();
            Arrays.sort(c);
            words[i]=new String(c);
        }
        int[] count=new int[26];
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                int k=0;
                for(k=0;k<words[j].length();k++){
                    if(words[i].indexOf(words[j].charAt(k))!=-1) break;
                }
                if(k==words[j].length()) ans=Math.max(ans,words[i].length()*k);
            }
        }
        return ans;
    }
}