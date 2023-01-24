//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().convert(arr, n);
            for (int i = 0; i < n; i++) {
                out.print(arr[i] + " ");
            }
            out.println();
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    void convert(int[] arr, int n) {
        //Code here
        HashMap<Integer,Integer>m1=new HashMap<>();
        for(int i=0;i<n;i++){
            m1.put(arr[i],i);
        }
        Arrays.sort(arr);
        HashMap<Integer,Integer>m2=new HashMap<>();
        for(int i=0;i<n;i++){
            m2.put(arr[i],i);
        }
        for(int i:m1.keySet()){
            arr[m1.get(i)]=m2.get(i);
        }
    }
}