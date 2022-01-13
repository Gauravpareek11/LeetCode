// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return 1;
                        else
                            return 0;
                    }
                
                    if(index1 < index2)
                        return 1;
                    else
                        return 0;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<K;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<N-1;i++){
            for(int j=0;j<Math.min(dict[i].length(),dict[i+1].length());j++){
                if(dict[i].charAt(j)!=dict[i+1].charAt(j)){
                    adj.get(dict[i].charAt(j)-'a').add(dict[i+1].charAt(j)-'a');
                    break;
                }
            }
        }
        boolean[] visited=new boolean[K];
        Stack<Integer>s1=new Stack<>();
        for(int i=0;i<K;i++){
            if(!visited[i]) dfs(i,visited,adj,s1);
        }
        StringBuilder ans=new StringBuilder("");
        while(!s1.isEmpty()){
            ans.append((char)(97+s1.pop()));
            ans.append(" ");
        }
        return ans.toString().trim();
    }
    void dfs(int i,boolean[] visited,ArrayList<ArrayList<Integer>>adj,Stack<Integer>s1){
        visited[i]=true;
        for(int j:adj.get(i)){
            if(!visited[j]) dfs(j,visited,adj,s1);
        }
        s1.add(i);
    }
}