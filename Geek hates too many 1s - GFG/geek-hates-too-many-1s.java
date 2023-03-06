//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.noConseBits(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int noConseBits(int n) {
        // code here
        char[] c=Integer.toBinaryString(n).toCharArray();
        
        for(int i=0;i<c.length-2;i++){
            if(c[i]==c[i+1] && c[i+1]==c[i+2] && c[i]=='1'){
                c[i+2]='0';
            }
        }
        int ans=0;
        int pow=1;
        for(int i=c.length-1;i>=0;i--){
            if(c[i]=='1'){
                ans+=pow;
            }
            pow=pow<<1;
        }
        return ans;
    }
}
        
