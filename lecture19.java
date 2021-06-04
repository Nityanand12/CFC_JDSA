import java.util.*;

// Leetcode 538. Convert BST to Greater Tree
// class Solution {
//   int s=0;
//   public TreeNode convertBST(TreeNode root) {
//    s= sum(root);
//       fun(root);
//       return root;
//   }
//   public void fun(TreeNode root){
//       if(root==null) return;
//       fun(root.left);
//       int k= root.val;
//       root.val=s;
//       s=s-k;
//       fun(root.right);
//   }
//   public int sum(TreeNode root){
//       if(root==null) return 0;
//       int left = sum(root.left);
//       int right= sum(root.right);
//       return left+right+root.val;
//   }
// }









// Leetcode 101. Symmetric Tree
// class Solution {
//   public boolean isSymmetric(TreeNode root) {
//      return fun(root,root)==false;
//   }
//    public boolean fun(TreeNode p, TreeNode q){
//       if(p==null&&q==null) return false;
//       if(p==null||q==null) return true;
//       if(p.val!=q.val) return true;
//       boolean res=false;
//       res=res||fun(p.left,q.right);
//       res=res||fun(p.right,q.left);
//       return res;
//   }
// }





// Leetcode 100. Same Tree
// class Solution {
//   public boolean isSameTree(TreeNode p, TreeNode q) {
//      boolean res=fun(p,q);
//       if(res==false) return true;
//       return false;
//   }
//   public boolean fun(TreeNode p, TreeNode q){
//       if(p==null&&q==null) return false;
//       if(p==null||q==null) return true;
//       if(p.val!=q.val) return true;
//       boolean res=false;
//       res=res||fun(p.left,q.left);
//       res=res||fun(p.right,q.right);
//       return res;
//   }
// }




class AVL<K extends Comparable<K>> {
  class Node {
    K value;
    Node left;
    Node right;
    int height;

    Node(K value) {
      height = 1;
      this.value = value;
      left = null;
      right = null;
    }
  }

  Node root;

  public void insert(K data) {
    root = insert(data, root);
  }

  private Node insert(K data, Node node) {
    if (node == null) {
      Node base = new Node(data);
      return base;
    }
    if (node.value.compareTo(data) < 0) {
      node.right = insert(data, node.right);
    } else {
      node.left = insert(data, node.left);
    }
    node.height = Math.max(height(node.left), height(node.right)) + 1;
    node = balance(node);
    return node;
  }

  private Node balance(Node node) {
    if (height(node.right) - height(node.left) > 1) {
      if (height(node.right.left) - height(node.right.right) > 0) {
        node.right = rightRotation(node.right);
      }
      node = leftRotation(node);
    }
    if (height(node.left) - height(node.right) > 1) {
      if (height(node.left.right) - height(node.left.left) > 0) {
        node.left = leftRotation(node.left);
      }
      node = rightRotation(node);
    }
    return node;
  }

  private Node leftRotation(Node node) {
    Node b = node.right;
    Node c = b.left;
    b.left = node;
    node.right = c;
    node.height = Math.max(height(node.left), height(node.right)) + 1;
    b.height = Math.max(height(b.left), height(b.right)) + 1;
    return b;
  }

  private Node rightRotation(Node node) {
    Node b = node.left;
    Node c = b.right;
    b.right = node;
    node.left = c;
    node.height = Math.max(height(node.left), height(node.right)) + 1;
    b.height = Math.max(height(b.left), height(b.right)) + 1;
    return b;
  }

  public int height(Node node) {
    if (node == null)
      return 0;
    return node.height;
  }

  public boolean find(K data) {
    return find(data, root);
  }

  private boolean find(K data, Node node) {
    if (node == null)
      return false;
    if (node.value.equals(data)) {
      return true;
    }
    if (node.value.compareTo(data) < 0) {
      return find(data, node.right);
    } else {
      return find(data, node.left);
    }
    // return false;
  }

  public void display() {
    display(root);
  }

  public void display(Node node) {
    if (node == null) {
      return;
    }
    if (node.left == null) {
      System.out.print(" -> ");
    } else {
      System.out.print(node.left.value + " -> ");
    }
    System.out.print(node.value);
    if (node.right == null) {
      System.out.print(" <- ");
    } else {
      System.out.print(" <- " + node.right.value);
    }
    System.out.println();
    display(node.left);
    display(node.right);
  }
}

public class lecture19 {
  public static void main(String[] args) {
    AVL<Integer> al = new AVL<>();
    for (int i = 1; i <= 9; i++) {
      al.insert(i);
    }
    al.display();
  }
}
