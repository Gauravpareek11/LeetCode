// { Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // int arr[] = new int[10000];
        
        int t = sc.nextInt();
        
        while(t-->0)
        {
            int n = sc.nextInt();
            int arr[]=new int[n];
            for(int i=0; i<n; i++)
            {
                arr[i] = sc.nextInt();
            }
            
            solver x = new solver();
            int res[]=x.print_next_greater_freq(arr,n);
            StringBuffer sb=new StringBuffer("");
            for(int i : res){
                sb.append(i+" ");
            }
            System.out.println(sb);
        }
    }
}
// } Driver Code Ends


class solver
{
    static int[] print_next_greater_freq(int arr[], int n)
    {
        HashMap<Integer,Integer>m1=new HashMap<>();
        for(int i:arr){
            if(m1.containsKey(i)) m1.put(i,m1.get(i)+1);
            else m1.put(i,1);
        }
        Stack<Integer>s1=new Stack<>();
        int[] ans=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!s1.isEmpty() && m1.get(arr[i])>=m1.get(s1.peek())){
                s1.pop();
            }
            ans[i]=(s1.isEmpty()?-1:s1.peek());
            s1.add(arr[i]);
        }
        return ans;
    }
}

