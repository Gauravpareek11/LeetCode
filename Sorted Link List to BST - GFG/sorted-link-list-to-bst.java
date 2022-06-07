// { Driver Code Starts
import java.util.*;

class LNode
{
    int data;
    LNode next;
    LNode(int d) {
        data = d; 
        next = null;
    }
}

class TNode
{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }
    
}


class ListToBST
{
    
  /* Function to print linked list */
   public static void preOrder(TNode root)
    {
        
        if(root==null)
            return;
            
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
	
	 
 
     /* Driver program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n = sc.nextInt();
			LNode head = new LNode(sc.nextInt());
            LNode tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new LNode(sc.nextInt());
                tail = tail.next;
            }
		
			Solution obj = new Solution();
			TNode root = obj.sortedListToBST(head);
			preOrder(root);
			
			System.out.println();
			
			t--;
			
         }
    }
}
// } Driver Code Ends


//User function Template for Java

/*Linked List Node
class LNode
{
    int data;
    LNode next;
    LNode(int d) {
        data = d; 
        next = null;
    }
}

//Tree Node
class TNode
{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }
    
}*/

class Solution
{
    public TNode sortedListToBST(LNode head)
    {
        //code here
        ArrayList<Integer>l1=new ArrayList<>();
        LNode ptr=head;
        while(ptr!=null){
            l1.add(ptr.data);
            ptr=ptr.next;
        }
        // Collections.sort(l1);
        TNode root=null;
        return solve(root,l1,0,l1.size()-1);
    }
    TNode solve(TNode root,ArrayList<Integer>l1,int i,int j){
        if(i==j){
            root=new TNode(l1.get(i));
            return root;
        }
        int mid=i+(int)Math.ceil((j-i)/2.0);
        root=new TNode(l1.get(mid));
        if(mid-1>=i) root.left=solve(root.left,l1,i,mid-1);
        if(mid+1<=j) root.right=solve(root.right,l1,mid+1,j);
        return root;
    }
}