// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        int[] a=nums.clone();
        Arrays.sort(a);
        HashMap<Integer,Integer>m1=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            m1.put(nums[i],i);
        }
        int count=0;
        for(int i=0;i<a.length;i++){
            if(nums[i]!=a[i]){
                int j=m1.get(a[i]);
                m1.put(nums[i],j);
                m1.put(a[i],i);
                swap(nums,i,j);
                // System.out.println(nums[i]);
                count++;
            }
        }
        return count;
    }
    void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}