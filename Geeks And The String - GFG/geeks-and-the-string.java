//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.removePair(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String removePair(String s) {
        Stack<Character>s1=new Stack<>();
        for(int i=0;i<s.length();i++){
            s1.add(s.charAt(i));
            if(s1.size()>=2){
                char a=s1.pop();
                char b=s1.pop();
                if(a!=b){
                    s1.add(b);
                    s1.add(a);
                }
            }
        }
        
        if(s1.size()>=2){
            char a=s1.pop();
            char b=s1.pop();
            if(a!=b){
                s1.add(b);
                s1.add(a);
            }
        }
        if(s1.isEmpty()) return "-1";
        else{
            StringBuilder sb=new StringBuilder("");
            while(!s1.isEmpty()){
                sb.append(s1.pop());
            }
            return sb.reverse().toString();
        }
    }
}
        
