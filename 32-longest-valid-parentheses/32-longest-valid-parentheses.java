class Solution {
    public int longestValidParentheses(String s) {
        int max=0;
        for(int i=0;i<s.length();i++){
            int op=0;
            int closing=0;
            for(int j=i;j<s.length();j++){
                if(s.charAt(j)=='(') op++;
                if(s.charAt(j)==')') closing++;
                if(closing>op) break;
                if(op==closing) max=Math.max(j-i+1,max);
            }
        }
        return max;
    }
}