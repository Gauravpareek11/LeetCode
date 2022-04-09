// { Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t > 0){
            String line = br.readLine().trim();
            Node root = buildTree(line);
            
            line = br.readLine().trim();
            String target_k[] = line.split(" ");
            int target = Integer.parseInt(target_k[0]);
            int k = Integer.parseInt(target_k[1]);
            
            solver x = new solver();
            System.out.println( x.sum_at_distK(root, target, k) );
            t--;
        }
    }
}

// } Driver Code Ends


/*
// node structure:

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/

class solver{
    static Node ans=null;
    static int sum_at_distK(Node root, int target, int k){
        // code here
        ans=null;
        HashMap<Node,Node>m1=new HashMap<>();
        solve(root,null,target,m1);
        // System.out.println(ans);
        List<Integer>l1=new ArrayList<>();
        inorder(ans,m1,null,l1,0,k);
        int sum=0;
        for(int i:l1){
            // System.out.println(i);
            sum+=i;
        }
        return sum;
    }
    static void solve(Node root,Node parent,int target,HashMap<Node,Node>m1){
        m1.put(root,parent);
        if(root.data==target) ans=root;
        if(root.left!=null) solve(root.left,root,target,m1);
        if(root.right!=null) solve(root.right,root,target,m1);
    }
    static void inorder(Node root,HashMap<Node,Node>m1,Node parent,List<Integer>l1,int i,int k){
        if(root==null || i>k) return;
        l1.add(root.data);
        if(root.left!=null && root.left!=parent) inorder(root.left,m1,root,l1,i+1,k);
        if(root.right!=null && root.right!=parent) inorder(root.right,m1,root,l1,i+1,k);
        if(m1.get(root)!=null && m1.get(root)!=parent) inorder(m1.get(root),m1,root,l1,i+1,k);
    }
}

