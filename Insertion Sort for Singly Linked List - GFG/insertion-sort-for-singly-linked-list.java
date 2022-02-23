// { Driver Code Starts
//Initial Template for Java

import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class insertion
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
      void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	/* Drier program to test above functions */
	public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
         {
			int n = sc.nextInt();
			insertion llist = new insertion(); 
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		head = ob.insertionSort(llist.head);
		llist.printList(head);
		
        t--;		
        }
    }}// } Driver Code Ends


//User function Template for Java

/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution
{
    public static Node insertionSort(Node head_ref)
    {
        Node head=null;
        while(head_ref!=null){
            if(head==null) head=new Node(head_ref.data);
            else{
                Node ptr=head;
                Node prev=null;
                while(ptr!=null && ptr.data<head_ref.data){
                    prev=ptr;
                    ptr=ptr.next;
                }
                if(ptr==head){
                    head=new Node(head_ref.data);
                    head.next=ptr;
                }
                else if(ptr==null) prev.next=new Node(head_ref.data);
                else{
                    Node p=new Node(head_ref.data);
                    p.next=prev.next;
                    prev.next=p;
                }
            }
            // Node k=head;
            // while(k!=null){
            //     System.out.print(k.data+"->");
            //     k=k.next;
            // }
            // System.out.println();
            head_ref=head_ref.next;
        }
        return head;
    }
}