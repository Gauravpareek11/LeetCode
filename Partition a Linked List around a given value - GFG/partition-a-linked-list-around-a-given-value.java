// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

class Partition {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.partition(head, k);
            printList(res);
            System.out.println();
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}// } Driver Code Ends


// User function Template for Java

/*class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node partition(Node node, int x) {
        // Your code here
        ArrayList<Integer>l1=new ArrayList<>();
        Node ptr=node;
        while(ptr!=null){
            l1.add(ptr.data);
            ptr=ptr.next;
        }
        // ArrayList<Integer>ans=new ArrayList<>();
        Node head=null;
         ptr=null;
        for(int i=0;i<l1.size();i++){
            if(l1.get(i)<x){
                if(head==null){
                    head=new Node(l1.get(i));
                    ptr=head;
                }
                else{
                    ptr.next=new Node(l1.get(i));
                    ptr=ptr.next;
                }
            }
        }
        for(int i=0;i<l1.size();i++){
            if(l1.get(i)==x){
                if(head==null){
                    head=new Node(l1.get(i));
                    ptr=head;
                }
                else{
                    ptr.next=new Node(l1.get(i));
                    ptr=ptr.next;
                }
            }
        }
        for(int i=0;i<l1.size();i++){
            if(l1.get(i)>x){
                if(head==null){
                    head=new Node(l1.get(i));
                    ptr=head;
                }
                else{
                    ptr.next=new Node(l1.get(i));
                    ptr=ptr.next;
                }
            }
        }
        return head;
    }
}