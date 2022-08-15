class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer>m1=new HashMap<>();
        m1.put('I',1);
        m1.put('V',5);
        m1.put('X',10);
        m1.put('L',50);
        m1.put('C',100);
        m1.put('D',500);
        m1.put('M',1000);
        
        int i=0;
        int sum=0;
        for(i=0;i<s.length()-1;i++){
            
            if(m1.get(s.charAt(i+1))>m1.get(s.charAt(i))){
                sum+=m1.get(s.charAt(i+1))-m1.get(s.charAt(i));
                i++;
            }
            else{
                sum+=m1.get(s.charAt(i));
            }
        }
        if(i<s.length()){
            sum+=m1.get(s.charAt(i));
        }
        return sum;
    }
}