class WordDictionary {
    Set<String>s1=new HashSet<>();
    HashMap<String,Boolean>m1=new HashMap<>();
    boolean check=false;
    public WordDictionary() {
    }
    
    public void addWord(String word) {
        s1.add(word);
        check=true;
    }
    
    public boolean search(String word) {
        if(!check && m1.containsKey(word)){
            return m1.get(word);
        }
        for(String a:s1){
            if(a.length()!=word.length()) continue;
            boolean f=true;
            if(a.length()==word.length()){
                for(int i=0;i<a.length();i++){
                    if(word.charAt(i)=='.') continue;
                    else{
                        if(word.charAt(i)!=a.charAt(i)){
                            f=false;
                            break;
                        }
                    }
                }
            }
            if(f==true){
                check=false;
                m1.put(word,true);
                return true;
            }
        }
        m1.put(word,false);
        check=false;
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */