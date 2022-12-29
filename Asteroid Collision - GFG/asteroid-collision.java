//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] a) {
        // code here
        Stack<Integer>s1=new Stack<>();
        s1.add(a[0]);
        for(int i=1;i<N;i++){
            if(!s1.isEmpty() && s1.peek()>0 && a[i]<0){
                boolean f=true;
                while(s1.size()>0 && s1.peek()>0 && a[i]<0){
                    int x=s1.pop();
                    int y=a[i];
                    if(Math.abs(y)<Math.abs(x)){
                        f=false;
                        s1.add(x);
                        break;
                    }
                    else if(Math.abs(y)==Math.abs(x)){
                        f=false;
                        break;
                    }
                    // System.out.println(a[i]+" "+s1);
                }
                if(f) s1.add(a[i]);
                // System.out.println(a[i]+" "+s1);
            }
            else{
                s1.add(a[i]);
            }
        }
        if(s1.size()==0) return new int[0];
        else{
            int[] ans=new int[s1.size()];
            int i=s1.size()-1;
            while(s1.size()>0){
                ans[i]=s1.pop();
                i--;
            }
            return ans;
        }
    }
}
