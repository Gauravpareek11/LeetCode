// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            int[] start = new int[N];
            int[] end = new int[N];
            
            for(int i=0; i<N; i++)
            {
                start[i] = Integer.parseInt(S1[i]);
                end[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxEvents(start,end,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution {
    static int maxEvents(int[] start, int[] end, int N) {
        int[][] a=new int[start.length][2];
        for(int i=0;i<start.length;i++){
            a[i][0]=start[i];
            a[i][1]=end[i];
        }
        Arrays.sort(a,(i,j)->Integer.compare(i[1],j[1]));
        Arrays.sort(a,(i,j)->Integer.compare(i[0],j[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
      int i = 0, ans = 0, d = 0;
       while (!pq.isEmpty() || i < N) {
           if (pq.isEmpty())
               d = a[i][0];
           while (i < N && a[i][0] <= d)
               pq.offer(a[i++][1]);
           pq.poll();
           ++ans; ++d;
           while (!pq.isEmpty() && pq.peek() < d)
               pq.poll();
       }
       return ans;
    }
}