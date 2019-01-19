package tree.binary.problems;


import java.util.Stack;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem001 {

  public static void preorder(Node root) {
    if(root == null) return;
    System.out.print(root.data + " ");
    preorder(root.left);
    preorder(root.right);
  }

  public static void preorderIteration(Node root) {
    Stack<Node> stack = new Stack<Node>();
    while(true) {
      while(root != null) {
        System.out.print(root.data + " ");
        stack.push(root);
        root = root.left;
      }
      if(stack.isEmpty()) break;
      root = stack.pop();
      root = root.right;
    }
    System.out.println();
  }

  public static void inorder(Node root) {
    if(root == null) return;
    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);
  }

  public static void inorderIteration(Node root) {
    Stack<Node> stack = new Stack<Node>();
    while(true) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      if(stack.isEmpty()) break;
      root = stack.pop();
      System.out.print(root.data + " ");
      root = root.right;
    }
  }

  public static void postorder(Node root) {
    if(root == null) return;
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.data + " ");
  }

  public static void postorderIteration(Node root) {
    Stack<Node> stack = new Stack<Node>();
    Stack<Node> aux = new Stack<Node>();
    while(true) {
      while(root != null) {
        stack.push(root);
        aux.push(root);
        root = root.right;
      }

      if(stack.isEmpty()) break;
      root = stack.pop();
      root = root.left;
    }

    while(!aux.isEmpty()) {
      System.out.print(aux.pop().data + " ");
    }
  }

  public static void main(String[] args) {
    Node root = BinaryTree.getTree();
    BinaryTree.display(root);

    System.out.println("\nPreorder");
    preorder(root);
    System.out.println();
    preorderIteration(root);

    System.out.println("\nInorder");
    inorder(root);
    System.out.println();
    inorderIteration(root);

    System.out.println("\n\nPostorder");
    postorder(root);
    System.out.println();
    postorderIteration(root);
  }

}
