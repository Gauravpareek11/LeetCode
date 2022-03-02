// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            long ans = ob.countStrings(S); 
            System.out.println(ans);
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long countStrings(String S) 
    { 
        // long ans=0;
        // char[] c=S.toCharArray();
        // HashSet<String>s1=new HashSet<>();
        // for(int i=0;i<S.length();i++){
        //     for(int j=i+1;j<S.length();j++){
        //         char a=c[i];
        //         c[i]=c[j];
        //         c[j]=a;
        //         if(!s1.contains(new String(c))){
        //             s1.add(new String(c));
        //             ans++;
        //         }
        //         a=c[i];
        //         c[i]=c[j];
        //         c[j]=a;
        //     }
        // }
        // // System.out.println(s1);
        // return ans;
        long ans=0;
        long[] count=new long[26];
        long n=S.length();
        for(int i=0;i<n;i++){
            count[S.charAt(i)-'a']++;
        }
        long rep=0;
        for(int i=0;i<26;i++){
            rep+=(count[i]*(count[i]-1))/2L;
        }
        return rep>0?1+(n*(n-1)/2L)-rep:(n*(n-1)/2);
    }
}