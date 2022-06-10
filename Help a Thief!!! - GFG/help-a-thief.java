// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int T = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            int[] B = new int[N];
            
            for(int i=0; i<N; i++)
            {
                A[i] = Integer.parseInt(S1[i]);
                B[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxCoins(A,B,T,N));
        }
    }
}// } Driver Code Ends


class Solution {
    static int maxCoins(int[] A, int[] B, int T, int N) {
        // code here
        if(T==0) return 0;
        int[][] a=new int[N][2];
        for(int i=0;i<N;i++){
            a[i][0]=A[i];
            a[i][1]=B[i];
        }
        Arrays.sort(a,(x,y)->Integer.compare(y[1],x[1]));
        int ans=0;
        int i=0;
        while(T!=0 && i<N){
            int p=Math.min(T,a[i][0]);
            ans+=p*a[i][1];
            T-=p;
            i++;
        }
        return ans;
    }
}