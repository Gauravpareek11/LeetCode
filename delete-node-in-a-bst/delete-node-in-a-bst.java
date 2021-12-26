/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ArrayList<Integer>l1=new ArrayList<Integer>();
    int found=0;
    TreeNode node;
    public TreeNode deleteNode(TreeNode root, int key) {
        search(root,key);
        if(found==0){
            return root;
        }
        else{
            preorder(root,key);
            for(int i=0;i<l1.size();i++){
                create(l1.get(i));
            }
            return node;
        }
    }
    void preorder(TreeNode root,int key){
        if(root==null){
            return;
        }
        if(root.val!=key){
            l1.add(root.val);
        }
        preorder(root.left,key);
        preorder(root.right,key);
    }
    void search(TreeNode root,int key){
        if(root==null){
            return;
        }
        if(root.val==key){
            found=1;
            return;
        }
        if(root.val<key){
            search(root.right,key);
        }
        if(root.val>key){
            search(root.left,key);
        }
    }
    TreeNode createNode(TreeNode node,int key){
        if(node==null){
            node=new TreeNode(key);
        }
        if(node.val>key){
            node.left=createNode(node.left,key);
        }
        if(node.val<key){
            node.right=createNode(node.right,key);
        }
        return node;
    }
    void create(int data){
        node=createNode(node,data);
    }
}