class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>>ans=new ArrayList<>();
        for(int i=0;i<searchWord.length();i++){
            String a=searchWord.substring(0,i+1);
            List<String>l1=new ArrayList<>();
            for(String x:products){
                if(x.startsWith(a)){
                    l1.add(x);
                }
                if(l1.size()==3) break;
            }
            ans.add(l1);
        }
        return ans;
    }
}