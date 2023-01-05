//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            String res = obj.longestString(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String longestString(int n, String[] arr) {
        // code here
        HashSet<String>s1=new HashSet<>();
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            s1.add(arr[i]);
        }
        String ans="";
        for(int i=0;i<n;i++){
            String s=arr[i];
            boolean f=true;
            for(int j=0;j<s.length();j++){
                String x=s.substring(0,j+1);
                if(!s1.contains(x)){
                    f=false;
                    break;
                }
            }
            if(f){
                if(ans.length()<s.length()) ans=s;
                
            }
        }
        return ans;
    }
}
        
