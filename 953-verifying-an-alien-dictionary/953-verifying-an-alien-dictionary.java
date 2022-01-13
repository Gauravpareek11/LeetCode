class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] mapping=new int[26];
        for (int i = 0; i < order.length(); i++)
            mapping[order.charAt(i) - 'a'] = i;
        
        for(int i=0;i<words.length-1;i++){
            for(int j=0;j<Math.min(words[i].length(),words[i+1].length());j++){
                if(words[i].charAt(j)!=words[i+1].charAt(j)){ 
                    if(mapping[words[i].charAt(j)-'a']>mapping[words[i+1].charAt(j)-'a'])
                        return false;
                    else if(i+1==words.length-1) return true;
                    else break;
                }
            }
            if(words[i].length()>words[i+1].length()) return false;
        }
        return true;
    }
}