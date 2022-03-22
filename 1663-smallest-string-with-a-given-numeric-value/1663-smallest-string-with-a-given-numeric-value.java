class Solution {
    public String getSmallestString(int n, int k) {
        char[] c={'#','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r',
                  's','t','u','v','w','x','y','z'};
        StringBuilder ans=new StringBuilder("");
        while(n>0){
            for(int i=1;i<=26;i++){
                if((k-i)<=(26*(n-1))){
                    // System.out.println(i);
                    ans.append(c[i]);
                    k-=i;
                    // System.out.println(k+" "+n);
                    break;
                }
            }
            n--;
        }
        // ans.append(c[k]);
        return ans.toString();
    }
}