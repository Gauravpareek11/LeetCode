class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        String[] x={".-","-...","-.-.","-..",".","..-.","--.",
                    "....","..",".---","-.-",".-..","--","-.","---",
                    ".--.","--.-",".-.","...","-","..-","...-",
                    ".--","-..-","-.--","--.."};
        HashSet<String>s1=new HashSet<>();
        for(String i:words){
            StringBuilder sb=new StringBuilder("");
            for(char c:i.toCharArray()){
                sb.append(x[c-'a']);
            }
            s1.add(sb.toString());
        }
        return s1.size();
    }
}