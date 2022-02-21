// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int keys[]= new int[n];
            for(int i = 0; i < n; i++)
                keys[i] = Integer.parseInt(input_line[i]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int freq[]= new int[n];
            for(int i = 0; i < n; i++)
                freq[i] = Integer.parseInt(input_line1[i]);
            Solution ob = new Solution();
            System.out.println(ob.optimalSearchTree(keys, freq, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java
// class pair{
//     int keys;
//     int freq;
//     pair(int keys,int freq){
//         this.keys=keys;
//         this.freq=freq;
//     }
// }
// class TreeNode{
//     pair val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(pair data){
//         this.val=data;
//         this.left=null;
//         this.right=null;
//     }
// }
// class Solution
// {
//     static TreeNode root=null;
//     static int ans=0;
//     static int optimalSearchTree(int keys[], int freq[], int n)
//     {
//         ans=0;
//         pair[] a=new pair[freq.length];
//         for(int i=0;i<freq.length;i++){
//             a[i]=new pair(keys[i],freq[i]);
//         }
//         Arrays.sort(a,(x,y)->Integer.compare(y.freq,x.freq));
//         for(int i=0;i<a.length;i++){
//             create(a[i]);
//         }
//         int h=height(root);
//         for(int i=h;i>=1;i--){
//             solve(root,i,i);
//         }
//         return ans;
//     }
//     static void create(pair data){
//         root=bst(root,data);
//     }
//     static TreeNode bst(TreeNode Node,pair data){
//         if(Node==null) Node=new TreeNode(data);
//         if(Node.val.keys<data.keys) Node.right=bst(Node.right,data);
//         if(Node.val.keys>data.keys) Node.left=bst(Node.left,data);
//         return Node;
//     }
//     static int height(TreeNode root){
//         if(root==null) return 0;
//         int l=height(root.left);
//         int r=height(root.right);
//         return Math.max(l,r)+1;
//     }
//     static void solve(TreeNode root,int level,int i){
//         if(root==null) return;
//         if(level==1) ans+=(root.val.freq*i);
//         if(level>1){
//             solve(root.left,level-1,i);
//             solve(root.right,level-1,i);
//         }
//     }
// }


class Solution
{
   static int optimalSearchTree(int key[], int freq[], int n)
   {
       int store[][][]=new int [n][n][n+1];
       for(int i=0;i<n;i++){
         for(int j=0;j<n;j++){
             for(int k=0;k<=n;k++)
               store[i][j][k]=-1;
         }
     }
  return dp(0,n-1,1,key,freq,store);
   }
   
   public static  int dp(int i,int j,int level,int key[],int freq[],int store[][][]){
    if(i==j){
        store[i][j][level]=freq[i]*level;
        return(store[i][j][level]);
    }
    if(i>j)
      return(0);
    
    if(store[i][j][level]!=-1)
     return(store[i][j][level]);
    
    int min=Integer.MAX_VALUE;
    for(int r=i;r<=j;r++){
        int v1=dp(i,r-1,level+1,key,freq,store);
        int v2=dp(r+1,j,level+1,key,freq,store);
        int v3=freq[r]*level;
        int total=v1+v2+v3;
        min=Math.min(total,min);
    }
    store[i][j][level]=min;
    return(min);
}
}
