import java.util.*;


// Leetcode 450. Delete Node in a BST
// class Solution {
//   public TreeNode deleteNode(TreeNode root, int key) {
//       if(root==null) return null;
//       if(root.val==key){
//           if(root.left!=null&&root.right!=null){
//               int k= minimum(root.right);
//               root.val=k;
//               root.right= deleteNode(root.right,k);
//           }
//           else if(root.left!=null){
//               return root.left;
//           }
//           else if(root.right!=null){
//               return root.right;
//           }
//           else{
//               return null;
//           }
//       }
//       root.left= deleteNode(root.left,key);
//       root.right= deleteNode(root.right,key);
//       return root;
//   }
//   public int minimum(TreeNode root){
//       if(root.left==null) return root.val;
//       return minimum(root.left);
          
//   }
// }





// Leetcode 543. Diameter of Binary Tree
// class Solution {
//   int ans=0;
//   public int diameterOfBinaryTree(TreeNode root) {
//       diameter(root);
//       return ans;
//   }
//   public int  diameter(TreeNode root){
//       if(root==null) return -1;
//       int left= diameter(root.left);
//       int right= diameter(root.right);
//       ans=Math.max(ans,left+right+2);
//       return Math.max(left,right)+1;
//   }
// }






// Leetcode 102. Binary Tree Level Order Traversal
// class Solution {
//   public List<List<Integer>> levelOrder(TreeNode root) {
//       int height= maxDepth(root);
//       List<List<Integer>>al= new ArrayList<List<Integer>>();
//       for(int i=0;i<height;i++){
//           al.add(new ArrayList<Integer>());
//       }
//       fun(al,root,0);
//       return al;
//   }
//   public void fun(List<List<Integer>>al,TreeNode root,int idx){
//       if(root==null) return ;
//       al.get(idx).add(root.val);
//       fun(al,root.left,idx+1);
//       fun(al,root.right,idx+1);
//   }
//   public int maxDepth(TreeNode root) {
//       if(root==null) return 0;
//       return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
//   }
// }




// Leetcode 111. Minimum Depth of Binary Tree
// class Solution {
//   public int minDepth(TreeNode root) {
//       if(root==null) return 0;
//       return fun(root);
//   }
//   public int fun(TreeNode root){
//       if(root==null) return Integer.MAX_VALUE;
//       if(root.left==null&&root.right==null) return 1;
//       return Math.min(fun(root.left),fun(root.right))+1;
//   }
// }




// Leetcode 104. Maximum Depth of Binary Tree
// class Solution {
//   public int maxDepth(TreeNode root) {
//       if(root==null) return 0;
//       return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
//   }
// }


// Leetcode 94. Binary Tree Inorder Traversal
// class Solution {
//   public List<Integer> inorderTraversal(TreeNode root) {
//       List<Integer>ans= new ArrayList<>();
//        // if(root==null) return ans;
//       inorder(root,ans);
//       return ans;
//   }
//   public void inorder(TreeNode root,List<Integer>ans){
//       if(root==null) return;
//       inorder(root.left,ans);
//       ans.add(root.val);
//       inorder(root.right,ans);
//   }
// }


// Leetcode 145. Binary Tree Postorder Traversal
// class Solution {
//   public List<Integer> postorderTraversal(TreeNode root) {
//       List<Integer>ans= new ArrayList<>();
//        // if(root==null) return ans;
//       postorder(root,ans);
//       return ans;
//   }
//   public void postorder(TreeNode root,List<Integer>ans){
//       if(root==null) return;
//       postorder(root.left,ans);
//       postorder(root.right,ans);
//       ans.add(root.val);
//   }
// }



// Leetcode 144. Binary Tree Preorder Traversal
// class Solution {
//   public List<Integer> preorderTraversal(TreeNode root) {
//          List<Integer>ans= new ArrayList<>();
//        // if(root==null) return ans;
//       preorder(root,ans);
//       return ans;
//   }
//   public void preorder(TreeNode root,List<Integer>ans){
//       if(root==null) return;
//       ans.add(root.val);
//       preorder(root.left,ans);
//       preorder(root.right,ans);
//   }
// }



class BinarySearchTree<K extends Comparable<K>>{
    class Node{
        K value;
        Node left;
        Node right;
        Node(K value){
            this.value=value;
            left=null;
            right=null;
        }
    }
    Node root;
    public void insert(K data){
      root=  insert(data,root);
    }
    public Node insert(K data,Node node){
        if(node==null){
            Node base= new Node(data);
            return base;
        }
        if(node.value.compareTo(data)<0){
            node.right= insert(data, node.right);
        }
        else{
            node.left= insert(data, node.left);
        }
        return node;
    }

    public boolean find(K data){
        return find(data,root);
    }
    public boolean find(K data, Node node){
        if(node == null)return false;
        if(node.value.equals(data)){
            return true;
        }
        if(node.value.compareTo(data)<0){
            return find(data,node.right);
        }
        else{
            return find(data,node.left);
        }
        // return false;
    }

    public void display(){
        display(root);
    }
    public void display(Node node){
        if(node == null){
          return;
        }
        if(node.left==null){
          System.out.print(" -> ");
        }
        else{
          System.out.print(node.left.value+" -> ");
        }
        System.out.print(node.value);
        if(node.right==null){
          System.out.print(" <- ");
        }
        else{
          System.out.print(" <- "+node.right.value);
        }
        System.out.println();
        display(node.left);
        display(node.right);
      }
    
}



public class lecture18 {
  public static void main(String[] args) {
      BinarySearchTree<Integer>bst=new BinarySearchTree<>();
      bst.insert(20);
      bst.insert(18);
      bst.insert(15);
      bst.insert(17);
      bst.insert(16);
      bst.insert(26);
      bst.insert(31);
      bst.insert(28);
      bst.insert(19);
      bst.display();
      System.out.println(bst.find(29));
  }
}
