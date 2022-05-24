class Solution {
    public int longestValidParentheses(String s) {
        // int max=0;
        // for(int i=0;i<s.length();i++){
        //     int op=0;
        //     int closing=0;
        //     for(int j=i;j<s.length();j++){
        //         if(s.charAt(j)=='(') op++;
        //         if(s.charAt(j)==')') closing++;
        //         if(closing>op) break;
        //         if(op==closing) max=Math.max(j-i+1,max);
        //     }
        // }
        // return max;
        
        
        int max=0;
        int op=0;
        int closing=0;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='(') op++;
            if(s.charAt(j)==')') closing++;
            if(op==closing) max=Math.max(2*op,max);
            if(closing>op) closing=op=0;
        }
        closing=op=0;
        for(int j=s.length()-1;j>=0;j--){
            if(s.charAt(j)=='(') op++;
            if(s.charAt(j)==')') closing++;
            if(op==closing) max=Math.max(2*op,max);
            if(closing<op) closing=op=0;
        }
        return max;
    }
}