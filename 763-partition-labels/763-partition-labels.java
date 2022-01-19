class Solution {
    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer>ans=new ArrayList<Integer>();
        HashSet<Character>s1=new HashSet<>();
        int[] count=new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        int i=0;
        int j=i+1;
        s1.add(s.charAt(i));
        count[s.charAt(i)-'a']--;
        if(count[s.charAt(i)-'a']==0){
            ans.add(1);
            s1.remove(s.charAt(i));
            i++;
        }
        while(j<s.length()){
            count[s.charAt(j)-'a']--;
            if(count[s.charAt(j)-'a']>0) s1.add(s.charAt(j));
            if(count[s.charAt(j)-'a']==0){
                if(s1.contains(s.charAt(j))) s1.remove(s.charAt(j));
                // System.out.println(s.charAt(j));
            }
            if(s1.size()==0){
                ans.add(j-i+1);
                i=j+1;
                j=i;
                if(i<s.length()){
                    s1.add(s.charAt(i));
                    count[s.charAt(i)-'a']--;
                    if(count[s.charAt(i)-'a']==0){
                        ans.add(1);
                        s1.remove(s.charAt(i));
                        i++;
                    }
                }
            }
            j++;
        }
        if(!s1.isEmpty()) ans.add(j-i);
        return ans;
    }
}