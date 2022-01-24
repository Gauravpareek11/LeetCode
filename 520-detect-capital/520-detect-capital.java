class Solution {
    public boolean detectCapitalUse(String word) {
        char[] words=word.toCharArray();
        int count=0;
        for(char c:words){
            if(Character.isUpperCase(c)) count++;
        }
        if(count==word.length()) return true;
        count=0;
        for(char c:words){
            if(Character.isLowerCase(c)) count++;
        }
        if(count==word.length()) return true;
        boolean is=false;
        if(Character.isUpperCase(words[0])) is=true;
        for(int i=1;i<words.length;i++){
            if(Character.isUpperCase(words[i])) return false;
        }
        return is;
    }
}