// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        Solution obj = new Solution();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String A = read.readLine().trim();
            
            String ans = obj.chooseandswap(A);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution{
    String chooseandswap(String A){
      ArrayList<Character>l1=new ArrayList<Character>();
      for(int i=0;i<A.length();i++){
          if(!l1.contains(A.charAt(i)))
                    l1.add(A.charAt(i));
      }
      for(int i=0;i<A.length();i++){
          l1.remove(new Character(A.charAt(i)));
          if(l1.isEmpty()){
              break;
          }
          Collections.sort(l1);
          char ch=l1.get(0);
          if(ch < A.charAt(i)){
              char ch2=A.charAt(i);
              char[] a=A.toCharArray();
              for(int j=0;j<a.length;j++){
                  if(a[j]==ch2){
                      a[j]=ch;
                  }
                  else if(a[j]==ch){
                      a[j]=ch2;
                  }
              }
              A=new String(a);
              break;
          }
      }
      return A;
    }
    
}