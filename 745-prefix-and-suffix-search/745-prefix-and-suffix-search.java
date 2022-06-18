class WordFilter {
    HashMap<String,Integer>m1;
    public WordFilter(String[] words) {
        m1=new HashMap<>();
        int index=0;
        for(String word:words){
            for(int i=0;i<=word.length();i++){
                for(int j=0;j<=word.length();j++){
                    String s=word.substring(0,i)+"#"+word.substring(j);
                    m1.put(s,index);
                }
            }
            index++;
        }
        
    }
    
    public int f(String prefix, String suffix) {
        String search=prefix+"#"+suffix;
        ArrayList<Integer>l1=new ArrayList<>();
        int i=m1.getOrDefault(search,-1);
        return i;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */