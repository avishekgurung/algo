package tree.binarysearch.problems;

import tree.binarysearch.util.BinarySearchTree;
import tree.binarysearch.util.Node;

public class Problem004 {

  /**
   * If the element has right child then the smallest element of right subtree is its successor.
   *
   * Else, we need to travel down the root and every time, we find a node which is higher than
   * the element, we keep it as successor.
   *
   * Same but opposite logic for predecessor as well.
   *
   * Approach 2: Perform a traversal, store in the array and find the successor etc.
   *
   * @param root
   * @param element
   * @return
   */

  public static int inorderSuccessor(Node root, Node element) {
    if(element.right != null) {
      element = element.right;
      while(element.left != null) element = element.left;
      return element.data;
    }
    else {
      Node successor = null;
      while(root != null){
        if(element.data < root.data) {
          successor =  root;
          root = root.left;
        }
        else if(element.data > root.data) {
          root = root.right;
        }
        else {
          break;
        }
      }
      if(successor == null) return -1; //Meaning no successor: for right most node.
      return successor.data;
    }
  }

  public static int inorderPredecessor(Node root, Node node) {
    if(node.left != null) {
      node = node.left;
      while(node.right != null) node = node.right;
      return node.data;
    }
    else {
      Node predecessor = null;
      while(root != null) {
        if(root.data < node.data) {
          predecessor = root;
          root = root.right;
        }
        else if(root.data > node.data) {
          root = root.left;
        }
        else {
          break;
        }
      }
      if(predecessor != null) return predecessor.data;
      else return -1;
    }
  }


  public static void main(String[] args) {

    Node root = BinarySearchTree.getTree();
    BinarySearchTree.display(root);

    Node node = root;
    System.out.println("Inorder Successor of " + node.data + "  is " + inorderSuccessor(root, node));

    node = root.left;
    System.out.println("Inorder Successor of " + node.data + "  is " + inorderSuccessor(root, node));

    node = root.left.right;
    System.out.println("Inorder Successor of " + node.data + "  is " + inorderSuccessor(root, node));

    node = root.right.left;
    System.out.println("Inorder Successor of " + node.data + "  is " + inorderSuccessor(root, node));

    node = root.right.right;
    System.out.println("Inorder Successor of " + node.data + "  is " + inorderSuccessor(root, node));

    System.out.println();
    node = root;
    System.out.println("Inorder Predecessor of " + node.data + "  is " + inorderPredecessor(root, node));

    node = root.left;
    System.out.println("Inorder Predecessor of " + node.data + "  is " + inorderPredecessor(root, node));

    node = root.left.right;
    System.out.println("Inorder Predecessor of " + node.data + "  is " + inorderPredecessor(root, node));

    node = root.right.left;
    System.out.println("Inorder Predecessor of " + node.data + "  is " + inorderPredecessor(root, node));

    node = root.right.right;
    System.out.println("Inorder Predecessor of " + node.data + "  is " + inorderPredecessor(root, node));

    node = root.left.left;
    System.out.println("Inorder Predecessor of " + node.data + "  is " + inorderPredecessor(root, node));
  }

}
