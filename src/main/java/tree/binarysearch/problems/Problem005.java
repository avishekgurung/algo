package tree.binarysearch.problems;

import tree.binarysearch.util.BinarySearchTree;
import tree.binarysearch.util.Node;

public class Problem005 {

  private static Node parent = null;
  public static void delete(Node root, int element) {
    if(root == null) return;
    if(element < root.data) {
      parent = root;
      delete(root.left, element);
    }
    else if(element > root.data) {
      parent = root;
      delete(root.right, element);
    }
    else { //when node to delete is found
      if(root.left != null && root.right != null) {
        int temp = root.right.data;
        root.data = temp;
        parent = root;
        delete(root.right, temp);
      }
      else if(root.right != null) {
        parent = root;
        int temp = root.right.data;
        root.data = temp;
        delete(root.right, temp);
      }
      else if(root.left != null) {
        parent = root;
        int temp = root.left.data;
        root.data = temp;
        delete(root.left, temp);
      }
      else {
        free(root);
      }
    }
  }

  private static void free(Node node) {
    if(parent.left == node) parent.left = null;
    else parent.right = null;
  }



  public static void main(String[] args) {

    Node root = BinarySearchTree.getTree();
    BinarySearchTree.display(root);
    System.out.println();
    int element = 4;
    System.out.println("Deleting " + element);
    delete(root, element);
    BinarySearchTree.display(root);

  }

}



