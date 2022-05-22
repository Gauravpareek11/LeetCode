// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            int Q = Integer.parseInt(read.readLine());
            
            int[] index = new int[Q];
            String[] sources = new String[Q];
            String[] targets = new String[Q];
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            String S3[] = read.readLine().split(" ");
            
            for(int i=0 ; i<Q ; i++) {
                index[i] = Integer.parseInt(S1[i]);
                sources[i] = S2[i];
                targets[i] = S3[i];
            }

            Solution ob = new Solution();
            System.out.println(ob.findAndReplace(S,Q,index,sources,targets));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class pair{
    int in;
    String source;
    String target;
    pair(int in,String source,String target){
        this.in=in;
        this.source=source;
        this.target=target;
    }
}
class Solution {
    static String findAndReplace(String S, int Q, int[] index, String[] sources, String[] targets) {
        // code here
        int i=0;
        pair[] p=new pair[index.length];
        for(i=0;i<index.length;i++){
            p[i]=new pair(index[i],sources[i],targets[i]);
        }
        Arrays.sort(p,(a,b)->Integer.compare(a.in,b.in));
        StringBuilder sb=new StringBuilder("");
        i=0;
        int j=0;
        while(i<S.length()){
            if(j<Q && i==p[j].in){
                if(S.substring(i,i+p[j].source.length()).equals(p[j].source))
                {
                sb.append(p[j].target);
                i+=p[j].source.length();
                j++;
                }
                else{
                    sb.append(S.charAt(i));
                    i++;
                    j++;
                }
            }
            else{
                sb.append(S.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
};