// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
        	String input_line[] = read.readLine().trim().split("\\s+");
        	int x = Integer.parseInt(input_line[0]);
        	int y = Integer.parseInt(input_line[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestPath(x,y));
        }
    } 
} // } Driver Code Ends


//User function Template for Java

class Solution { 
    int shortestPath( int x, int y){ 
        ArrayList<Integer>l1=new ArrayList<Integer>();
        ArrayList<Integer>l2=new ArrayList<>();
        while(x>=1){
            l1.add(x);
            x=x/2;
        }
        while(y>=1){
            l2.add(y);
            y=y/2;
        }
        int a=0;
        int f=0;
        for(int i=0;i<l1.size();i++){
            if(l2.contains(l1.get(i))){
                f=l1.get(i);
                break;
            }
            else a++;
        }
        for(int i=0;i<l2.size();i++)
        {
            if(l2.get(i)==f) break;
            else a++;
        }
        return a;
    }
}